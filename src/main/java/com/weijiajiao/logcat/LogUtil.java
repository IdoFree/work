package com.weijiajiao.logcat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by fly on 2017/6/6.
 */
public class LogUtil {
    private static boolean DEBUG = true;
    private static final Log COMMONLOG = LogFactory.getLog(LogUtil.class);

    public static void error(String tag, Object logDes) {
        if (DEBUG) {
            COMMONLOG.error(tag + ":----" + logDes);
        }
    }

    public static void warn(String tag, Object logDes) {
        if (DEBUG) {
            COMMONLOG.warn(tag + ":----" + logDes);
        }
    }

    public static void debug(String tag, Object logDes) {
        if (DEBUG) {
            COMMONLOG.debug(tag + ":----" + logDes);
        }
    }

    public static void info(String tag, Object logDes) {
        if (DEBUG) {
            COMMONLOG.info(tag + ":----" + logDes);
        }
    }

    public static void trace(String tag, Object logDes) {
        if (DEBUG) {
            COMMONLOG.trace(tag + ":----" + logDes);
        }
    }
}
