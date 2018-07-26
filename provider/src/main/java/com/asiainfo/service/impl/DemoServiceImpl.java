package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.asiainfo.entity.Order;
import com.asiainfo.entity.OrderItem;
import com.asiainfo.repository.OrderItemRepository;
import com.asiainfo.repository.OrderRepository;
import com.asiainfo.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018-05-17.
 */
@Service(version = "1.0.0")
public class DemoServiceImpl implements IDemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepositorys;

    @Override
    public String sayHello(String name) {

        //List<Userinfo> userinfos = mapper.selectPage(new Page<Userinfo>(), new EntityWrapper<>());

        //Userinfo admin = mapper.findByUsername("test");

        //for(int i = 0 ; i < 12 ; i++){
        //    Userinfo userinfo = new Userinfo();
        //    userinfo.setUsername("user " + i);
        //    mapper.insert(userinfo);
        //}

        Order order = null;
        OrderItem item = null;
        for(int i = 0 ; i < 3000 ; i++){
            order = new Order();
            order.setUserId(i * 3);
            order.setStatus("1");
            order.setOrderId(i);
            item = new OrderItem();
            item.setOrderId(i);
            item.setUserId(i * 3);
            item.setOrderItemId(i * 7);
            orderRepository.save(order);
            orderItemRepositorys.save(item);
        }

        return name + " say hello";
    }
}
