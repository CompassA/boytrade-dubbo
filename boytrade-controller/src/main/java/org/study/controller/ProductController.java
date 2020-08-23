package org.study.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.boytrade.service.ProductService;
import org.study.config.ApiPath;
import org.study.util.ProductInfoBuilder;

/**
 * @author fanqie
 * @date 2020/6/2
 */
@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Reference
    private ProductService productService;

    @GetMapping(ApiPath.Product.PRODUCT_INFO)
    public Object getProductInfo(@RequestParam("id") int id) {
        logger.info(String.format("cross cache, product id=%d", id));
        return ProductInfoBuilder.buildVO(productService.getProductById(id));
    }

}
