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

public class Kiosk_R_Fastfood_Menu_Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_drink);
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_B(View v){
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_M_S(View v){
        Intent goto_Kiosk_R_F_M_S = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Side.class);
        startActivity(goto_Kiosk_R_F_M_S);
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
        startActivity(goto_Kiosk_R_F_P_R);
    }
}