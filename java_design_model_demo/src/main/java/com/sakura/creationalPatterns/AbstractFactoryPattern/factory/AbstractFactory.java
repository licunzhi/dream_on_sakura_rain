package com.sakura.creationalPatterns.AbstractFactoryPattern.factory;

import com.sakura.AbstractFactoryPattern.inter.AnimalInterface;
import com.sakura.AbstractFactoryPattern.inter.ColorInterface;
import com.sakura.creationalPatterns.AbstractFactoryPattern.inter.AnimalInterface;
import com.sakura.creationalPatterns.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc abstract class factory include a series of methods to provide different kind object
 * @date 2018-08-28
 */
public abstract class AbstractFactory {

    public abstract AnimalInterface produceAnimal(String animalType);

    public abstract ColorInterface produceColor(String colorType);

}
