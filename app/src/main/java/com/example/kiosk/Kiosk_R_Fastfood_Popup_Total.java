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

public class Kiosk_R_Fastfood_Popup_Total extends AppCompatActivity {

    private int value;
    private int burger;
    private int side;
    private int drink;
    private int total;
    private String burgerName;
    private String burgerSize;
    private String sideName;
    private String drinkName;

    private TextView burger_text;
    private TextView size_text;
    private TextView total_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_total);

        burger_text = findViewById(R.id.burger_text);
        size_text = findViewById(R.id.size_text);
        total_text = findViewById(R.id.total_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerSize = intent.getStringExtra("burgerSize");
            side = intent.getIntExtra("side", 0);
            sideName = intent.getStringExtra("sideName");
            drink = intent.getIntExtra("drink", 0);
            drinkName = intent.getStringExtra("drinkName");
            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
            if (burgerSize != null) {
                size_text.setText(burgerSize);
            }
            total = burger + side + drink;
            total_text.setText(String.valueOf(total));
        }
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        goto_Kiosk_R_F_P_D.putExtra("value", value);
        goto_Kiosk_R_F_P_D.putExtra("burger", burger);
        goto_Kiosk_R_F_P_D.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_D.putExtra("burgerName", burgerSize);
        goto_Kiosk_R_F_P_D.putExtra("side", side);
        goto_Kiosk_R_F_P_D.putExtra("sideName", sideName);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        value += total;
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }
}