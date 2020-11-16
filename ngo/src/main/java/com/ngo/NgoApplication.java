package com.ngo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.ngo.Repository")
@SpringBootApplication(scanBasePackages={"com.ngo.Repository", "com.ngo.Models"})
public class NgoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgoApplication.class, args);
    }

}
