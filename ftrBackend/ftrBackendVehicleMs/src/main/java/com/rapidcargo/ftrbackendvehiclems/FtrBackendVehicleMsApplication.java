package com.infosys.ftrbackendvehiclems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FtrBackendVehicleMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtrBackendVehicleMsApplication.class, args);
    }
}
