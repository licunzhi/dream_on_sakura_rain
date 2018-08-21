package com.pagehelper.demo.model;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-20
 */
public class User {

    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", password='" + password + '\'' + '}';
    }
}
