package com.example.vue.controller;

import com.example.vue.bean.ResponseBean;
import com.example.vue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName InformationController
 * @Description 登录控制
 * @Author lcz
 * @Date 2019/07/02 14:09
 */
@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * login
     */
    @PostMapping("/loginAction")
    public ResponseBean<HashMap> info(@RequestBody Map params) {
        return loginService.login(params);
    }

    /**
     * registered
     */
    @PostMapping("/registered")
    public ResponseBean<Integer> registered(@RequestBody Map params) {
        return loginService.registered(params);
    }

}
