// Ftrbackendeureka/src/main/java/com/rapidcargo/ftrbackendeureka/FtrBackendEurekaApplication.java
package com.rapidcargo.ftrbackendeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FtrBackendEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtrBackendEurekaApplication.class, args);
    }
}
