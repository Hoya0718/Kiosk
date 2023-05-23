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

    private TextView burger_text;
    private String intentString;
    private String intentInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_size);

        burger_text = findViewById(R.id.burger_text);

        Intent intent = getIntent();
        if (intent != null) {
            intentString = intent.getStringExtra("name");
            intentInt = intent.getStringExtra("value");
            if (intentString != null) {
                burger_text.setText(intentString);
            }
        }
    }

    public void goto_Kiosk_R_F_P_Sd(View view) {
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        Intent goto_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Set.class);
        startActivity(goto_Kiosk_R_F_P_St);
    }
}