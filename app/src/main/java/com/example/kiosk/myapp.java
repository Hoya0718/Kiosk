package com.example.kiosk;

import android.app.Application;

public class myapp extends Application {

    protected int id=18;

    public int getId() {
        return this.id;
    }

    public void setId(int a) {
        this.id = a;
    }
}
