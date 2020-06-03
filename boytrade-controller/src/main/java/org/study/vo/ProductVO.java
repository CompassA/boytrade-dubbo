package org.study.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author fanqie
 * @date 2020/6/2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVO {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private String createTime;
    private String updateTime;

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Double getProductPrice() { return productPrice; }
    public void setProductPrice(Double productPrice) { this.productPrice = productPrice; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "ProductVO{" + "productId=" + productId + ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice + ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' + '}';
    }
}

