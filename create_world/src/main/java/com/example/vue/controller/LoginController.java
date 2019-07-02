package com.example.vue.controller;

import com.example.vue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName InformationController
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/02 14:09
 */
@RestController
@RequestMapping("/sakura")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/getDataMap")
    public Object info(String name, String password) {
        System.out.println(name);
        System.out.println(password);
        return loginService.login();
    }

}
