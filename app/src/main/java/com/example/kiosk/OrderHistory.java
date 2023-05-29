package com.example.kiosk;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory extends Application {

    private List<Order> orderList;

    @Override
    public void onCreate() {
        super.onCreate();
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

}