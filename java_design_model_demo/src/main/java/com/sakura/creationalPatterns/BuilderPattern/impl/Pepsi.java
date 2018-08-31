package com.sakura.creationalPatterns.BuilderPattern.impl;

import com.sakura.BuilderPattern.item.ColdDrink;
import com.sakura.creationalPatterns.BuilderPattern.item.ColdDrink;

public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
