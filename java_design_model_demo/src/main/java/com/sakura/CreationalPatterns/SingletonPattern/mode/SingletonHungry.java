package com.sakura.CreationalPatterns.SingletonPattern.mode;

/**
 * @author licunzhi
 * @desc 推荐使用这种
 * @date 2018-08-28
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    /**
     * before use this method to create instance ,this instance has already be created
     *
     * just return the instance
     *
     * whatever how many times the instance is just the same one
     */
    public static SingletonHungry getInstance() {
        return instance;
    }
}
