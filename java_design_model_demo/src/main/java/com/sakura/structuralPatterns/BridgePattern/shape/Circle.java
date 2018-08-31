package com.sakura.structuralPatterns.BridgePattern.shape;

import com.sakura.structuralPatterns.BridgePattern.draw.DrawAPI;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-31
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
