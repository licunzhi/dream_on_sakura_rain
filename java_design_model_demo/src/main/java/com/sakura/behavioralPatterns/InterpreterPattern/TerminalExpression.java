package com.sakura.behavioralPatterns.InterpreterPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interperter(String context) {
        return data.contains(context);
    }
}
