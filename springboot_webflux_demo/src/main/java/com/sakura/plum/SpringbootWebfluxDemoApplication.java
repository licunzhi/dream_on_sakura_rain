package com.sakura.plum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootWebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
    }
}
