package com.sakura.factorypattern.impl;

import com.sakura.factorypattern.inter.AnimalInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Cat implements AnimalInterface {

    public void animal() {
        System.out.println("produce an animal is cat !");
    }
}
