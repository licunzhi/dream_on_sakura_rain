package com.sakura.behavioralPatterns.VisitorPAttern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
