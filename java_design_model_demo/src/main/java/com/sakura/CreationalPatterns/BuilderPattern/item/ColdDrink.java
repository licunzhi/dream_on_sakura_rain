package com.sakura.CreationalPatterns.BuilderPattern.item;

import com.sakura.BuilderPattern.inter.Item;
import com.sakura.BuilderPattern.inter.Packing;
import com.sakura.BuilderPattern.pack.Bottle;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
