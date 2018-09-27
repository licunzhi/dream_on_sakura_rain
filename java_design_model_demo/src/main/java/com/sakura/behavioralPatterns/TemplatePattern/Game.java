package com.sakura.behavioralPatterns.TemplatePattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
