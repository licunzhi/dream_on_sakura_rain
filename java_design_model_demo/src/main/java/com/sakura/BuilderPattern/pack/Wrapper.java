package com.sakura.BuilderPattern.pack;

import com.sakura.BuilderPattern.inter.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}