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

public class Kiosk_R_Fastfood_Main extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_main);

        myapp myApp = (myapp) getApplicationContext();
        if (myApp.getPracticeFastfoodCheck()) {
            myApp.setP_Time(System.currentTimeMillis());
        } else {
            myApp.setR_Time(System.currentTimeMillis());
        }

        value = 0;
    }

    public void goto_Kiosk_R_F_M_B(View v){
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Back(View v){
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Part.class);

        myapp myApp = (myapp) getApplicationContext();
        myApp.setCheckFastfoodMission("X");
        myApp.setMissionCheck(false);

        startActivity(goto_Back);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}