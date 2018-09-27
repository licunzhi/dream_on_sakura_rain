package com.sakura.behavioralPatterns.TemplatePattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
