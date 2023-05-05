package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_12 extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk12);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("축하드립니다. 음식점 단계를 완료했습니다. 버스 단계로 넘어가세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    public void goto_kiosk_13(View v){
        tts.shutdown();
        Intent goto_kiosk_13 = new Intent(getApplicationContext(),Kiosk_13.class);
        startActivity(goto_kiosk_13);
    }
}