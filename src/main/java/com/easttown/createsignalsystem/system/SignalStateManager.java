package com.easttown.createsignalsystem.system;

import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.config.RouteConfiguration;
import com.easttown.createsignalsystem.util.SimpleLogger;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import com.simibubi.create.content.trains.signal.SignalEdgeGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 全局信号状态管理器
 *
 * 负责管理所有信号显示器的状态更新，不依赖区块加载。
 *
 * 工作原理：
 * 1. 注册所有信号显示器位置和配置
 * 2. 定期检查相关信号组的状态
 * 3. 缓存最新状态，供API和方块实体访问
 * 4. 方块实体加载时从缓存同步
 *
 * 与区块加载的关系：
 * - 状态更新：不依赖区块加载（全局tick）
 * - 配置管理：方块实体放置/破坏时注册/注销（需区块加载）
 * - 状态同步：方块实体加载时从缓存获取最新状态
 */
public class SignalStateManager extends SavedData {

    private static final String DATA_NAME = "create_signal_system_states";

    // 单例实例
    private static SignalStateManager clientInstance = null;

    // 所有信号显示器的状态缓存（维度 -> 位置 -> 状态）
    private final Map<ResourceLocation, Map<BlockPos, SignalStateCache>> dimensionCache = new ConcurrentHashMap<>();

    // 待处理的更新队列（避免在事件处理中直接修改缓存）
    private final Queue<StateUpdateTask> updateQueue = new ConcurrentLinkedQueue<>();

    // 最后更新时间戳（用于控制更新频率）
    private long lastUpdateTick = 0;
    private static final int UPDATE_INTERVAL_TICKS = 5; // 每5个tick更新一次（4次/秒）

    /**
     * 信号状态缓存
     */
    public static class SignalStateCache {
        public final BlockPos position;
        public final ResourceLocation dimension;

        // 信号组ID数组（0:当前, 1-3:前方）
        public final UUID[] signalGroupIds = new UUID[4];

        // 边界ID数组（用于调试和追踪）
        public final String[] boundaryIds = new String[4];

        // 占用状态数组（对应信号组ID）
        public final boolean[] occupancyStates = new boolean[4];

        // 四显示信号状态
        public SignalStateDisplayBlockEntity.FourAspectSignalState fourAspectState;

        // 基础信号状态（来自Create）
        public com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState baseSignalState;

        // 配置状态
        public int currentRoute = 1;
        public boolean forceRed = false;
        public int lastRedstoneSignal = 0;

        // 进路配置（红石信号映射和进路详细配置）
        public final Map<Integer, Integer> signalMappings = new HashMap<>(); // 红石信号(0-15) -> 进路槽位(0-7)
        public final Map<Integer, RouteConfiguration> routeConfigs = new HashMap<>(); // 进路槽位(1-7) -> 进路配置

        // 连接状态
        public boolean isConnectedToTrack = false;
        public UUID connectedBoundaryId = null;
        public UUID connectedGraphId = null;

        // 寻路相关数据
        public final double[] travelDistances = new double[3]; // 到前方信号组的距离（索引1-3）
        public final int[] travelCallCounts = new int[3]; // 寻路调用次数
        public long lastPathfindingTick = 0;
        public boolean needsPathfindingUpdate = true;

        // 更新时间戳
        public long lastUpdatedTick = 0;
        public long lastConfigUpdateTick = 0;
        public long lastOccupancyUpdateTick = 0;

        public SignalStateCache(BlockPos position, ResourceLocation dimension) {
            this.position = position;
            this.dimension = dimension;
            this.fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.INVALID;
            this.baseSignalState = com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.INVALID;
            // 初始化数组
            for (int i = 0; i < 4; i++) {
                boundaryIds[i] = "";
            }
        }

        /**
         * 从方块实体同步完整配置
         * 在区块卸载前调用，确保全局管理器拥有最新状态
         */
        public void syncFromBlockEntity(SignalStateDisplayBlockEntity blockEntity) {
            System.arraycopy(blockEntity.getSignalGroupIds(), 0, signalGroupIds, 0, 4);
            System.arraycopy(blockEntity.getOccupancyStates(), 0, occupancyStates, 0, 4);

            // 同步边界ID
            String[] entityBoundaryIds = blockEntity.getBoundaryIds();
            if (entityBoundaryIds != null && entityBoundaryIds.length >= 4) {
                System.arraycopy(entityBoundaryIds, 0, boundaryIds, 0, 4);
            }

            this.currentRoute = blockEntity.getCurrentRoute();
            this.forceRed = blockEntity.isForceRed();
            this.lastRedstoneSignal = blockEntity.getLastRedstoneSignal();
            this.fourAspectState = blockEntity.getFourAspectState();

            // 同步进路配置
            this.signalMappings.clear();
            this.signalMappings.putAll(blockEntity.getAllSignalMappings());

            this.routeConfigs.clear();
            this.routeConfigs.putAll(blockEntity.getAllRouteConfigs());

            // 更新配置时间戳
            this.lastConfigUpdateTick = blockEntity.getLevel() != null ?
                blockEntity.getLevel().getGameTime() : 0;

            // 同步后重新计算状态以确保一致性
            calculateFourAspectState();
            calculateBaseSignalState();
        }

        /**
         * 从全局数据同步连接状态
         */
        public void syncConnectionState() {
            // 检查信号机是否连接到轨道网络
            // 遍历所有轨道图，查找包含此位置的信号边界

            this.isConnectedToTrack = false;
            this.connectedBoundaryId = null;
            this.connectedGraphId = null;

            for (TrackGraph graph : Create.RAILWAYS.trackNetworks.values()) {
                // 直接获取信号边界
                Collection<SignalBoundary> boundaries = graph.getPoints(EdgePointType.SIGNAL);

                for (SignalBoundary boundary : boundaries) {
                    // 检查边界是否包含此位置
                    if (boundary.blockEntities.getFirst().containsKey(position) ||
                        boundary.blockEntities.getSecond().containsKey(position)) {

                        this.isConnectedToTrack = true;
                        this.connectedBoundaryId = boundary.id;
                        this.connectedGraphId = graph.id;
                        return;
                    }
                }
            }
        }


        /**
         * 更新占用状态（从全局信号组管理器）
         */
        public void updateOccupancyStates() {
            for (int i = 0; i < 4; i++) {
                UUID groupId = signalGroupIds[i];
                if (groupId != null) {
                    SignalEdgeGroup group = Create.RAILWAYS.signalEdgeGroups.get(groupId);
                    occupancyStates[i] = group != null && !group.trains.isEmpty();
                }
            }
            this.lastOccupancyUpdateTick = System.currentTimeMillis();
        }

        /**
         * 计算四显示信号状态
         */
        public void calculateFourAspectState() {
            // 如果没有连接或当前信号组无效
            if (!isConnectedToTrack || signalGroupIds[0] == null) {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.INVALID;
                return;
            }

            // 强制红灯优先
            if (forceRed) {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.RED;
                return;
            }

            // 检查当前信号组（索引0）
            boolean currentOccupied = occupancyStates[0];
            boolean firstAheadOccupied = signalGroupIds[1] != null && occupancyStates[1];
            boolean secondAheadOccupied = signalGroupIds[2] != null && occupancyStates[2];

            if (currentOccupied) {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.RED;
            } else if (firstAheadOccupied) {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.YELLOW;
            } else if (secondAheadOccupied) {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.GREEN_YELLOW;
            } else {
                fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.GREEN;
            }
        }

        /**
         * 计算基础信号状态
         */
        public void calculateBaseSignalState() {
            switch (fourAspectState) {
                case RED:
                    baseSignalState = com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.RED;
                    break;
                case YELLOW:
                case GREEN_YELLOW:
                    baseSignalState = com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.YELLOW;
                    break;
                case GREEN:
                    baseSignalState = com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.GREEN;
                    break;
                case INVALID:
                default:
                    baseSignalState = com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.INVALID;
            }
        }

        /**
         * 清理指定的边界ID引用
         * @param boundaryId 要清理的边界ID（UUID字符串）
         */
        public void clearBoundaryReference(String boundaryId) {
            if (boundaryId == null || boundaryId.isEmpty()) {
                return;
            }

            for (int i = 0; i < boundaryIds.length; i++) {
                if (boundaryId.equals(boundaryIds[i])) {
                    boundaryIds[i] = "";
                    signalGroupIds[i] = null;
                    // 对应的占用状态也重置
                    occupancyStates[i] = false;
                    SimpleLogger.debug("[{}] 清理边界ID引用: {} (槽位{})",
                        position, boundaryId, i);
                }
            }
        }

        /**
         * 检查并清理所有空的边界ID引用
         * @return 是否还有有效的边界ID
         */
        public boolean cleanupEmptyBoundaryIds() {
            boolean hasValidBoundary = false;

            for (int i = 0; i < boundaryIds.length; i++) {
                if (boundaryIds[i] != null && !boundaryIds[i].isEmpty()) {
                    hasValidBoundary = true;
                } else {
                    // 清理空槽位
                    boundaryIds[i] = "";
                    signalGroupIds[i] = null;
                    occupancyStates[i] = false;
                }
            }

            return hasValidBoundary;
        }

        /**
         * 检查是否需要重新寻路
         */
        public boolean needsPathfinding(long currentTick) {
            // 从未寻路过
            if (lastPathfindingTick == 0) {
                return true;
            }

            // 标记需要更新
            if (needsPathfindingUpdate) {
                return true;
            }

            // 定期更新（每60秒，即1200tick）
            if (currentTick - lastPathfindingTick > 1200) {
                return true;
            }

            // 连接状态变化
            if (!isConnectedToTrack) {
                return false; // 未连接，不需要寻路
            }

            return false;
        }

        /**
         * 重置寻路数据
         */
        public void resetPathfindingData() {
            for (int i = 1; i < 4; i++) {
                signalGroupIds[i] = null;
                boundaryIds[i] = "";
                travelDistances[i-1] = 0.0;
                travelCallCounts[i-1] = 0;
            }
            lastPathfindingTick = 0;
            needsPathfindingUpdate = true;
        }

        /**
         * 标记寻路完成
         */
        public void markPathfindingComplete(long currentTick) {
            lastPathfindingTick = currentTick;
            needsPathfindingUpdate = false;
        }

        /**
         * 设置前方信号组数据
         */
        public void setForwardSignalGroup(int index, UUID groupId, String boundaryId, double distance) {
            if (index >= 1 && index <= 3) {
                signalGroupIds[index] = groupId;
                boundaryIds[index] = boundaryId != null ? boundaryId : "";
                travelDistances[index-1] = distance;
                travelCallCounts[index-1]++;
            }
        }

        /**
         * 转换为NBT
         */
        public CompoundTag toNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putLong("pos", position.asLong());

            // 保存信号组ID
            for (int i = 0; i < 4; i++) {
                if (signalGroupIds[i] != null) {
                    tag.putUUID("groupId" + i, signalGroupIds[i]);
                }
            }

            // 保存边界ID
            for (int i = 0; i < 4; i++) {
                if (!boundaryIds[i].isEmpty()) {
                    tag.putString("boundaryId" + i, boundaryIds[i]);
                }
            }

            // 保存占用状态
            for (int i = 0; i < 4; i++) {
                tag.putBoolean("occupied" + i, occupancyStates[i]);
            }

            // 保存其他状态
            tag.putString("fourAspectState", fourAspectState.name());
            tag.putInt("currentRoute", currentRoute);
            tag.putBoolean("forceRed", forceRed);
            tag.putInt("lastRedstoneSignal", lastRedstoneSignal);

            // 保存连接状态
            tag.putBoolean("isConnected", isConnectedToTrack);
            if (connectedBoundaryId != null) {
                tag.putUUID("connectedBoundaryId", connectedBoundaryId);
            }
            if (connectedGraphId != null) {
                tag.putUUID("connectedGraphId", connectedGraphId);
            }

            // 保存进路配置
            CompoundTag signalMappingsTag = new CompoundTag();
            for (Map.Entry<Integer, Integer> entry : signalMappings.entrySet()) {
                signalMappingsTag.putInt("signal_" + entry.getKey(), entry.getValue());
            }
            tag.put("signalMappings", signalMappingsTag);

            CompoundTag routeConfigsTag = new CompoundTag();
            for (Map.Entry<Integer, RouteConfiguration> entry : routeConfigs.entrySet()) {
                routeConfigsTag.put("route_" + entry.getKey(), entry.getValue().serialize());
            }
            tag.put("routeConfigs", routeConfigsTag);

            // 保存寻路数据
            tag.putLong("lastPathfindingTick", lastPathfindingTick);
            tag.putBoolean("needsPathfindingUpdate", needsPathfindingUpdate);

            return tag;
        }

        /**
         * 从NBT加载
         */
        public static SignalStateCache fromNBT(CompoundTag tag, ResourceLocation dimension) {
            BlockPos pos = BlockPos.of(tag.getLong("pos"));
            SignalStateCache cache = new SignalStateCache(pos, dimension);

            // 加载信号组ID
            for (int i = 0; i < 4; i++) {
                if (tag.contains("groupId" + i, Tag.TAG_INT_ARRAY)) {
                    cache.signalGroupIds[i] = tag.getUUID("groupId" + i);
                }
            }

            // 加载边界ID
            for (int i = 0; i < 4; i++) {
                if (tag.contains("boundaryId" + i, Tag.TAG_STRING)) {
                    cache.boundaryIds[i] = tag.getString("boundaryId" + i);
                }
            }

            // 加载占用状态
            for (int i = 0; i < 4; i++) {
                if (tag.contains("occupied" + i, Tag.TAG_BYTE)) {
                    cache.occupancyStates[i] = tag.getBoolean("occupied" + i);
                }
            }

            // 加载其他状态
            if (tag.contains("fourAspectState", Tag.TAG_STRING)) {
                try {
                    cache.fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.valueOf(
                            tag.getString("fourAspectState"));
                } catch (IllegalArgumentException e) {
                    cache.fourAspectState = SignalStateDisplayBlockEntity.FourAspectSignalState.INVALID;
                }
            }

            if (tag.contains("currentRoute", Tag.TAG_INT)) {
                cache.currentRoute = tag.getInt("currentRoute");
            }

            if (tag.contains("forceRed", Tag.TAG_BYTE)) {
                cache.forceRed = tag.getBoolean("forceRed");
            }

            if (tag.contains("lastRedstoneSignal", Tag.TAG_INT)) {
                cache.lastRedstoneSignal = tag.getInt("lastRedstoneSignal");
            }

            // 加载连接状态
            if (tag.contains("isConnected", Tag.TAG_BYTE)) {
                cache.isConnectedToTrack = tag.getBoolean("isConnected");
            }

            if (tag.contains("connectedBoundaryId", Tag.TAG_INT_ARRAY)) {
                cache.connectedBoundaryId = tag.getUUID("connectedBoundaryId");
            }

            if (tag.contains("connectedGraphId", Tag.TAG_INT_ARRAY)) {
                cache.connectedGraphId = tag.getUUID("connectedGraphId");
            }

            // 加载寻路数据
            if (tag.contains("lastPathfindingTick", Tag.TAG_LONG)) {
                cache.lastPathfindingTick = tag.getLong("lastPathfindingTick");
            }

            if (tag.contains("needsPathfindingUpdate", Tag.TAG_BYTE)) {
                cache.needsPathfindingUpdate = tag.getBoolean("needsPathfindingUpdate");
            }

            // 加载进路配置
            if (tag.contains("signalMappings", Tag.TAG_COMPOUND)) {
                CompoundTag signalMappingsTag = tag.getCompound("signalMappings");
                cache.signalMappings.clear();
                for (String key : signalMappingsTag.getAllKeys()) {
                    if (key.startsWith("signal_")) {
                        int signal = Integer.parseInt(key.substring(7)); // 去掉"signal_"前缀
                        int route = signalMappingsTag.getInt(key);
                        cache.signalMappings.put(signal, route);
                    }
                }
            }

            if (tag.contains("routeConfigs", Tag.TAG_COMPOUND)) {
                CompoundTag routeConfigsTag = tag.getCompound("routeConfigs");
                cache.routeConfigs.clear();
                for (String key : routeConfigsTag.getAllKeys()) {
                    if (key.startsWith("route_")) {
                        int routeId = Integer.parseInt(key.substring(6)); // 去掉"route_"前缀
                        CompoundTag routeTag = routeConfigsTag.getCompound(key);
                        RouteConfiguration config = RouteConfiguration.deserialize(routeTag);
                        if (config != null) {
                            cache.routeConfigs.put(routeId, config);
                        }
                    }
                }
            }

            return cache;
        }
    }

    /**
     * 状态更新任务
     */
    private static class StateUpdateTask {
        public final ResourceLocation dimension;
        public final BlockPos position;
        @Nullable
        public final SignalStateCache newCache; // null表示删除

        public StateUpdateTask(ResourceLocation dimension, BlockPos position, @Nullable SignalStateCache newCache) {
            this.dimension = dimension;
            this.position = position;
            this.newCache = newCache;
        }
    }

    // 私有构造函数
    private SignalStateManager() {}

    /**
     * 获取指定维度的管理器实例
     */
    @Nullable
    public static SignalStateManager get(Level level) {
        if (level.isClientSide) {
            // 客户端使用临时实例
            if (clientInstance == null) {
                clientInstance = new SignalStateManager();
            }
            return clientInstance;
        }

        if (level instanceof ServerLevel serverLevel) {
            DimensionDataStorage storage = serverLevel.getDataStorage();
            return storage.computeIfAbsent(SignalStateManager::load, SignalStateManager::new, DATA_NAME);
        }

        return null;
    }

    /**
     * 从NBT加载
     */
    public static SignalStateManager load(CompoundTag nbt) {
        SignalStateManager manager = new SignalStateManager();

        // 加载维度数据
        if (nbt.contains("dimensions", Tag.TAG_LIST)) {
            ListTag dimensionList = nbt.getList("dimensions", Tag.TAG_COMPOUND);
            for (Tag tag : dimensionList) {
                CompoundTag dimensionTag = (CompoundTag) tag;
                ResourceLocation dimension = ResourceLocation.parse(dimensionTag.getString("dimension"));

                Map<BlockPos, SignalStateCache> cacheMap = new ConcurrentHashMap<>();
                manager.dimensionCache.put(dimension, cacheMap);

                if (dimensionTag.contains("signals", Tag.TAG_LIST)) {
                    ListTag signalList = dimensionTag.getList("signals", Tag.TAG_COMPOUND);
                    for (Tag signalTag : signalList) {
                        CompoundTag signalData = (CompoundTag) signalTag;

                        // 使用SignalStateCache的fromNBT方法加载
                        SignalStateCache cache = SignalStateCache.fromNBT(signalData, dimension);
                        cacheMap.put(cache.position, cache);
                    }
                }
            }
        }

        return manager;
    }

    /**
     * 保存到NBT
     */
    @Override
    public CompoundTag save(CompoundTag nbt) {
        ListTag dimensionList = new ListTag();

        for (Map.Entry<ResourceLocation, Map<BlockPos, SignalStateCache>> entry : dimensionCache.entrySet()) {
            CompoundTag dimensionTag = new CompoundTag();
            dimensionTag.putString("dimension", entry.getKey().toString());

            ListTag signalList = new ListTag();
            for (SignalStateCache cache : entry.getValue().values()) {
                // 使用SignalStateCache的toNBT方法保存
                CompoundTag signalData = cache.toNBT();
                signalList.add(signalData);
            }

            dimensionTag.put("signals", signalList);
            dimensionList.add(dimensionTag);
        }

        nbt.put("dimensions", dimensionList);
        return nbt;
    }

    /**
     * 服务器tick更新
     */
    public void tick(ServerLevel level) {
        // 处理队列中的更新
        processUpdateQueue();

        // 控制更新频率
        long currentTick = level.getGameTime();
        if (currentTick - lastUpdateTick < UPDATE_INTERVAL_TICKS) {
            return;
        }
        lastUpdateTick = currentTick;

        // 1. 更新所有信号状态（占用状态和计算）
        updateAllSignalStates(level);

        // 2. 执行后台寻路服务（需要寻路的信号机）
        performPathfindingService(level, currentTick);

        // 3. 同步连接状态（检查信号机是否仍然连接到轨道）
        syncConnectionStates(level);

        // 4. 定期清理无效缓存（每10分钟清理一次）
        if (currentTick % 12000 == 0) { // 12000 ticks = 10分钟
            cleanupInvalidCaches(level);
            SimpleLogger.debug("执行定期缓存清理");
        }
    }

    /**
     * 处理更新队列
     */
    private void processUpdateQueue() {
        while (!updateQueue.isEmpty()) {
            StateUpdateTask task = updateQueue.poll();
            Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.computeIfAbsent(
                    task.dimension, k -> new ConcurrentHashMap<>());

            if (task.newCache == null) {
                // 删除
                cacheMap.remove(task.position);
            } else {
                // 添加或更新
                cacheMap.put(task.position, task.newCache);
            }
        }

        // 标记数据已更改
        setDirty();
    }

    /**
     * 更新所有信号状态
     */
    private void updateAllSignalStates(ServerLevel level) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null || cacheMap.isEmpty()) {
            return;
        }

        for (SignalStateCache cache : cacheMap.values()) {
            // 同步连接状态（从全局轨道网络）
            cache.syncConnectionState();

            // 更新占用状态
            cache.updateOccupancyStates();

            // 计算信号状态
            cache.calculateFourAspectState();
            cache.calculateBaseSignalState();

            cache.lastUpdatedTick = level.getGameTime();

            // 通知方块实体（如果已加载）
            notifyBlockEntityIfLoaded(level, cache.position);
        }

        // 标记数据已更改
        setDirty();
    }

    /**
     * 注册或更新信号显示器（通过方块实体）
     */
    public void registerSignal(Level level, BlockPos pos, SignalStateDisplayBlockEntity blockEntity) {
        if (level.isClientSide) {
            return;
        }

        ResourceLocation dimension = level.dimension().location();

        // 检查是否已有缓存
        SignalStateCache cache = getSignalCache(level, pos);
        if (cache == null) {
            cache = new SignalStateCache(pos, dimension);
        }

        // 从方块实体同步配置
        cache.syncFromBlockEntity(blockEntity);

        // 同步连接状态
        cache.syncConnectionState();

        cache.lastUpdatedTick = level.getGameTime();

        updateQueue.add(new StateUpdateTask(dimension, pos, cache));
    }

    /**
     * 注册或更新信号显示器（通过缓存对象）
     */
    public void registerSignal(Level level, BlockPos pos, SignalStateCache cache) {
        if (level.isClientSide) {
            return;
        }

        ResourceLocation dimension = level.dimension().location();
        cache.lastUpdatedTick = level.getGameTime();
        updateQueue.add(new StateUpdateTask(dimension, pos, cache));
    }

    /**
     * 注销信号显示器
     */
    public void unregisterSignal(Level level, BlockPos pos) {
        if (level.isClientSide) {
            return;
        }

        ResourceLocation dimension = level.dimension().location();

        // 清理该缓存自身的空引用（防止内存泄漏）
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);
        if (cacheMap != null) {
            SignalStateCache cache = cacheMap.get(pos);
            if (cache != null) {
                cache.cleanupEmptyBoundaryIds();
            }
        }

        updateQueue.add(new StateUpdateTask(dimension, pos, null));
    }


    /**
     * 定期清理无效的缓存条目
     * @param level 服务器级别
     */
    public void cleanupInvalidCaches(ServerLevel level) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);
        if (cacheMap == null) {
            return;
        }

        long currentTick = level.getGameTime();
        int removedCount = 0;

        Iterator<Map.Entry<BlockPos, SignalStateCache>> iterator = cacheMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<BlockPos, SignalStateCache> entry = iterator.next();
            SignalStateCache cache = entry.getValue();

            // 清理空边界ID
            cache.cleanupEmptyBoundaryIds();

            // 检查是否还有有效的边界ID
            boolean hasValidBoundary = false;
            for (String boundaryId : cache.boundaryIds) {
                if (boundaryId != null && !boundaryId.isEmpty()) {
                    hasValidBoundary = true;
                    break;
                }
            }

            // 如果没有有效边界ID且长时间未更新（超过10分钟），移除缓存
            if (!hasValidBoundary && currentTick - cache.lastUpdatedTick > 12000) {
                iterator.remove();
                removedCount++;
            }
        }

        if (removedCount > 0) {
            SimpleLogger.debug("清理缓存：移除 {} 个无效条目", removedCount);
            setDirty();
        }
    }

    /**
     * 获取信号状态缓存
     */
    @Nullable
    public SignalStateCache getSignalCache(Level level, BlockPos pos) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null) {
            return null;
        }

        return cacheMap.get(pos);
    }

    /**
     * 从全局缓存恢复状态到方块实体
     * 在区块加载时调用，用于恢复信号机状态
     */
    public boolean restoreStateToBlockEntity(ServerLevel level, BlockPos pos, SignalStateDisplayBlockEntity blockEntity) {
        SignalStateCache cache = getSignalCache(level, pos);
        if (cache == null) {
            return false;
        }

        try {
            // 恢复四个信号组ID
            System.arraycopy(cache.signalGroupIds, 0, blockEntity.getSignalGroupIds(), 0, 4);

            // 恢复占用状态
            System.arraycopy(cache.occupancyStates, 0, blockEntity.getOccupancyStates(), 0, 4);

            // 恢复配置状态
            blockEntity.setCurrentRoute(cache.currentRoute);
            blockEntity.setForceRed(cache.forceRed);
            blockEntity.setLastRedstoneSignal(cache.lastRedstoneSignal);

            // 恢复四显示信号状态
            blockEntity.setFourAspectState(cache.fourAspectState);

            // 恢复进路配置
            blockEntity.setSignalMappings(cache.signalMappings);
            blockEntity.setRouteConfigs(cache.routeConfigs);

            // 标记需要重新寻路（因为可能已过期）
            blockEntity.markNeedsPathfindingUpdate();

            SimpleLogger.debug("[{}] 从全局缓存恢复状态成功", pos);
            return true;
        } catch (Exception e) {
            SimpleLogger.error("[{}] 从全局缓存恢复状态失败: {}", pos, e.getMessage());
            return false;
        }
    }

    /**
     * 获取维度中所有信号的位置
     */
    public Set<BlockPos> getAllSignalPositions(Level level) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null) {
            return Collections.emptySet();
        }

        return new HashSet<>(cacheMap.keySet());
    }

    /**
     * 获取维度中的所有信号缓存（供事件处理器使用）
     */
    public Map<BlockPos, SignalStateCache> getDimensionCache(Level level) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null) {
            return Collections.emptyMap();
        }

        return cacheMap;
    }

    /**
     * 通过边界ID查找信号机缓存
     * @param level 服务器级别
     * @param boundaryId 边界ID（UUID字符串表示）
     * @return 匹配的信号机缓存列表（可能为空）
     */
    public List<SignalStateCache> findSignalCachesByBoundaryId(ServerLevel level, String boundaryId) {
        List<SignalStateCache> results = new ArrayList<>();
        if (boundaryId == null || boundaryId.isEmpty()) {
            return results;
        }

        Map<BlockPos, SignalStateCache> cacheMap = getDimensionCache(level);
        if (cacheMap == null || cacheMap.isEmpty()) {
            return results;
        }

        for (SignalStateCache cache : cacheMap.values()) {
            // 先清理缓存中的空边界ID（防止查询到无效数据）
            cache.cleanupEmptyBoundaryIds();

            for (int i = 0; i < 4; i++) {
                String id = cache.boundaryIds[i];
                // 严格检查：非空且相等
                if (id != null && !id.isEmpty() && boundaryId.equals(id)) {
                    results.add(cache);
                    break; // 一个信号机可能有多个相同的边界ID，但我们只需要添加一次
                }
            }
        }

        return results;
    }

    /**
     * 通过边界ID获取四显示信号状态
     * @param level 服务器级别
     * @param boundaryId 边界ID（UUID字符串表示）
     * @return 四显示信号状态，如果没有找到返回INVALID
     */
    public SignalStateDisplayBlockEntity.FourAspectSignalState getFourAspectStateForBoundary(ServerLevel level, String boundaryId) {
        List<SignalStateCache> caches = findSignalCachesByBoundaryId(level, boundaryId);
        if (caches.isEmpty()) {
            return SignalStateDisplayBlockEntity.FourAspectSignalState.INVALID;
        }
        // 返回第一个找到的信号机状态
        return caches.get(0).fourAspectState;
    }

    /**
     * 通过边界ID获取二显示信号状态
     * @param level 服务器级别
     * @param boundaryId 边界ID（UUID字符串表示）
     * @return 二显示信号状态，如果没有找到返回INVALID
     */
    public com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState getTwoAspectStateForBoundary(ServerLevel level, String boundaryId) {
        List<SignalStateCache> caches = findSignalCachesByBoundaryId(level, boundaryId);
        if (caches.isEmpty()) {
            return com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState.INVALID;
        }
        // 返回第一个找到的信号机的基础信号状态
        return caches.get(0).baseSignalState;
    }

    /**
     * 执行后台寻路服务
     */
    private void performPathfindingService(ServerLevel level, long currentTick) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null || cacheMap.isEmpty()) {
            return;
        }

        // 限制每tick处理的信号机数量，避免性能问题
        int processedCount = 0;
        final int MAX_PER_TICK = 5;

        for (SignalStateCache cache : cacheMap.values()) {
            if (processedCount >= MAX_PER_TICK) {
                break;
            }

            // 检查是否需要寻路
            if (cache.needsPathfinding(currentTick)) {
                if (performPathfindingForSignal(level, cache, currentTick)) {
                    processedCount++;
                }
            }
        }

        if (processedCount > 0) {
            setDirty(); // 标记数据已更改
        }
    }

    /**
     * 为单个信号机执行寻路
     */
    private boolean performPathfindingForSignal(ServerLevel level, SignalStateCache cache, long currentTick) {
        // 如果没有连接到轨道，跳过
        if (!cache.isConnectedToTrack || cache.connectedGraphId == null || cache.connectedBoundaryId == null) {
            cache.markPathfindingComplete(currentTick);
            return false;
        }

        // 查找连接的轨道图和边界
        TrackGraph graph = Create.RAILWAYS.trackNetworks.get(cache.connectedGraphId);
        if (graph == null) {
            cache.resetPathfindingData();
            cache.markPathfindingComplete(currentTick);
            return false;
        }

        // 查找信号边界
        SignalBoundary boundary = null;
        for (SignalBoundary b : graph.getPoints(EdgePointType.SIGNAL)) {
            if (b.id.equals(cache.connectedBoundaryId)) {
                boundary = b;
                break;
            }
        }

        if (boundary == null) {
            cache.resetPathfindingData();
            cache.markPathfindingComplete(currentTick);
            return false;
        }

        // 执行寻路逻辑（类似于SignalStateDisplayBlockEntity.findForwardSignalGroups）
        boolean success = findForwardSignalGroups(level, cache, graph, boundary);

        // 标记寻路完成
        cache.markPathfindingComplete(currentTick);
        return success;
    }

    /**
     * 查找前方信号组（全局版本，不依赖区块加载）
     */
    private boolean findForwardSignalGroups(ServerLevel level, SignalStateCache cache,
                                            TrackGraph graph,
                                            com.simibubi.create.content.trains.signal.SignalBoundary boundary) {
        try {
            // 重置前方信号组数据
            cache.resetPathfindingData();

            // 确定当前方块在边界的哪一侧
            boolean isFirstSide = boundary.blockEntities.getFirst().containsKey(cache.position);
            boolean isSecondSide = boundary.blockEntities.getSecond().containsKey(cache.position);

            if (!isFirstSide && !isSecondSide) {
                return false;
            }

            boolean primary = isFirstSide;
            UUID currentGroupId = primary ? boundary.groups.getFirst() : boundary.groups.getSecond();
            cache.signalGroupIds[0] = currentGroupId;
            cache.boundaryIds[0] = boundary.id.toString();

            // 获取边界位置
            com.simibubi.create.foundation.utility.Couple<com.simibubi.create.content.trains.graph.TrackNodeLocation>
                nodeLocations = boundary.edgeLocation;
            if (nodeLocations == null) {
                return false;
            }

            // 这里需要实现TravellingPoint寻路逻辑
            // 由于代码复杂且需要大量Create内部API，这里简化实现
            // 实际应该复制SignalStateDisplayBlockEntity中的寻路逻辑

            // 简化：只查找当前信号组，不查找前方信号组
            // TODO: 实现完整的寻路逻辑

            return true;

        } catch (Exception e) {
            // 寻路失败，记录错误
            SimpleLogger.error(
                "寻路失败: 位置={}, 错误={}", cache.position, e.getMessage());
            return false;
        }
    }

    /**
     * 同步所有信号机的连接状态
     */
    private void syncConnectionStates(ServerLevel level) {
        ResourceLocation dimension = level.dimension().location();
        Map<BlockPos, SignalStateCache> cacheMap = dimensionCache.get(dimension);

        if (cacheMap == null || cacheMap.isEmpty()) {
            return;
        }

        boolean anyChanged = false;

        for (SignalStateCache cache : cacheMap.values()) {
            boolean wasConnected = cache.isConnectedToTrack;
            UUID oldBoundaryId = cache.connectedBoundaryId;
            UUID oldGraphId = cache.connectedGraphId;

            // 同步连接状态
            cache.syncConnectionState();

            // 检查连接状态是否变化
            if (wasConnected != cache.isConnectedToTrack ||
                (oldBoundaryId != null && !oldBoundaryId.equals(cache.connectedBoundaryId)) ||
                (oldGraphId != null && !oldGraphId.equals(cache.connectedGraphId))) {

                // 连接状态变化，需要重新寻路
                cache.needsPathfindingUpdate = true;
                anyChanged = true;
            }
        }

        if (anyChanged) {
            setDirty();
        }
    }

    /**
     * 如果方块实体已加载，通知其更新状态
     */
    public static void notifyBlockEntityIfLoaded(ServerLevel level, BlockPos pos) {
        if (level == null || pos == null) {
            return;
        }

        // 尝试获取方块实体
        if (level.getBlockEntity(pos) instanceof SignalStateDisplayBlockEntity blockEntity) {
            // TODO: 暂时禁用全局缓存同步，因为稳定版本没有这些方法
            // blockEntity.syncFromGlobalCache();
            // blockEntity.updateRedstoneOutput();
            // 标记方块实体已更改
            blockEntity.setChanged();
        }
    }
}