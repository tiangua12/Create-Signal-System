# Create铁路系统区块加载机制分析

本文档详细分析机械动力（Create）模组的铁路系统为什么能够在区块不加载时继续运行的底层技术实现。

## 一、核心设计理念

Create铁路系统的核心设计理念是**逻辑与渲染分离**：

1. **逻辑层**：列车位置、速度、信号状态等由纯Java对象管理
2. **渲染层**：列车实体（`CarriageContraptionEntity`）仅负责视觉表现和物理交互
3. **数据层**：轨道图（`TrackGraph`）作为全局数据结构独立于区块存在

## 二、系统架构概览

### 2.1 关键组件

| 组件 | 作用 | 区块依赖 |
|------|------|----------|
| `GlobalRailwayManager` | 全局铁路管理器，存储所有列车和轨道图 | 无 |
| `Train` | 列车逻辑对象，管理速度、导航、车厢 | 无 |
| `TravellingPoint` | 旅行点，在轨道图上定位和移动 | 无 |
| `TrackGraph` | 轨道图，存储节点和边的拓扑结构 | 无 |
| `CarriageContraptionEntity` | 列车实体，负责渲染和碰撞 | 依赖区块加载 |
| `Carriage` | 车厢逻辑，连接逻辑和实体 | 部分依赖 |

### 2.2 数据流
```
逻辑更新周期（每tick）：
GlobalRailwayManager.tick() → Train.tick() → Carriage.travel() → TravellingPoint.travel()

实体管理周期：
Carriage.manageEntities() → 检查区块活跃度 → 创建/移除实体
```

## 三、区块不加载时的运行机制

### 3.1 逻辑继续运行

即使区块未加载，以下逻辑仍然每tick执行：

```java
// GlobalRailwayManager.java:187-208
public void tick(Level level) {
    if (level.dimension() != Level.OVERWORLD)
        return;

    // 1. 清理信号组状态
    signalEdgeGroups.forEach((id, group) -> {
        group.trains.clear();
        group.reserved = null;
    });

    // 2. 更新轨道图点（信号等）
    trackNetworks.forEach((id, graph) -> {
        graph.tickPoints(true);
        graph.resolveIntersectingEdgeGroups(level);
    });

    // 3. 更新所有列车逻辑
    tickTrains(level);

    // 4. 后处理轨道图点
    trackNetworks.forEach((id, graph) -> graph.tickPoints(false));
}
```

### 3.2 旅行点移动不受区块限制

`TravellingPoint.travel()`方法纯粹在数学上沿着轨道图移动：

```java
// TravellingPoint.java:185-355
public double travel(TrackGraph graph, double distance, ITrackSelector trackSelector,
    IEdgePointListener signalListener, ITurnListener turnListener, IPortalListener portalListener) {

    // 基于距离计算新位置，遍历轨道边
    // 不检查区块状态，只操作TrackGraph数据结构
}
```

### 3.3 实体智能管理

#### 3.3.1 区块活跃度检测
```java
// CarriageEntityHandler.java:39-43
public static boolean isActiveChunk(Level level, BlockPos pos) {
    if (level instanceof ServerLevel serverLevel)
        return serverLevel.isPositionEntityTicking(pos);
    return false;
}
```

#### 3.3.2 实体生命周期
```java
// Carriage.java:239-299
public void manageEntities(Level level) {
    // 检查列车当前所在的维度
    currentlyTraversedDimensions.clear();
    bogeys.forEach(cb -> {
        cb.points.forEach(tp -> {
            if (tp.node1 != null)
                currentlyTraversedDimensions.add(tp.node1.getLocation().dimension);
        });
    });

    // 管理每个维度上的实体
    for (Entry<ResourceKey<Level>, DimensionalCarriageEntity> entry : entities.entrySet()) {
        // 如果实体在不活跃的区块，标记为leftTickingChunks
        CarriageEntityHandler.validateCarriageEntity(entity);
        if (!entity.isAlive() || entity.leftTickingChunks || discard) {
            dimensionalCarriageEntity.removeAndSaveEntity(entity, discard);
            continue;
        }
    }
}
```

## 四、关键特性详解

### 4.1 玩家在车上的特殊处理

当有玩家在列车上时，系统会确保前方区块加载：

```java
// Carriage.java:863-881
for (Entity e : entity.getPassengers()) {
    if (!(e instanceof Player))
        continue;
    if (e.distanceToSqr(entity) > 32 * 32)
        continue;
    if (CarriageEntityHandler.isActiveChunk(entity.level(), BlockPos.containing(lookahead)))
        break;
    train.carriageWaitingForChunks = id;  // 标记为等待区块
    return;
}
```

在列车tick中：
```java
// Train.java:285
if (carriageWaitingForChunks != -1)
    distance = 0;  // 停止移动，等待区块加载
```

### 4.2 数据持久化

铁路数据通过`RailwaySavedData`保存，继承自`SavedData`：

```java
// RailwaySavedData.java
public class RailwaySavedData extends SavedData {
    private Map<UUID, TrackGraph> trackNetworks;
    private Map<UUID, SignalEdgeGroup> signalBlocks;
    private Map<UUID, Train> trains;

    public static RailwaySavedData load(MinecraftServer server) {
        // 从世界存储加载
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        // 保存到世界存储
    }
}
```

### 4.3 多维度支持

列车可以跨维度运行，每个维度有独立的实体：

```java
// Carriage.java:252-264
for (Iterator<Entry<ResourceKey<Level>, DimensionalCarriageEntity>> iterator =
     entities.entrySet().iterator(); iterator.hasNext();) {

    Entry<ResourceKey<Level>, DimensionalCarriageEntity> entry = iterator.next();
    MinecraftServer server = level.getServer();
    ServerLevel currentLevel = server.getLevel(entry.getKey());

    // 为每个维度管理实体
}
```

## 五、性能优化设计

### 5.1 延迟实体创建

实体只在需要时创建（区块活跃且有玩家附近）：

```java
// Carriage.java:269-274
if (entity == null) {
    if (dimensionalCarriageEntity.positionAnchor != null &&
        CarriageEntityHandler.isActiveChunk(currentLevel,
            BlockPos.containing(dimensionalCarriageEntity.positionAnchor))) {
        dimensionalCarriageEntity.createEntity(currentLevel, anyAvailableEntity() == null);
    }
}
```

### 5.2 列车状态缓存

列车位置、速度等状态缓存在`Train`对象中，避免频繁计算。

### 5.3 轨道图增量更新

轨道图只在修改时更新，移动时只更新旅行点位置。

## 六、与Minecraft原生机制对比

| 特性 | Minecraft原生矿车 | Create列车 |
|------|-------------------|------------|
| **区块依赖** | 完全依赖，区块卸载时停止 | 逻辑独立，实体依赖 |
| **数据存储** | 实体NBT | 独立SavedData |
| **跨区块移动** | 需要区块加载 | 逻辑上可跨任何区块 |
| **玩家在车上** | 强制区块加载 | 检查并等待区块加载 |
| **性能影响** | 高（实体始终存在） | 低（实体按需创建） |

## 七、限制与边界情况

### 7.1 当前限制

1. **信号交互**：信号块需要区块加载才能检测列车占用
2. **车站交互**：车站需要区块加载才能处理停车
3. **观察者触发**：轨道观察者需要区块加载才能检测物品

### 7.2 已知问题

1. **区块边界停车**：如果前方区块未加载且列车上有玩家，列车会停止
2. **实体同步延迟**：区块加载后实体重新创建可能有短暂延迟
3. **内存占用**：大型轨道图可能占用较多内存

## 八、技术实现总结

Create铁路系统能在区块不加载时运行的关键技术：

1. **抽象层分离**：逻辑状态与实体渲染完全分离
2. **图论基础**：基于轨道图的数学移动，不依赖世界状态
3. **懒加载实体**：实体按需创建和销毁，减少性能开销
4. **智能区块检测**：仅在必要时检查区块状态
5. **数据持久化**：独立于区块的全局数据存储

这种设计使得Create铁路系统能够：
- ✅ 在无人区域继续运行
- ✅ 跨越未加载区块（逻辑上）
- ✅ 节省服务器资源
- ✅ 保持状态持久性
- ✅ 支持超大规模铁路网络

## 九、扩展思考

### 9.1 可能的改进

1. **预测性区块加载**：基于列车时刻表预加载前方区块
2. **信号缓存**：缓存信号状态避免区块依赖
3. **异步实体管理**：在独立线程处理实体更新

### 9.2 设计启示

Create的这种"逻辑优先，渲染其次"的设计模式可用于其他需要跨区块运行的模组系统，如：
- 物流管道网络
- 无线能源系统
- 全局信号网络

---
*分析基于Create模组源代码，版本信息见version.properties。具体实现可能随版本更新而变化。*