package com.pagehelper.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*不使用多数据源的配置*/
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/*使用默认数据源配置*/
@SpringBootApplication
@MapperScan(value = "com.pagehelper.demo.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
