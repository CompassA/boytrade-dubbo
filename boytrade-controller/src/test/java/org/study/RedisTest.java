package org.study;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public class RedisTest extends BaseTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void strTest() {
        String key1 = "test_key";
        String value1 = "test_value";
        stringRedisTemplate.opsForValue().set(key1, value1, 1, TimeUnit.MINUTES);
        Assert.assertEquals(value1, stringRedisTemplate.opsForValue().get(key1));

        String key2 = "test_key2";
        int value2 = 100;
        redisTemplate.opsForValue().set(key2, value2, 1, TimeUnit.MINUTES);
        Assert.assertEquals(value2, redisTemplate.opsForValue().get(key2));
    }

    @Test
    public void objTest() {
        String key = "obj_key";
        InnerTestObject value = new InnerTestObject("TEST", 100, false);
        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
        Assert.assertEquals(value, redisTemplate.opsForValue().get(key));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class InnerTestObject {
        private String propertyA;
        private int propertyB;
        private boolean propertyC;

        public InnerTestObject() {}

        public InnerTestObject(String propertyA, int propertyB, boolean propertyC) {
            this.propertyA = propertyA;
            this.propertyB = propertyB;
            this.propertyC = propertyC;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof InnerTestObject)) {
                return false;
            }
            if (other == this) {
                return true;
            }
            InnerTestObject otherObj = (InnerTestObject) other;
            return propertyA.equals(otherObj.propertyA)
                    && propertyB == otherObj.propertyB
                    && propertyC == otherObj.propertyC;
        }

        public String getPropertyA() { return propertyA; }
        public void setPropertyA(String propertyA) { this.propertyA = propertyA; }
        public int getPropertyB() { return propertyB; }
        public void setPropertyB(int propertyB) { this.propertyB = propertyB; }
        public boolean isPropertyC() { return propertyC; }
        public void setPropertyC(boolean propertyC) { this.propertyC = propertyC; }
    }
}
