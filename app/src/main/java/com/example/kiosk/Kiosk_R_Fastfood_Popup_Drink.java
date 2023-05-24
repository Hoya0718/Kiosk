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

    private int value;
    private int burger;
    private int side;
    private int drink;
    private String burgerName;
    private String burgerSize;
    private String sideName;

    private TextView burger_text;
    private TextView size_text;
    private TextView side_text;

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
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_drink);

        burger_text = findViewById(R.id.burger_text);
        size_text = findViewById(R.id.size_text);
        side_text = findViewById(R.id.side_text);

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
            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerSize = intent.getStringExtra("burgerSize");
            side = intent.getIntExtra("side", 0);
            sideName = intent.getStringExtra("sideName");
            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
            if (burgerSize != null) {
                size_text.setText(burgerSize);
            }
            if (sideName != null) {
                side_text.setText(sideName);
            }
        }

        drink = 0;
    }

    public void goto_Kiosk_R_F_P_T(View view) {
        Intent goto_Kiosk_R_F_P_T = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Total.class);
        goto_Kiosk_R_F_P_T.putExtra("value", value);
        goto_Kiosk_R_F_P_T.putExtra("burger", burger);
        goto_Kiosk_R_F_P_T.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_T.putExtra("burgerSize", burgerSize);
        goto_Kiosk_R_F_P_T.putExtra("side", side);
        goto_Kiosk_R_F_P_T.putExtra("sideName", sideName);
        switch (view.getId()) {
            case R.id.chistr_lay:
                drink+=2000;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String chistr = chistr_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", chistr);
                break;
            case R.id.chijadu_lay:
                drink+=2000;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String chijadu = chijadu_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", chijadu);
                break;
            case R.id.drinkoran_lay:
                drink+=1600;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String drinkoran = drinkoran_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkoran);
                break;
            case R.id.shakestr_lay:
                drink+=2800;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String shakestr = shakestr_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", shakestr);
                break;
            case R.id.shakecho_lay:
                drink+=2800;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String shakecho = shakecho_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", shakecho);
                break;
            case R.id.shakeba_lay:
                drink+=2800;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String shakeba = shakeba_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", shakeba);
                break;
            case R.id.drinkcoca_lay:
                drink+=1700;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String drinkcoca = drinkcoca_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkcoca);
                break;
            case R.id.drinkcoze_lay:
                drink+=1700;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String drinkcoze = drinkcoze_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkcoze);
                break;
            case R.id.drinkspri_lay:
                drink+=1700;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String drinkspri = drinkspri_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkspri);
                break;
            case R.id.drinkhwan_lay:
                drink+=1700;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String drinkhwan = drinkhwan_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkhwan);
                break;
            case R.id.milk_lay:
                drink+=1600;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String milk = milk_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", milk);
                break;
            case R.id.water_lay:
                drink+=1300;
                goto_Kiosk_R_F_P_T.putExtra("drink", drink);
                String water = water_text.getText().toString();
                goto_Kiosk_R_F_P_T.putExtra("drinkName", water);
                break;
        }
        startActivity(goto_Kiosk_R_F_P_T);
    }

    public void goto_Kiosk_R_F_P_Sd(View view) {
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        goto_Kiosk_R_F_P_Sd.putExtra("value", value);
        goto_Kiosk_R_F_P_Sd.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerName", burgerSize);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }
}