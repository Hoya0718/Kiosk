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

public class Intro_8_3 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_3);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("빅맥 세트가 선택되었습니다." +
                            "이제 사이드 메뉴와 음료만 고르면 됩니다." +
                            "사이드 메뉴에서 가장 인기있는 후렌치 후라이를 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Big Mc set is selected." +
                            "Now I just have to choose a side menu and a drink." +
                            "Choose the most popular French fries from the side menu.");
                }
            }
        });
    }

    public void popup_kiosk_08_3(View v){
        tts.shutdown();
        Intent popup_kiosk_08_3 = new Intent(getApplicationContext(), Kiosk_8_3.class);
        startActivity(popup_kiosk_08_3);
    }

    public void goto_intro_kiosk_08_2(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_2 = new Intent(getApplicationContext(), Intro_8_2.class);
        startActivity(goto_intro_kiosk_08_2);
    }

    public void goto_intro_kiosk_08_4(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_4 = new Intent(getApplicationContext(), Intro_8_4.class);
        startActivity(goto_intro_kiosk_08_4);
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