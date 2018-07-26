package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2018-05-25.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={HazelcastAutoConfiguration.class,DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class, JdbcTemplateAutoConfiguration.class,DataSourceProperties.class})
public class ConsumerStart {

    public static void main(String args[]){
        //SpringApplication.run(ConsumerStart.class, args);
        new SpringApplicationBuilder(ConsumerStart.class).web(true).run(args);

    }

}
