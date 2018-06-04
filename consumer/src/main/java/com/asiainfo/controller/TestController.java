package com.asiainfo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.asiainfo.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018-05-25.
 */
@Controller
@EnableAutoConfiguration
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Reference(version = "1.0.0")
    private IDemoService demoService;

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        try {
            String str = demoService.sayHello("kkoo");

        }catch (Exception e){
            logger.info(" Exception " + e);
        }

        return "你好，Spring Boot";
    }
}
