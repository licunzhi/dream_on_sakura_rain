package com.example.springboothtml.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author licunzhi
 * @desc 组件容器初始化
 * @date 2018-10-22
 */
@Configuration
public class RestTemplateComponent {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
