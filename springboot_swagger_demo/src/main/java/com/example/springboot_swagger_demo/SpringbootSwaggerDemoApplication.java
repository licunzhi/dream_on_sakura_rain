package com.example.springboot_swagger_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootSwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerDemoApplication.class, args);
	}
}
