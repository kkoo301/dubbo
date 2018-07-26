package com.asiainfo;


import com.alibaba.dubbo.container.Main;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by admin on 2018-05-17.
 */
@SpringBootApplication
@EntityScan({"com.asiainfo.entity" })
public class ProviderStart {

    public static void main(String args[]) {

        new SpringApplicationBuilder(ProviderStart.class).bannerMode(Banner.Mode.OFF).web(false).run(args);

        Main.main(args);

    }

}
