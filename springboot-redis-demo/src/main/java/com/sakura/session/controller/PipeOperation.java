package com.sakura.session.controller;

import com.sakura.session.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
                (RedisCallback<Boolean>) connection -> {
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

    @GetMapping("/pipeTest")
    public String pipeTest() {

        for (int j = 0; j < 100; j++) {
            long start = System.currentTimeMillis();
            int finalJ = j;
            List results = redisTemplate.executePipelined(
                    (RedisCallback<Boolean>) connection -> {
                        connection.openPipeline();
                        for (int i = 0; i < 100000; i++) {
                            connection.set((i + "-" + finalJ).getBytes(), (System.currentTimeMillis() + "").getBytes());
                        }
                        return null;
                    }
            );
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            System.out.println(results.contains(false));
            redisTemplate.getConnectionFactory().getConnection().closePipeline();
        }

        return "ok";
    }


    /**
     * JVM参数调优
     *
     * 短时间创建出较多的对象，但是很快被消亡
     * @return
     */
    @GetMapping("/jvmUserMemory")
    public String jvmUserMemory() throws InterruptedException {

        List<User> users = new ArrayList<>();
        for (int index = 0; index < 10000; index++) {
            User user = new User();
            user.setUserId(index + "");
            user.setAddress(UUID.randomUUID().toString());
            user.setAge(new Random().nextInt(30));
            user.setPhone(String.valueOf(new Random().nextLong()));
            users.add(user);
        }

        for (User user : users) {
            Thread.sleep(10);
            Thread.currentThread().setName("Thread_demo_one");
            System.out.println(Thread.currentThread().getName());
            System.out.println(user);
        }

        return "ok";
    }
}
