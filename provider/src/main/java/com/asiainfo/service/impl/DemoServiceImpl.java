package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.asiainfo.entity.Order;
import com.asiainfo.entity.OrderItem;
import com.asiainfo.repository.OrderItemRepository;
import com.asiainfo.repository.OrderRepository;
import com.asiainfo.service.IDemoService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    public String insertHello(String name) {

        Order order = null;
        OrderItem item = null;
        List<Order> orderList = Lists.newArrayList();
        List<OrderItem> orderItems = Lists.newArrayList();
        for(int i = 1 ; i <= 30 ; i++){
            order = new Order();
            order.setUserId(i * 3);
            order.setStatus("1");
            order.setOrderId(i);
            item = new OrderItem();
            item.setOrderId(i);
            item.setUserId(i * 3);
            item.setOrderItemId(i * 7);
            orderList.add(order);
            orderItems.add(item);
        }
        orderRepository.save(orderList);
        orderItemRepositorys.save(orderItems);
        return name + " say hello";
    }
}
