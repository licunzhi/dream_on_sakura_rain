package com.sakura.behavioralPatterns.TemplatePattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
