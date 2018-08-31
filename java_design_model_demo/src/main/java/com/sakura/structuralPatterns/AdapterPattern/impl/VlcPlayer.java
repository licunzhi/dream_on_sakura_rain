package com.sakura.structuralPatterns.AdapterPattern.impl;

import com.sakura.structuralPatterns.AdapterPattern.inter.AdvancedMediaPlayer;

/**
 * @author licunzhi
 * @desc a class implements AdvancedMediaPlayer just have the function to play vlc
 * @date 2018-08-31
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("do nothing :" + fileName);
    }

}
