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

public class Intro_8_1 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_1);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("빅맥이 선택되었습니다." +
                            "이 화면은 세트 메뉴 여부를 물어보는 화면입니다." +
                            "세트 메뉴를 고르면 사이드 메뉴와 음료를 값싸게 먹을 수 있습니다." +
                            "단품은 사이드 메뉴와 음료 없이 햄버거만 나와요." +
                            "세트 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Big Mc is selected." +
                            "This screen asks whether or not you want a set menu." +
                            "If you choose the set menu, you can get a cheap side menu and drinks." +
                            "Single item only comes with hamburgers, no side menus and no drinks." +
                            "Please press the set button.");
                }
            }
        });
    }

    public void popup_kiosk_08_1(View v){
        tts.shutdown();
        Intent popup_kiosk_08_1 = new Intent(getApplicationContext(), Kiosk_8_1.class);
        startActivity(popup_kiosk_08_1);
    }

    public void goto_intro_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_d = new Intent(getApplicationContext(), Intro_7_d.class);
        startActivity(goto_intro_kiosk_07_d);
    }

    public void goto_intro_kiosk_08_2(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_2 = new Intent(getApplicationContext(), Intro_8_2.class);
        startActivity(goto_intro_kiosk_08_2);
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