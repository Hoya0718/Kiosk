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

public class Kiosk_R_Fastfood_Popup_Total extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_total);
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_M_E(View view) {
        Intent goto_Kiosk_R_F_M_E = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_End.class);
        startActivity(goto_Kiosk_R_F_M_E);
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }
}