/*
 *  Copyright 2015-2020 Xmiles, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.dl.board.game.core.tools;

import com.dl.board.game.core.configure.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * Description: 基于redis分布式锁
 *
 * @author Ale
 * @date 2018-01-24
 */
@Slf4j
public class RedisDistributedLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间 单位秒
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

        Jedis jedis= null;

        try {
            jedis= JedisUtils.getResource();
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + expireTime * 1000;
            while (System.currentTimeMillis() < end) {
                String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                if (LOCK_SUCCESS.equals(result)) {
                    return true;
                }
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    log.error("RedisDistributedLock tryGetDistributedLock sleep error ", e);
                }
            }
            return  false;
        } catch (Exception e) {

        } finally {
            if(jedis!=null) {
                JedisUtils.returnResource(jedis);
            }
        }
        return false;
    }


    /**
     * 获取分布式锁不等待
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间 单位秒
     * @return
     */
    public static boolean getLock(String lockKey, String requestId, int expireTime) {
        Jedis jedis= null;
        try {
            jedis= JedisUtils.getResource();
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
            return  false;
        } catch (Exception e) {

        } finally {
            if(jedis!=null) {
                JedisUtils.returnResource(jedis);
            }
        }
        return false;
    }


    /**
     * 尝试获取分布式锁，不会等待锁，
     * 只有锁主动释放或者超过10天锁失效后才会释放
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLockWithOutTime(String lockKey, String requestId) {

        Jedis jedis= null;
        try {
            jedis= JedisUtils.getResource();
            // 获取锁的超时时间，超过这个时间则放弃获取锁
                String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,60*60*24*10 );
                if (LOCK_SUCCESS.equals(result)) {
                    return true;
                }
            return  false;
        } catch (Exception e) {

        } finally {
            if(jedis!=null) {
                JedisUtils.returnResource(jedis);
            }
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {

        Jedis jedis= null;
        try {
            jedis= JedisUtils.getResource();
            String redisKey = jedis.get(lockKey);
            if (requestId.equals(redisKey)) {
                jedis.del(lockKey);
            }
            /*String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }*/
        } catch (Exception e) {
            log.error("释放分布式锁异常 lockKey = " + lockKey + " requestId = " + requestId, e);
        } finally {
            if(jedis!=null) {
                JedisUtils.returnResource(jedis);
            }
        }
        return false;

    }
}
