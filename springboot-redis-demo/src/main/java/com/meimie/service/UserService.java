package com.meimie.service;

import com.meimie.dao.UserDao;
import com.meimie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/04/02 16:41
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User findById(String id){
        return userDao.findById(id);
    }

    public int addUser(String name,String age){
        return userDao.addUser(name,age);
    }

    public void updataById(String id,String name){
        userDao.updataById(id,name);
    }

    public void deleteById(String id){
        userDao.deleteById(id);
    }
}
