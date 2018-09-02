package com.sakura.behavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-02
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
