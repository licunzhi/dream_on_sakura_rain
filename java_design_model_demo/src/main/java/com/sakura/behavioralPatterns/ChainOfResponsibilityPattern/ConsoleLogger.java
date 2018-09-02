package com.sakura.behavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-02
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
