package com.sakura.creationalPatterns.AbstractFactoryPattern.impl.color;

import com.sakura.creationalPatterns.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Blue implements ColorInterface {

    public void color() {
        System.out.println("produce a color is blue !");
    }
}
