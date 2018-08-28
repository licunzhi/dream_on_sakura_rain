package com.sakura.AbstractFactoryPattern.factory;

import com.sakura.AbstractFactoryPattern.impl.animal.Cat;
import com.sakura.AbstractFactoryPattern.impl.animal.Dog;
import com.sakura.AbstractFactoryPattern.impl.animal.Duck;
import com.sakura.AbstractFactoryPattern.inter.AnimalInterface;
import com.sakura.AbstractFactoryPattern.inter.ColorInterface;

/**
 * @author licunzhi
 * @desc animal factory provide the method to produce different object
 * @date 2018-08-28
 */
public class AnimalFactory extends AbstractFactory {

    public AnimalInterface produceAnimal(String animalType) {
        if(animalType == null){
            return null;
        }
        if(animalType.equalsIgnoreCase("DOG")){
            return new Dog();
        } else if(animalType.equalsIgnoreCase("CAT")){
            return new Cat();
        } else if(animalType.equalsIgnoreCase("DUCK")){
            return new Duck();
        }
        return null;

    }

    public ColorInterface produceColor(String colorType) {
        return null;
    }

}
