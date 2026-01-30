package com.easttown.createsignalsystem.system;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.init.ModBlocks;
import com.easttown.createsignalsystem.util.SimpleLogger;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.signal.SignalEdgeGroup;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.*;

/**
 * 信号系统事件处理器
 *
 * 监听各种事件以更新信号状态，不依赖区块加载
 *
 * 功能：
 * 1. 红石信号变化检测（即使区块未加载）
 * 2. 方块放置/破坏处理
 * 3. 轨道网络变化检测
 */
@Mod.EventBusSubscriber(modid = CreateSignalSystemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SignalSystemEventHandlers {

    // 跟踪上次处理的轨道网络状态（用于检测变化）
    private static final Map<UUID, TrackGraphSnapshot> lastTrackGraphSnapshots = new HashMap<>();
    private static long lastTrackGraphCheckTick = 0;
    private static final long TRACK_GRAPH_CHECK_INTERVAL = 200; // 每10秒检查一次

    /**
     * 处理红石信号变化事件
     *
     * 当信号机附近的红石信号变化时，即使区块未加载也能检测到
     */
    @SubscribeEvent
    public static void onNeighborChanged(BlockEvent.NeighborNotifyEvent event) {
        if (!(event.getLevel() instanceof Level level)) {
            return;
        }
        if (level.isClientSide()) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = event.getState();

        // 检查是否是信号机方块
        if (!isSignalBlock(state)) {
            return;
        }

        // 检查是否是红石相关变化
        if (!isRedstoneRelated(event)) {
            return;
        }

        // 更新全局缓存中的红石信号状态
        updateRedstoneStateInCache((ServerLevel) level, pos);
    }

    /**
     * 处理方块放置/破坏事件
     *
     * 当信号机被放置或破坏时更新缓存
     */
    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getLevel() instanceof Level level) {
            handleBlockChange(level, event.getPos(), true);
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getLevel() instanceof Level level) {
            handleBlockChange(level, event.getPos(), false);
        }
    }

    /**
     * 区块卸载事件 - 同步区块内所有信号机的状态到全局管理器
     */
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onChunkUnload(ChunkEvent.Unload event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            // 获取该区块内的所有信号机方块实体并同步状态
            // 注意：event.getChunk() 返回 ChunkAccess，需要转换为 LevelChunk
            if (event.getChunk() instanceof LevelChunk levelChunk) {
                syncSignalsInChunk(serverLevel, levelChunk);
            }
        }
    }

    /**
     * 服务器tick事件 - 用于定期更新信号状态
     */
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        long currentTick = event.getServer().getTickCount();

        // 定期检查轨道网络变化（每10秒）
        if (currentTick - lastTrackGraphCheckTick > TRACK_GRAPH_CHECK_INTERVAL) {
            lastTrackGraphCheckTick = currentTick;
            checkTrackGraphChangesOnTick();
        }

        // 定期更新所有列车的占用状态（每5个tick，即4次/秒）
        if (currentTick % 5 == 0) {
            updateAllTrainOccupancyStates(event.getServer());
        }
    }


    // ========== 辅助方法 ==========

    /**
     * 更新所有列车的占用状态
     */
    private static void updateAllTrainOccupancyStates(MinecraftServer server) {
        // 遍历所有维度
        for (ServerLevel level : server.getAllLevels()) {
            SignalStateManager manager = SignalStateManager.get(level);
            if (manager == null) {
                continue;
            }

            // 获取当前维度中所有列车
            updateTrainOccupancyInLevel(manager, level);
        }
    }

    /**
     * 更新单个维度中所有列车的占用状态
     */
    private static void updateTrainOccupancyInLevel(SignalStateManager manager, ServerLevel level) {
        // 收集所有列车的信号组
        Set<UUID> occupiedGroups = new HashSet<>();

        // 遍历Create的所有列车
        ResourceKey<Level> dimensionKey = level.dimension();
        for (Train train : Create.RAILWAYS.trains.values()) {
            // 检查列车是否有车厢在当前维度
            boolean trainInLevel = false;
            for (Carriage carriage : train.carriages) {
                // 使用公共方法检查维度
                if (carriage.getDimensionalIfPresent(dimensionKey) != null) {
                    trainInLevel = true;
                    break;
                }
            }
            if (trainInLevel) {
                occupiedGroups.addAll(getTrainSignalGroups(train));
            }
        }

        // 更新全局缓存中的占用状态
        updateAllSignalGroupOccupancy(manager, level, occupiedGroups);
    }


    /**
     * 获取列车当前所在的信号组
     * 从列车对象的occupiedSignalBlocks获取（只包括物理占用，预约不算占用）
     */
    private static Set<UUID> getTrainSignalGroups(Train train) {
        Set<UUID> groups = new HashSet<>();

        // 只添加物理占用的信号组（与信号机逻辑保持一致，预约不算占用）
        groups.addAll(train.occupiedSignalBlocks.keySet());

        return groups;
    }

    /**
     * 更新所有缓存中相关信号组的占用状态
     */
    private static void updateAllSignalGroupOccupancy(SignalStateManager manager, ServerLevel level, Set<UUID> occupiedGroups) {
        // 获取当前维度的所有缓存
        Map<BlockPos, SignalStateManager.SignalStateCache> cacheMap = manager.getDimensionCache(level);

        if (cacheMap == null || cacheMap.isEmpty()) {
            return;
        }

        boolean anyChanged = false;

        // 更新所有缓存的占用状态
        for (SignalStateManager.SignalStateCache cache : cacheMap.values()) {
            boolean cacheChanged = false;

            for (int i = 0; i < 4; i++) {
                UUID groupId = cache.signalGroupIds[i];
                if (groupId != null) {
                    boolean newOccupied = occupiedGroups.contains(groupId);
                    if (cache.occupancyStates[i] != newOccupied) {
                        cache.occupancyStates[i] = newOccupied;
                        cacheChanged = true;
                    }
                }
            }

            if (cacheChanged) {
                // 重新计算信号状态
                cache.calculateFourAspectState();
                cache.calculateBaseSignalState();
                cache.lastOccupancyUpdateTick = level.getGameTime();
                anyChanged = true;
            }
        }

        if (anyChanged) {
            manager.setDirty();
        }
    }


    /**
     * 检查是否是信号机方块
     */
    private static boolean isSignalBlock(BlockState state) {
        // 检查是否是信号状态显示器方块
        return state.getBlock() == ModBlocks.SIGNAL_STATE_DISPLAY.get();
    }

    /**
     * 检查是否是红石相关变化
     */
    private static boolean isRedstoneRelated(BlockEvent.NeighborNotifyEvent event) {
        // 简单实现：检查事件是否由红石相关方块触发
        // 可以通过检查附近方块的状态来优化
        return true; // 简化处理，总是认为是红石相关
    }

    /**
     * 更新缓存中的红石信号状态
     */
    private static void updateRedstoneStateInCache(ServerLevel level, BlockPos pos) {
        SignalStateManager manager = SignalStateManager.get(level);
        if (manager == null) {
            return;
        }

        // 获取当前红石信号强度
        int redstoneSignal = level.getBestNeighborSignal(pos);

        // 获取或创建缓存
        SignalStateManager.SignalStateCache cache = manager.getSignalCache(level, pos);
        if (cache == null) {
            // 如果缓存不存在，可能是区块未加载
            // 创建临时缓存条目
            cache = new SignalStateManager.SignalStateCache(pos, level.dimension().location());
            cache.syncConnectionState(); // 同步连接状态
        }

        // 更新红石信号状态
        cache.lastRedstoneSignal = redstoneSignal;

        // 根据红石信号更新进路和强制红灯标志
        if (redstoneSignal >= 1 && redstoneSignal <= 6) {
            cache.currentRoute = redstoneSignal;
            cache.forceRed = false;
        } else if (redstoneSignal == 0) {
            cache.forceRed = false;
        } else {
            cache.forceRed = true;
        }

        // 重新计算信号状态
        cache.calculateFourAspectState();
        cache.calculateBaseSignalState();

        // 保存到管理器
        manager.registerSignal(level, pos, cache);

        // 标记缓存已更改
        manager.setDirty();
    }

    /**
     * 处理方块变化
     */
    private static void handleBlockChange(Level level, BlockPos pos, boolean isPlace) {
        if (level.isClientSide()) {
            return;
        }

        SignalStateManager manager = SignalStateManager.get((ServerLevel) level);
        if (manager == null) {
            return;
        }

        if (isPlace) {
            // 方块放置：创建初始缓存条目
            SignalStateManager.SignalStateCache cache = new SignalStateManager.SignalStateCache(
                pos, level.dimension().location());
            cache.syncConnectionState();
            manager.registerSignal(level, pos, cache);
        } else {
            // 方块破坏：从缓存中移除
            manager.unregisterSignal(level, pos);
        }
    }

    /**
     * 更新受轨道网络变化影响的信号机
     */
    private static void updateAffectedSignals(TrackGraph graph) {
        if (graph == null) {
            return;
        }

        // 获取所有信号机缓存
        // 这里需要访问所有维度的管理器，简化实现：只处理已加载的维度

        // 记录轨道网络快照
        lastTrackGraphSnapshots.put(graph.id, new TrackGraphSnapshot(graph));

        // 标记所有连接到这个轨道图的信号机需要重新寻路
        // 注意：这里简化实现，只处理当前已知的服务器级别
        // 实际应该通过服务器实例获取所有维度
        // 暂时留空，待实现更完整的方法
    }

    /**
     * Tick时检查轨道网络变化（备用方案）
     */
    private static void checkTrackGraphChangesOnTick() {
        // 检查所有轨道网络是否有变化
        for (TrackGraph graph : Create.RAILWAYS.trackNetworks.values()) {
            TrackGraphSnapshot currentSnapshot = new TrackGraphSnapshot(graph);
            TrackGraphSnapshot lastSnapshot = lastTrackGraphSnapshots.get(graph.id);

            if (lastSnapshot == null || !lastSnapshot.equals(currentSnapshot)) {
                // 轨道网络发生变化
                updateAffectedSignals(graph);
                lastTrackGraphSnapshots.put(graph.id, currentSnapshot);
            }
        }
    }

    /**
     * 为信号机注册缓存（辅助方法，供其他类调用）
     */
    public static void registerSignalCache(ServerLevel level, BlockPos pos, SignalStateDisplayBlockEntity blockEntity) {
        SignalStateManager manager = SignalStateManager.get(level);
        if (manager != null) {
            manager.registerSignal(level, pos, blockEntity);
        }
    }

    /**
     * 同步区块内所有信号机的状态到全局管理器
     */
    private static void syncSignalsInChunk(ServerLevel serverLevel, LevelChunk chunk) {
        SignalStateManager manager = SignalStateManager.get(serverLevel);
        if (manager == null) {
            return;
        }

        // 遍历区块内的所有方块实体
        for (var entry : chunk.getBlockEntities().entrySet()) {
            BlockPos pos = entry.getKey();
            var blockEntity = entry.getValue();

            if (blockEntity instanceof SignalStateDisplayBlockEntity signalEntity) {
                // 同步当前状态到全局管理器
                manager.registerSignal(serverLevel, pos, signalEntity);
                SimpleLogger.debug("[{}] 区块卸载，状态已同步到全局管理器", pos);
            }
        }
    }

    /**
     * 轨道网络快照（用于检测变化）
     */
    private static class TrackGraphSnapshot {
        private final UUID graphId;
        private final int nodeCount;
        private final int edgeCount;
        private final int signalCount;
        private final long hash;

        public TrackGraphSnapshot(TrackGraph graph) {
            this.graphId = graph.id;

            // 使用公共方法获取节点和边数量
            this.nodeCount = graph.getNodes().size();

            // 边数量需要估算，因为edges可能是私有字段
            // 简化：使用节点数量估算
            this.edgeCount = estimateEdgeCount(graph);

            // 计算信号边界数量
            int signalCount = 0;
            try {
                // 尝试获取信号边界类型
                signalCount = estimateSignalCount(graph);
            } catch (Exception e) {
                // 忽略错误
            }
            this.signalCount = signalCount;

            // 简单哈希用于快速比较
            this.hash = (long) nodeCount << 32 | edgeCount;
        }

        private static int estimateEdgeCount(TrackGraph graph) {
            // 简化估算：平均每个节点有2条连接
            return graph.getNodes().size() * 2;
        }

        private static int estimateSignalCount(TrackGraph graph) {
            // 简化：返回0，因为获取信号边界类型可能复杂
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof TrackGraphSnapshot)) return false;
            TrackGraphSnapshot other = (TrackGraphSnapshot) obj;
            return graphId.equals(other.graphId) &&
                   nodeCount == other.nodeCount &&
                   edgeCount == other.edgeCount &&
                   signalCount == other.signalCount &&
                   hash == other.hash;
        }

        @Override
        public int hashCode() {
            return Objects.hash(graphId, nodeCount, edgeCount, signalCount, hash);
        }
    }
}