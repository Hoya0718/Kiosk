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

public class Kiosk_R_Fastfood_Popup_Size extends AppCompatActivity {

    private int value;
    private int burger;
    private String burgerName;
    private String burgerSize;
    private byte[] burgerArray;

    private TextView burger_text;

    private Button set_Btn;
    private Button lar_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_size);

        burger_text = findViewById(R.id.burger_text);

        set_Btn = findViewById(R.id.set_Btn);
        lar_Btn = findViewById(R.id.lar_Btn);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");

            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
        }
    }

    public void goto_Kiosk_R_F_P_Sd(View view) {
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        goto_Kiosk_R_F_P_Sd.putExtra("value", value);

        switch (view.getId()) {

            case R.id.set_Btn:
                burgerSize = set_Btn.getText().toString();
                break;

            case R.id.lar_Btn:
                burger+=700;
                burgerSize = lar_Btn.getText().toString();
                break;

        }

        goto_Kiosk_R_F_P_Sd.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerImage", burgerArray);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerSize", burgerSize);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        Intent goto_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Set.class);
        goto_Kiosk_R_F_P_St.putExtra("value", value);

        goto_Kiosk_R_F_P_St.putExtra("burger", burger);
        goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_St.putExtra("burgerImage", burgerArray);
        startActivity(goto_Kiosk_R_F_P_St);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}