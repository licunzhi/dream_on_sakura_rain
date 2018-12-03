package com.example.springboothtml.controller;

import com.example.springboothtml.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-03
 */
@RestController
@RequestMapping("/cookie")
public class CookieChange {

    @Autowired
    private CookieService cookieService;

    @PutMapping("/change")
    public String changeCookie() {
        return cookieService.changeCookie();
    }


}
