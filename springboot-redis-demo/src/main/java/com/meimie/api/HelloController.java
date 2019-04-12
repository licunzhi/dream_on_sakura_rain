package com.meimie.api;

import com.meimie.model.User;
import com.meimie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/adduser")
    public int addUser(@RequestParam("name")String name, @RequestParam("age")String age){
        return userService.addUser(name, age);
    }
    @RequestMapping("/findUser")
    public User findUser(@RequestParam("id") String id){
        return userService.findById(id);
    }
    @RequestMapping("/updataById")
    public String updataById(@RequestParam("id") String id,@RequestParam("name") String name){
        try {
            userService.updataById(id, name);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam("id") String id){
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

}
