package com.sakura.structuralPatterns.FacadePattern.shape;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Square");
    }
}
