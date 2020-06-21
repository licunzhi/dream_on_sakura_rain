package com.sakura.rain.service;

/**
 * @ClassName UserService
 * @function [业务功能]
 * @notice 针对原子操作的业务封装
 * @Author lcz
 * @Date 2020/06/16 12:55
 */
public class UserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
