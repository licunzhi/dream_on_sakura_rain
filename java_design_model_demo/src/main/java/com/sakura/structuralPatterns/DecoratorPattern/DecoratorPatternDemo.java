package com.sakura.structuralPatterns.DecoratorPattern;

import com.sakura.structuralPatterns.DecoratorPattern.decorator.RedShapeDecorator;
import com.sakura.structuralPatterns.DecoratorPattern.shape.Circle;
import com.sakura.structuralPatterns.DecoratorPattern.shape.Rectangle;
import com.sakura.structuralPatterns.DecoratorPattern.shape.Shape;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        /**
         * conclusion:
         *  it already has a interface has the function to draw()
         *  but does not have the function to define the color
         *  and now wo must use this function
         *
         *  so wen can create a decorator to strong the base interface
         *
         *  first we should create a abstract class just named ShapeDecorator to implement shape interface
         *  second we need to create a or one more class to extend the decorator
         *  in subclass we could override the method draw()
         *  also can create abstract function to be waited in subclass
         *
         *  when we use, we can new different Shape by the subclass of decorator
         *
         */

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
