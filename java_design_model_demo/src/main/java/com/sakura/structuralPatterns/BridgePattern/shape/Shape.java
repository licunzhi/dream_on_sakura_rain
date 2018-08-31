package com.sakura.structuralPatterns.BridgePattern.shape;

import com.sakura.structuralPatterns.BridgePattern.draw.DrawAPI;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-31
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
