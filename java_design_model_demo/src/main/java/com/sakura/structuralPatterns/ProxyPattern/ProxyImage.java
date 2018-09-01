package com.sakura.structuralPatterns.ProxyPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
