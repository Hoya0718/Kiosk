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

public class Kiosk_R_Fastfood_Pay_Meth extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_pay_meth);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
        }
    }

    public void goto_Kiosk_F_R_O_H(View v){
        Intent goto_Kiosk_R_F_O_H = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Order_Hist.class);
        goto_Kiosk_R_F_O_H.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_O_H);
    }

    public void goto_Kiosk_F_R_P(View v){
        Intent goto_Kiosk_F_R_P = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Pay.class);
        goto_Kiosk_F_R_P.putExtra("value", value);
        startActivity(goto_Kiosk_F_R_P);
    }
}