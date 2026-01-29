# 四显示信号机GUI及进路配置系统实现计划

## 项目概述
为四显示信号机添加GUI界面，允许玩家使用扳手右键打开配置界面，自定义每个进路（1-7）的转向行为。取代当前硬编码的转向逻辑。

## 现有代码分析

### 当前进路系统（SignalStateDisplayBlockEntity.java:672-742）
```java
// 当前硬编码逻辑：
// 进路1：直行
// 进路2：第一个岔道左转，之后直行
// 进路3：两个岔道都左转，之后直行
// 进路4：第一个岔道右转，之后直行
// 进路5：两个岔道都右转，之后直行
// 进路6：默认直行
```

### 现有NBT存储（SignalStateDisplayBlockEntity.java:900-932）
已存储`CurrentRoute`、`ForceRed`等基础数据，需要扩展存储进路配置。

### 滑条组件分析
- 现有组件：`NumericSlider` (src/main/java/com/easttown/createsignalsystem/client/widget/NumericSlider.java)
- 参考文档：`UnifiedSlider`使用方式（两者接口类似）
- 支持功能：图标模式、文本标签、鼠标事件、值变化回调

## 实现方案

### 1. 新增数据结构（新建文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/config/RouteConfiguration.java`

```java
// 进路配置类 - 存储在信号机方块实体的NBT中
// 每个进路有4个道岔配置槽位，进路总数从6个增加到7个（槽位1-7）
public class RouteConfiguration {
    private int slotId; // 槽位ID (1-7)，对应红石信号选择
    private String displayNumber; // 显示编号（可自定义，如"1"、"10"、"A1"等）
    private String displayName; // 显示名称
    private TurnAction[] turnActions = new TurnAction[4]; // 4个道岔配置槽位
    private boolean defaultStraight = true; // 默认直行

    // NBT序列化方法
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("SlotId", slotId);
        tag.putString("DisplayNumber", displayNumber);
        tag.putString("DisplayName", displayName);
        tag.putBoolean("DefaultStraight", defaultStraight);

        for (int i = 0; i < turnActions.length; i++) {
            if (turnActions[i] != null) {
                tag.put("Action_" + i, turnActions[i].serialize());
            }
        }
        return tag;
    }

    public static RouteConfiguration deserialize(CompoundTag tag) {
        RouteConfiguration config = new RouteConfiguration();
        config.slotId = tag.getInt("SlotId");
        config.displayNumber = tag.getString("DisplayNumber");
        config.displayName = tag.getString("DisplayName");
        config.defaultStraight = tag.getBoolean("DefaultStraight");

        for (int i = 0; i < 4; i++) {
            if (tag.contains("Action_" + i)) {
                config.turnActions[i] = TurnAction.deserialize(tag.getCompound("Action_" + i));
            }
        }
        return config;
    }
}

// 转向动作类 - 使用三格滑条控制左转/前进/右转
public class TurnAction {
    private int junctionIndex; // 第几个岔道 (1, 2, 3, 4)
    private SteerDirection direction; // 转向方向 (LEFT, RIGHT, NONE)
    private double distanceThreshold; // 距离阈值（可选高级参数）
    private double speedLimit; // 速度限制（可选高级参数，实际影响旅行点速度）

    // NBT序列化方法
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("JunctionIndex", junctionIndex);
        tag.putString("Direction", direction.name());
        tag.putDouble("DistanceThreshold", distanceThreshold);
        tag.putDouble("SpeedLimit", speedLimit);
        return tag;
    }

    public static TurnAction deserialize(CompoundTag tag) {
        TurnAction action = new TurnAction();
        action.junctionIndex = tag.getInt("JunctionIndex");
        action.direction = SteerDirection.valueOf(tag.getString("Direction"));
        action.distanceThreshold = tag.getDouble("DistanceThreshold");
        action.speedLimit = tag.getDouble("SpeedLimit");
        return action;
    }
}

// 红石信号到进路槽位的映射配置
public class SignalMapping {
    private int redstoneSignal; // 红石信号强度 (1-15)
    private int targetSlotId; // 目标进路槽位ID (1-7)

    public SignalMapping(int redstoneSignal, int targetSlotId) {
        this.redstoneSignal = redstoneSignal;
        this.targetSlotId = targetSlotId;
    }

    // NBT序列化
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("RedstoneSignal", redstoneSignal);
        tag.putInt("TargetSlotId", targetSlotId);
        return tag;
    }

    public static SignalMapping deserialize(CompoundTag tag) {
        return new SignalMapping(
            tag.getInt("RedstoneSignal"),
            tag.getInt("TargetSlotId")
        );
    }
}
```

### 2. 扩展方块实体存储（修改现有文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/block/entity/SignalStateDisplayBlockEntity.java`

**修改内容：**
- 添加字段：`private Map<Integer, RouteConfiguration> routeConfigs = new HashMap<>();`
- 添加字段：`private Map<Integer, Integer> signalMappings = new HashMap<>();`（红石信号映射）
- 修改NBT序列化方法（`write()`和`read()`）以存储配置
- 添加默认配置初始化逻辑（1-7进路的预设值）
- 修改转向选择逻辑：在`findForwardSignalGroups()`方法中使用配置而非硬编码

### 3. 创建GUI界面（新建文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/client/screen/RouteConfigScreen.java`

**GUI结构：**
- 继承`AbstractSimiScreen`（Create模组标准GUI基类）
- 使用标签页（Tab）系统切换不同配置页面
- 使用现有`NumericSlider`组件进行三态选择（左转/直行/右转）
- 使用`IconButton`进行确认/取消操作
- 实现自动保存机制（ESC退出、标签页切换、实时保存）

**标签页设计：**
1. **详情标签页**（标签1：信号机详情）
   - 当前状态、强制红灯、信号组占用状态
   - 当前进路、显示编号和名称
   - 基本信息展示区

2. **进路配置标签页**（标签2-4：进路1-3、进路4-6、进路7）
   - 标签2：进路1-3配置
   - 标签3：进路4-6配置
   - 标签4：进路7配置 + 高级设置
   - 每个进路：显示编号输入框 + 名称输入框
   - 4个垂直排列的图标模式滑条（每个道岔）
   - 高级参数：距离阈值、速度限制（可为空）

3. **红石映射标签页**（标签5：信号映射）
   - 配置红石信号强度（1-15）到进路槽位（1-7）的映射
   - 15个滑条（值范围1-7），每个对应一个红石信号强度
   - 恢复默认映射按钮
   - 映射关系预览表格

**标签页实现：**
- 顶部标签栏：使用Create的标签页组件或自定义按钮组
- 内容区域：根据当前选中标签显示不同内容
- 标签切换自动保存：切换标签时自动保存当前标签的配置

### 4. 创建数据包（新建文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/network/ConfigureRoutePacket.java`

**功能：**
- 扩展`BlockEntityConfigurationPacket`（Create标准数据包）
- 序列化进路配置数据和红石映射数据
- 将配置从客户端发送到服务器
- 在服务器端应用到方块实体

### 5. 修改扳手交互（修改现有文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/block/SignalStateDisplayBlock.java`

**修改内容：**
- 在`onWrenched()`方法中添加GUI打开逻辑
- 当玩家持有扳手且未按住Shift时打开配置界面
- 保持Shift+扳手快速拆除功能

### 6. 更新转向逻辑（修改现有文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/block/entity/SignalStateDisplayBlockEntity.java`

**修改内容：**
- 替换硬编码的转向选择逻辑（第672-742行）
- 根据`currentRoute`从`routeConfigs`获取配置
- 基于配置动态创建`ITrackSelector`
- 保持向后兼容性：无配置时使用默认行为

### 7. 注册数据包和屏幕（修改现有文件）
**文件：**
- `src/main/java/com/easttown/createsignalsystem/CreateSignalSystemMod.java`（数据包注册）
- `src/main/java/com/easttown/createsignalsystem/client/ClientModEvents.java`（GUI注册）

## 实施步骤

### 第一阶段：基础数据结构
1. 创建`RouteConfiguration.java`包含三个内部类
2. 在`SignalStateDisplayBlockEntity`中添加配置存储字段
3. 实现NBT序列化方法扩展

### 第二阶段：GUI界面
1. 创建`RouteConfigScreen.java`主屏幕类
2. 实现分页系统（5个页面）
3. 集成`NumericSlider`组件（图标模式，允许紫黑块）
4. 实现输入框、按钮等UI组件
5. 添加自动保存逻辑

### 第三阶段：网络通信
1. 创建`ConfigureRoutePacket.java`数据包
2. 在主类中注册数据包处理器
3. 实现GUI到数据包的通信
4. 添加网络通道初始化

### 第四阶段：交互逻辑
1. 修改`SignalStateDisplayBlock.java`的扳手交互
2. 替换`SignalStateDisplayBlockEntity.java`中的转向逻辑
3. 添加默认配置初始化
4. 实现红石信号映射逻辑

### 第五阶段：测试与调试
1. 验证GUI正常打开
2. 测试配置保存和加载
3. 验证转向行为按配置工作
4. 测试多人游戏同步
5. 验证ESC自动保存机制

## 关键技术细节

### 1. NumericSlider配置（图标模式，允许紫黑块）
- 设置`maxValue = 2`（3个位置：左转/直行/右转）
- 启用图标模式：`setIconMode(true)`
- 图标设置：使用null或无效ResourceLocation（显示紫黑块）
- 值映射：0=左转(LEFT), 1=直行(NONE), 2=右转(RIGHT)
- 参考`SLIDER_USAGE_GUIDE.md`中的`UnifiedSlider`使用方式

### 2. 自动保存机制
1. **ESC键退出**：自动保存所有更改
2. **标签页切换**：切换标签时自动保存当前标签页配置
3. **实时保存**：输入框编辑后延迟1秒自动保存，滑条值变化后立即保存
4. **手动保存**：提供保存按钮作为确认
5. 在屏幕`removed()`方法中调用`sendDataToServer()`

### 3. NBT存储扩展
在现有`write()`和`read()`方法基础上添加：
```java
// 进路配置存储
CompoundTag routeConfigsTag = new CompoundTag();
for (Map.Entry<Integer, RouteConfiguration> entry : routeConfigs.entrySet()) {
    routeConfigsTag.put("Route_" + entry.getKey(), entry.getValue().serialize());
}
tag.put("RouteConfigs", routeConfigsTag);

// 红石信号映射存储
CompoundTag signalMappingsTag = new CompoundTag();
for (Map.Entry<Integer, Integer> entry : signalMappings.entrySet()) {
    CompoundTag mappingTag = new CompoundTag();
    mappingTag.putInt("RedstoneSignal", entry.getKey());
    mappingTag.putInt("TargetSlotId", entry.getValue());
    signalMappingsTag.put("Mapping_" + entry.getKey(), mappingTag);
}
tag.put("SignalMappings", signalMappingsTag);
```

### 4. 转向逻辑适配
```java
// 新逻辑：基于配置创建TrackSelector
ITrackSelector createRouteSelector(int routeId, TravellingPoint travellingPoint) {
    RouteConfiguration config = routeConfigs.getOrDefault(routeId, getDefaultConfig(routeId));

    if (config.getTurnActions().length == 0 && config.isDefaultStraight()) {
        return travellingPoint.steer(SteerDirection.NONE, new Vec3(0, 1, 0));
    }

    // 基于4个道岔配置创建复合选择器
    // 实现略...
}
```

## 验证计划

### 功能测试：
1. 使用扳手右键信号机打开GUI
2. 配置不同进路的转向规则
3. 保存配置并重新加载世界验证持久化
4. 测试实际转向行为是否符合配置
5. 验证红石信号映射功能
6. 测试ESC自动保存机制

### 兼容性测试：
1. 现有存档的升级兼容性
2. 多人游戏同步测试
3. 与其他模组的兼容性
4. 向后兼容性（无配置时使用默认行为）

### 性能测试：
1. NBT存储大小影响
2. GUI渲染性能
3. 转向计算性能
4. 网络同步性能

## 风险评估与缓解

### 风险1：NBT数据膨胀
- **风险**：进路配置可能增加NBT数据大小
- **缓解**：使用压缩存储，限制规则数量，默认不存储空配置

### 风险2：客户端-服务器同步
- **风险**：配置不同步导致行为不一致
- **缓解**：使用可靠数据包，添加版本验证，自动重试机制

### 风险3：向后兼容性
- **风险**：旧存档升级时丢失进路配置
- **缓解**：添加默认配置生成逻辑，版本检测

### 风险4：GUI复杂性
- **风险**：界面过于复杂难以使用
- **缓解**：分页设计，提供预设模板，简化操作流程

## 关键文件路径

### 新建文件：
- `src/main/java/com/easttown/createsignalsystem/config/RouteConfiguration.java`
- `src/main/java/com/easttown/createsignalsystem/client/screen/RouteConfigScreen.java`
- `src/main/java/com/easttown/createsignalsystem/network/ConfigureRoutePacket.java`

### 修改文件：
- `src/main/java/com/easttown/createsignalsystem/block/entity/SignalStateDisplayBlockEntity.java`
- `src/main/java/com/easttown/createsignalsystem/block/SignalStateDisplayBlock.java`
- `src/main/java/com/easttown/createsignalsystem/CreateSignalSystemMod.java`
- `src/main/java/com/easttown/createsignalsystem/client/ClientModEvents.java`

## 成功标准
1. 玩家可以使用扳手右键打开配置GUI
2. 可以配置每个进路（1-7）的4个道岔转向规则
3. 可以自定义红石信号到进路的映射关系
4. 配置能够保存并在重新加载后保持
5. 旅行点的实际转向行为符合配置
6. ESC键退出自动保存配置
7. 保持与现有功能的兼容性