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

public class Kiosk_R_Fastfood_Popup_Side extends AppCompatActivity {

    private int value;
    private int burger;
    private int side;
    private String burgerName;
    private String burgerSize;

    private TextView burger_text;
    private TextView size_text;

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
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_side);

        burger_text = findViewById(R.id.burger_text);
        size_text = findViewById(R.id.size_text);

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
            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerSize = intent.getStringExtra("burgerSize");
            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
            if (burgerSize != null) {
                size_text.setText(burgerSize);
            }
        }

        side = 0;
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        goto_Kiosk_R_F_P_D.putExtra("value", value);
        goto_Kiosk_R_F_P_D.putExtra("burger", burger);
        goto_Kiosk_R_F_P_D.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_D.putExtra("burgerSize", burgerSize);
        switch (view.getId()) {
            case R.id.snacksan_lay:
                side+=3000;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String snacksan = snacksan_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", snacksan);
                break;
            case R.id.snackshu_lay:
                side+=2300;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String snackshu = snackshu_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", snackshu);
                break;
            case R.id.mcnurget_lay:
                side+=2900;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String mcnurget = mcnurget_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", mcnurget);
                break;
            case R.id.huri_lay:
                side+=2000;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String huri = huri_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", huri);
                break;
            case R.id.hashbra_lay:
                side+=1300;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String hashbra = hashbra_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", hashbra);
                break;
            case R.id.chickentender_lay:
                side+=1200;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String chickentender = chickentender_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", chickentender);
                break;
            case R.id.chezstick_lay:
                side+=2500;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String chezstick = chezstick_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", chezstick);
                break;
            case R.id.cuol_lay:
                side+=1900;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String cuol = cuol_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", cuol);
                break;
            case R.id.churu_lay:
                side+=1000;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String churu = churu_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", churu);
                break;
            case R.id.icesu_lay:
                side+=2100;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String icesu = icesu_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", icesu);
                break;
            case R.id.iceco_lay:
                side+=2100;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String iceco = iceco_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", iceco);
                break;
            case R.id.iceba_lay:
                side+=1600;
                goto_Kiosk_R_F_P_D.putExtra("side", side);
                String iceba = iceba_text.getText().toString();
                goto_Kiosk_R_F_P_D.putExtra("sideName", iceba);
                break;
        }
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("value", value);
        goto_Kiosk_R_F_P_Sz.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerName", burgerName);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }
}