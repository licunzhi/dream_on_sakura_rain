package com.sakura.structuralPatterns.AdapterPattern.impl;

import com.sakura.structuralPatterns.AdapterPattern.inter.AdvancedMediaPlayer;
import com.sakura.structuralPatterns.AdapterPattern.inter.MediaPlayer;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-31
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
