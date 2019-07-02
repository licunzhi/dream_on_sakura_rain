package com.example.vue.service;

import com.example.vue.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginService
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/02 15:24
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Object login() {
        return loginMapper.login();
    }
}
