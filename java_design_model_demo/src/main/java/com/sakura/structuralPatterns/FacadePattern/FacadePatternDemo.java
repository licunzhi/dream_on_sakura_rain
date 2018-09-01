package com.sakura.structuralPatterns.FacadePattern;

/**
 * @author licunzhi
 * @desc test demo for test result
 * @date 2018-09-01
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        /**
         * do not know say what
         */
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
