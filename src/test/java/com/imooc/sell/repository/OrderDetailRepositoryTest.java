package com.imooc.sell.repository;

import com.imooc.sell.dataObject.OrderDetail;
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
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("134435254");
        orderDetail.setOrderId("1322222");
        orderDetail.setProductIcon("xx.com");
        orderDetail.setProductId("3124231");
        orderDetail.setProductName("xoox");
        orderDetail.setProductPrice(new BigDecimal(220));
        orderDetail.setProductQuantity(2);
        OrderDetail rs = repository.save(orderDetail);
        Assert.assertNotNull(rs);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> list = repository.findByOrderId("1322222");
        Assert.assertNotEquals(0,list.size());
    }
}