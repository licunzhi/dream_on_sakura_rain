package com.example.springboot_resttemplate_demo.controller;

import com.example.springboot_resttemplate_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-22
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String get() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.baidu.com/", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>").append("responseEntity.getStatusCode()：")
                        .append(statusCode).append("<hr>").append("responseEntity.getStatusCodeValue()：")
                        .append(statusCodeValue).append("<hr>").append("responseEntity.getHeaders()：").append(headers)
                        .append("<hr>");
        return result.toString();
    }

    @GetMapping("/user")
    public ResponseEntity<User> user() {
        User user = new User();
        user.setId("id-dasdashdakshdkahsdkashdkahsd");
        user.setName("sakura");
        user.setEmail("1205131711@qq.com");
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/weather/{city}")
    public String weather(@PathVariable(value = "city") String city) {
        String apiUrl = "http://wthrcdn.etouch.cn/weather_mini?city=" + city;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>").append("responseEntity.getStatusCode()：")
                        .append(statusCode).append("<hr>").append("responseEntity.getStatusCodeValue()：")
                        .append(statusCodeValue).append("<hr>").append("responseEntity.getHeaders()：").append(headers)
                        .append("<hr>");
        return result.toString();
    }
}
