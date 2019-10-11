package com.example.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName IndexController
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/13 08:59
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/demoTest")
    @ResponseBody
    public String demoTest() {
        return "This is java server response";
//        return "This is sakura server response";
    }
}
