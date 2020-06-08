package com.sakura.rain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName UserApi
 * @function [业务功能]
 * @notice 控制层只做入参出参处理
 * @Author lcz
 * @Date 2020/06/08 14:57
 */
@RestController
@RequestMapping("/user")
public class UserApi {


    @Autowired
    private RestTemplate restTemplateSinger;

    @GetMapping("/getUserList/{type}")
    public ResponseEntity<List> getUserList(@PathVariable(value = "type") Integer type) {
        String url = "http://127.0.0.1:8010";
        switch (type) {
            case 1:
                url = "http://127.0.0.1:8010";
                break;
            case 2:
                url = "http://127.0.0.1:8011";
                break;
            case 3:
                url = "http://127.0.0.1:8012";
                break;
            default:
                break;
        }
        return restTemplateSinger.getForEntity(url + "/user/getUserList", List.class);
    }
}
