package com.sukura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author licunzhi
 * @desc  默认页面跳转配置
 * @date 2018-07-24
 */
@Controller
public class WebIndexController {

    @GetMapping("/index")
    public String index() {
        return "/index";
    }
}
