package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Kiosk_7_b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_b);
    }

    public void goto_kiosk_06(View v){
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_07_s(View v){
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void goto_kiosk_07_d(View v){
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }

    public void popup_kiosk_08_1(View view) {
        Intent popup_kiosk_08_1 = new Intent(getApplicationContext(), Kiosk_8_1.class);
        startActivity(popup_kiosk_08_1);
    }
}