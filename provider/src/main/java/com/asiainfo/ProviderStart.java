package com.asiainfo;


import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by admin on 2018-05-17.
 */
@SpringBootApplication
@MapperScan("com.asiainfo.mapper")
public class ProviderStart {

    public static void main(String args[]) {

        new SpringApplicationBuilder(ProviderStart.class).web(false).run(args);

        Main.main(args);

    }

}
