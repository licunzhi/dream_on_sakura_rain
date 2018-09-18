package com.sakura.behavioralPatterns.InterpreterPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-18
 */
public class AndExpression implements Expression {

    private Expression exp1;
    private Expression exp2;

    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interperter(String context) {
        return (exp1.interperter(context) && exp2.interperter(context));
    }
}
