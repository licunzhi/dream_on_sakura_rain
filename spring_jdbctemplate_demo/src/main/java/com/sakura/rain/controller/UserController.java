package com.sakura.rain.controller;

import com.sakura.rain.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description 功能描述
 * @Author lcz
 * @Date 2019/03/04 16:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/detail")
    public Object getUser() {
        return userDao.getUser();
    }
}
