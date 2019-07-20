package com.example.vue.service;

import com.example.vue.bean.ResponseBean;
import com.example.vue.mapper.MovieMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName MovieService
 * @Description 电影服务层
 * @Author lcz
 * @Date 2019/07/10 10:00
 */
@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    public ResponseBean<PageInfo> search(HashMap params) {
        List<HashMap<String, String>> result = movieMapper.search(params);
        PageInfo pageInfo = new PageInfo<>(result);
        return new ResponseBean<>(HttpStatus.OK.value(),"success", pageInfo);
    }

    public ResponseBean<PageInfo> halls(HashMap params) {
        List<HashMap<String, String>> result = movieMapper.halls(params);
        PageInfo pageInfo = new PageInfo<>(result);
        return new ResponseBean<>(HttpStatus.OK.value(),"success", pageInfo);
    }
}
