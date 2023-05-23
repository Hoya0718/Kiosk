package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_drink);
    }

    public void goto_Kiosk_R_F_P_T(View view) {
        Intent goto_Kiosk_R_F_P_T = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Total.class);
        startActivity(goto_Kiosk_R_F_P_T);
    }

    public void goto_Kiosk_R_F_P_Sd(View view) {
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }
}