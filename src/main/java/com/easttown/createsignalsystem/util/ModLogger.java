package com.easttown.createsignalsystem.util;

import com.easttown.createsignalsystem.config.ModConfiguration;
import com.easttown.createsignalsystem.CreateSignalSystemMod;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * 模组日志包装器
 * 根据配置控制调试日志输出
 */
public class ModLogger implements Logger {
    private final Logger delegate;
    private final String name;

    /**
     * 创建ModLogger实例
     */
    public ModLogger(Logger delegate) {
        this.delegate = delegate;
        this.name = delegate.getName();
    }

    /**
     * 获取模组主日志记录器
     */
    public static ModLogger getLogger() {
        return new ModLogger(CreateSignalSystemMod.LOGGER);
    }

    /**
     * 检查是否启用调试日志
     */
    private boolean isDebugEnabledInternal() {
        return ModConfiguration.isDebugLoggingEnabled() && delegate.isDebugEnabled();
    }

    /**
     * 检查是否启用详细算法跟踪
     */
    private boolean isDetailedTracingEnabled() {
        return ModConfiguration.isDetailedAlgorithmTracingEnabled();
    }

    /**
     * 检查是否启用性能日志
     */
    private boolean isPerformanceLoggingEnabled() {
        return ModConfiguration.isPerformanceLoggingEnabled();
    }

    // ========== 调试日志方法 ==========

    @Override
    public boolean isDebugEnabled() {
        return isDebugEnabledInternal();
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabledInternal() && delegate.isDebugEnabled(marker);
    }

    @Override
    public void debug(String msg) {
        if (isDebugEnabledInternal()) {
            delegate.debug(msg);
        }
    }

    @Override
    public void debug(String format, Object arg) {
        if (isDebugEnabledInternal()) {
            delegate.debug(format, arg);
        }
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        if (isDebugEnabledInternal()) {
            delegate.debug(format, arg1, arg2);
        }
    }

    @Override
    public void debug(String format, Object... arguments) {
        if (isDebugEnabledInternal()) {
            delegate.debug(format, arguments);
        }
    }

    @Override
    public void debug(String msg, Throwable t) {
        if (isDebugEnabledInternal()) {
            delegate.debug(msg, t);
        }
    }

    @Override
    public void debug(Marker marker, String msg) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg);
        }
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, format, arg);
        }
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, format, arg1, arg2);
        }
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, format, arguments);
        }
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg, t);
        }
    }

    // ========== 详细算法跟踪方法 ==========

    /**
     * 输出详细算法跟踪日志
     */
    public void traceAlgorithm(String msg) {
        if (isDetailedTracingEnabled()) {
            delegate.debug("[算法跟踪] " + msg);
        }
    }

    /**
     * 输出详细算法跟踪日志（带参数）
     */
    public void traceAlgorithm(String format, Object... arguments) {
        if (isDetailedTracingEnabled()) {
            delegate.debug("[算法跟踪] " + format, arguments);
        }
    }

    // ========== 性能日志方法 ==========

    /**
     * 输出性能日志
     */
    public void performance(String msg) {
        if (isPerformanceLoggingEnabled()) {
            delegate.info("[性能] " + msg);
        }
    }

    /**
     * 输出性能日志（带参数）
     */
    public void performance(String format, Object... arguments) {
        if (isPerformanceLoggingEnabled()) {
            delegate.info("[性能] " + format, arguments);
        }
    }

    // ========== 其他日志级别方法（直接委托） ==========

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return delegate.isTraceEnabled(marker);
    }

    @Override
    public void trace(String msg) {
        delegate.trace(msg);
    }

    @Override
    public void trace(String format, Object arg) {
        delegate.trace(format, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        delegate.trace(format, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        delegate.trace(format, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        delegate.trace(msg, t);
    }

    @Override
    public void trace(Marker marker, String msg) {
        delegate.trace(marker, msg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        delegate.trace(marker, format, arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        delegate.trace(marker, format, arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... arguments) {
        delegate.trace(marker, format, arguments);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        delegate.trace(marker, msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return delegate.isInfoEnabled(marker);
    }

    @Override
    public void info(String msg) {
        delegate.info(msg);
    }

    @Override
    public void info(String format, Object arg) {
        delegate.info(format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        delegate.info(format, arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        delegate.info(format, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        delegate.info(msg, t);
    }

    @Override
    public void info(Marker marker, String msg) {
        delegate.info(marker, msg);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        delegate.info(marker, format, arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        delegate.info(marker, format, arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        delegate.info(marker, format, arguments);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        delegate.info(marker, msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return delegate.isWarnEnabled(marker);
    }

    @Override
    public void warn(String msg) {
        delegate.warn(msg);
    }

    @Override
    public void warn(String format, Object arg) {
        delegate.warn(format, arg);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        delegate.warn(format, arg1, arg2);
    }

    @Override
    public void warn(String format, Object... arguments) {
        delegate.warn(format, arguments);
    }

    @Override
    public void warn(String msg, Throwable t) {
        delegate.warn(msg, t);
    }

    @Override
    public void warn(Marker marker, String msg) {
        delegate.warn(marker, msg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        delegate.warn(marker, format, arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        delegate.warn(marker, format, arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        delegate.warn(marker, format, arguments);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        delegate.warn(marker, msg, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return delegate.isErrorEnabled(marker);
    }

    @Override
    public void error(String msg) {
        delegate.error(msg);
    }

    @Override
    public void error(String format, Object arg) {
        delegate.error(format, arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        delegate.error(format, arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        delegate.error(format, arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        delegate.error(msg, t);
    }

    @Override
    public void error(Marker marker, String msg) {
        delegate.error(marker, msg);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        delegate.error(marker, format, arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        delegate.error(marker, format, arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        delegate.error(marker, format, arguments);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        delegate.error(marker, msg, t);
    }
}