package com.sakura.CreationalPatterns.BuilderPattern.impl;

import com.sakura.BuilderPattern.item.Burger;
import com.sakura.CreationalPatterns.BuilderPattern.item.Burger;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
