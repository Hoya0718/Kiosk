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

    public void goto_Kiosk_F_R_P_T(View v){
        Intent goto_Kiosk_R_F_P_T = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Pay_Table.class);
        goto_Kiosk_R_F_P_T.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_P_T);
    }

    public void goto_Kiosk_R_F_P(View v){
        Intent goto_Kiosk_R_F_P = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Pay.class);
        goto_Kiosk_R_F_P.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_P);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}