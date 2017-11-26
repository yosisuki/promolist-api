package com.tiket.tix.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.tiket.tix.controllers", "com.tiket.tix.services", "com.tiket.tix.servicesimpl","com.tiket.tix.entities", "com.tiket.tix.repositories", "com.tiket.tix.web"})
@EnableMongoRepositories("com.tiket.tix.repositories")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
