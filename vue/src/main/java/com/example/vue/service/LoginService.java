package com.example.vue.service;

import com.example.vue.bean.ResponseBean;
import com.example.vue.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public ResponseBean<HashMap> login(Map params) {
        HashMap<String, String> login = loginMapper.login(params);
        if (login == null) {
            return new ResponseBean<>(HttpStatus.BAD_REQUEST.value(), "fail", null);
        }
        login.remove("user_pass");
        return new ResponseBean<>(HttpStatus.OK.value(), "success", login);
    }

    public ResponseBean<Integer> registered(Map params) {
        Integer result = loginMapper.registered(params);
        return new ResponseBean<>(HttpStatus.OK.value(), "success", result);
    }
}
