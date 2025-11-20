// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/FtrBackendUserMsApplication.java
package com.rapidcargo.ftrbackenduserms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FtrBackendUserMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtrBackendUserMsApplication.class, args);
    }
}
