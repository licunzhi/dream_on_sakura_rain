package com.sakura.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PipeOperation
 * @Description 管道操作命令
 * @Author lcz
 * @Date 2020/02/24 21:49
 */
@RestController
public class PipeOperation {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/pipeString")
    public String pipeOperation() {

        long start = System.currentTimeMillis();
        List results = redisTemplate.executePipelined(
                (RedisCallback<Object>) connection -> {
                    connection.openPipeline();
                    for (int i = 0; i < 100000; i++) {
                        connection.set((i + "").getBytes(), (System.currentTimeMillis() + "").getBytes());
                    }
                    connection.closePipeline();
                    return null;
                }
        );
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(results);
        return "ok";
    }

    @GetMapping("/pipeList")
    public String pipeList() {

        long start = System.currentTimeMillis();
        redisTemplate.execute((RedisCallback) connection -> {
            System.out.println(connection.geoCommands());
            return null;
        });

        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return "ok";
    }
}
