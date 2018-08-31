package com.sakura.CreationalPatterns.BuilderPattern.pack;

import com.sakura.BuilderPattern.inter.Packing;
import com.sakura.CreationalPatterns.BuilderPattern.inter.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
