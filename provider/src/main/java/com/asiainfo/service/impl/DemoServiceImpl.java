package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.asiainfo.common.core.dao.mybatis.MyBatisBaseDao;
import com.asiainfo.entity.Order;
import com.asiainfo.entity.OrderItem;
import com.asiainfo.repository.OrderItemRepository;
import com.asiainfo.repository.OrderRepository;
import com.asiainfo.service.IDemoService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


/**
 * Created by admin on 2018-05-17.
 */
@Slf4j
@Service(version = "1.0.0")
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepositorys;
    @Autowired
    private MyBatisBaseDao myBatisBaseDao;

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
        orderRepository.saveAll(orderList);
        orderItemRepositorys.saveAll(orderItems);


        return name + " say hello";
    }

    @Override
    public Map find() {
        Pageable pageable = PageRequest.of(3,30);
        Page<OrderItem> page = myBatisBaseDao.findPage("com.asiainfo.entity.OrderItem", "findOrder", null, pageable );
        System.out.println(page.getContent());
        System.out.println("findPage : " + page.getContent().size());

        List<OrderItem> findOrder = myBatisBaseDao.findLimitList("com.asiainfo.entity.OrderItem", "findOrder", null, 10);
        System.out.println(findOrder);
        System.out.println("findLimitList : " + findOrder.size());

        List<OrderItem> findOrder1 = myBatisBaseDao.findList("com.asiainfo.entity.OrderItem", "findOrder", null);
        System.out.println(findOrder1);
        System.out.println("findList : " + findOrder1.size());

        Map<String, OrderItem> map = myBatisBaseDao.findMap("com.asiainfo.entity.OrderItem", "findOrder", null, "orderId", 10);
        System.out.println(map);
        System.out.println("findMap : " + map.size());

        return null;
    }
}
