# 四显示信号机GUI及进路配置系统实现计划

## 项目概述
为四显示信号机添加GUI界面，允许玩家使用扳手右键打开配置界面，自定义每个进路（1-6）的转向行为。取代当前硬编码的转向逻辑。

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

    // Getter方法
    public int getRedstoneSignal() { return redstoneSignal; }
    public int getTargetSlotId() { return targetSlotId; }
}
```

### 2. 扩展方块实体存储（修改现有文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/block/entity/SignalStateDisplayBlockEntity.java`

**修改内容：**
- 添加字段：`private Map<Integer, RouteConfiguration> routeConfigs = new HashMap<>();`
- 修改NBT序列化方法（`write()`和`read()`）以存储配置
- 添加默认配置初始化逻辑（1-6进路的预设值）
- 修改转向选择逻辑：在`findForwardSignalGroups()`方法中使用配置而非硬编码

### 3. 创建GUI界面（新建文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/client/screen/RouteConfigScreen.java`

**GUI结构：**
- 继承`AbstractSimiScreen`（Create模组标准GUI基类）
- 主界面：显示6个进路槽位
- 进路详情界面：配置该进路的转向规则序列
- 使用现有`NumericSlider`组件进行数值输入
- 使用`IconButton`进行确认/取消操作

**界面元素：**
1. 进路列表：6个按钮对应1-6进路
2. 进路详情：
   - 进路名称编辑框
   - 转向规则列表（添加/删除/编辑）
   - 每个规则：岔道索引 + 转向方向（左/右/直行）
   - 默认直行复选框

### 4. 创建数据包（新建文件）
**文件：** `src/main/java/com/easttown/createsignalsystem/network/ConfigureRoutePacket.java`

**功能：**
- 扩展`BlockEntityConfigurationPacket`（Create标准数据包）
- 序列化进路配置数据
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

## 实施步骤

### 第一阶段：基础数据结构
1. 创建`RouteConfiguration.java`和`TurnRule.java`
2. 在`SignalStateDisplayBlockEntity`中添加配置存储字段
3. 实现NBT序列化方法

### 第二阶段：GUI界面
1. 创建`RouteConfigScreen.java`
2. 实现进路列表主界面
3. 实现进路详情编辑界面
4. 集成`NumericSlider`组件

### 第三阶段：网络通信
1. 创建`ConfigureRoutePacket.java`
2. 在主类中注册数据包处理器
3. 实现GUI到数据包的通信

### 第四阶段：交互逻辑
1. 修改`SignalStateDisplayBlock.java`的扳手交互
2. 替换`SignalStateDisplayBlockEntity.java`中的转向逻辑
3. 添加默认配置初始化

### 第五阶段：测试与调试
1. 验证GUI正常打开
2. 测试配置保存和加载
3. 验证转向行为按配置工作
4. 测试多人游戏同步

## 关键文件路径

### 新建文件：
- `src/main/java/com/easttown/createsignalsystem/config/RouteConfiguration.java`
- `src/main/java/com/easttown/createsignalsystem/config/TurnRule.java`
- `src/main/java/com/easttown/createsignalsystem/client/screen/RouteConfigScreen.java`
- `src/main/java/com/easttown/createsignalsystem/network/ConfigureRoutePacket.java`

### 修改文件：
- `src/main/java/com/easttown/createsignalsystem/block/entity/SignalStateDisplayBlockEntity.java`
- `src/main/java/com/easttown/createsignalsystem/block/SignalStateDisplayBlock.java`
- `src/main/java/com/easttown/createsignalsystem/CreateSignalSystemMod.java`（数据包注册）
- `src/main/java/com/easttown/createsignalsystem/client/ClientModEvents.java`（GUI注册）

## 技术细节

### 1. NBT存储结构
**重要：** 进路配置直接存储在`SignalStateDisplayBlockEntity`的NBT中，与现有数据`CurrentRoute`、`ForceRed`等存储在同一NBT标签内。每个信号机方块独立存储自己的配置，不依赖外部配置文件。

```java
// 在SignalStateDisplayBlockEntity.write()方法中添加：
@Override
protected void write(CompoundTag tag, boolean clientPacket) {
    super.write(tag, clientPacket);

    // 现有数据存储...
    tag.putInt("CurrentRoute", currentRoute);
    tag.putBoolean("ForceRed", forceRed);
    // ... 其他现有字段

    // 新增进路配置存储（与现有数据共存）
    CompoundTag routeConfigsTag = new CompoundTag();
    for (Map.Entry<Integer, RouteConfiguration> entry : routeConfigs.entrySet()) {
        routeConfigsTag.put("Route_" + entry.getKey(), entry.getValue().serialize());
    }
    tag.put("RouteConfigs", routeConfigsTag);
}

// 在SignalStateDisplayBlockEntity.read()方法中添加读取逻辑：
@Override
protected void read(CompoundTag tag, boolean clientPacket) {
    super.read(tag, clientPacket);

    // 现有数据读取...
    if (tag.contains("CurrentRoute")) {
        currentRoute = tag.getInt("CurrentRoute");
    }
    if (tag.contains("ForceRed")) {
        forceRed = tag.getBoolean("ForceRed");
    }
    // ... 其他现有字段

    // 新增进路配置读取
    if (tag.contains("RouteConfigs")) {
        CompoundTag routeConfigsTag = tag.getCompound("RouteConfigs");
        routeConfigs.clear();
        for (String key : routeConfigsTag.getAllKeys()) {
            if (key.startsWith("Route_")) {
                try {
                    int routeId = Integer.parseInt(key.substring(6));
                    CompoundTag routeTag = routeConfigsTag.getCompound(key);
                    RouteConfiguration config = RouteConfiguration.deserialize(routeTag);
                    routeConfigs.put(routeId, config);
                } catch (NumberFormatException e) {
                    // 忽略无效键
                }
            }
        }
    }

    // 新增红石信号映射表存储
    CompoundTag signalMappingsTag = new CompoundTag();
    for (Map.Entry<Integer, Integer> entry : signalMappings.entrySet()) {
        CompoundTag mappingTag = new CompoundTag();
        mappingTag.putInt("RedstoneSignal", entry.getKey());
        mappingTag.putInt("TargetSlotId", entry.getValue());
        signalMappingsTag.put("Mapping_" + entry.getKey(), mappingTag);
    }
    tag.put("SignalMappings", signalMappingsTag);
}

// 在SignalStateDisplayBlockEntity.read()方法中添加读取逻辑：
@Override
protected void read(CompoundTag tag, boolean clientPacket) {
    super.read(tag, clientPacket);

    // 现有数据读取...
    if (tag.contains("CurrentRoute")) {
        currentRoute = tag.getInt("CurrentRoute");
    }
    if (tag.contains("ForceRed")) {
        forceRed = tag.getBoolean("ForceRed");
    }
    // ... 其他现有字段

    // 新增进路配置读取
    if (tag.contains("RouteConfigs")) {
        CompoundTag routeConfigsTag = tag.getCompound("RouteConfigs");
        routeConfigs.clear();
        for (String key : routeConfigsTag.getAllKeys()) {
            if (key.startsWith("Route_")) {
                try {
                    int routeId = Integer.parseInt(key.substring(6));
                    CompoundTag routeTag = routeConfigsTag.getCompound(key);
                    RouteConfiguration config = RouteConfiguration.deserialize(routeTag);
                    routeConfigs.put(routeId, config);
                } catch (NumberFormatException e) {
                    // 忽略无效键
                }
            }
        }
    }

    // 新增红石信号映射表读取
    if (tag.contains("SignalMappings")) {
        CompoundTag signalMappingsTag = tag.getCompound("SignalMappings");
        signalMappings.clear();
        for (String key : signalMappingsTag.getAllKeys()) {
            if (key.startsWith("Mapping_")) {
                try {
                    CompoundTag mappingTag = signalMappingsTag.getCompound(key);
                    int redstoneSignal = mappingTag.getInt("RedstoneSignal");
                    int targetSlotId = mappingTag.getInt("TargetSlotId");
                    signalMappings.put(redstoneSignal, targetSlotId);
                } catch (Exception e) {
                    // 忽略无效映射
                }
            }
        }
    }
}
```

### 2. GUI布局（分页设计）

**第一页：信号机详情信息**
```
+--------------------------------+
|      四显示信号机详情          |
|                                |
| 当前状态: 红灯                 |
| 当前进路: 1                    |
| 强制红灯: 否                   |
|                                |
| 信号组占用状态:                |
| • 当前: 空闲                   |
| • 前方1: 占用                  |
| • 前方2: 空闲                  |
| • 前方3: 空闲                  |
|                                |
|       [下一页] [关闭]          |
+--------------------------------+
```

**ESC键处理：**
- 按ESC键退出GUI时自动保存当前配置
- 在`removed()`方法中调用`sendDataToServer()`
- 添加`tick()`方法检测配置变化，延迟自动保存

**第二页及以后：进路配置页面（每页2-3个进路）**
```
+--------------------------------+
|        进路配置 (1-3)          |
|                                |
| 进路 [1] : [直行模式]          |
|  道岔1: [●○○] 左转/直行/右转   |
|  道岔2: [○●○] 左转/直行/右转   |
|  道岔3: [○○●] 左转/直行/右转   |
|  道岔4: [●○○] 左转/直行/右转   |
|                                |
| 进路 [2] : [左转-直行]         |
|  道岔1: [●○○] 左转/直行/右转   |
|  道岔2: [○●○] 左转/直行/右转   |
|  道岔3: [○○●] 左转/直行/右转   |
|  道岔4: [●○○] 左转/直行/右转   |
|                                |
| 进路 [3] : [双左转]            |
|  道岔1: [●○○] 左转/直行/右转   |
|  道岔2: [●○○] 左转/直行/右转   |
|  道岔3: [○●○] 左转/直行/右转   |
|  道岔4: [○●○] 左转/直行/右转   |
|                                |
|  [上一页] [下一页] [保存]      |
+--------------------------------+
```

**进路显示格式：**
- 固定显示"进路 [编号] :"
- 编号为固定值1-7（不可编辑）
- 名称使用`EditBox`组件编辑
- 实时保存名称更改到配置

**自动保存机制：**
1. **ESC键退出**：自动保存所有更改
2. **页面切换**：自动保存当前页配置
3. **实时保存**：名称编辑后延迟1秒自动保存
4. **手动保存**：提供保存按钮作为确认

**NumericSlider配置（图标模式，允许紫黑块）：**
- 使用现有的`NumericSlider`组件，设置`maxValue = 2`（3个位置）
- 启用图标模式：`setIconMode(true)`
- 图标设置：
  - 位置0（左转）：使用null或无效ResourceLocation（显示紫黑块）
  - 位置1（直行）：使用null或无效ResourceLocation（显示紫黑块）
  - 位置2（右转）：使用null或无效ResourceLocation（显示紫黑块）
  - 或者使用占位符图标，等待后续添加自定义箭头贴图
- 设置深色图标模式：`setDarkIconMode(true)`（Create原版风格）
- 值映射：
  - 0 = 左转 (LEFT)
  - 1 = 前进/直行 (NONE)
  - 2 = 右转 (RIGHT)
- **注意**：如果图标为null或无效，会显示紫黑块（missing texture），这是可接受的临时解决方案

**页面分配方案：**
- 页面1: 信号机详情
- 页面2: 进路1-3配置
- 页面3: 进路4-6配置
- 页面4: 进路7配置 + 高级设置
- 使用标签页或翻页按钮切换

### 3. 转向逻辑适配
```java
// 新逻辑：基于配置创建TrackSelector
ITrackSelector createRouteSelector(int routeId, TravellingPoint travellingPoint) {
    RouteConfiguration config = routeConfigs.getOrDefault(routeId, getDefaultConfig(routeId));

    if (config.getTurnRules().isEmpty() && config.isDefaultStraight()) {
        return travellingPoint.steer(SteerDirection.NONE, new Vec3(0, 1, 0));
    }

    // 基于配置规则创建复合选择器
    // 实现略...
}
```

## 验证计划

### 功能测试：
1. 使用扳手右键信号机打开GUI
2. 配置不同进路的转向规则
3. 保存配置并重新加载世界验证持久化
4. 测试实际转向行为是否符合配置

### 兼容性测试：
1. 现有存档的升级兼容性
2. 多人游戏同步测试
3. 与其他模组的兼容性

### 性能测试：
1. NBT存储大小影响
2. GUI渲染性能
3. 转向计算性能

## 风险评估与缓解

### 风险1：NBT数据膨胀
- **风险**：进路配置可能增加NBT数据大小
- **缓解**：使用压缩存储，限制规则数量

### 风险2：客户端-服务器同步
- **风险**：配置不同步导致行为不一致
- **缓解**：使用可靠数据包，添加版本验证

### 风险3：向后兼容性
- **风险**：旧存档升级时丢失进路配置
- **缓解**：添加默认配置生成逻辑

### 风险4：GUI复杂性
- **风险**：界面过于复杂难以使用
- **缓解**：提供预设模板，简化操作流程

## 时间估算
- 基础数据结构：2小时
- GUI界面：4小时
- 网络通信：2小时
- 交互逻辑：3小时
- 测试调试：3小时
- 总计：约14小时

## 成功标准
1. 玩家可以使用扳手右键打开配置GUI
2. 可以配置每个进路的转向规则
3. 配置能够保存并在重新加载后保持
4. 旅行点的实际转向行为符合配置
5. 保持与现有功能的兼容性
