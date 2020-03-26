package com.sakura.rain.service;

import com.sakura.rain.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName UserSimpleService
 * @function [业务功能]
 * @notice 针对原子操作的业务封装
 * @Author lcz
 * @Date 2020/03/26 12:19
 */
@FeignClient(value = "CLOUD-USER-SERVICE-DEMO")
public interface UserSimpleService {

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    User get(@PathVariable("id") long id);

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<User> list();

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    boolean add(User dept);
}
