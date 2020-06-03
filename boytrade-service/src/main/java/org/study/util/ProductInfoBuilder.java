package org.study.util;

import org.study.data.ProductInfoData;
import org.study.data.ProductModel;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public final class ProductInfoBuilder {

    private ProductInfoBuilder() {
        throw new RuntimeException("illegal call!");
    }

    public static ProductModel buildModel(ProductInfoData data) {
        if (data == null) {
            return null;
        }
        ProductModel model = new ProductModel();
        model.setProductId(data.getProductId());
        model.setProductName(data.getProductName());
        model.setProductPrice(data.getProductPrice());
        model.setCreateTime(DateUtil.toString(data.getCreateTime()));
        model.setUpdateTime(DateUtil.toString(data.getUpdateTime()));
        return model;
    }
}
