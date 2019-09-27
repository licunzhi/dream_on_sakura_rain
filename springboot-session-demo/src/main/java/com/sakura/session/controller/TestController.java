package com.sakura.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName TestController
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/09/27 07:43
 */
@RestController
public class TestController {

    @GetMapping("/setUserInfo")
    public String setUserInfo(HttpSession session) {
        session.setAttribute("user", "sakrua");
        return "sakura";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null) {
            return "";
        }
        return user.toString();
    }


    @GetMapping("/logoutOut")
    public String logoutOut(HttpSession session) {
        session.invalidate();
        return "注销登录信息";
    }
}
