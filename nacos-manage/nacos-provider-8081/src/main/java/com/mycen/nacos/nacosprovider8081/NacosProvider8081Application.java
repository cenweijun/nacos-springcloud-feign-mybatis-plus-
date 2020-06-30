package com.mycen.nacos.nacosprovider8081;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.mycen.nacos.nacosprovider8081.mapper")
public class NacosProvider8081Application {

    public static void main(String[] args) {

        SpringApplication.run(NacosProvider8081Application.class, args);
    }

}
