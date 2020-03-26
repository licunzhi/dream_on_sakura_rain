package com.sakura.rain.api;

import com.sakura.rain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * restTemplate在cloud项目中内部也在使用
     * 注册中的服务都可以被拉取到客户端进行一系列自定义访问策略或是默认负载配置进行访问
     */
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


    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/user/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(USER_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
