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

public class Kiosk_R_Fastfood_Menu_Side extends AppCompatActivity {

    private int value;
    private TextView money_text;

    private TextView snacksan_text;
    private TextView snackshu_text;
    private TextView mcnurget_text;
    private TextView huri_text;
    private TextView hashbra_text;
    private TextView chickentender_text;
    private TextView chezstick_text;
    private TextView cuol_text;
    private TextView churu_text;
    private TextView icesu_text;
    private TextView iceco_text;
    private TextView iceba_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_side);

        money_text = findViewById(R.id.money_text);

        snacksan_text = findViewById(R.id.snacksan_text);
        snackshu_text = findViewById(R.id.snackshu_text);
        mcnurget_text = findViewById(R.id.mcnurget_text);
        huri_text = findViewById(R.id.huri_text);
        hashbra_text = findViewById(R.id.hashbra_text);
        chickentender_text = findViewById(R.id.chickentender_text);
        chezstick_text = findViewById(R.id.chezstick_text);
        cuol_text = findViewById(R.id.cuol_text);
        churu_text = findViewById(R.id.churu_text);
        icesu_text = findViewById(R.id.icesu_text);
        iceco_text = findViewById(R.id.iceco_text);
        iceba_text = findViewById(R.id.iceba_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
            money_text.setText(String.valueOf(value));
        }
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_B(View v){
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_M_D(View v){
        Intent goto_Kiosk_R_F_M_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Drink.class);
        goto_Kiosk_R_F_M_D.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_D);
    }

    public void money_plus(View view){
        switch (view.getId()) {
            case R.id.snacksan_lay:
                value+=3000;
                break;
            case R.id.snackshu_lay:
                value+=2300;
                break;
            case R.id.mcnurget_lay:
                value+=2900;
                break;
            case R.id.huri_lay:
                value+=2000;
                break;
            case R.id.hashbra_lay:
                value+=1300;
                break;
            case R.id.chickentender_lay:
                value+=1200;
                break;
            case R.id.chezstick_lay:
                value+=2500;
                break;
            case R.id.cuol_lay:
                value+=1900;
                break;
            case R.id.churu_lay:
                value+=1000;
                break;
            case R.id.icesu_lay:
                value+=2100;
                break;
            case R.id.iceco_lay:
                value+=2100;
                break;
            case R.id.iceba_lay:
                value+=1600;
                break;
        }
        money_text.setText(String.valueOf(value));
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        if (value != 0) {
            Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
            goto_Kiosk_R_F_P_R.putExtra("value", value);
            startActivity(goto_Kiosk_R_F_P_R);
        }
    }
}