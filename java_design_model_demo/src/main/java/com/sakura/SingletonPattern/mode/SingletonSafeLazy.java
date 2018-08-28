package com.sakura.SingletonPattern.mode;

/**
 * @author licunzhi
 * @desc lazy mode safe
 * @date 2018-08-28
 */
public class SingletonSafeLazy {

    private static SingletonSafeLazy instance;

    /**
     * private constructor avoid instanced
     */
    private SingletonSafeLazy() {

    }

    /**
     * the keyword synchronized make the method became a atom operation
     *
     * before finish to create instance the lock will always here
     */
    public static synchronized SingletonSafeLazy getInstance() {

        if (instance == null) {
            instance = new SingletonSafeLazy();
        }
        return instance;

    }

}
