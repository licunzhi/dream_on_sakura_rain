package com.sakura.creationalPatterns.BuilderPattern.pack;

import com.sakura.BuilderPattern.inter.Packing;
import com.sakura.creationalPatterns.BuilderPattern.inter.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
