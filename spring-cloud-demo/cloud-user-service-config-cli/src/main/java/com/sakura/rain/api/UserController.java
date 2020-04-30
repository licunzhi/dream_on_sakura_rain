package com.sakura.rain.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 用户控制层
 * @date 2018-11-29
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${name}")
    private String name;

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id) {
        return name;
    }
}
