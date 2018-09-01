package com.sakura.structuralPatterns.ProxyPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
