package org.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.study.constants.PointCutCenter;
import org.study.handler.RedisHandler;
import org.study.response.ApiResponse;
import org.study.util.RedisKeyCenter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author fanqie
 * Created on 2020.08.22
 */
@Aspect
@Component
public class CacheAspect {

    @Autowired
    private RedisHandler redisHandler;

    @Pointcut(PointCutCenter.PRODUCT_CACHE)
    public void cacheProduct() {
    }

    @Around("cacheProduct()")
    public Object productInfoAround(ProceedingJoinPoint joinPoint) throws Throwable {
        int id = (Integer) joinPoint.getArgs()[0];
        String redisKey = RedisKeyCenter.getProductInfoKey(id);
        Object productInfo = redisHandler.getCache(redisKey);

        //加锁防缓存击穿，获取锁之后先去访问缓存，缓存中还没有才去访问数据库
        if (productInfo == null) {
            synchronized (redisKey.intern()) {
                productInfo = redisHandler.getCache(redisKey);
                if (productInfo == null) {
                    productInfo = joinPoint.proceed();
                }

                //防穿透，数据库不存在这条字段时，给缓存塞一个代表空的数据
                if (productInfo == null) {
                    productInfo = RedisHandler.NULL_MARK;
                }

                //防雪崩，过期时间随机化
                long timeout = 10 + new Random().nextInt(10);
                redisHandler.save(redisKey, productInfo, timeout, TimeUnit.MINUTES);
            }
        }

        return redisHandler.isNullMark(productInfo)
                ? ApiResponse.fail("商品不存在")
                : ApiResponse.success(productInfo);
    }
}
