package com.sakura.structuralPatterns.BridgePattern.draw.impl;

import com.sakura.structuralPatterns.BridgePattern.draw.DrawAPI;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-31
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
