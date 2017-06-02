package com.weijiajiao.logcat;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fly on 2017/6/1.
 */
public class LogMapper {
    private static final String LOG_DIR="log";
    private static LogMapper instance;
    private static String currentDate = "";

    private static FileWriter fileWriter;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    private LogMapper() {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            System.out.println("文件路径："+url.getPath());
            String rootFilePath = url.getPath().substring(0,url.getPath().lastIndexOf("target"))+LOG_DIR;
            System.out.println("文件路径："+rootFilePath);
            currentDate = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            String logFilePath = rootFilePath + File.separator + currentDate +".txt";
            System.out.println("文件路径："+logFilePath);
            File logFile = new File(logFilePath);
            if (!logFile.exists()){
                logFile.createNewFile();
            }
            fileWriter = new FileWriter(logFile,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogMapper getInstance(){
        if (instance==null|| fileWriter == null||!isCurrentDate()){
            synchronized (LogMapper.class) {
                instance = new LogMapper();
            }
        }
        return instance;
    }

    public void addEntity(Map<String,String> map) {
        synchronized (LogMapper.class) {
            if (map == null) {
                return;
            }
            if (fileWriter == null) {
                throw new NullPointerException("FileWriter null");
            }
            try {
                print("\n");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    print(entry.getKey()+": ");
                    print(entry.getValue());
                    print("\n");
                }
                print("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                    fileWriter = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void print(String s) throws IOException {
            fileWriter.write(s);
    }

    private static boolean isCurrentDate() {
        return currentDate.equals(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }


}
