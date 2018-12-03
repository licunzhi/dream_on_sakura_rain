package com.example.springboothtml.controller;

import com.example.springboothtml.domain.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-20
 */
@ApiIgnore
@Controller
@RequestMapping
public class PathController {

    @Autowired
    @Qualifier("config")
    private Config config;

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/product/search")
    public ModelAndView productSearch() {
        ModelMap map = new ModelMap();
        map.addAttribute("cookie", config.getCookie());
        map.addAttribute("time", config.getTime());
        return new ModelAndView("product/search", map);
    }

    @PutMapping("/product/update/cookie")
    @ResponseBody
    public String updateCookie(@RequestParam String cookie) {
        Config config = new Config();
        File file = new File(PathController.class.getClassLoader().getResource("property.properties").getPath());
        try (FileInputStream fileInputStream = new FileInputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.setProperty("cookie", cookie);
            properties.store(fileOutputStream, "Update Cookie");
            config.setCookie(cookie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HttpStatus.OK.name();
    }
}
