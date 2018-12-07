package com.sakura.rain.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sakura.rain.entity.User;
import com.sakura.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author licunzhi
 * @desc 用户控制层
 * @date 2018-11-29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * 在这里面我使用了get方法的异常行为作为演示的典例
     *  一旦服务调用出现了错误信息行为  会调用@HystrixCommand标注好的fallbackMethod 调用类中指定好的方法
     * */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_get_user")
    public User get(@PathVariable Long id) {
        // return userService.get(id);
        User user = userService.get(id);

        if (user == null) {
            // 在没有进行配置熔断机制的时候会直接抛出异常   接口调用会接受到指定的信息数据  配置完成之后就会返回配置好的方法的指定行为信息
            throw new RuntimeException("ID:" + id + "没有对应的用户信息查询行为");
        }

        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody User user) {
        return userService.add(user);
    }


    public User processHystrix_get_user(@PathVariable("id") Long id) {
        return new User().setId(id).setName("此用户的信息并不存在").setDb_source("can not find the information in databases");
    }
}
