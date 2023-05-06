package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_28 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk28);

        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("이제 수납 및 처방을 알아볼까요? 수납 및 처방전 발행을 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Now let's take a look at receiving and prescribing. Tap Collections and prescriptions.");
                    }
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    tts.speak("수납 및 처방전 발행은 여기에 있어요.", TextToSpeech.QUEUE_FLUSH, null, null);
                else
                    tts.speak("Storage and prescriptions are here.", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 15000);

    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_29(View v) {

        tts.shutdown();
        Intent goto_kiosk_29 = new Intent(getApplicationContext(), Kiosk_29.class);
        startActivity(goto_kiosk_29);
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