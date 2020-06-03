package org.study.boytrade.service;

import org.study.data.ProductModel;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public interface ProductService {

    /**
     * get product info
     * @param productId primary key
     * @return product info model
     */
    ProductModel getProductById(int productId);
}
