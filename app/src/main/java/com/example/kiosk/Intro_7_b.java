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

public class Intro_7_b extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_b);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 메뉴를 고르는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to choose a burger menu." +
                            "You can hear the explanation of the menu by pressing the button on the screen." +
                            "For an explanation of the flow, please click the McDonald's logo button.");
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

            case R.id.b1955_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("일구오오버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.batodi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("베이컨 토마토 디럭스");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.bigmc_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("빅맥");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.mcchi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥치킨버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.mccri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥크리스피버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.quater_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("쿼터파운드 치즈 버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.sanhi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥스파이시 상하이 버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.susu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈슈버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.subi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈비버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.bulgogi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("불고기버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.cheeze_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("치즈버거");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.ham_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("햄버거");
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

    public void goto_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_06(View v){
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_intro_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_s = new Intent(getApplicationContext(), Intro_7_s.class);
        startActivity(goto_intro_kiosk_07_s);
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