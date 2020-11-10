package com.knife4j.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/10/13 15:19
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public String main() {
        return "/index";
    }
}
