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

public class Intro_7_d extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_d);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("음료 메뉴 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the drink menu screen." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.reco_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("추천메뉴");
                } else {
                    speakText("reco");
                }
                break;
            case R.id.burger_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.snack_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피스낵");
                } else {
                    speakText("happy-snack");
                }
                break;
            case R.id.side_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("사이드");
                } else {
                    speakText("side");
                }
                break;
            case R.id.coffee_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("커피");
                } else {
                    speakText("coffee");
                }
                break;
            case R.id.dessert_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("디저트");
                } else {
                    speakText("dessert");
                }
                break;
            case R.id.drink_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("음료");
                } else {
                    speakText("drink");
                }
                break;
            case R.id.meal_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피밀");
                } else {
                    speakText("happy-meal");
                }
                break;

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

            case R.id.ord_his_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문 내역");
                } else {
                    speakText("order history");
                }
                break;
        }
    }

    public void goto_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }

    public void goto_intro_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_s = new Intent(getApplicationContext(), Intro_7_s.class);
        startActivity(goto_intro_kiosk_07_s);
    }

    public void goto_intro_kiosk_08_1(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_1 = new Intent(getApplicationContext(), Intro_8_1.class);
        startActivity(goto_intro_kiosk_08_1);
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