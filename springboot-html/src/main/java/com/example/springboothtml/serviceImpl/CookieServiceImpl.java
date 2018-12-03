package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-03
 */
@Service
public class CookieServiceImpl implements CookieService {

    private static final String URL_TEMPLATE = "https://www.taobao.com/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String changeCookie() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_TEMPLATE, String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        headers.values().forEach(value -> System.out.println(value));
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>").append("responseEntity.getStatusCode()：")
                        .append(statusCode).append("<hr>").append("responseEntity.getStatusCodeValue()：")
                        .append(statusCodeValue).append("<hr>").append("responseEntity.getHeaders()：").append(headers)
                        .append("<hr>");
        return result.toString();
    }

    //thw=cn; Path=/; Domain=.taobao.com; Expires=Tue, 03-Dec-19 02:02:42 GMT;
}
