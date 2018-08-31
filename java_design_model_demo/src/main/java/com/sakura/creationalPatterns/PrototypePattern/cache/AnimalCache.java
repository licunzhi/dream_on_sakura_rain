package com.sakura.creationalPatterns.PrototypePattern.cache;

import com.sakura.PrototypePattern.Animal.Animal;
import com.sakura.PrototypePattern.impl.Cat;
import com.sakura.PrototypePattern.impl.Dog;
import com.sakura.PrototypePattern.impl.Duck;

import java.util.HashMap;
import java.util.Map;

/**
 * @author licunzhi
 * @desc the cache to store the object
 * @date 2018-08-30
 */
public class AnimalCache {

    private static Map<String, Animal> animalCache = new HashMap<>();

    public static Animal getAnimal(String animalType) {
        Animal animal = animalCache.get(animalType);
        return (Animal) animal.clone();
    }

    /**
     * It just like init the container to provide the method to gey the type you want
     */
    public static void loadCache() {
        System.out.println("Init the object to provide to use(clone)");

        Dog dog = new Dog();
        animalCache.put(dog.getType(), dog);
        System.out.println("the dog info :");
        System.out.println(dog);

        Cat cat = new Cat();
        animalCache.put(cat.getType(), cat);
        System.out.println("the cat info :");
        System.out.println(cat);

        Duck duck = new Duck();
        animalCache.put(duck.getType(), duck);
        System.out.println("the duck info :");
        System.out.println(duck);
    }
}
