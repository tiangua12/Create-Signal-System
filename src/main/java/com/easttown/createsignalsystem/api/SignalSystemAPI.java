package com.easttown.createsignalsystem.api;

import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.system.SignalStateManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * 信号系统API
 * 提供简洁的接口来读取信号机的状态
 *
 * <h2>增强功能：支持区块未加载查询</h2>
 * <p>本API现在支持在区块未加载时查询信号状态：</p>
 * <ul>
 *   <li><b>区块已加载：</b>直接从方块实体获取实时状态</li>
 *   <li><b>区块未加载：</b>从全局状态缓存获取最新状态</li>
 *   <li><b>数据一致性：</b>缓存状态由SignalStateManager定期更新，保证数据时效性</li>
 * </ul>
 *
 * <h2>与原版机械动力信号系统的差异</h2>
 * <p><b>重要：</b>机械动力原版信号灯可以不依赖区块加载而更新，原因如下：</p>
 * <ul>
 *   <li><b>全局架构：</b>原版信号使用全局的SignalBoundary（信号边界），
 *       这是TrackEdgePoint类型，存储在TrackGraph中，由铁路系统全局管理。</li>
 *   <li><b>事件驱动：</b>原版信号状态更新由铁路系统事件触发（如列车移动），
 *       不依赖单个方块实体的tick()方法。</li>
 *   <li><b>本模组实现：</b>通过增强型全局状态管理器，实现了类似原版的不依赖区块加载功能。
 *       SignalStateManager定期更新所有信号状态并缓存，供API查询。</li>
 * </ul>
 *
 * <h2>数据存储说明</h2>
 * <ul>
 *   <li><b>全局状态缓存：</b>所有信号机的状态存储在SignalStateManager中，
 *       定期更新占用状态、连接状态和信号组ID。</li>
 *   <li><b>方块实体NBT：</b>信号机的配置和当前状态存储在方块实体的NBT数据中，
 *       包括进路设置、信号组ID、占用状态等。</li>
 *   <li><b>机械动力铁路系统NBT：</b>Create模组的铁路系统（Railways）有专门的NBT表存储全局数据。</li>
 * </ul>
 *
 * <h2>使用建议</h2>
 * <ul>
 *   <li>本API自动处理区块加载状态，无需手动检查</li>
 *   <li>对于需要最高实时性的应用，确保相关区块已加载</li>
 *   <li>缓存状态更新频率为每5tick（4次/秒），满足大多数应用需求</li>
 * </ul>
 */
public class SignalSystemAPI {

    private SignalSystemAPI() {
        // 静态工具类，无需实例化
    }

    // ========== 核心查询方法 ==========

    /**
     * 获取指定位置的信号状态显示器方块实体
     *
     * <p><b>注意：</b>此方法要求区块已加载。如果区块未加载，将返回null。
     * 对于未加载的区块，请使用其他API方法从缓存获取状态。</p>
     *
     * @param level 世界
     * @param pos 位置
     * @return 信号状态显示器方块实体，如果不存在、类型不匹配或区块未加载则返回null
     */
    @Nullable
    public static SignalStateDisplayBlockEntity getSignalDisplay(Level level, BlockPos pos) {
        if (level == null || pos == null) {
            return null;
        }

        // 检查区块是否加载
        if (!level.isLoaded(pos)) {
            return null;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SignalStateDisplayBlockEntity signalDisplay) {
            return signalDisplay;
        }

        return null;
    }

    /**
     * 检查指定位置是否为有效的信号状态显示器
     *
     * @param level 世界
     * @param pos 位置
     * @return 如果是有效的信号状态显示器则返回true
     */
    public static boolean isSignalDisplay(Level level, BlockPos pos) {
        // 尝试从方块实体获取
        if (getSignalDisplay(level, pos) != null) {
            return true;
        }

        // 尝试从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                return cache != null;
            }
        }

        return false;
    }

    // ========== 状态获取方法（支持缓存） ==========

    /**
     * 获取四显示信号状态（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 四显示信号状态，如果信号机不存在则返回null
     */
    @Nullable
    public static SignalStateDisplayBlockEntity.FourAspectSignalState getFourAspectSignalState(Level level, BlockPos pos) {
        // 优先从方块实体获取（区块已加载）
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getFourAspectState();
        }

        // 从缓存获取（区块未加载）
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.fourAspectState;
                }
            }
        }

        return null;
    }

    /**
     * 获取当前进路编号（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 进路编号（1-6），如果信号机不存在则返回-1
     */
    public static int getCurrentRoute(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getCurrentRoute();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.currentRoute;
                }
            }
        }

        return -1;
    }

    /**
     * 获取是否强制红灯（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 是否强制红灯，如果信号机不存在则返回false
     */
    public static boolean isForceRed(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.isForceRed();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.forceRed;
                }
            }
        }

        return false;
    }

    /**
     * 获取指定槽位的信号组ID（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @param index 槽位索引（0-3，0为当前信号组，1-3为前方信号组）
     * @return 信号组ID，如果信号机不存在或索引无效则返回null
     */
    @Nullable
    public static UUID getSignalGroupId(Level level, BlockPos pos, int index) {
        if (index < 0 || index >= 4) {
            return null;
        }

        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getSignalGroupId(index);
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null && cache.signalGroupIds != null && index < cache.signalGroupIds.length) {
                    return cache.signalGroupIds[index];
                }
            }
        }

        return null;
    }

    /**
     * 获取指定槽位的占用状态（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @param index 槽位索引（0-3）
     * @return 占用状态，如果信号机不存在或索引无效则返回false
     */
    public static boolean getOccupancyState(Level level, BlockPos pos, int index) {
        if (index < 0 || index >= 4) {
            return false;
        }

        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getOccupancyState(index);
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null && cache.occupancyStates != null && index < cache.occupancyStates.length) {
                    return cache.occupancyStates[index];
                }
            }
        }

        return false;
    }

    /**
     * 获取所有信号组ID的副本（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 信号组ID数组的副本（长度为4），如果信号机不存在则返回null
     */
    @Nullable
    public static UUID[] getSignalGroupIds(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getSignalGroupIds();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null && cache.signalGroupIds != null) {
                    // 返回副本，避免外部修改
                    UUID[] copy = new UUID[4];
                    System.arraycopy(cache.signalGroupIds, 0, copy, 0, 4);
                    return copy;
                }
            }
        }

        return null;
    }

    /**
     * 获取所有占用状态的副本（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 占用状态数组的副本（长度为4），如果信号机不存在则返回null
     */
    @Nullable
    public static boolean[] getOccupancyStates(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getOccupancyStates();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null && cache.occupancyStates != null) {
                    // 返回副本，避免外部修改
                    boolean[] copy = new boolean[4];
                    System.arraycopy(cache.occupancyStates, 0, copy, 0, 4);
                    return copy;
                }
            }
        }

        return null;
    }

    /**
     * 获取最后的红石信号强度（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 红石信号强度（0-15），如果信号机不存在则返回0
     */
    public static int getLastRedstoneSignal(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getLastRedstoneSignal();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.lastRedstoneSignal;
                }
            }
        }

        return 0;
    }

    /**
     * 获取基础信号状态（来自Create的信号系统，支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 基础信号状态，如果信号机不存在则返回null
     */
    @Nullable
    public static com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState getBaseSignalState(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getBaseSignalState();
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.baseSignalState;
                }
            }
        }

        return null;
    }

    /**
     * 获取信号机是否通电（红灯时输出红石信号，支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 是否通电，如果信号机不存在则返回false
     */
    public static boolean isPowered(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.isPowered();
        }

        // 从缓存获取：红灯时输出信号
        SignalStateDisplayBlockEntity.FourAspectSignalState state = getFourAspectSignalState(level, pos);
        return state == SignalStateDisplayBlockEntity.FourAspectSignalState.RED;
    }

    /**
     * 检查信号机是否处于有效状态（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 如果信号机有效（非INVALID状态）则返回true
     */
    public static boolean isValidSignal(Level level, BlockPos pos) {
        SignalStateDisplayBlockEntity.FourAspectSignalState state = getFourAspectSignalState(level, pos);
        return state != null && state != SignalStateDisplayBlockEntity.FourAspectSignalState.INVALID;
    }

    /**
     * 检查信号机是否连接到轨道网络（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 如果信号机连接到轨道网络则返回true
     */
    public static boolean isConnectedToTrack(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            return signalDisplay.getSignal() != null;
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                return cache != null && cache.isConnectedToTrack;
            }
        }

        return false;
    }

    /**
     * 获取信号机连接到的边界ID（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 边界ID，如果信号机未连接或不存在则返回null
     */
    @Nullable
    public static UUID getConnectedBoundaryId(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            com.simibubi.create.content.trains.signal.SignalBoundary boundary = signalDisplay.getSignal();
            return boundary != null ? boundary.id : null;
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.connectedBoundaryId;
                }
            }
        }

        return null;
    }

    /**
     * 获取信号机连接到的轨道图ID（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 轨道图ID，如果信号机未连接或不存在则返回null
     */
    @Nullable
    public static UUID getConnectedGraphId(Level level, BlockPos pos) {
        // 优先从方块实体获取
        SignalStateDisplayBlockEntity signalDisplay = getSignalDisplay(level, pos);
        if (signalDisplay != null) {
            // 需要从边界获取轨道图，这里简化处理
            // 实际应该从边界获取所在轨道图
        }

        // 从缓存获取
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    return cache.connectedGraphId;
                }
            }
        }

        return null;
    }

    /**
     * 获取信号机是否需要寻路更新（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 如果需要寻路更新则返回true
     */
    public static boolean needsPathfindingUpdate(Level level, BlockPos pos) {
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                return cache != null && cache.needsPathfindingUpdate;
            }
        }
        return false;
    }

    /**
     * 强制信号机重新寻路（支持区块未加载）
     *
     * @param level 世界
     * @param pos 位置
     * @return 操作是否成功
     */
    public static boolean requestPathfindingUpdate(Level level, BlockPos pos) {
        if (level instanceof ServerLevel serverLevel) {
            SignalStateManager manager = SignalStateManager.get(serverLevel);
            if (manager != null) {
                SignalStateManager.SignalStateCache cache = manager.getSignalCache(serverLevel, pos);
                if (cache != null) {
                    cache.needsPathfindingUpdate = true;
                    manager.setDirty();
                    return true;
                }
            }
        }
        return false;
    }
}