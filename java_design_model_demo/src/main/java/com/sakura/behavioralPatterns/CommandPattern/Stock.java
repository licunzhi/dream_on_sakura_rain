package com.sakura.behavioralPatterns.CommandPattern;

/**
 * @author licunzhi
 * @desc request action
 * @date 2018-09-18
 */
public class Stock {
    private String name = "sakura";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ",Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}
