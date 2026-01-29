package com.easttown.createsignalsystem.network;

import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.config.RouteConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 进路配置数据包 - 将配置从客户端发送到服务器
 */
public class ConfigureRoutePacket {
    private BlockPos pos;
    private Map<Integer, RouteConfiguration> routeConfigs;
    private Map<Integer, Integer> signalMappings;

    public ConfigureRoutePacket(FriendlyByteBuf buffer) {
        this.pos = buffer.readBlockPos();

        routeConfigs = new HashMap<>();
        signalMappings = new HashMap<>();

        // 读取进路配置
        int routeCount = buffer.readInt();
        for (int i = 0; i < routeCount; i++) {
            int routeId = buffer.readInt();
            CompoundTag tag = buffer.readNbt();
            if (tag != null) {
                RouteConfiguration config = RouteConfiguration.deserialize(tag);
                routeConfigs.put(routeId, config);
            }
        }

        // 读取信号映射
        int mappingCount = buffer.readInt();
        for (int i = 0; i < mappingCount; i++) {
            int signal = buffer.readInt();
            int targetSlot = buffer.readInt();
            signalMappings.put(signal, targetSlot);
        }
    }

    public ConfigureRoutePacket(BlockPos pos, Map<Integer, RouteConfiguration> routeConfigs, Map<Integer, Integer> signalMappings) {
        this.pos = pos;
        this.routeConfigs = routeConfigs;
        this.signalMappings = signalMappings;
    }

    public void write(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(pos);

        // 写入进路配置数量
        buffer.writeInt(routeConfigs.size());
        for (Map.Entry<Integer, RouteConfiguration> entry : routeConfigs.entrySet()) {
            buffer.writeInt(entry.getKey());
            CompoundTag tag = entry.getValue().serialize();
            buffer.writeNbt(tag);
        }

        // 写入信号映射数量
        buffer.writeInt(signalMappings.size());
        for (Map.Entry<Integer, Integer> entry : signalMappings.entrySet()) {
            buffer.writeInt(entry.getKey());
            buffer.writeInt(entry.getValue());
        }
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Level level = context.get().getSender().level();
            if (level == null || !level.isLoaded(pos)) {
                return;
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof SignalStateDisplayBlockEntity signalEntity) {
                // 将配置应用到方块实体
                for (Map.Entry<Integer, RouteConfiguration> entry : routeConfigs.entrySet()) {
                    signalEntity.setRouteConfig(entry.getKey(), entry.getValue());
                }

                for (Map.Entry<Integer, Integer> entry : signalMappings.entrySet()) {
                    signalEntity.setSignalMapping(entry.getKey(), entry.getValue());
                }

                // 标记已更改并通知客户端
                signalEntity.setChanged();
                signalEntity.sendData();
            }
        });
        context.get().setPacketHandled(true);
    }
}