package com.sakura.AbstractFactoryPattern.impl.color;

import com.sakura.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Yellow implements ColorInterface {

    public void color() {
        System.out.println("produce a color is yellow !");
    }
}
