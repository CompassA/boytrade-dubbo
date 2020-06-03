package org.study.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.boytrade.service.ProductService;
import org.study.config.ApiPath;
import org.study.handler.RedisHandler;
import org.study.response.ApiResponse;
import org.study.util.ProductInfoBuilder;
import org.study.util.RedisKeyCenter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author fanqie
 * @date 2020/6/2
 */
@RestController
public class ProductController {

    @Reference
    private ProductService productService;

    @Autowired
    private RedisHandler redisHandler;

    @GetMapping(ApiPath.Product.PRODUCT_INFO)
    public ApiResponse getProductInfo(@RequestParam("id") int id) {
        String redisKey = RedisKeyCenter.getProductInfoKey(id);
        Object productInfo = redisHandler.getCache(redisKey);
        if (productInfo == null) {
            synchronized (redisKey.intern()) {
                productInfo = redisHandler.getCache(redisKey);
                if (productInfo == null) {
                    productInfo = ProductInfoBuilder.buildVO(productService.getProductById(id));
                }
                if (productInfo == null) {
                    productInfo = RedisHandler.NULL_MARK;
                }
                long timeout = 10 + new Random().nextInt(10);
                redisHandler.save(redisKey, productInfo, timeout, TimeUnit.MINUTES);
            }
        }
        return redisHandler.isNullMark(productInfo)
                ? ApiResponse.fail("商品不存在")
                : ApiResponse.success(productInfo);
    }

}
