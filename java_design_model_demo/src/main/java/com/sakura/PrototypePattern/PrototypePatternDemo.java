package com.sakura.PrototypePattern;

import com.sakura.PrototypePattern.cache.AnimalCache;
import com.sakura.PrototypePattern.impl.Cat;
import com.sakura.PrototypePattern.impl.Dog;
import com.sakura.PrototypePattern.impl.Duck;

/**
 * @author licunzhi
 * @desc PrototypePattern test demo for testing
 * @date 2018-08-30
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        AnimalCache.loadCache();

        System.out.println("execute the copy or clone method to get a new object");

        Dog dog = (Dog) AnimalCache.getAnimal("dog");
        dog.animal();
        System.out.println("the dog(clone) info :");
        System.out.println(dog);

        Cat cat = (Cat) AnimalCache.getAnimal("cat");
        cat.animal();
        System.out.println("the cat(clone) info :");
        System.out.println(cat);

        Duck duck = (Duck) AnimalCache.getAnimal("duck");
        duck.animal();
        System.out.println("the duck(clone) info :");
        System.out.println(duck);

        /**
         * keywords: deep copy(深度拷贝)
         *
         * result info：
         *      Init the object to provide to use(clone)
         *      the dog info :
         *      com.sakura.PrototypePattern.impl.Dog@6a38e57f---------------┓-------→not the same address means not the same object
         *      the cat info :                                              ┊
         *      com.sakura.PrototypePattern.impl.Cat@1c6b6478               ┊
         *      the duck info :                                             ┊
         *      com.sakura.PrototypePattern.impl.Duck@4ac68d3e              ┊
         *      execute the copy or clone method to get a new object        ┊
         *      te is dog                                                   ┊
         *      the dog(clone) info :                                       ┊
         *      com.sakura.PrototypePattern.impl.Dog@277c0f21---------------┚
         *      te is cat
         *      the cat(clone) info :
         *      com.sakura.PrototypePattern.impl.Cat@6073f712
         *      te is duck
         *      the duck(clone) info :
         *      com.sakura.PrototypePattern.impl.Duck@43556938
         *
         * we can see from the contrast of the dotted line mark in the above comment
         * although all of them are dog type , but they are not one object
         * they have the same content and attributes, but they belong two store objects in memory
         *
         * association:
         *      such as wo have used a cache tools named LoadingCache
         *      it has a method load for init the cache
         *      you can code some logical method to use the method param to load the object you will use
         *      if you are interested in cache tools just like i have referred to
         *      you can do some study
         */
    }
}
