package com.dl.board.game.core.tools;

import com.dl.board.game.core.configure.JedisUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * redis开关工具类
 * sxl
 */
public class RedisOnOffUtils {

    /**
     * 获取redis开关（先从本地获取）
     *
     * @param onOffKey
     * @param keepTime
     * @return
     */
    public static boolean isStatusOn(String onOffKey, Integer keepTime) {
        return StringUtils.isNotBlank(getRedisAfterLocal(onOffKey, keepTime));
    }

    /**
     * 获取缓存值（先从本地获取）
     *
     * @param redisKey
     * @param keepTime
     * @return
     */
    public static String getRedisAfterLocal(String redisKey, Integer keepTime) {
        String redisValue = null;
        RedisValueObject obj = redisValueMap.get(redisKey);
        if (obj != null && System.currentTimeMillis() - obj.getQueryTime() <= keepTime * 1000) {
            redisValue = obj.getRedisValue();
        } else {
            redisValue = JedisUtils.get(redisKey);
            RedisValueObject newObj = new RedisValueObject();
            newObj.setQueryTime(System.currentTimeMillis());
            newObj.setRedisValue(redisValue);
            redisValueMap.put(redisKey, newObj);
        }
        return redisValue;
    }

    /**
     * 获取缓存值（先从本地获取）,redis null 不会存到本地
     *
     * @param redisKey
     * @param keepTime
     * @return
     */
    public static String getRedisAfterLocalCheckNull(String redisKey, Integer keepTime) {
        String redisValue = null;
        RedisValueObject obj = redisValueMap.get(redisKey);
        if (obj != null && System.currentTimeMillis() - obj.getQueryTime() <= keepTime * 1000) {
            redisValue = obj.getRedisValue();
        } else {
            redisValue = JedisUtils.get(redisKey);
            if (StringUtils.isNotBlank(redisValue)){
                RedisValueObject newObj = new RedisValueObject();
                newObj.setQueryTime(System.currentTimeMillis());
                newObj.setRedisValue(redisValue);
                redisValueMap.put(redisKey, newObj);
            }
        }
        return redisValue;
    }

    public static Boolean getRoiValue(String localCacheKey, Integer lockCachekeepTime,
                                      RoiExecuteCallBack roiExecuteCallBack) {
        Boolean isHighQualityUserGroup = false;
        RedisValueObject roiObject = redisValueMap.get(localCacheKey);

        if (roiObject != null && System.currentTimeMillis() - roiObject.getQueryTime() <= lockCachekeepTime * 1000) {
            isHighQualityUserGroup = Boolean.valueOf(roiObject.getRedisValue());
        } else {
            isHighQualityUserGroup = roiExecuteCallBack.execute();
            if (Objects.isNull(isHighQualityUserGroup)) {
                isHighQualityUserGroup = false;
            }
            RedisValueObject newObj = new RedisValueObject();
            newObj.setQueryTime(System.currentTimeMillis());
            newObj.setRedisValue(String.valueOf(isHighQualityUserGroup));
            redisValueMap.put(localCacheKey, newObj);
        }
        return isHighQualityUserGroup;
    }

    /**
     * 清除本地缓存
     * @param localCacheKey
     */
    public static void remove(String localCacheKey) {
        redisValueMap.remove(localCacheKey);
    }

    public static void put(String localCacheKey, Object value) {
        RedisValueObject newObj = new RedisValueObject();
        newObj.setQueryTime(System.currentTimeMillis());
        newObj.setRedisValue(String.valueOf(value));
        redisValueMap.put(localCacheKey, newObj);
    }


    private static Map<String, RedisValueObject> redisValueMap = new HashMap<>();

    static class RedisValueObject {

        String redisValue;
        long queryTime;

        public String getRedisValue() {
            return redisValue;
        }

        public void setRedisValue(String redisValue) {
            this.redisValue = redisValue;
        }

        public long getQueryTime() {
            return queryTime;
        }

        public void setQueryTime(long queryTime) {
            this.queryTime = queryTime;
        }
    }

    @FunctionalInterface
    public interface RoiExecuteCallBack {
        // 执行redis操作
        Boolean execute();
    }

    @FunctionalInterface
    public interface BooleanCallBack {
        Boolean handle(String str1, String str2);
    }

    @FunctionalInterface
    public interface StringCallBack {
        String handle();
    }

    @FunctionalInterface
    public interface StringCallBackV2 {
        String handle() throws Exception;
    }

    @FunctionalInterface
    public interface MapCallBack {
        Map<String, String> handle();
    }

}
