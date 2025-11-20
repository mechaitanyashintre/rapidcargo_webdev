// FtrBackendGateway/src/main/java/com/rapidcargo/ftrbackendgateway/FtrBackendGatewayApplication.java
package com.rapidcargo.ftrbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class FtrBackendGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtrBackendGatewayApplication.class, args);
    }
}
