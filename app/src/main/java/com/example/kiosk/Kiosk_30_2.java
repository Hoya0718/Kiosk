package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_30_2 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30_2);

        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("결제 완료 창을 보여줍니다. 아래에 처방전이 나옵니다. 확인해주세요");
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goto_kiosk_31 = new Intent(getApplicationContext(), Kiosk_31.class);
                startActivity(goto_kiosk_31);
            }
        }, 15000);
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_31(View v){
        Intent goto_kiosk_31 = new Intent(this, Kiosk_31.class);
        startActivity(goto_kiosk_31);
    }
}