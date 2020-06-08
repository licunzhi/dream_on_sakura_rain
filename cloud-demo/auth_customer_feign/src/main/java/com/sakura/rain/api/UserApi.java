package com.sakura.rain.api;

import com.sakura.rain.entity.UserInfo;
import com.sakura.rain.feign.AuthFeignClient;
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
    private AuthFeignClient authFeignClient;


    /**
     * 使用这种接口式声明的前提条件相当于吧其他为服务的地址和请求参数信息都拿到
     * 简单来说，经过简单的封装可以使得调用微服务中的其他接口就行调用自己的服务一样
     * @return ResponseEntity<List<UserInfo>>
     */
    @GetMapping("/getUserList")
    public ResponseEntity<List<UserInfo>> getUserList() {
        return authFeignClient.getUserList();
    }
}
