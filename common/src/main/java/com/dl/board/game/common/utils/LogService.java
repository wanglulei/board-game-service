package com.dl.board.game.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.text.MessageFormat;

/**
 * @Description
 * @Author wanglulei
 * @Date 2020/6/12  10:31
 **/
public class LogService {

    public final static String INFO_NAME = "infoAppender";

    public final static String DEBUG_NAME = "debugAppender";

    public final static String WARN_NAME = "warnAppender";

    public final static String ERROR_NAME = "errorAppender";

    public static Logger getInfoLogger() {
        Logger infoLogger = LoggerFactory.getLogger(INFO_NAME);
        return infoLogger;
    }

    public static Logger getDebugLogger() {
        Logger debugLogger = LoggerFactory.getLogger(DEBUG_NAME);
        return debugLogger;
    }

    public static Logger getWarnLogger() {
        Logger warnLogger = LoggerFactory.getLogger(WARN_NAME);
        return warnLogger;
    }

    public static Logger getErrorLogger() {
        Logger errorLogger = LoggerFactory.getLogger(ERROR_NAME);
        return errorLogger;
    }

    public static void info(String message) {
        getInfoLogger().info(message);
    }

    public static void debug(String message) {
        getDebugLogger().debug(message);
    }

    public static void warn(String message) {
        getWarnLogger().debug(message);
    }

    public static void warn(String format, Object... params) {
        getWarnLogger().warn(format, params);
    }

    public static void error(String message) {
        getErrorLogger().error(message);
    }

    public static void error(String message, Throwable t) {
        getErrorLogger().error(message, t);
    }

    public static void error(String format, Throwable t, String... params) {
        String formatResult = MessageFormat.format(format, params);
        getErrorLogger().error(formatResult, t);
    }

    public static void error(Exception e) {
        getErrorLogger().error(e.getMessage());
    }

    public static void info(String messagePattern, String arg) {
        info(MessageFormatter.format(messagePattern, arg).getMessage());
    }

    public static void info(String messagePattern, Object arg) {
        info(MessageFormatter.format(messagePattern, arg).getMessage());
    }

    /**
     *  info("hello: {}, id is: {}", name, id)
     * @param messagePattern
     * @param args
     */
    public static void info(String messagePattern, Object... args) {

        info(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
    }



    /**
     * debug("hello: {}, id is: {}", name, id)
     * @param messagePattern
     * @param args
     */
    public static void debug(String messagePattern, Object... args) {

        debug(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
    }

    public static void error(String messagePattern, Object... args) {

        error(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
    }

    public static void error(Throwable e, String messagePattern, Object... args) {

        error(MessageFormatter.arrayFormat(messagePattern, args).getMessage(), e);

    }
}
