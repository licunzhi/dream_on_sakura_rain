package com.sakura.behavioralPatterns.MementoPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
