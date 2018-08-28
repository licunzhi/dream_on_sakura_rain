package com.sakura.AbstractFactoryPattern;

import com.sakura.AbstractFactoryPattern.factory.AbstractFactory;
import com.sakura.AbstractFactoryPattern.inter.AnimalInterface;
import com.sakura.AbstractFactoryPattern.inter.ColorInterface;
import com.sakura.AbstractFactoryPattern.producer.FactoryBean;

/**
 * @author licunzhi
 * @desc Abstract Factory Pattern
 * @date 2018-08-28
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {

        /**
         * use the Abstract Factory Pattern steps:
         *      a: to get the factory we should use the factoryType
         *      b: use the factory bean we get to produce the object that we want
         *
         * conclusion:
         *      the difference between FactoryPattern and AbstractFactoryPattern can recognize
         *      the first is use a tool to produce the product that we can direct used
         *      the last is to use a tools utils to produce a tool and then use the tool
         *      to produce the produce that we may want used
         *
         *      the first we may use to produce some kind of object we want
         *      the last we may use to produce a series of objects we want
         *
         *                                       factory
         *                                          |
         *                            |▔▔▔▔▔▔▔|▔▔▔▔▔▔▔▔|
         *                     factory_one    factory_two     factory_three
         *                         |              |               |
         *                    |▔▔|▔▔|     |▔▔|▔▔|      |▔▔|▔▔|
         *                    a   b    c    aa   bb  cc     aaa  bbb ccc
         *
         *
         *
         *
         */
        AbstractFactory animalFactory = FactoryBean.produceFacroty("ANIMAL");

        AnimalInterface dog = animalFactory.produceAnimal("DOG");
        dog.animal();
        AnimalInterface cat = animalFactory.produceAnimal("CAT");
        cat.animal();
        AnimalInterface duck = animalFactory.produceAnimal("DUCK");
        duck.animal();

        AbstractFactory colorFactory = FactoryBean.produceFacroty("COLOR");

        ColorInterface red = colorFactory.produceColor("RED");
        red.color();
        ColorInterface blue = colorFactory.produceColor("BLUE");
        blue.color();
        ColorInterface yellow = colorFactory.produceColor("YELLOW");
        yellow.color();



    }



}
