package com.house.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/house/consume")
public class HouseConsumeController {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello(){
        return this.restTemplate.getForObject("http://house-service/house/hello", String.class);
    }
}
