package com.sakura.rain.service;

import com.sakura.rain.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-02
 */
/*可以实现接口加注解的方式实现接口的调用 类似mybatis的接口加注解@Mapper的实现方式*/
@FeignClient(value = "CLOUD-USER-SERVICE-DEMO")
public interface UserClientService {
    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    User get(@PathVariable("id") long id);

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<User> list();

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    boolean add(User dept);
}
