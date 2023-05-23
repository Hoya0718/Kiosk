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

public class Kiosk_R_Fastfood_Popup_Reco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_reco);
    }

    public void goto_Kiosk_R_F_O_H(View v){
        Intent goto_Kiosk_R_F_O_H = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Order_Hist.class);
        startActivity(goto_Kiosk_R_F_O_H);
    }
}