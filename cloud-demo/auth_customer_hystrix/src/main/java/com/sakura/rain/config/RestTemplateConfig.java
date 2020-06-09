package com.sakura.rain.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 * @author lcz
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 但实例调用使用
     *
     * @return RestTemplate
     */
    @Bean(value = "restTemplateSinger")
    public RestTemplate getRestTemplateSinger() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    /**
     * 内部实现负载调用方式
     * @return restTemplate
     */
    @Bean(value = "restTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        return new RestTemplate(simpleClientHttpRequestFactory);
    }
}
