package com.easttown.createsignalsystem.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ModConfiguration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // 配置项定义
    public static final ForgeConfigSpec.BooleanValue ENABLE_DEBUG_LOGGING;
    public static final ForgeConfigSpec.BooleanValue ENABLE_DETAILED_ALGORITHM_TRACING;
    public static final ForgeConfigSpec.BooleanValue ENABLE_PERFORMANCE_LOGGING;

    static {
        BUILDER.push("general").comment("通用配置");

        ENABLE_DEBUG_LOGGING = BUILDER
                .comment("启用调试日志输出")
                .comment("如果启用，将显示详细的调试信息")
                .define("enableDebugLogging", false);

        ENABLE_DETAILED_ALGORITHM_TRACING = BUILDER
                .comment("启用详细算法跟踪")
                .comment("如果启用，将显示信号算法的详细执行步骤")
                .define("enableDetailedAlgorithmTracing", false);

        ENABLE_PERFORMANCE_LOGGING = BUILDER
                .comment("启用性能日志")
                .comment("如果启用，将记录算法执行时间等性能信息")
                .define("enablePerformanceLogging", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    /**
     * 注册配置
     */
    public static void register() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON,
                SPEC,
                "create_signal_system.toml"
        );
    }

    /**
     * 检查是否启用调试日志
     */
    public static boolean isDebugLoggingEnabled() {
        return ENABLE_DEBUG_LOGGING.get();
    }

    /**
     * 检查是否启用详细算法跟踪
     */
    public static boolean isDetailedAlgorithmTracingEnabled() {
        return ENABLE_DETAILED_ALGORITHM_TRACING.get();
    }

    /**
     * 检查是否启用性能日志
     */
    public static boolean isPerformanceLoggingEnabled() {
        return ENABLE_PERFORMANCE_LOGGING.get();
    }
}