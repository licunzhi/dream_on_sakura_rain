package com.example.springboothtml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 这是整个项目的启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHtmlApplication.class, args);
	}
}
