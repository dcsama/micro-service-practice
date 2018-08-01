package com.house.consumer.api.fail;

import com.house.consumer.api.HouseRemoteClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HouseRemoteClientFallbackFactory implements FallbackFactory<HouseRemoteClient> {
    @Override
    public HouseRemoteClient create(Throwable throwable) {
        return new HouseRemoteClient() {
            @Override
            public String hello() {
                System.err.println(throwable.getMessage());
                return "call hello failed.";
            }
        };
    }
}
