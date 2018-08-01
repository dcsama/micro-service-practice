package com.house.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean(name = "feignLoggerLevel")
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
