package org.study;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.study.data.ProductInfoData;
import org.study.mapper.ProductInfoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public class DataBaseTest extends BaseTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void productInfoMapperTest() {
        ProductInfoData mock = new ProductInfoData();
        mock.setProductName("d");
        mock.setProductPrice(2312321);
        Assert.assertEquals(1, productInfoMapper.insert(mock));

        List<ProductInfoData> mockList = getMockList();
        Assert.assertEquals(mockList.size(), productInfoMapper.insertList(mockList));

        mockList.add(mock);

        List<ProductInfoData> queryList = mockList.stream()
                .map(mockData -> productInfoMapper.selectById(mockData.getProductId()))
                .peek(System.out::println)
                .collect(Collectors.toList());
        Assert.assertEquals(queryList.size(), mockList.size());
    }

    private List<ProductInfoData> getMockList() {
        ProductInfoData mockData1 = new ProductInfoData();
        mockData1.setProductName("a");
        mockData1.setProductPrice(10000);
        ProductInfoData mockData2 = new ProductInfoData();
        mockData2.setProductName("b");
        mockData2.setProductPrice(10000);
        ProductInfoData mockData3 = new ProductInfoData();
        mockData3.setProductName("c");
        mockData3.setProductPrice(10000);
        List<ProductInfoData> mockList = new ArrayList<>(10);
        mockList.add(mockData1);
        mockList.add(mockData2);
        mockList.add(mockData3);
        return mockList;
    }
}
