package com.sakura.behavioralPatterns.StatePattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
