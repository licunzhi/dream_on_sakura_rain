package com.sakura.behavioralPatterns.MementoPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
