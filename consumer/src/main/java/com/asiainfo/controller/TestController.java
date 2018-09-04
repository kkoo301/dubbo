package com.asiainfo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.asiainfo.service.IDemoService;
import com.asiainfo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018-05-25.
 */
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        try {

            //String str = testService.insertHello("kkoo");
            testService.select("a");
        }catch (Exception e){
            logger.info(" Exception " + e);
        }

        return "你好，Spring Boot";
    }
}
