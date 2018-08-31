package com.sakura.structuralPatterns.AdapterPattern.inter;

/**
 * @author licunzhi
 * @desc a player can play other type of music except mp3 type music
 * @date 2018-08-31
 */
public interface AdvancedMediaPlayer {

    public void playVlc(String fileName);

    public void playMp4(String fileName);
}
