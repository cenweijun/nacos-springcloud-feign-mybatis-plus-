package com.mycen.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.mycen.nacos.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos/")

public class TestController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private Client client;

    @GetMapping("configs")
    public String getConfig() {
        String property = applicationContext.getEnvironment().getProperty("common");
        System.out.println(property);
        return property;
    }

    @GetMapping("service1")
    public String  getClient() {
        return client.service();
    }
}
