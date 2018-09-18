package com.sakura.behavioralPatterns.CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc create the class to use command--order(execute)
 * @date 2018-09-18
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        orderList.forEach(Order::execute);
        // this method clear() will remove all elements in orderList, and the orderList size will zero
        orderList.clear();
    }
}
