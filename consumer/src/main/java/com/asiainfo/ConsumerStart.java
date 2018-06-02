package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2018-05-25.
 */
@SpringBootApplication
public class ConsumerStart {

    public static void main(String args[]){
        //SpringApplication.run(ConsumerStart.class, args);
        new SpringApplicationBuilder(ConsumerStart.class).web(true).run(args);

    }

}
