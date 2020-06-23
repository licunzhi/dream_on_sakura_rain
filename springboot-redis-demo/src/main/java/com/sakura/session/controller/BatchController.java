package com.sakura.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BatchController
 * @Description 批量操作
 * @Author lcz
 * @Date 2020/01/20 14:01
 */
@RestController
public class BatchController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/batchUpdate")
    public String batchOperation() {
        long startTime = System.currentTimeMillis();
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        for (int i = 0; i < 100000; i++) {
            stringObjectValueOperations.set((i + ""), System.currentTimeMillis() + "");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return "ok";
    }

    @GetMapping("/batchUpdateThread")
    public String batchUpdateThread() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 200, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200), new ThreadPoolExecutor.DiscardOldestPolicy());

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            threadPool.submit(() -> {
                for (int j = 0; j < 500; j++) {
                    redisTemplate.opsForValue().set(UUID.randomUUID().toString(), System.currentTimeMillis() + "");
                }
            });
        }
        while(threadPool.getQueue().size() != 0) {

        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return "ok";
    }
}

