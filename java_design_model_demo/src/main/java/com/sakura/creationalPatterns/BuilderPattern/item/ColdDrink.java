package com.sakura.creationalPatterns.BuilderPattern.item;

import com.sakura.creationalPatterns.BuilderPattern.inter.Item;
import com.sakura.creationalPatterns.BuilderPattern.inter.Packing;
import com.sakura.creationalPatterns.BuilderPattern.pack.Bottle;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
