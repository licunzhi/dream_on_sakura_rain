package com.sakura.factorypattern.factory;

import com.sakura.factorypattern.impl.Cat;
import com.sakura.factorypattern.impl.Dog;
import com.sakura.factorypattern.impl.Duck;
import com.sakura.factorypattern.inter.AnimalInterface;
import javafx.scene.shape.Circle;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-28
 */
public class AnimalFactory {

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

}
