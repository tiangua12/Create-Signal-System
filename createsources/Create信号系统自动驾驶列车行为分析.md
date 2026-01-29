# Create信号系统自动驾驶列车行为分析

基于Create模组源代码分析自动驾驶列车在信号系统中的行为逻辑，重点分析列车遇到红灯时的处理机制，以及非常接近绿灯时突然变成红灯的情况。

## 代码结构概述

关键文件路径：

1. **列车实体和导航系统**：
   - `com/simibubi/create/content/trains/entity/Train.java` - 列车主类
   - `com/simibubi/create/content/trains/entity/Navigation.java` - 列车导航和信号处理

2. **信号系统核心**：
   - `com/simibubi/create/content/trains/signal/SignalBlock.java` - 信号块定义
   - `com/simibubi/create/content/trains/signal/SignalBoundary.java` - 信号块实体
   - `com/simibubi/create/content/trains/signal/SignalEdgeGroup.java` - 信号组管理

3. **信号状态**：
   - `SignalState`枚举：`RED`（红）、`YELLOW`（黄）、`GREEN`（绿）、`INVALID`（无效）
   - `SignalType`枚举：`ENTRY_SIGNAL`（入口信号）、`CROSS_SIGNAL`（交叉信号）

## 自动驾驶列车遇到红灯时的行为

### 1. 信号扫描机制

列车通过`Navigation.tick()`方法中的`signalScout`（旅行点）扫描前方信号：

```java
// 计算制动距离
double acceleration = train.acceleration();
double brakingDistance = (train.speed * train.speed) / (2 * acceleration);
double brakingDistanceNoFlicker = brakingDistance + 3 - (brakingDistance % 3);
double scanDistance = Mth.clamp(brakingDistanceNoFlicker, preDepartureLookAhead, distanceToDestination);
```

扫描距离基于当前速度计算的制动距离，确保列车有足够的距离停车。

### 2. 信号占用检查

在`signalScout.travel()`的回调函数中，检查每个遇到的信号：

```java
boolean occupied = !train.manualTick
    && (signal.isForcedRed(nodes.getSecond()) || signalEdgeGroup.isOccupiedUnless(train));
```

占用条件：
- 列车处于自动驾驶模式（`!train.manualTick`）
- 信号被强制设为红灯（通过红石信号）
- 信号组被其他列车占用（`signalEdgeGroup.isOccupiedUnless(train)`）

### 3. 信号组占用逻辑

`SignalEdgeGroup.isOccupiedUnless()`方法检查信号组是否被占用：

```java
public boolean isOccupiedUnless(Train train) {
    if (intersectingResolved.isEmpty())
        walkIntersecting(intersectingResolved::add);
    for (SignalEdgeGroup group : intersectingResolved)
        if (group.isThisOccupiedUnless(train))
            return true;
    return false;
}

private boolean isThisOccupiedUnless(Train train) {
    return reserved != null || trains.size() > 1 || !trains.contains(train) && !trains.isEmpty();
}
```

信号组被占用的情况：
- 信号组被预留（`reserved != null`）
- 信号组中有多列列车
- 信号组中有列车，但不包含当前列车

### 4. 等待信号处理

如果检测到红灯，列车设置等待状态：

```java
if (occupied) { // Section is occupied
    waitingForSignal = Pair.of(boundary.id, primary);
    distanceToSignal = distance;
    if (!crossSignal)
        return true; // Standard entry signal, do not collect any further segments
}
```

### 5. 速度控制逻辑

列车根据到信号的距离调整目标速度：

```java
double targetDistance = waitingForSignal != null ? distanceToSignal : distanceToDestination;
double targetSpeed = targetDistance > brakingDistance ? topSpeed * speedMod : 0;
train.targetSpeed = targetSpeed;
train.approachTargetSpeed(1);
```

如果到信号的距离小于制动距离，目标速度设为0，列车开始减速。

### 6. 信号监听器

当列车通过信号时，触发`frontSignalListener()`：

```java
public IEdgePointListener frontSignalListener() {
    return (distance, couple) -> {
        if (!(couple.getFirst()instanceof SignalBoundary signal))
            return false;

        // 如果这是等待的信号，停止列车
        if (navigation.waitingForSignal != null && navigation.waitingForSignal.getFirst()
            .equals(signal.getId())) {
            speed = 0;
            navigation.distanceToSignal = 0;
            return true;
        }

        // 占用信号组
        UUID groupId = signal.getGroup(couple.getSecond().getSecond());
        SignalEdgeGroup signalEdgeGroup = Create.RAILWAYS.signalEdgeGroups.get(groupId);
        if (signalEdgeGroup == null)
            return false;

        // 如果信号组被占用且列车没有调度表，触发RED_SIGNAL成就
        if ((runtime.getSchedule() == null || runtime.paused) && signalEdgeGroup.isOccupiedUnless(this))
            carriages.forEach(c -> c.forEachPresentEntity(cce -> cce.getControllingPlayer()
                .ifPresent(uuid -> AllAdvancements.RED_SIGNAL.awardTo(cce.level().getPlayerByUUID(uuid)))));

        // 预留信号组
        signalEdgeGroup.reserved = signal;
        occupy(groupId, signal.id);
        return false;
    };
}
```

### 7. 惩罚系统

列车等待信号时会产生路径查找惩罚：

```java
public static class Penalties {
    static final int STATION = 50, STATION_WITH_TRAIN = 300;
    static final int MANUAL_TRAIN = 200, IDLE_TRAIN = 700, ARRIVING_TRAIN = 50, WAITING_TRAIN = 50, ANY_TRAIN = 25,
        RED_SIGNAL = 25, REDSTONE_RED_SIGNAL = 400;
}

public int getNavigationPenalty() {
    if (manualTick)
        return Penalties.MANUAL_TRAIN;
    if (runtime.getSchedule() == null || runtime.paused)
        return Penalties.IDLE_TRAIN;
    if (navigation.waitingForSignal != null && navigation.ticksWaitingForSignal > 0)
        return Penalties.WAITING_TRAIN + Math.min(navigation.ticksWaitingForSignal / 20, 1000);
    if (navigation.destination != null && navigation.distanceToDestination < 50 || navigation.distanceToSignal < 20)
        return Penalties.ARRIVING_TRAIN;
    return Penalties.ANY_TRAIN;
}
```

## 非常接近绿灯时突然变成红灯的情况分析

### 1. 信号状态更新机制

信号状态在`SignalBoundary.tickState()`中每帧更新：

```java
private void tickState(TrackGraph graph) {
    for (boolean current : Iterate.trueAndFalse) {
        boolean forcedRed = isForcedRed(current);
        UUID group = groups.get(current);
        SignalEdgeGroup signalEdgeGroup = signalEdgeGroups.get(group);

        boolean occupiedUnlessBySelf = forcedRed || signalEdgeGroup.isOccupiedUnless(this);
        cachedStates.set(current, occupiedUnlessBySelf ? SignalState.RED : resolveSignalChain(graph, current));
    }
}
```

信号状态根据占用情况实时变化，可能从绿变红。

### 2. 列车响应机制

列车通过`signalScout`每帧扫描前方信号，能够检测到信号状态的突然变化：

1. **扫描频率**：`signalScout`在每帧的`Navigation.tick()`中执行
2. **检测延迟**：最多1帧的延迟（约50毫秒，在20TPS下）
3. **制动距离**：列车基于当前速度计算制动距离，如果信号突然变红时列车已经非常接近，可能无法及时停止

### 3. 临界情况分析

**场景**：列车以高速接近绿灯，距离信号很近时信号突然变红。

**可能结果**：

1. **成功停车**：如果制动距离足够，列车在信号前停止
   - 条件：`distanceToSignal > brakingDistance`
   - 行为：列车减速至0，等待信号变绿

2. **闯红灯**：如果制动距离不足，列车可能通过红灯信号
   - 条件：`distanceToSignal <= brakingDistance`
   - 行为：列车无法及时停止，通过信号
   - 后果：触发`RED_SIGNAL`成就（如果列车没有调度表或暂停）

3. **信号组预留冲突**：如果信号组被其他列车占用，当前列车闯红灯可能导致冲突
   - 信号组占用逻辑防止多列车进入同一区域
   - 但时间窗口内可能发生冲突

### 4. 安全机制

1. **提前扫描**：`scanDistance`基于制动距离，列车提前检测信号
2. **信号预留**：列车通过信号时预留信号组，防止其他列车进入
3. **交叉信号连锁**：`CROSS_SIGNAL`类型信号形成连锁，确保所有路径空闲
4. **强制红灯**：红石信号可以强制设为红灯，优先级最高

### 5. 交叉信号的特殊处理

交叉信号（`SignalType.CROSS_SIGNAL`）有特殊逻辑：

```java
private SignalState resolveSignalChain(TrackGraph graph, boolean side) {
    if (types.get(side) != SignalType.CROSS_SIGNAL)
        return SignalState.GREEN;

    // 收集连锁信号
    boolean allPathsFree = true;
    boolean noPathsFree = true;

    for (Entry<UUID, Boolean> entry : chainedSignals.get(side).entrySet()) {
        SignalState otherState = otherSignal.cachedStates.get(sideOfOther);
        allPathsFree &= otherState == SignalState.GREEN || otherState == SignalState.INVALID;
        noPathsFree &= otherState == SignalState.RED;
    }

    if (allPathsFree)
        return SignalState.GREEN;
    if (noPathsFree)
        return SignalState.RED;
    return SignalState.YELLOW;
}
```

交叉信号需要所有路径空闲才能变绿，任何一条路径占用都会变红或黄。

## 总结

### 自动驾驶列车遇到红灯时的行为：

1. **提前检测**：基于制动距离扫描前方信号
2. **减速停车**：如果检测到红灯，计算制动距离并减速
3. **等待信号**：在信号前停止，等待信号变绿
4. **占用信号组**：通过信号时预留信号组，防止其他列车进入
5. **惩罚系统**：等待信号增加路径查找成本

### 非常接近绿灯时突然变成红灯的情况：

1. **实时响应**：列车每帧检测信号状态变化
2. **制动距离限制**：能否及时停车取决于当前速度和制动距离
3. **安全风险**：如果制动距离不足，可能闯红灯
4. **成就触发**：闯红灯且列车没有调度表时触发`RED_SIGNAL`成就
5. **系统稳健性**：信号组占用逻辑和预留机制防止严重碰撞

### 设计特点：

1. **保守策略**：基于制动距离的提前扫描
2. **实时更新**：信号状态每帧更新
3. **防御性驾驶**：交叉信号连锁确保安全
4. **惩罚机制**：鼓励高效路径规划
5. **成就系统**：教育玩家正确使用信号

该信号系统实现了较为安全的铁路自动化，平衡了效率和安全。但在极端情况下（高速接近突然变红的信号），物理限制可能导致闯红灯行为。

---
*分析基于Create模组源代码，版本信息见version.properties*