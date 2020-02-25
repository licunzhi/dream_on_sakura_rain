package com.sakura.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description 展示首页页面
 * @Author lcz
 * @Date 2020/02/24 21:41
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }


}
