package com.sakura.behavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-02
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
