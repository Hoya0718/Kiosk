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

public class Kiosk_R_Fastfood_Menu_Drink extends AppCompatActivity {

    private int value;
    private TextView money_text;

    private TextView chistr_text;
    private TextView chijadu_text;
    private TextView drinkoran_text;
    private TextView shakestr_text;
    private TextView shakecho_text;
    private TextView shakeba_text;
    private TextView drinkcoca_text;
    private TextView drinkcoze_text;
    private TextView drinkspri_text;
    private TextView drinkhwan_text;
    private TextView milk_text;
    private TextView water_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_drink);

        money_text = findViewById(R.id.money_text);

        chistr_text = findViewById(R.id.chistr_text);
        chijadu_text = findViewById(R.id.chijadu_text);
        drinkoran_text = findViewById(R.id.drinkoran_text);
        shakestr_text = findViewById(R.id.shakestr_text);
        shakecho_text = findViewById(R.id.shakecho_text);
        shakeba_text = findViewById(R.id.shakeba_text);
        drinkcoca_text = findViewById(R.id.drinkcoca_text);
        drinkcoze_text = findViewById(R.id.drinkcoze_text);
        drinkspri_text = findViewById(R.id.drinkspri_text);
        drinkhwan_text = findViewById(R.id.drinkhwan_text);
        milk_text = findViewById(R.id.milk_text);
        water_text = findViewById(R.id.water_text);

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

    public void goto_Kiosk_R_F_M_S(View v){
        Intent goto_Kiosk_R_F_M_S = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Side.class);
        goto_Kiosk_R_F_M_S.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_S);
    }

    public void money_plus(View view){
        switch (view.getId()) {
            case R.id.chistr_lay:
                value+=2000;
                break;
            case R.id.chijadu_lay:
                value+=2000;
                break;
            case R.id.drinkoran_lay:
                value+=1600;
                break;
            case R.id.shakestr_lay:
                value+=2800;
                break;
            case R.id.shakecho_lay:
                value+=2800;
                break;
            case R.id.shakeba_lay:
                value+=2800;
                break;
            case R.id.drinkcoca_lay:
                value+=1700;
                break;
            case R.id.drinkcoze_lay:
                value+=1700;
                break;
            case R.id.drinkspri_lay:
                value+=1700;
                break;
            case R.id.drinkhwan_lay:
                value+=1700;
                break;
            case R.id.milk_lay:
                value+=1600;
                break;
            case R.id.water_lay:
                value+=1300;
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