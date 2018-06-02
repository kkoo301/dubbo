package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2018-05-25.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-config.xml"})
public class ConsumerStart {

    public static void main(String args[]){
        SpringApplication.run(ConsumerStart.class,args);
    }

}
