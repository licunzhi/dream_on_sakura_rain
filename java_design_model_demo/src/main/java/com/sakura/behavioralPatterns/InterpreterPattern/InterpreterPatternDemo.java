package com.sakura.behavioralPatterns.InterpreterPattern;

/**
 * @author licunzhi
 * @desc interpreter pattern demo
 * @date 2018-09-18
 */
public class InterpreterPatternDemo {


    public static void main(String[] args) {
        Expression linux = new TerminalExpression("ls cd mkdir vi");
        Expression window = new TerminalExpression("dir cd");
        OrExpression orExpression = new OrExpression(linux, window);
        AndExpression andExpression = new AndExpression(linux, window);

        System.out.println("linux or windows commands ? result : " + orExpression.interperter("vi"));
        System.out.println("linux and windows common commands ? result : " + andExpression.interperter("cd"));
        System.out.println("linux and windows common commands ? result : " + andExpression.interperter("vi"));

    }
}
