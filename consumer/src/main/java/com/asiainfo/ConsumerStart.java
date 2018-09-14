package com.asiainfo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by admin on 2018-09-14.
 */
@SpringBootApplication
public class ConsumerStart {
    public static void main(String args[]) {
        new SpringApplicationBuilder(ConsumerStart.class).web(WebApplicationType.SERVLET).run(args);
    }
}
