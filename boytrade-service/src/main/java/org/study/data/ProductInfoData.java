package org.study.data;

import java.sql.Timestamp;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public class ProductInfoData {

    private int productId;
    private String productName;
    private int productPrice;
    private Timestamp createTime;
    private Timestamp updateTime;

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getProductPrice() { return productPrice; }
    public void setProductPrice(int productPrice) { this.productPrice = productPrice; }
    public Timestamp getCreateTime() { return createTime; }
    public void setCreateTime(Timestamp createTime) { this.createTime = createTime; }
    public Timestamp getUpdateTime() { return updateTime; }
    public void setUpdateTime(Timestamp updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "ProductInfoData{productId=" + productId + ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice + ", createTime=" + createTime +
                ", updateTime=" + updateTime + '}';
    }
}
