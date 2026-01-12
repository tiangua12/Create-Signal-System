package com.easttown.createsignalsystem.util;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.config.ModConfiguration;
import org.slf4j.Logger;

/**
 * 简单日志包装器
 * 使用一条配置控制所有日志输出
 */
public class SimpleLogger {
    private static final Logger LOGGER = CreateSignalSystemMod.LOGGER;

    /**
     * 检查是否启用日志输出
     */
    private static boolean isLoggingEnabled() {
        return ModConfiguration.isDebugOutputEnabled();
    }

    /**
     * 输出调试日志（受配置控制）
     */
    public static void debug(String msg) {
        if (isLoggingEnabled()) {
            LOGGER.debug(msg);
        }
    }

    /**
     * 输出调试日志（带格式，受配置控制）
     */
    public static void debug(String format, Object arg) {
        if (isLoggingEnabled()) {
            LOGGER.debug(format, arg);
        }
    }

    /**
     * 输出调试日志（带格式，受配置控制）
     */
    public static void debug(String format, Object arg1, Object arg2) {
        if (isLoggingEnabled()) {
            LOGGER.debug(format, arg1, arg2);
        }
    }

    /**
     * 输出调试日志（带格式，受配置控制）
     */
    public static void debug(String format, Object... arguments) {
        if (isLoggingEnabled()) {
            LOGGER.debug(format, arguments);
        }
    }

    /**
     * 输出信息日志（受配置控制）
     */
    public static void info(String msg) {
        if (isLoggingEnabled()) {
            LOGGER.info(msg);
        }
    }

    public static void info(String format, Object arg) {
        if (isLoggingEnabled()) {
            LOGGER.info(format, arg);
        }
    }

    public static void info(String format, Object arg1, Object arg2) {
        if (isLoggingEnabled()) {
            LOGGER.info(format, arg1, arg2);
        }
    }

    public static void info(String format, Object... arguments) {
        if (isLoggingEnabled()) {
            LOGGER.info(format, arguments);
        }
    }

    /**
     * 输出警告日志（受配置控制）
     */
    public static void warn(String msg) {
        if (isLoggingEnabled()) {
            LOGGER.warn(msg);
        }
    }

    public static void warn(String format, Object arg) {
        if (isLoggingEnabled()) {
            LOGGER.warn(format, arg);
        }
    }

    public static void warn(String format, Object arg1, Object arg2) {
        if (isLoggingEnabled()) {
            LOGGER.warn(format, arg1, arg2);
        }
    }

    public static void warn(String format, Object... arguments) {
        if (isLoggingEnabled()) {
            LOGGER.warn(format, arguments);
        }
    }

    /**
     * 输出错误日志（受配置控制）
     */
    public static void error(String msg) {
        if (isLoggingEnabled()) {
            LOGGER.error(msg);
        }
    }

    public static void error(String format, Object arg) {
        if (isLoggingEnabled()) {
            LOGGER.error(format, arg);
        }
    }

    public static void error(String format, Object arg1, Object arg2) {
        if (isLoggingEnabled()) {
            LOGGER.error(format, arg1, arg2);
        }
    }

    public static void error(String format, Object... arguments) {
        if (isLoggingEnabled()) {
            LOGGER.error(format, arguments);
        }
    }

    /**
     * 输出错误日志（带异常，受配置控制）
     */
    public static void error(String msg, Throwable t) {
        if (isLoggingEnabled()) {
            LOGGER.error(msg, t);
        }
    }
}