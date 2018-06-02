package com.asiainfo;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * Created by admin on 2018-05-17.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-config.xml"})
public class ProviderStart {

    private static final Logger logger = LoggerFactory.getLogger(ProviderStart.class);

    public static void main(String args[]) throws IOException {
        SpringApplication.run(ProviderStart.class,args);
        logger.info("dubbo ready start");
        Main.main(args);
    }

}
