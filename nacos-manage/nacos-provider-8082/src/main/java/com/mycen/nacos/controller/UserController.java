package com.mycen.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    //测试配置中心连接
    @GetMapping("configs")
    public String getConfig() {
        String property = applicationContext.getEnvironment().getProperty("common");
        System.out.println(property);
        return property;
    }


    @GetMapping("service")
    public String service() {
        return "serviceasdfhgj";
    }
}