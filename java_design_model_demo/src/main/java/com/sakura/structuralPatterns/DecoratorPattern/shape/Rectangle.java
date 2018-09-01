package com.sakura.structuralPatterns.DecoratorPattern.shape;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
