package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_R_Bus_Congratulations extends AppCompatActivity {
    private Button b_backbegin_btn; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_congratulations);

        b_backbegin_btn = findViewById(R.id.b_backbegin_btn);



        b_backbegin_btn = findViewById(R.id.b_backbegin_btn);
        b_backbegin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Congratulations.this, Kiosk_R_Part.class);
                startActivity(intent);
            }

        });

    }
}

