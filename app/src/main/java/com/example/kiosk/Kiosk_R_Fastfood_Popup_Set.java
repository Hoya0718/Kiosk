package com.example.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Set extends AppCompatActivity {

    private int value;
    private int burger;
    private String burgerName;
    private byte[] burgerArray;

    private Bitmap burgerBitmap;

    private TextView showMission;

    private TextView burger_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_set);

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());

        burger_text = findViewById(R.id.burger_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");

            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
        }
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("value", value);

        burger-=2000;

        goto_Kiosk_R_F_P_Sz.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerImage", burgerArray);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }

    public void goto_Kiosk_R_F_M_Bp(View view) {
        Intent goto_Kiosk_R_F_M_Bp = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);

        value+=burger;

        burgerBitmap = BitmapFactory.decodeByteArray(burgerArray, 0, burgerArray.length);

        myapp orderHistory = (myapp) getApplicationContext();
        Order order = new Order(burgerName, burger, 1, burgerBitmap);
        orderHistory.addOrder(order);

        goto_Kiosk_R_F_M_Bp.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_Bp);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }

    public void onDestroy() {
        super.onDestroy();
        burgerBitmap = null;
    }
}