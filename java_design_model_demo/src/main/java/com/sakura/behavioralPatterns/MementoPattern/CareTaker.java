package com.sakura.behavioralPatterns.MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
