package com.sakura.CreationalPatterns.BuilderPattern.pack;

import com.sakura.BuilderPattern.inter.Packing;
import com.sakura.CreationalPatterns.BuilderPattern.inter.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
