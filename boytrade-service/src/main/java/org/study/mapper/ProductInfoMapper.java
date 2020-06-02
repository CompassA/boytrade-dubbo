package org.study.mapper;

import org.apache.ibatis.annotations.Param;
import org.study.data.ProductInfoData;

import java.util.List;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public interface ProductInfoMapper {

    /**
     * select by primary key
     * @param productId primary key
     * @return query data
     */
    ProductInfoData selectById(@Param("productId") int productId);

    /**
     * insert value
     * @param data to be inserted
     * @return affect rows
     */
    int insert(@Param("data") ProductInfoData data);

    /**
     * insert values
     * @param dataList values to be inserted
     * @return affect rows
     */
    int insertList(@Param("dataList") List<ProductInfoData> dataList);
}
