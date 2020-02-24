package com.sakura.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName BatchController
 * @Description 批量操作
 * @Author lcz
 * @Date 2020/01/20 14:01
 */
public class BatchController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/batchUpdate")
    public String batchOperation() {
        return "";
    }
}
