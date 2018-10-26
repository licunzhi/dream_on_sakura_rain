package com.meimie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author licunzhi
 * @desc 测试接口
 * @date 2018-10-18
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /*
    * 原生的配置信息查找可以在源码包中
    * readme文件
    *
    * 官方介绍文档原生配置方式https://docs.spring.io/spring-data/redis/docs/2.0.11.RELEASE/reference/html/
    * */

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // inject the template as ListOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    @GetMapping("/{info}")
    public void addInfo(@PathVariable("info") String info) {
        /*
        * 实现命令
        *
        * */
        stringRedisTemplate.opsForList().leftPush("name", info);
    }

}
