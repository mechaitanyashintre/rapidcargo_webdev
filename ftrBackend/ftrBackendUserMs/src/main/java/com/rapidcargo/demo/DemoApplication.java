// FtrBackendUserMs/src/main/java/com/infosys/ftrbackenduserms/FtrBackendUserMsApplication.java
package com.infosys.ftrbackenduserms;

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
