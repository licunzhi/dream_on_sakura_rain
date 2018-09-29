package com.sakura.plum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 调用接口之后停止工作
 * @date 2018-09-29
 */
@RestController
@RequestMapping("/sakura")
public class ApiController extends ApplicationObjectSupport {

    @Autowired
    private ExitApplication exitApplication;

    @GetMapping("/exit")
    public String exit() {
        SpringApplication.exit(super.getApplicationContext(), exitApplication);
        return "ok";
    }
}
