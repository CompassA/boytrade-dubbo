package org.study.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.boytrade.service.ProductService;
import org.study.data.ProductModel;
import org.study.mapper.ProductInfoMapper;
import org.study.util.ProductInfoBuilder;

/**
 * @author fanqie
 * @date 2020/6/2
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductModel getProductById(int productId) {
        return ProductInfoBuilder.buildModel(productInfoMapper.selectById(productId));
    }
}
