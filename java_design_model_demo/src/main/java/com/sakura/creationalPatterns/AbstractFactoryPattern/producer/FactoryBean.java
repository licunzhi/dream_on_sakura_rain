package com.sakura.creationalPatterns.AbstractFactoryPattern.producer;


import com.sakura.creationalPatterns.AbstractFactoryPattern.factory.AbstractFactory;
import com.sakura.creationalPatterns.AbstractFactoryPattern.factory.AnimalFactory;
import com.sakura.creationalPatterns.AbstractFactoryPattern.factory.ColorlFactory;

/**
 * @author licunzhi
 * @desc the boss of factory, coding the inner logic method to produce different kind of factory
 * @date 2018-08-28
 */
public class FactoryBean {

    public static AbstractFactory produceFactory(String choiceType) {
        if (null == choiceType) {
            return null;
        }

        if(choiceType.equalsIgnoreCase("ANIMAL")){
            return new AnimalFactory();
        } else if(choiceType.equalsIgnoreCase("COLOR")){
            return new ColorlFactory();
        }
        return null;
    }
}
