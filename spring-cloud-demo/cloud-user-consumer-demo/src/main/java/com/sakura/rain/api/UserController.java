package com.sakura.rain.api;

import com.sakura.rain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 调用接口
 * @date 2018-11-29
 */
@RestController
public class UserController {

//    private static final String USER_URL_PREFIX = "http://cloud-user-demo-8088:8088";
    private static final String USER_URL_PREFIX = "http://CLOUD-USER-SERVICE-DEMO";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(USER_URL_PREFIX+"/user/get/{id}", User.class, params);
    }

    @GetMapping("/user/list")
    public List list() {
        return restTemplate.getForObject(USER_URL_PREFIX+"/user/list", List.class);
    }

    @PostMapping("/user/create")
    public boolean create(@RequestBody User user) {
        return restTemplate.postForObject(USER_URL_PREFIX+"/user/create", user, Boolean.class);
    }
}
