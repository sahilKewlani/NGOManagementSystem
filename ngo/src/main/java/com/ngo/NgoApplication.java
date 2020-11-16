package com.ngo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.ngo.Repository", "com.ngo.Models", "com.ngo.Security", "com.ngo.controllers", "com.ngo.Payload", "com.ngo.Services"})
public class NgoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgoApplication.class, args);
    }

}
