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
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30_2);
        handler = new Handler();
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("결제 완료 창을 보여줍니다. 아래에 처방전이 나옵니다. 확인해주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("The payment completion window appears. Below you will see your prescription, please check it.");
                    }
                }
            }
        });


        new Handler().postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                tts.shutdown();
                if(getClass().getSimpleName().equals("Kiosk_30_2")) {
                    Intent goto_kiosk_31 = new Intent(getApplicationContext(), Kiosk_31.class);
                    startActivity(goto_kiosk_31);
                }
            }
        }, 15000);
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_31(View v){
        tts.shutdown();
        Intent goto_kiosk_31 = new Intent(this, Kiosk_31.class);
        startActivity(goto_kiosk_31);
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