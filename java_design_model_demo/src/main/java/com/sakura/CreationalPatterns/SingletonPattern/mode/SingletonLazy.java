package com.sakura.CreationalPatterns.SingletonPattern.mode;

/**
 * @author licunzhi
 * @desc lazy mode not safe
 * @date 2018-08-28
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    /**
     * private constructor avoid instanced
     */
    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {

        if (instance == null) {
            /**
             * there may not create a instance and another object use this method to create instance
             *
             * so the method is not a atom operation
             */
            instance = new SingletonLazy();
        }
        return instance;

    }
}
