package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Set extends AppCompatActivity {

    private String intentString;
    private String intentInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_set);

        Intent intent = getIntent();
        if (intent != null) {
            intentString = intent.getStringExtra("name");
            intentInt = intent.getStringExtra("value");
        }
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("name", intentString);
        goto_Kiosk_R_F_P_Sz.putExtra("value", intentInt);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }

    public void goto_Kiosk_R_F_M_Bp(View view) {
        Intent goto_Kiosk_R_F_M_Bp = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        startActivity(goto_Kiosk_R_F_M_Bp);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        startActivity(goto_Kiosk_R_F_M_B);
    }
}