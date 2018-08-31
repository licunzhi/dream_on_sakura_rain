package com.sakura.structuralPatterns.AdapterPattern.impl;

import com.sakura.structuralPatterns.AdapterPattern.inter.AdvancedMediaPlayer;

/**
 * @author licunzhi
 * @desc has the function to play mp4
 * @date 2018-08-31
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("do nothing :" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
