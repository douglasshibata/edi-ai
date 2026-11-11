package com.edi.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EdiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdiApplication.class, args);
    }
}
