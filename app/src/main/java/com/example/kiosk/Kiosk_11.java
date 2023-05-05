package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_11 extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk11);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("안녕", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    public void goto_kiosk_10(View v){
        Intent goto_kiosk_10 = new Intent(getApplicationContext(),Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }

    public void goto_kiosk_12(View v){
        Intent goto_kiosk_12 = new Intent(getApplicationContext(),Kiosk_12.class);
        startActivity(goto_kiosk_12);
    }
}