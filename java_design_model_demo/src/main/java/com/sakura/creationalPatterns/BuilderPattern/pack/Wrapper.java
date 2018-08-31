package com.sakura.creationalPatterns.BuilderPattern.pack;

import com.sakura.creationalPatterns.BuilderPattern.inter.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
