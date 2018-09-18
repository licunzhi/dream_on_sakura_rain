package com.sakura.behavioralPatterns.CommandPattern;

/**
 * @author licunzhi
 * @desc the class to implement order command but is the sell method
 * @date 2018-09-18
 */
public class SellStock implements Order {
    private Stock sakura;

    public SellStock(Stock sakura) {
        this.sakura = sakura;
    }

    @Override
    public void execute() {
        sakura.sell();
    }
}
