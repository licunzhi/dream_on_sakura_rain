package com.sakura.CreationalPatterns.PrototypePattern.impl;

import com.sakura.CreationalPatterns.PrototypePattern.Animal.Animal;
import com.sakura.PrototypePattern.Animal.Animal;

public class Cat extends Animal {

    public Cat() {
        type = "cat";
    }

    @Override
    public void animal() {
        System.out.println("te is cat");
    }
}
