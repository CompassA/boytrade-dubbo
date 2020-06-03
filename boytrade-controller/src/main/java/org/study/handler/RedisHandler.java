package org.study.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author fanqie
 * @date 2020/6/3
 */
@Component
public class RedisHandler {

    public static final NullMark NULL_MARK = new NullMark();

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public Object getCache(String redisKey) {
        return redisTemplate.opsForValue().get(redisKey);
    }

    public void save(Object redisKey, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(redisKey, value, timeout, unit);
    }

    public boolean isNullMark(Object cacheValue) {
        return cacheValue instanceof NullMark;
    }

    private static class NullMark implements Serializable {
        private final String info = "this is redis null mark";
    }
}
