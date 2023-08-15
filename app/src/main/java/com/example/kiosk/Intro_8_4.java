package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Intro_8_4 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_4);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("후렌치 후라이가 선택되었습니다." +
                            "음료 메뉴에서 가장 인기있는 코카콜라를 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("French fries is selected." +
                            "Choose the most popular Coca-Cola from the drink menu.");
                }
            }
        });
    }

    public void popup_kiosk_08_4(View v){
        tts.shutdown();
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void goto_intro_kiosk_08_3(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_3 = new Intent(getApplicationContext(), Intro_8_3.class);
        startActivity(goto_intro_kiosk_08_3);
    }

    public void goto_intro_kiosk_08_5(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_5 = new Intent(getApplicationContext(), Intro_8_5.class);
        startActivity(goto_intro_kiosk_08_5);
    }

    private void speakText(String text) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }

    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}