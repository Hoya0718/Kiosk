package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_24 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk24);

        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                tts.speak("병원 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 3000);

    }
    public void goto_kiosk_25(View v){

        tts.shutdown();

        Intent goto_kiosk_25 = new Intent(getApplicationContext(),Kiosk_25.class);
        startActivity(goto_kiosk_25);
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }
}