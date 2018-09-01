package com.sakura.structuralPatterns.BridgePattern;

import com.sakura.structuralPatterns.BridgePattern.draw.impl.GreenCircle;
import com.sakura.structuralPatterns.BridgePattern.draw.impl.RedCircle;
import com.sakura.structuralPatterns.BridgePattern.shape.Circle;
import com.sakura.structuralPatterns.BridgePattern.shape.Shape;

/**
 * @author licunzhi
 * @desc test demo
 * @date 2018-08-31
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        /**
         * conclusion:
         *      Abstraction and realization decouple
         *
         *      shape is a abstract class as bridge
         *      empty method about draw, the method has implements in drawApi
         *      we can use drawApi`s subclass -redCircle or greenCircle directly
         *      but if we create a bridge shape and give a abstract method
         *      subclass can override the method
         *
         *      just like the method or function doesnt belong the circle
         *      if circle extends abstract class shape
         *      it can make drawApi`s method as it`s own method
         *
         */
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
