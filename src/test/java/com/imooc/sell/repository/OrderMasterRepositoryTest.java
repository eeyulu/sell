package com.imooc.sell.repository;

import com.imooc.sell.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123144");
        orderMaster.setBuyerName("小王");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("xxoo");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(7));
        OrderMaster master =repository.save(orderMaster);
        Assert.assertNotNull(master);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,4);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,orderMasterPage.getContent().size());
    }
}