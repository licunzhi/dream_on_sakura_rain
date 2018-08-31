package com.sakura.creationalPatterns.BuilderPattern.pack;

import com.sakura.creationalPatterns.BuilderPattern.inter.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
