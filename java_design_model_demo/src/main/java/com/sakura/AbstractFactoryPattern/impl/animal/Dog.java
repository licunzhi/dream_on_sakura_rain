package com.sakura.AbstractFactoryPattern.impl.animal;

import com.sakura.AbstractFactoryPattern.inter.AnimalInterface;

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
