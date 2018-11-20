package com.example.springboothtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-20
 */
@Controller
@RequestMapping
public class PathController {

    @GetMapping
    public String indexPage() {
        return "index";
    }
}
