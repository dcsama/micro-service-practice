package com.house.gateway.configuration;

import com.house.gateway.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class FilterConfiguration {

    @Bean(name = "ipFilter")
    public IpFilter getIpFilter(){
        return new IpFilter();
    }
}
