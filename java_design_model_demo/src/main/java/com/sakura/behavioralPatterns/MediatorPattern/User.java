package com.sakura.behavioralPatterns.MediatorPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
