package com.asiainfo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.asiainfo.service.IDemoService;
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

    @Reference(version = "1.0.0")
    private IDemoService demoService;

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        for(int i = 0 ; i < 10 ; i++){
            try {
                String str = demoService.sayHello("kkoo");

                System.out.println(" Tried " + i + " ====> " + str);
            }catch (Exception e){
                System.out.println(" Exception " + e);
            }

        }
        return "你好，Spring Boot";
    }
}
