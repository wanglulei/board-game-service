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
package com.dl.board.game.core.configure;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: cache默认配置类
 *
 * @author Ale
 * @date 2018-04-26
 */
@Configuration
@Slf4j
public class CacheConfig {
    @Value("${aliyun.enable}")
    private boolean isAliyun;

    @Value("${spring.redis.host:\"\"}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.timeout:6000}")
    private int timeout;

    @Value("${spring.redis.password:\"\"}")
    private String password;

    @Value("${spring.redis.test.mastername:\"\"}")
    private String mastername;

    @Value("${spring.redis.test.sentinel:\"\"}")
    private String sentinel;

    @Value("${spring.redis.test.passwd:\"\"}")
    private String testPasswd;

    @Value("${spring.redis.jedis.pool.max-active:200}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.maxWait:200}")
    private int maxWait;

    @Value("${spring.redis.jedis.pool.max-idle:8}0")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle:10}")
    private int minIdle;

    @Value("${spring.redis.database}")
    private int database;

    @Bean
    public Pool<Jedis> pool(){

        Pool<Jedis> pool=null;

        GenericObjectPoolConfig pc = new GenericObjectPoolConfig();
        pc.setMinIdle(minIdle);
        pc.setMaxIdle(maxIdle);
        pc.setMaxTotal(maxIdle);
        if(StringUtils.isEmpty(password)){
            password = null;
        }
        if(isAliyun){
            pool= new JedisPool(pc, host, port,timeout,password, database);
        } else {
            Set<String> sentinels = new HashSet<String>();
            String[] sentinels_config =sentinel.split(" ");
            for (String ipport : sentinels_config) {
                String hostAndPort[] = ipport.split(":");
                log.info(hostAndPort[0]);
                sentinels.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])).toString());
            }
            pool=new JedisSentinelPool(mastername, sentinels, pc, timeout, testPasswd, database);
        }
        return pool;
    }

}
