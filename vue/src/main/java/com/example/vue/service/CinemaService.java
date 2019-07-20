package com.example.vue.service;

import com.example.vue.bean.ResponseBean;
import com.example.vue.mapper.CinemaMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CinemaService
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/08 11:16
 */
@Service
public class CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    public ResponseBean<PageInfo> search(HashMap params) {
        List<HashMap<String, String>> result = cinemaMapper.search(params);
        PageInfo pageInfo = new PageInfo<>(result);
        return new ResponseBean<>(HttpStatus.OK.value(),"success", pageInfo);
    }
}
