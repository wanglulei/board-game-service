package com.dl.board.game.common.utils;

import java.text.MessageFormat;

/**
 * @Description
 * @Author wanglulei
 * @Date 2020/6/12  10:31
 **/
public class GameRedisKeyUtil {

    /**
     * 利用统配符的方式生成redis Key
     *
     * @param key
     * @param values
     * @return
     */
    public static String format(String key, Object... values) {
        if (values != null && values.length > 0) {
            for (int out = 0; out < values.length && values[out] != null; ++out) {
                values[out] = String.valueOf(values[out]);
            }

            String var3 = MessageFormat.format(key, values);
            var3 = var3.replaceAll("\\$", "");
            return var3;
        } else {
            return key;
        }
    }
}
