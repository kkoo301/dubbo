package com.asiainfo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by admin on 2018-05-17.
 */

@SpringBootApplication
public class ProviderStart {

    public static void main(String args[]) {
        new SpringApplicationBuilder(ProviderStart.class).web(WebApplicationType.NONE).run(args);
    }
}
