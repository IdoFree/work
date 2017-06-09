package com.weijiajiao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

/**
 * Created by fly on 2017/6/7.
 */
public abstract class RedisGenerateDao<K extends Serializable, V extends Serializable> {
    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    public JdkSerializationRedisSerializer getRedisSerializer() {
        return (JdkSerializationRedisSerializer) redisTemplate.getDefaultSerializer();
    }
}
