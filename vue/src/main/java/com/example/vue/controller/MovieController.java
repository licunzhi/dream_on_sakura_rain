package com.example.vue.controller;

import com.example.vue.bean.ResponseBean;
import com.example.vue.service.MovieService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName MovieController
 * @Description 电影控制器
 * @Author lcz
 * @Date 2019/07/10 09:58
 */
@RestController
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/search")
    public ResponseBean<PageInfo> search(@RequestBody HashMap params) {
        return movieService.search(params);
    }


    @PostMapping("/halls")
    public ResponseBean<PageInfo> halls(@RequestBody HashMap params) {
        return movieService.halls(params);
    }
}
