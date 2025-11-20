// Ftrbackendconfig/src/main/java/com/infosys/ftrbackendconfig/FtrBackendConfigApplication.java
package com.infosys.ftrbackendconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FtrBackendConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtrBackendConfigApplication.class, args);
    }
}
