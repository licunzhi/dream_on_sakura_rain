package com.sakura.CreationalPatterns.BuilderPattern.item;

import com.sakura.BuilderPattern.inter.Item;
import com.sakura.BuilderPattern.inter.Packing;
import com.sakura.BuilderPattern.pack.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
