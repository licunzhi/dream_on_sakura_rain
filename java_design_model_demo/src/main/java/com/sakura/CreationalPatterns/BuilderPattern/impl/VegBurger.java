package com.sakura.CreationalPatterns.BuilderPattern.impl;

import com.sakura.BuilderPattern.item.Burger;
import com.sakura.CreationalPatterns.BuilderPattern.item.Burger;

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
