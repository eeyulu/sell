package com.imooc.sell.repository;

import com.imooc.sell.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("xx");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(1001);
        productInfo.setProductDescription("oo");
        productInfo.setProductIcon("xx.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo rs = repository.save(productInfo);
        Assert.assertNotNull(rs);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());
    }
}