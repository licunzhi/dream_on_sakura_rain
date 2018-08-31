package com.sakura.CreationalPatterns.AbstractFactoryPattern.impl.color;

import com.sakura.AbstractFactoryPattern.inter.ColorInterface;
import com.sakura.CreationalPatterns.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Red implements ColorInterface {

    public void color() {
        System.out.println("produce a color is red !");
    }
}
