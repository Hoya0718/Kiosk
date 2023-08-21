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
                    speakText("세트 구성 중 음료를 고르는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to select drinks during set composition." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.drinkcoca_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코카콜라");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.drinkspri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("스프라이트");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.drinkhwan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("환타");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.drinkcoze_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코카콜라제로");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chistr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 칠러");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chijadu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("자두 칠러");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.shakestr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 쉐이크");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.shakecho_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 쉐이크");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.shakeba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 쉐이크");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.drinkoran_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("오렌지쥬스");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.milk_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("우유");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.water_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("생수");
                } else {
                    speakText("burger");
                }
                break;
        }
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