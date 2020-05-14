package com.sakura.behavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
