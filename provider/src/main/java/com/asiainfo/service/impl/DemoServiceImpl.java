package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.asiainfo.repository.UserinfoDao;
import com.asiainfo.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by admin on 2018-05-17.
 */
@Service(version = "1.0.0")
public class DemoServiceImpl implements IDemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    @Transactional
    public String sayHello(String name) {

        try {
            Thread.sleep(new Random().nextInt(1300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + " say hello";
    }
}
