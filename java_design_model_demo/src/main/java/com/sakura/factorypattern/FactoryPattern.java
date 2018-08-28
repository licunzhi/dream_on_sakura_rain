package com.sakura.factorypattern;

import com.sakura.factorypattern.factory.AnimalFactory;
import com.sakura.factorypattern.inter.AnimalInterface;

/**
 * @author licunzhi
 * @desc factory pattern
 * @date 2018-08-28
 */
public class FactoryPattern {
    public static void main(String[] args) {

        /**
         * new an object of factory
         */
        AnimalFactory animalFactory = new AnimalFactory();

        /**
         * use the method of produceAnimal to get an Animal
         * the type of the method return id decided by the param of animalType
         * such as (ignore the lower and upper about the param):
         *      cat(CAT)
         *      dog(DOG)
         *      duck(DUCK)
         */
        AnimalInterface animalOne = animalFactory.produceAnimal("CAT");
        animalOne.animal();

        AnimalInterface animalTwo = animalFactory.produceAnimal("DOG");
        animalTwo.animal();

        AnimalInterface animalThree = animalFactory.produceAnimal("DUCK");
        animalThree.animal();

        /**
         * when we use the AnimalFactory`s method of produceAnimal
         * we just to give a param means animal type
         * and then we can get the return
         * wo may not know how to create the object
         * but we can finally get the result that we want
         *
         * base the codes above
         * we can also use more complex words or not just one param to approve
         * the judgement in the method
         * so ,wo get do use more choice to get more type results
         *
         *                              factory
         *                                  |
         *                    |▔▔▔▔▔▔▔|▔▔▔▔▔▔▔▔|
         *               bean_one       bean_two       bean_three
         */

    }
}
