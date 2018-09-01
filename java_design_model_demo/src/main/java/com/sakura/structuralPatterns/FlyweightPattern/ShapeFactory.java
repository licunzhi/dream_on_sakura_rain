package com.sakura.structuralPatterns.FlyweightPattern;

import java.util.HashMap;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
