package com.pagehelper.demo.api;

import com.github.pagehelper.PageInfo;
import com.pagehelper.demo.mapper.UserMapper;
import com.pagehelper.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-20
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/licunzhi/{pageNum}/{pageSize}")
    public PageInfo<User> test(@PathVariable(value = "pageNum") Integer pageNum,
                    @PathVariable(value = "pageSize") Integer pageSize) {
        List<User> users = userMapper.selectUser(pageNum, pageSize);
        users.forEach(user -> System.out.println(user));
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
