package com.sakura.rain.dao;

import com.sakura.rain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author licunzhi
 * @desc 用户操作接口层
 * @date 2018-11-29
 */
@Mapper
public interface UserDao {

    boolean insertUserModel(User user);

    User getUser(Long id);

    List<User> getAllUser();
}
