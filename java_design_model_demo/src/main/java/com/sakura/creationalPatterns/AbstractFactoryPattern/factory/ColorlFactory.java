package com.sakura.creationalPatterns.AbstractFactoryPattern.factory;

import com.sakura.creationalPatterns.AbstractFactoryPattern.impl.color.Blue;
import com.sakura.creationalPatterns.AbstractFactoryPattern.impl.color.Red;
import com.sakura.creationalPatterns.AbstractFactoryPattern.impl.color.Yellow;
import com.sakura.creationalPatterns.AbstractFactoryPattern.inter.AnimalInterface;
import com.sakura.creationalPatterns.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc color factory provide the method to produce the color object
 * @date 2018-08-28
 */
public class ColorlFactory extends AbstractFactory {

    public AnimalInterface produceAnimal(String animalType) {
        return null;
    }

    public ColorInterface produceColor(String colorType) {
        if(colorType == null){
            return null;
        }
        if(colorType.equalsIgnoreCase("RED")){
            return new Red();
        } else if(colorType.equalsIgnoreCase("BLUE")){
            return new Blue();
        } else if(colorType.equalsIgnoreCase("YELLOW")){
            return new Yellow();
        }
        return null;

    }

}
