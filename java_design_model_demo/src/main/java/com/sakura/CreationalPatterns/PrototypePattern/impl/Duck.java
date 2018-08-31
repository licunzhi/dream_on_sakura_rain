package com.sakura.CreationalPatterns.PrototypePattern.impl;

import com.sakura.PrototypePattern.Animal.Animal;

public class Duck extends Animal {

    public Duck() {
        type = "duck";
    }

    @Override
    public void animal() {
        System.out.println("te is duck");
    }
}
