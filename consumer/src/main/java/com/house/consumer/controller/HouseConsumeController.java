package com.house.consumer.controller;

import com.house.consumer.api.HouseRemoteClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/house/consume")
public class HouseConsumeController {

    @Resource(name = "houseRemoteClient")
    private HouseRemoteClient houseRemoteClient;

    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "callHelloBack")
    public String callHello(){
        return houseRemoteClient.hello();
    }

    public String callHelloBack(){
        return "call Hello failed.";
    }
}
