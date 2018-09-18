package com.sakura.behavioralPatterns.MediatorPattern;

import java.util.Date;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
