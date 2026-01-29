# 四显示信号机GUI进路配置标签页完善计划

## 项目概述
当前四显示信号机的GUI界面（RouteConfigScreen.java）已经实现了基本框架和部分标签页，但进路配置标签页（进路1-3、进路4-6、进路7）的内容尚未实现。本计划旨在完成这些缺失的进路配置UI，使玩家能够通过GUI配置每个进路的转向规则。

## 当前状态分析

### 已完成的组件
1. **基础数据结构** - RouteConfiguration.java, TurnAction.java, SignalMapping.java 已完整实现
2. **方块实体集成** - SignalStateDisplayBlockEntity.java 已集成进路配置系统，包括：
   - 配置存储字段（routeConfigs, signalMappings）
   - NBT序列化方法（write/read）
   - 默认配置初始化（initializeDefaultConfigs）
   - 进路选择器逻辑（createRouteSelector）
3. **网络通信** - ConfigureRoutePacket.java 已实现客户端-服务器配置同步
4. **GUI框架** - RouteConfigScreen.java 已实现：
   - 5个标签页的框架结构
   - 详情标签页（显示信号机状态）
   - 映射配置标签页（显示红石信号映射）
   - 基本UI组件（标签页按钮、操作按钮）
5. **交互逻辑** - SignalStateDisplayBlock.java 已实现扳手打开GUI功能

### 缺失的功能
1. **进路配置标签页UI** - 标签页2-4（进路1-3、进路4-6、进路7）仅有空框架
2. **配置保存逻辑** - saveCurrentTabConfig() 方法未实现
3. **进路配置组件** - 缺少每个进路的：
   - 显示编号输入框（EditBox）
   - 显示名称输入框（EditBox）
   - 4个道岔转向滑条（NumericSlider）
   - 默认直行复选框（如果需要）

## 技术分析

### 现有UI组件模式
从 RouteConfigScreen.java 分析现有模式：
- 使用 Create 模组的 AbstractSimiScreen 基类
- 使用 IconButton 作为操作按钮
- 使用 Label 显示文本
- 使用 EditBox 进行文本输入（在 initMappingTab 中已使用）

### NumericSlider 组件分析
NumericSlider 组件位于 `client/widget/NumericSlider.java`，支持：
- 任意格子数量（maxValue 决定）
- 图标模式（iconMode）
- 深色图标模式（darkIconMode，Create原版风格）
- 值变化回调（onValueChanged）

对于转向配置，需要设置为：
- maxValue = 2（3个位置：左转/直行/右转）
- iconMode = true（显示图标）
- 图标设置：可以使用 null 或无效 ResourceLocation 显示紫黑块作为占位符
- 值映射：0=左转(LEFT), 1=直行(NONE), 2=右转(RIGHT)

### 配置数据结构
每个进路（RouteConfiguration）包含：
- slotId: 进路ID（1-7）
- displayNumber: 显示编号字符串
- displayName: 显示名称
- turnActions[4]: 4个道岔的转向动作数组
- defaultStraight: 默认直行标志

每个转向动作（TurnAction）包含：
- junctionIndex: 岔道索引（1-4）
- direction: 转向方向（LEFT/RIGHT/NONE）
- distanceThreshold: 距离阈值（可选）
- speedLimit: 速度限制（可选）

## 实施计划

### 第一阶段：完善进路配置标签页UI
1. **实现 initRouteTab(int startRoute, int endRoute) 方法**
   - 为每个进路（startRoute到endRoute）创建配置区域
   - 每个进路区域包含：
     - 显示编号输入框（EditBox）
     - 显示名称输入框（EditBox）
     - 4个垂直排列的 NumericSlider（每个道岔）
     - 滑条标签（如"道岔1"、"道岔2"等）
   - 使用现有 routeConfigs 数据初始化组件值

2. **实现 initRoute7Tab() 方法**
   - 与 initRouteTab 类似，但专为进路7设计
   - 可添加高级设置区域（距离阈值、速度限制输入框）

3. **实现对应的渲染方法**
   - 在 renderTabContent 中添加对应标签页的渲染逻辑
   - 确保滑条和输入框正确显示

### 第二阶段：实现配置保存逻辑
1. **实现 saveCurrentTabConfig() 方法**
   - 根据当前标签页收集配置数据
   - 对于进路配置标签页：收集每个进路的显示编号、显示名称、4个滑条值
   - 将滑条值（0-2）转换为 TurnAction 方向枚举
   - 更新 routeConfigs 映射

2. **实现滑条和输入框的事件处理**
   - 为 NumericSlider 设置 onValueChanged 回调，实时保存配置
   - 为 EditBox 设置 changeListener，实时保存配置
   - 添加防抖机制避免频繁保存

### 第三阶段：集成和测试
1. **验证GUI正常打开和显示**
2. **测试配置保存和加载**
3. **验证转向行为按配置工作**
4. **测试多人游戏同步**

## 详细实现步骤

### 1. 扩展 RouteConfigScreen 类
**修改文件：** `src/main/java/com/easttown/createsignalsystem/client/gui/screen/RouteConfigScreen.java`

**新增字段：**
```java
// 进路配置标签页的UI组件存储
private Map<Integer, EditBox> displayNumberBoxes = new HashMap<>();
private Map<Integer, EditBox> displayNameBoxes = new HashMap<>();
private Map<Integer, NumericSlider[]> turnSliders = new HashMap<>();
```

**修改 initRouteTab 方法：**
- 为每个进路创建配置区域
- 使用垂直布局，每个进路占用一定高度
- 添加标签和组件到对应映射中

**滑条配置示例：**
```java
NumericSlider slider = new NumericSlider(x, y, 120, 20);
slider.setMaxValue(2); // 3个位置
slider.setIconMode(true);
slider.setDarkIconMode(true);
slider.setCurrentValue(getDirectionValue(turnAction.getDirection()));
slider.onValueChanged = (newValue) -> {
    // 更新配置并保存
    TurnAction action = turnActions[junctionIndex];
    action.setDirection(getDirectionFromValue(newValue));
    saveCurrentTabConfig();
};
```

### 2. 实现工具方法
**方向值转换：**
```java
private int getDirectionValue(TravellingPoint.SteerDirection direction) {
    switch (direction) {
        case LEFT: return 0;
        case NONE: return 1;
        case RIGHT: return 2;
        default: return 1;
    }
}

private TravellingPoint.SteerDirection getDirectionFromValue(int value) {
    switch (value) {
        case 0: return TravellingPoint.SteerDirection.LEFT;
        case 1: return TravellingPoint.SteerDirection.NONE;
        case 2: return TravellingPoint.SteerDirection.RIGHT;
        default: return TravellingPoint.SteerDirection.NONE;
    }
}
```

### 3. 完善 saveCurrentTabConfig 方法
根据当前标签页类型处理配置保存：
- 详情标签页：无需保存
- 进路配置标签页：保存所有显示的进路配置
- 映射标签页：保存信号映射（已部分实现）

## 关键文件路径

### 主要修改文件：
1. `src/main/java/com/easttown/createsignalsystem/client/gui/screen/RouteConfigScreen.java`
   - 实现进路配置标签页UI
   - 实现配置保存逻辑

### 相关文件：
1. `src/main/java/com/easttown/createsignalsystem/client/widget/NumericSlider.java`
   - 滑条组件使用参考

## 验证计划

### 功能测试：
1. 使用扳手右键信号机打开GUI
2. 切换到进路1-3配置标签页
3. 修改进路1的显示编号和名称
4. 调整4个道岔的转向滑条
5. 切换到其他标签页再切换回来，验证配置保持
6. 保存配置并重新加载世界，验证持久化
7. 测试实际转向行为是否符合配置

### 兼容性测试：
1. 现有存档的升级兼容性
2. 多人游戏同步测试
3. 与其他模组的兼容性

## 风险评估与缓解

### 风险1：GUI布局复杂
- **风险**：进路配置标签页包含大量组件，布局可能混乱
- **缓解**：使用垂直流式布局，确保组件不重叠；添加滚动功能如果内容过多

### 风险2：配置保存性能
- **风险**：实时保存可能导致频繁的网络数据包发送
- **缓解**：添加防抖机制（延迟保存）；仅在必要时发送数据包

### 风险3：NumericSlider图标显示
- **风险**：图标模式可能显示紫黑块（missing texture）
- **缓解**：接受紫黑块作为临时解决方案；未来可添加自定义箭头图标

## 成功标准
1. 玩家可以打开GUI并切换到所有标签页
2. 进路配置标签页显示完整的配置界面
3. 可以修改每个进路的显示编号、名称和转向规则
4. 配置修改后能够正确保存
5. 保存后的配置能够持久化并在重新加载后保持
6. 实际转向行为符合GUI中的配置