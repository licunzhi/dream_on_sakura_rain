package com.sakura.creationalPatterns.PrototypePattern.impl;

import com.sakura.PrototypePattern.Animal.Animal;

public class Dog extends Animal {

    public Dog() {
        type = "dog";
    }

    @Override
    public void animal() {
        System.out.println("te is dog");
    }
}
