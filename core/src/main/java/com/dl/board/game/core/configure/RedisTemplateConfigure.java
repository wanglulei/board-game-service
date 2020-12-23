package com.dl.board.game.core.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisTemplateConfigure {

    @Bean
    public RedisTemplate<String, Object> jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> jsonRedisTemplate = new RedisTemplate<>();
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        jsonRedisTemplate.setConnectionFactory(redisConnectionFactory);
        jsonRedisTemplate.setKeySerializer(RedisSerializer.string());
        jsonRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        jsonRedisTemplate.setHashKeySerializer(RedisSerializer.string());
        jsonRedisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        jsonRedisTemplate.afterPropertiesSet();
        return jsonRedisTemplate;
    }
}
