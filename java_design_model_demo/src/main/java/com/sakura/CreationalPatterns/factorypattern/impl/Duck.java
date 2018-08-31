package com.sakura.CreationalPatterns.factorypattern.impl;

import com.sakura.factorypattern.inter.AnimalInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Duck implements AnimalInterface {

    public void animal() {
        System.out.println("produce an animal is duck !");
    }
}
