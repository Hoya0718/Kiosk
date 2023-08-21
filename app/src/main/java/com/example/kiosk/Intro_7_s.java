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

public class Intro_7_s extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_s);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("사이드 메뉴 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the side menu screen." +
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

            case R.id.snacksan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("상하이 치킨 스낵랩");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.snackshu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈림프 스낵랩");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.mcnurget_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥너겟");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.huri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("후렌치 후라이");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.hashbra_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해쉬 브라운");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chickentender_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥스파이시 치킨 텐더");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chezstick_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("골든 모짜렐라 치즈스틱");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.cuol_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코울슬로");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.churu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("츄러스");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.icesu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 선데이 아이스크림");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.iceco_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 선데이 아이스크림");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.iceba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 선데이 아이스크림");
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

    public void goto_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void goto_intro_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_b = new Intent(getApplicationContext(), Intro_7_b.class);
        startActivity(goto_intro_kiosk_07_b);
    }

    public void goto_intro_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_d = new Intent(getApplicationContext(), Intro_7_d.class);
        startActivity(goto_intro_kiosk_07_d);
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