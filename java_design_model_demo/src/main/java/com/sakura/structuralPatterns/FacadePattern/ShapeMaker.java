package com.sakura.structuralPatterns.FacadePattern;

import com.sakura.structuralPatterns.FacadePattern.shape.Circle;
import com.sakura.structuralPatterns.FacadePattern.shape.Rectangle;
import com.sakura.structuralPatterns.FacadePattern.shape.Shape;
import com.sakura.structuralPatterns.FacadePattern.shape.Square;

/**
 * @author licunzhi
 * @desc all object method function use this maker to do
 * @date 2018-09-01
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
