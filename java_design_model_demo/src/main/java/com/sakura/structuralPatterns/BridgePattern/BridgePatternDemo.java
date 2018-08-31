package com.sakura.structuralPatterns.BridgePattern;

import com.sakura.structuralPatterns.BridgePattern.draw.impl.GreenCircle;
import com.sakura.structuralPatterns.BridgePattern.draw.impl.RedCircle;
import com.sakura.structuralPatterns.BridgePattern.shape.Circle;
import com.sakura.structuralPatterns.BridgePattern.shape.Shape;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-31
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
