package com.weijiajiao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by junli on 2017/6/5.
 */
public class Logger {

    public static void debug(Object info){
        System.out.println(logPrefix(LogLevel.DEBUG) + info.toString());
    }

    public static void info(Object info){
        System.out.println(logPrefix(LogLevel.INFO) + info.toString());
    }

    public static void warning(Object info){
        System.out.println(logPrefix(LogLevel.WARNING) + info.toString());
    }

    public static void error(Object info){
        System.out.println(logPrefix(LogLevel.ERROR) + info.toString());
    }

    private static String logPrefix(LogLevel level){
        final StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length >= 4){
            StackTraceElement invokeElement = elements[3];
            String className = invokeElement.getClassName();
            String methodName = invokeElement.getMethodName();
            int lineNumber = invokeElement.getLineNumber();
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String prefix = time + " [" + level.toString() + "] " + className + "-" + methodName + ":" + lineNumber + " --- ";
            return prefix;
        } else {
            return "";
        }
    }

}

enum LogLevel {
    DEBUG, INFO, WARNING, ERROR;
}
