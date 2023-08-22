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
                    speakText("추천메뉴에는 맥도날드의 대표적이고 맛있는 메뉴들로 구성된 선택 목록이 있습니다.");
                } else {
                    speakText("reco");
                }
                break;
            case R.id.burger_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("버거는 다양한 종류의 신선한 재료로 만든 햄버거로, 빅맥, 치즈버거 등이 포함됩니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.snack_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피스낵은 작은 사이즈의 간식 메뉴로, 감자튀김 등이 포함되어 있습니다.");
                } else {
                    speakText("happy-snack");
                }
                break;
            case R.id.side_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("사이드는 부가적인 음식 메뉴로, 샐러드나 감자튀김 등이 포함됩니다.");
                } else {
                    speakText("side");
                }
                break;
            case R.id.coffee_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("커피는 다양한 종류의 커피 음료로, 아메리카노, 라떼 등이 준비되어 있습니다.");
                } else {
                    speakText("coffee");
                }
                break;
            case R.id.dessert_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("디저트는 달콤한 음식으로, 아이스크림, 파이 등이 제공됩니다.");
                } else {
                    speakText("dessert");
                }
                break;
            case R.id.drink_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("음료는 다양한 음료수 메뉴로, 소다, 주스, 커피 등이 포함되어 있습니다.");
                } else {
                    speakText("drink");
                }
                break;
            case R.id.meal_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피밀은 아침 식사 메뉴로, 미니 머핀 등 신선한 아침 음식이 제공됩니다.");
                } else {
                    speakText("happy-meal");
                }
                break;

            case R.id.snacksan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("상하이 치킨 스낵랩은 바삭한 피짜 치킨과 신선한 채소가 들어간 간식으로, 매콤한 소스가 특징입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.snackshu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈림프 스낵랩은 슈림프와 신선한 채소가 들어간 간식으로, 매콤한 소스가 특징입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.mcnurget_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥너겟은 고소한 닭고기로 만든 작고 바삭한 고기볼로, 부담없이 즐길 수 있는 간식입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.huri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("후렌치 후라이는 바삭한 감자튀김으로, 입맛을 자극합니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.hashbra_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해쉬 브라운은 감자 튀김 토마토 맛으로, 입맛을 자극합니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chickentender_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥스파이시 치킨 텐더는 매콤한 햄버거, 닭고기 텐더로, 풍부한 맛과 텍스처가 특징입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.chezstick_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("골든 모짜렐라 치즈스틱은 바삭한 외피와 녹아든 모짜렐라 치즈로, 부드럽고 고소한 간식입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.cuol_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코울슬로는 신선한 채소와 드레싱으로 만든 샐러드로, 상큼하면서도 건강한 선택입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.churu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("츄러스는 바삭한 외피와 부드러운 속으로, 달콤하게 맛볼 수 있는 디저트입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.icesu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 선데이 아이스크림는 상큼한 딸기와 부드러운 아이스크림으로 만든 간단한 디저트로, 달콤한 맛이 일품입니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.iceco_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 선데이 아이스크림는 풍부한 초콜릿 소스와 바닐라 아이스크림이 어우러져 달콤하고 진한 디저트를 이룹니다.");
                } else {
                    speakText("burger");
                }
                break;
            case R.id.iceba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 선데이 아이스크림는 부드러운 바닐라 아이스크림과 달콤한 시럽, 훈제 아몬드가 조화를 이룬 맛깔나는 디저트입니다.");
                } else {
                    speakText("burger");
                }
                break;

            case R.id.ord_his_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문 내역은 주문한 음식과 메뉴에 대한 정보를 확인할 수 있는 기능을 제공합니다.");
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