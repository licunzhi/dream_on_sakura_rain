package com.sakura.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestController
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/09/27 07:43
 */
@RestController
public class TestController {

//    @Resource
//    @Qualifier(value = "redisTemplate")
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/setUserInfo")
    public String setUserInfo(HttpSession session) {
        session.setAttribute("user", "sakrua");
        return "sakura";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null) {
            return "";
        }
        return user.toString();
    }


    @GetMapping("/logoutOut")
    public String logoutOut(HttpSession session) {
        session.invalidate();
        return "注销登录信息";
    }

    @GetMapping("/fillRedis")
    public String fileRedis() {

        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        System.out.println(listOperations);

        /*为数据设置过期时间*/
        redisTemplate.opsForValue().set("name", "licunzhi", 10, TimeUnit.SECONDS);

        /*得到旧数据并塞入新数据*/
        Object oldValue = redisTemplate.opsForValue().getAndSet("name", "park");
        System.out.println(oldValue);

        /*数据追加 有问题*/
        redisTemplate.opsForValue().set("demo", "licunzhi");
        System.out.println(redisTemplate.opsForValue().get("demo"));
        redisTemplate.opsForValue().append("demo", "park");
        System.out.println(redisTemplate.opsForValue().get("demo"));

        /*注入数组*/
        String[] arr = new String[]{"demo1", "demo2", "demo3"};
        redisTemplate.opsForList().leftPushAll("list", arr);
        Long siz = redisTemplate.opsForList().size("list");
        System.out.println(redisTemplate.opsForList().range("list", 0 , -1));
        /*左右塞入*/
        redisTemplate.opsForList().leftPush("list", "left");
        redisTemplate.opsForList().rightPush("list", "right");
        System.out.println(redisTemplate.opsForList().range("list", 0 , -1));
        /*位置数据替换*/
        redisTemplate.opsForList().set("list", 1, "no.1");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        /*删除首个满足的情况*/
        redisTemplate.opsForList().remove("list", 1, "no.1");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        /*获取指定位置的数据*/
        Object list = redisTemplate.opsForList().index("list", 2);
        System.out.println(list);
        /*查看过期时间*/
        Long list1 = redisTemplate.getExpire("list");
        System.out.println(list1);
        redisTemplate.expire("list", 10, TimeUnit.SECONDS);
        Long list2 = redisTemplate.getExpire("list");
        System.out.println(list2);

        /*哈希数据*/
        redisTemplate.opsForHash().put("map", "name", "licunzhi");
        System.out.println(redisTemplate.opsForHash().get("map", "name"));

        /*哈希的散列表*/
        System.out.println(redisTemplate.opsForHash().keys("map"));
        System.out.println(redisTemplate.opsForHash().entries("map"));

        /*迭代器*/
        Cursor<Map.Entry<Object, Object>> map = redisTemplate.opsForHash().scan("map", ScanOptions.NONE);
        while(map.hasNext()) {
            Map.Entry entry = map.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /*集合*/
        Long set = redisTemplate.opsForSet().add("set", new String[]{"set1", "set2", "set3"});
        System.out.println("set add result: " + set);
        System.out.println(redisTemplate.opsForSet().members("set"));
        /*移除其中的对象数据*/
        redisTemplate.opsForSet().remove("set", "set1", "demo1");
        System.out.println(redisTemplate.opsForSet().members("set"));
        /*随机弹射*/
        System.out.println(redisTemplate.opsForSet().pop("set"));
        System.out.println(redisTemplate.opsForSet().members("set"));
        /*集合移动*/
        Long set1 = redisTemplate.opsForSet().add("set1", new String[]{"set11", "set12", "set13"});
        System.out.println("set add result: " + set1);
        System.out.println(redisTemplate.opsForSet().members("set1"));
        redisTemplate.opsForSet().move("set1", "set11", "set");
        System.out.println(redisTemplate.opsForSet().members("set"));
        System.out.println(redisTemplate.opsForSet().members("set1"));

        /*有序集合*/
        System.out.println(redisTemplate.opsForZSet().add("zset", "zset-1", 2));
        System.out.println(redisTemplate.opsForZSet().add("zset", "zset-2", 1));
        System.out.println(redisTemplate.opsForZSet().range("zset", 0 , -1));
        /*批量添加*/
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-5",9.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-6",6.1);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        redisTemplate.opsForZSet().add("zset1", tuples);
        System.out.println(redisTemplate.opsForZSet().range("zset1", 0, -1));
        /*移除数据*/
        redisTemplate.opsForZSet().remove("zset1", "zset-5");
        System.out.println(redisTemplate.opsForZSet().range("zset1", 0, -1));

        /*清空所有的数据*/
        redisTemplate.delete(redisTemplate.keys("*"));
        return "塞入数据";
    }
}
