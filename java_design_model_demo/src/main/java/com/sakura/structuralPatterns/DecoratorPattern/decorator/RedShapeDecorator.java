package com.sakura.structuralPatterns.DecoratorPattern.decorator;

import com.sakura.structuralPatterns.DecoratorPattern.shape.Shape;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
