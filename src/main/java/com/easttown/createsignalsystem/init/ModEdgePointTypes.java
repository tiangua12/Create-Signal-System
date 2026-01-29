package com.easttown.createsignalsystem.init;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.edgepoint.DistantSignalEdgePoint;
import com.simibubi.create.content.trains.graph.EdgePointType;
import net.minecraft.resources.ResourceLocation;

/**
 * 注册自定义EdgePoint类型
 */
public class ModEdgePointTypes {

    // 预告信号点类型
    public static final EdgePointType<DistantSignalEdgePoint> DISTANT_SIGNAL =
        EdgePointType.register(
            ResourceLocation.fromNamespaceAndPath(CreateSignalSystemMod.MOD_ID, "distant_signal"),
            DistantSignalEdgePoint::new
        );

    /**
     * 静态初始化 - 确保类型被注册
     */
    public static void init() {
        // 静态字段初始化时会自动注册
        // 这个方法只是确保类被加载
    }
}