package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Kiosk_11 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk11);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("카드를 그림과 같이 꽂아주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Insert the card as shown in the picture.");
                }
            }
        });
    }

    public void goto_kiosk_10(View v){
        tts.shutdown();
        Intent goto_kiosk_10 = new Intent(getApplicationContext(),Kiosk_10.class);
        startActivity(goto_kiosk_10);
    }

    public void goto_kiosk_12(View v){
        tts.shutdown();
        Intent goto_kiosk_12 = new Intent(getApplicationContext(),Kiosk_12.class);
        startActivity(goto_kiosk_12);
    }

    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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