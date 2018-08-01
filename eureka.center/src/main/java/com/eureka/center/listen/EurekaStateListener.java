package com.eureka.center.listen;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        System.err.println(event.getAppName() + "\t" + event.getServerId() + "\t"
            + "is down.");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName() + "\t" + "registered.");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        System.err.println(event.getAppName() + "\t" + "renewed.");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event){
        System.err.println("***** Eureka Server Started *****");
    }
}
