package com.sakura.rain.service.impl;

import com.sakura.rain.dao.UserDao;
import com.sakura.rain.entity.User;
import com.sakura.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author licunzhi
 * @desc 用户操作具体实现
 * @date 2018-11-29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        return userDao.insertUserModel(user);
    }

    @Override
    public User get(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> list() {
        return userDao.getAllUser();
    }
}
