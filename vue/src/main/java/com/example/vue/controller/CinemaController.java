package com.example.vue.controller;

import com.example.vue.bean.ResponseBean;
import com.example.vue.service.CinemaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName CinemaController
 * @Description 影院控制器
 * @Author lcz
 * @Date 2019/07/08 11:14
 */
@RestController
@RequestMapping("/Cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/search")
    public ResponseBean<PageInfo> search(@RequestBody HashMap params) {
        return cinemaService.search(params);
    }
}
