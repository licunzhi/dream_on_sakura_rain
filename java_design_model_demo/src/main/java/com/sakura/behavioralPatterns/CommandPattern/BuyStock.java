package com.sakura.behavioralPatterns.CommandPattern;

/**
 * @author licunzhi
 * @desc command implements
 * @date 2018-09-18
 */
public class BuyStock implements Order{

    private Stock sakura;

    public BuyStock(Stock sakura) {
        this.sakura = sakura;
    }

    @Override
    public void execute() {
        // use the method in Stock
        sakura.buy();
    }
}
