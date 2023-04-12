package com.example.connecttocassandra3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@RestController
@ComponentScan(
        basePackages = {
                "com.example.connecttocassandra3.modules.location",
                "com.example.connecttocassandra3.modules.hub",
                "com.example.connecttocassandra3.modules.domains_and_areas",
        }
)
public class ConnectToCassandra3Application {

    public static void main(String[] args) {
        SpringApplication.run(ConnectToCassandra3Application.class, args);

    }

}
