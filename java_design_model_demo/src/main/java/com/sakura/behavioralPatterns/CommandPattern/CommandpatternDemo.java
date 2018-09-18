package com.sakura.behavioralPatterns.CommandPattern;

/**
 * @author licunzhi
 * @desc test the command pattern demo test
 * @date 2018-09-18
 */
public class CommandpatternDemo {
    public static void main(String[] args) {
        /**
         * conclusion:
         *      the command pattern define a interface to implement
         *      how to do or do what in subclass to do
         *
         *      we create different type class to implement the special class order
         *      although we use the same method execute
         *      but the print is decided by the subclass
         */
        BuyStock sakuraBuy = new BuyStock(new Stock());
        SellStock sakuraSell = new SellStock(new Stock());

        Broker broker = new Broker();
        broker.takeOrder(sakuraBuy);
        broker.takeOrder(sakuraSell);
        broker.placeOrders();
    }
}
