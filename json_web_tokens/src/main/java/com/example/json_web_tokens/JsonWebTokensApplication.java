package com.example.json_web_tokens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JsonWebTokensApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonWebTokensApplication.class, args);
    }
}
