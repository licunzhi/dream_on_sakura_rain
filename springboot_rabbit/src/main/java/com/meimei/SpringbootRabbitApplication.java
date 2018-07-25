package com.meimei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitApplication.class, args);
	}
}
