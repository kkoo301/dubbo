package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.asiainfo.entity.Userinfo;
import com.asiainfo.mapper.UserinfoMapper;
import com.asiainfo.service.IDemoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2018-05-17.
 */
@Service(version = "1.0.0")
public class DemoServiceImpl implements IDemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private UserinfoMapper mapper;

    @Override
    public String sayHello(String name) {

        //List<Userinfo> userinfos = mapper.selectPage(new Page<Userinfo>(), new EntityWrapper<>());

        //Userinfo admin = mapper.findByUsername("test");

        //for(int i = 0 ; i < 12 ; i++){
        //    Userinfo userinfo = new Userinfo();
        //    userinfo.setUsername("user " + i);
        //    mapper.insert(userinfo);
        //}

        List<Long> ids = new ArrayList<>();
        ids.add(1006840049003716609L);
        ids.add(1006839628591849474L);
        mapper.selectBatchIds(ids);


        return name + " say hello";
    }
}
