package com.asiainfo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018-08-23.
 */
@Service
public class TestService {

    @Reference(version = "1.0.0")
    private IDemoService demoService;

    public String insertHello(String args){
        return demoService.insertHello("kkoo");
    }

    public void select(String args){
        demoService.find();
    }

}
