package com.pagehelper.demo;

import com.github.pagehelper.PageInfo;
import com.pagehelper.demo.configuration.db.LocalDatasource;
import com.pagehelper.demo.mapper.UserMapper;
import com.pagehelper.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        List<User> users = userMapper.selectUser(5, 2);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        users.forEach(user -> System.out.println(user));
    }

}
