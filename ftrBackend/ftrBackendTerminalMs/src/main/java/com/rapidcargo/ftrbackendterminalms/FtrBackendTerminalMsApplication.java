package com.infosys.ftrbackendterminalms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FtrBackendTerminalMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtrBackendTerminalMsApplication.class, args);
    }
}
