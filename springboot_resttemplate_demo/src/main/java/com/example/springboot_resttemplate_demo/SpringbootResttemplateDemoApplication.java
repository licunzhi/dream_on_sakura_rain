package com.example.springboot_resttemplate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootResttemplateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootResttemplateDemoApplication.class, args);
    }
}
