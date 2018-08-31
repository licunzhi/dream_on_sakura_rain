package com.sakura.structuralPatterns.AdapterPattern.inter;

/**
 * @author licunzhi
 * @desc player interface just can play mp3 type music
 * @date 2018-08-31
 */
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}
