package com.sakura.behavioralPatterns.VisitorPAttern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
