package com.sakura.behavioralPatterns.VisitorPAttern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-27
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
