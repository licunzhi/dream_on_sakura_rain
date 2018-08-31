package com.sakura.creationalPatterns.BuilderPattern.item;

import com.sakura.creationalPatterns.BuilderPattern.inter.Item;
import com.sakura.creationalPatterns.BuilderPattern.inter.Packing;
import com.sakura.creationalPatterns.BuilderPattern.pack.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
