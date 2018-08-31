package com.sakura.creationalPatterns.factorypattern.impl;

import com.sakura.creationalPatterns.factorypattern.inter.AnimalInterface;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class Dog implements AnimalInterface {

    public void animal() {
        System.out.println("produce an animal is dog !");
    }
}
