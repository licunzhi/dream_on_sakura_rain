package com.sakura.PrototypePattern.impl;

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
