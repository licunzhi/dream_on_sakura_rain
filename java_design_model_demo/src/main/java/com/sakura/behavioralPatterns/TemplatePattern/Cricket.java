package com.sakura.behavioralPatterns.TemplatePattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
