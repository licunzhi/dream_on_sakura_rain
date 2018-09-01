package com.sakura.structuralPatterns.DecoratorPattern.decorator;

import com.sakura.structuralPatterns.DecoratorPattern.shape.Shape;

/**
 * @author licunzhi
 * @desc decorator to strong shape interface function
 * @date 2018-09-01
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
