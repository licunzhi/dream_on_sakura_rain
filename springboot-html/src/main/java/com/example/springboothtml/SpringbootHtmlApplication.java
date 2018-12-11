package com.example.springboothtml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 这是整个项目的启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableAsync
public class SpringbootHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHtmlApplication.class, args);
	}
}
