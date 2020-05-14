package com.sakura.behavioralPatterns.ObserverPattern;

/**
 * @ClassName Observer
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/14 19:53
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
