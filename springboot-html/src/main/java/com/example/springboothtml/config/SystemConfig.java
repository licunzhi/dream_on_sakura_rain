package com.example.springboothtml.config;

import com.example.springboothtml.domain.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-21
 */
@Configuration
public class SystemConfig {

    @Bean
    public Config config() {
        Config config = new Config();
        File file = new File(this.getClass().getClassLoader().getResource("property.properties").getFile());
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String cookie = (String) properties.get("cookie");
            Integer time = Integer.parseInt(properties.get("time").toString());
            config.setCookie(cookie);
            config.setTime(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

}
