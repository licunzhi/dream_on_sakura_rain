package com.sakura.behavioralPatterns.MediatorPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User sakura = new User("sakura");
        User plumLi = new User("plum");

        sakura.sendMessage("this is sakura message");
        plumLi.sendMessage("this is plum message");
    }
}
