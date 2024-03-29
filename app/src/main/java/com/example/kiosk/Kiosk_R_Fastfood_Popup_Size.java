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
    private byte[] burgerArray;

    private TextView askMission;
    private TextView showMission;
    private TextView burger_text;
    private TextView set_text;
    private TextView lar_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_size);

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());
        askMission = findViewById(R.id.askMission);

        if (showMission.getText().toString().equals(" ")) {
            askMission.setText(" ");
        }

        burger_text = findViewById(R.id.burger_text);

        set_text = findViewById(R.id.set_text);
        lar_text = findViewById(R.id.lar_text);

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
                burgerName += " - " + set_text.getText().toString();
                break;

            case R.id.lar_Btn:
                burger+=700;
                burgerName += " - " + lar_text.getText().toString();
                break;

        }

        goto_Kiosk_R_F_P_Sd.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerImage", burgerArray);
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