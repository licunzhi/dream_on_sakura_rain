package com.sakura.rain.service;

import com.sakura.rain.entity.User;

import java.util.List;

/**
 * @author licunzhi
 * @desc 用户操作服务层
 * @date 2018-11-29
 */
public interface UserService {

    boolean add(User user);

    User get(Long id);

    List<User> list();
}
