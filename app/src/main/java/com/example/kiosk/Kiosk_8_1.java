package com.example.kiosk;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_8_1 extends AppCompatActivity {
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_1);
    }

    public void popup_kiosk_08_2(View view) {
        Intent popup_kiosk_08_2 = new Intent(getApplicationContext(), Kiosk_8_2.class);
        startActivity(popup_kiosk_08_2);
    }

    public void goto_kiosk_07_b(View view) {
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }
}