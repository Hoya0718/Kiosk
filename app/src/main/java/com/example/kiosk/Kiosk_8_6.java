package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_6 extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_6);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("안녕", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    public void popup_kiosk_08_7(View view) {
        Intent popup_kiosk_08_7 = new Intent(getApplicationContext(), Kiosk_8_7.class);
        startActivity(popup_kiosk_08_7);
    }

    public void goto_kiosk_06(View view) {
        Intent popup_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(popup_kiosk_06);
    }
}