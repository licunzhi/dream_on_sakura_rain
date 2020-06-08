package com.sakura.rain.api;

import com.sakura.rain.entity.UserInfo;
import com.sakura.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private UserService userService;

    @GetMapping("/getUserList")
    public ResponseEntity<List<UserInfo>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }
}
