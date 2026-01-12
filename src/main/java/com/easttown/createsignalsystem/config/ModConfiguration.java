package com.easttown.createsignalsystem.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ModConfiguration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // 配置项定义
    public static final ForgeConfigSpec.BooleanValue ENABLE_DEBUG_OUTPUT;

    static {
        BUILDER.push("general").comment("通用配置");

        ENABLE_DEBUG_OUTPUT = BUILDER
                .comment("启用调试日志输出")
                .comment("如果启用，将显示所有调试信息（包括算法跟踪和性能日志）")
                .comment("禁用时，只输出info、warn、error级别的关键日志")
                .define("enableDebugOutput", false);

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
     * 检查是否启用调试输出
     */
    public static boolean isDebugOutputEnabled() {
        return ENABLE_DEBUG_OUTPUT.get();
    }
}