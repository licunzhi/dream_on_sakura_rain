package com.sakura.structuralPatterns.ProxyPattern;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        /**
         * conclusion:
         * whatever what kind of pattern, must use interface
         *
         * in this case ProxyPattern
         * create a proxy for use, the function or object copy form real image
         * when use to create and next time if the init operation still exist
         * do copy again
         *
         * by doing this can save memory and others
         *
         */
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
