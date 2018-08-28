package com.sakura.SingletonPattern.mode;

/**
 * @author licunzhi
 * @desc double checking locking mode safe
 * @date 2018-08-28
 */
public class SingletonDoubleCheck {

    private static SingletonDoubleCheck instance;

    /**
     * private constructor avoid instanced
     */
    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getInstance() {

        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }

        }
        return instance;

    }

}
