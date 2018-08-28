package com.sakura.SingletonPattern.mode;

/**
 * @author licunzhi
 * @desc classloader mode safe
 * @date 2018-08-28
 */
public class SingletonLoader {

    private static class SingletonHolder {
        private static final SingletonLoader INSTANCE = new SingletonLoader();
    }

    /**
     * private constructor avoid instanced
     */
    private SingletonLoader() {

    }

    public static SingletonLoader getInstance() {
        return SingletonHolder.INSTANCE;

    }

}
