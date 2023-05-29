package com.example.kiosk;

import android.graphics.Bitmap;

public class Order {

    private String orderName;
    private int orderPrice;
    private int orderCount;
    private Bitmap orderBitmap;

    // 생성자, getter, setter 등 필요한 메서드를 추가합니다.

    public Order(String orderName, int orderPrice, int orderCount, Bitmap orderBitmap) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
        this.orderBitmap = orderBitmap;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public Bitmap getOrderBitmap() {
        return orderBitmap;
    }

    public void setOrderBitmap(Bitmap orderBitmap) {
        this.orderBitmap = orderBitmap;
    }
}