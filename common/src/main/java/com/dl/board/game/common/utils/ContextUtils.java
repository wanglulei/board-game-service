package com.dl.board.game.common.utils;

import java.util.HashMap;

/**
 * @ClassName ContextUtils
 * @Description
 * @Author wanglulei
 * @Date 2020/12/23  15:01
 **/
public class ContextUtils {
    public static class Constant{
        public final static String KEY_START_TIME = "startTime";
    }
    private static ThreadLocal<HashMap<String,Object>> datas = new ThreadLocal<HashMap<String,Object>>();

    public static HashMap<String,Object> getDatas(){
        HashMap<String, Object> map = datas.get();
        if (map == null) {
            map = new HashMap<String,Object>();
            setDate(map);
        }

        return map;
    }

    public static void setDate(HashMap<String,Object> data ){
        datas.set(data);
    }

    public static void clean(){
        datas.remove();
    }
}