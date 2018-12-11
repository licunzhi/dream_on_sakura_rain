package com.example.springboothtml.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-20
 */
@ApiIgnore
@Controller
@RequestMapping
public class PathController {

    @Value("${headers.cookie}")
    private String cookie;

    @Value("${sleep.time}")
    private String time;

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/product/system")
    public ModelAndView productSearch() {
        ModelMap map = new ModelMap();
        map.addAttribute("cookie", cookie);
        map.addAttribute("time", time);
        return new ModelAndView("product/system", map);
    }
}
