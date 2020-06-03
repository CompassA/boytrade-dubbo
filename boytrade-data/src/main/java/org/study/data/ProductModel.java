package org.study.data;

import java.io.Serializable;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public class ProductModel implements Serializable {

    private int productId;
    private String productName;
    private int productPrice;
    private String createTime;
    private String updateTime;

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getProductPrice() { return productPrice; }
    public void setProductPrice(int productPrice) { this.productPrice = productPrice; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }
}
