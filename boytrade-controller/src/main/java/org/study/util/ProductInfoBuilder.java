package org.study.util;

import org.study.data.ProductModel;
import org.study.vo.ProductVO;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public final class ProductInfoBuilder {

    private ProductInfoBuilder() { throw new RuntimeException("illegal call!"); }

    public static ProductVO buildVO(ProductModel model) {
        if (model == null) {
            return null;
        }
        ProductVO vo = new ProductVO();
        vo.setProductId(model.getProductId());
        vo.setProductName(model.getProductName());
        vo.setProductPrice(model.getProductPrice() * 1.0 / 100);
        vo.setCreateTime(model.getCreateTime());
        vo.setUpdateTime(model.getUpdateTime());
        return vo;
    }
}
