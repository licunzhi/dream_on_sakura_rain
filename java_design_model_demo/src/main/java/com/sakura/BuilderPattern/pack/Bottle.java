package com.sakura.BuilderPattern.pack;

import com.sakura.BuilderPattern.inter.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
