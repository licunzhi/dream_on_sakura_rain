package com.sakura.rain.service;

import com.sakura.rain.entity.UserInfo;
import com.sakura.rain.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @function [业务功能]
 * @notice 针对原子操作的业务封装
 * @Author lcz
 * @Date 2020/06/08 14:58
 */
@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getUserList() {
        return userInfoMapper.getUserList();
    }
}
