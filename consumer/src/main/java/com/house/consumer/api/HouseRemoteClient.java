package com.house.consumer.api;

import com.house.consumer.api.fail.HouseRemoteClientFallbackFactory;
import com.house.consumer.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "house-service",
        path = "/house",
        qualifier = "houseRemoteClient",
        configuration = FeignConfiguration.class,
        fallbackFactory = HouseRemoteClientFallbackFactory.class)
public interface HouseRemoteClient {

    @GetMapping("/hello")
    String hello();
}
