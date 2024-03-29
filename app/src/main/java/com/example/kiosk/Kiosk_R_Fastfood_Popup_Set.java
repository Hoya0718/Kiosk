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

    private TextView askMission;
    private TextView showMission;
    private TextView burger_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_set);

        myapp myApp = (myapp) getApplicationContext();
        myApp.setR_F_Pop_Time(System.currentTimeMillis());
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());
        askMission = findViewById(R.id.askMission);

        if (showMission.getText().toString().equals(" ")) {
            askMission.setText(" ");
        }

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

    public void goto_Kiosk_R_F_P_C(View view) {
        Intent goto_Kiosk_R_F_P_C = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Count.class);

        goto_Kiosk_R_F_P_C.putExtra("value", value);
        goto_Kiosk_R_F_P_C.putExtra("plus", burger);
        goto_Kiosk_R_F_P_C.putExtra("plusName", burgerName);
        goto_Kiosk_R_F_P_C.putExtra("plusImage", burgerArray);
        startActivity(goto_Kiosk_R_F_P_C);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}