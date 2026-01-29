# Create信号系统强制停止机制修改方案

本文档提供通过Mixin修改Create模组，使自动驾驶列车在遇到红灯时不能强制瞬间停止，最多只能以最大减速度滑行，可能闯红灯的方案。

## 一、当前强制停止机制分析

### 1.1 关键代码位置
`Train.java:426-470` 的 `frontSignalListener()` 方法：

```java
public IEdgePointListener frontSignalListener() {
    return (distance, couple) -> {
        // ... 其他逻辑 ...

        if (!(couple.getFirst()instanceof SignalBoundary signal))
            return false;

        // 关键强制停止逻辑
        if (navigation.waitingForSignal != null && navigation.waitingForSignal.getFirst()
            .equals(signal.getId())) {
            speed = 0;  // ← 强制瞬间停止
            navigation.distanceToSignal = 0;
            return true;  // ← 阻止后续处理
        }

        // ... 信号组占用逻辑 ...
    };
}
```

### 1.2 现有三级制动系统

| 制动类型 | 减速度公式 | 触发条件 | 效果 |
|---------|-----------|----------|------|
| **正常减速** | `acceleration() × 1` | 自动驾驶检测到红灯 | 渐进减速 |
| **紧急制动** | `acceleration() × 2` | 手动反向操作 | 加倍减速 |
| **强制停止** | `∞`（瞬间） | 前端到达等待的信号 | 瞬间停止 |

### 1.3 制动距离计算
```java
// Navigation.java:102
double brakingDistance = (train.speed * train.speed) / (2 * acceleration);

// Navigation.java:279-290
double targetSpeed = targetDistance > brakingDistance ? topSpeed * speedMod : 0;
train.targetSpeed = targetSpeed;
train.approachTargetSpeed(1);  // 使用正常减速度
```

## 二、修改目标

### 2.1 预期行为
1. **移除强制瞬间停止**：列车前端到达等待的信号时，不能直接 `speed = 0`
2. **只能最大减速度滑行**：使用紧急制动减速度 `acceleration() × 2`
3. **允许闯红灯**：如果制动距离不足，列车可以滑过信号
4. **保持信号组占用**：列车通过信号后正常占用信号组

### 2.2 物理限制
- **最大减速度**：`acceleration() × 2`
- **制动距离**：`speed² / (2 × acceleration × 2) = speed² / (4 × acceleration)`
- **滑行距离**：实际停车距离可能大于理论制动距离

## 三、Mixin实现方案

### 3.1 Mixin类结构
```java
@Mixin(Train.class)
public abstract class TrainMixin {

    @Shadow public Navigation navigation;
    @Shadow public double speed;

    @Shadow public abstract float acceleration();

    /**
     * 修改 frontSignalListener 方法中的强制停止逻辑
     * 注入点：方法内部的条件判断块
     */
    @ModifyVariable(
        method = "frontSignalListener()Lcom/simibubi/create/foundation/utility/IEdgePointListener;",
        at = @At(
            value = "INVOKE",
            target = "Lcom/simibubi/create/content/trains/entity/Navigation;getWaitingForSignal()Lorg/apache/commons/lang3/tuple/Pair;",
            ordinal = 0
        ),
        ordinal = 0
    )
    private boolean modifyEmergencyStop(boolean original) {
        // 修改逻辑：不强制停止，改为最大减速度滑行
        return false;  // 让后续代码继续执行
    }
}
```

### 3.2 更直接的修改方案（推荐）
直接替换 `frontSignalListener()` 方法中的强制停止逻辑：

```java
@Mixin(Train.class)
public abstract class TrainMixin {

    @Shadow public Navigation navigation;
    @Shadow public double speed;
    @Shadow public double targetSpeed;

    @Shadow public abstract float acceleration();

    /**
     * 修改强制停止为最大减速度滑行
     * 注入点：在设置 speed = 0 之前
     */
    @Inject(
        method = "lambda$frontSignalListener$0",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/Double;doubleValue()D",
            ordinal = 0
        ),
        cancellable = true
    )
    private void onEmergencyStop(CallbackInfoReturnable<Boolean> cir) {
        // 获取当前速度方向
        double currentSpeed = this.speed;

        if (navigation.waitingForSignal != null) {
            // 不清除速度，改为设置目标速度为0并应用紧急减速度
            targetSpeed = 0;

            // 应用最大减速度 (acceleration * 2)
            // 注意：实际减速在 approachTargetSpeed 方法中处理
            // 这里只是设置状态，让列车知道需要紧急制动

            // 清除等待状态，让列车可以继续处理信号
            navigation.waitingForSignal = null;
            navigation.distanceToSignal = 0;

            // 不停止方法执行，让后续信号组占用逻辑继续
            cir.setReturnValue(false);
        }
    }
}
```

### 3.3 完整Mixin实现
```java
package com.example.createmixin.mixin;

import com.simibubi.create.content.trains.entity.Navigation;
import com.simibubi.create.content.trains.entity.Train;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Train.class)
public abstract class TrainMixin {

    @Shadow public Navigation navigation;
    @Shadow public double speed;
    @Shadow public double targetSpeed;

    @Shadow public abstract float acceleration();

    /**
     * 修改前端信号监听器的强制停止逻辑
     * 原逻辑：speed = 0（瞬间停止）
     * 新逻辑：targetSpeed = 0 + 最大减速度滑行
     */
    @Inject(
        method = "lambda$frontSignalListener$0",  // Lambda方法名可能不同，需要反编译确认
        at = @At(
            value = "FIELD",
            target = "Lcom/simibubi/create/content/trains/entity/Train;speed:D",
            opcode = Opcodes.PUTFIELD,
            ordinal = 0
        ),
        cancellable = true
    )
    private void modifyFrontSignalStop(CallbackInfoReturnable<Boolean> cir) {
        // 取消原来的 speed = 0 操作
        cir.cancel();

        // 设置目标速度为0，让列车以最大减速度减速
        targetSpeed = 0;

        // 如果需要应用紧急减速度，可以在这里设置一个标志
        // 然后在 approachTargetSpeed 方法中检查这个标志

        // 清除等待信号状态
        if (navigation != null) {
            navigation.waitingForSignal = null;
            navigation.distanceToSignal = 0;
        }

        // 返回 false，让信号组占用逻辑继续执行
        cir.setReturnValue(false);
    }

    /**
     * 可选：修改 approachTargetSpeed 方法，在紧急制动时使用最大减速度
     */
    @Inject(
        method = "approachTargetSpeed",
        at = @At("HEAD")
    )
    private void onApproachTargetSpeed(float accelerationMod, CallbackInfo ci) {
        // 检查是否需要紧急制动（当前速度 > 0 且目标速度 = 0 且距离信号很近）
        if (navigation != null && navigation.waitingForSignal != null
            && speed > 0 && targetSpeed == 0
            && navigation.distanceToSignal < (speed * speed) / (4 * acceleration())) {
            // 使用最大减速度 (accelerationMod = 2)
            accelerationMod = 2.0f;
        }
    }
}
```

## 四、备选方案：修改Navigation类

### 4.1 修改制动距离计算
```java
@Mixin(Navigation.class)
public abstract class NavigationMixin {

    /**
     * 修改制动距离计算，增加安全系数
     * 使列车更早开始减速，但最终可能仍然闯红灯
     */
    @ModifyVariable(
        method = "tick",
        at = @At(value = "STORE", ordinal = 0),
        ordinal = 1
    )
    private double modifyBrakingDistance(double original) {
        // 原公式：brakingDistance = (speed * speed) / (2 * acceleration)
        // 改为使用最大减速度计算：brakingDistance = (speed * speed) / (4 * acceleration)
        // 这样制动距离减半，列车需要更早开始减速
        return original / 2.0;
    }

    /**
     * 修改目标速度计算逻辑
     */
    @Redirect(
        method = "tick",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/Math;max(DD)D"
        )
    )
    private double modifyTargetSpeedLogic(double a, double b) {
        // 原逻辑：targetSpeed = targetDistance > brakingDistance ? topSpeed : 0
        // 修改为：即使targetDistance <= brakingDistance，也不立即设为0
        // 而是根据剩余距离线性减少目标速度
        if (targetDistance <= brakingDistance) {
            // 线性减少，最小为0
            return Math.max(0, topSpeed * (targetDistance / brakingDistance));
        }
        return Math.max(a, b);
    }
}
```

## 五、测试方案

### 5.1 测试场景
1. **低速接近**：速度5m/s，距离信号10m
   - 预期：能在信号前停止
   - 制动距离：5²/(4×0.02)=312.5m（假设加速度0.02）

2. **高速接近**：速度15m/s，距离信号50m
   - 预期：可能闯红灯
   - 制动距离：15²/(4×0.02)=2812.5m

3. **临界情况**：速度10m/s，距离信号30m
   - 预期：滑行通过信号

### 5.2 验证点
1. ✅ 列车前端到达信号时不会瞬间停止
2. ✅ 使用最大减速度减速（accelerationMod = 2）
3. ✅ 可以闯红灯通过信号
4. ✅ 通过后正常占用信号组
5. ✅ 不会触发异常或崩溃

## 六、注意事项

### 6.1 潜在问题
1. **信号组冲突**：多列车可能同时进入同一信号组
2. **路径查找异常**：闯红灯后导航系统可能混乱
3. **成就系统**：有时刻表的列车闯红灯不会触发RED_SIGNAL成就
4. **物理碰撞**：如果另一列车已在信号组内，可能发生碰撞

### 6.2 兼容性考虑
1. **Mixin版本**：确保与Create模组版本兼容
2. **其他模组**：可能与其他修改列车行为的模组冲突
3. **多人游戏**：需要在客户端和服务器端同时安装

### 6.3 性能影响
1. **计算开销**：最大减速度计算增加少量开销
2. **网络同步**：列车位置同步可能更频繁
3. **信号更新**：信号组状态更新更复杂

## 七、部署步骤

### 7.1 开发环境
```gradle
dependencies {
    implementation 'org.spongepowered:mixin:0.8.5'
    implementation 'net.minecraftforge:forge:1.20.1-47.1.0'
}
```

### 7.2 Mixin配置文件
```json
// mixins.createtrains.json
{
  "required": true,
  "minVersion": "0.8",
  "package": "com.example.createmixin.mixin",
  "compatibilityLevel": "JAVA_17",
  "mixins": [
    "TrainMixin",
    "NavigationMixin"
  ],
  "injectors": {
    "defaultRequire": 1
  }
}
```

### 7.3 构建与测试
1. 编译Mixin模组
2. 在开发环境中测试
3. 调整参数优化效果
4. 发布最终版本

## 八、总结

通过Mixin修改Create模组的强制停止机制，可以实现：
1. **移除瞬间停止**：列车不会在信号位置强制停止
2. **最大减速度滑行**：使用紧急制动减速度减速
3. **允许闯红灯**：制动距离不足时可以通过信号
4. **保持系统完整性**：其他信号逻辑正常运作

这种修改适合想要更真实物理模拟或增加挑战性的玩家，但需要注意可能增加列车碰撞的风险。

---
*注：具体Mixin方法名可能需要根据实际反编译结果调整。建议使用MixinGradle或类似工具分析原版代码结构。*