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
                    speakText("코카콜라는 캐러멜 풍미의 대표적인 탄산음료입니다.");
                } else {
                    speakText("Coca-Cola is a typical carbonated soft drink with a caramel flavor.");
                }
                break;
            case R.id.drinkspri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("스프라이트는 상쾌한 레몬-라임 맛의 탄산음료입니다.");
                } else {
                    speakText("Sprite is a refreshing lemon-lime flavored soda.");
                }
                break;
            case R.id.drinkhwan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("환타는 풍부한 오렌지 향의 탄산음료입니다.");
                } else {
                    speakText("Fanta is a carbonated soft drink with a rich orange flavor.");
                }
                break;
            case R.id.drinkcoze_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코카콜라제로는 칼로리가 없는 버전의 코카콜라로, 시원하면서도 가벼운 선택지입니다.");
                } else {
                    speakText("Coca-Cola Zero is a calorie-free version of Coca-Cola, a cool, lightweight option.");
                }
                break;
            case R.id.chistr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 칠러는 과일 향기와 시원함이 어우러진 음료로, 딸기의 풍부한 맛을 즐길 수 있습니다.");
                } else {
                    speakText("Strawberry chiller is a drink with a fruity aroma and coolness, " +
                            "allowing you to enjoy the rich taste of strawberries.");
                }
                break;
            case R.id.chijadu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("자두 칠러는 과일 향기와 시원함이 어우러진 음료로, 자두의 풍부한 맛을 즐길 수 있습니다.");
                } else {
                    speakText("Plum chiller is a drink with a fruity aroma and coolness, " +
                            "allowing you to enjoy the rich taste of plums.");
                }
                break;
            case R.id.shakestr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 쉐이크는 부드럽고 크리미한 맛의 딸기 밀크쉐이크입니다.");
                } else {
                    speakText("Strawberry Shake is a strawberry milkshake with a smooth and creamy taste.");
                }
                break;
            case R.id.shakecho_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 쉐이크는 부드럽고 크리미한 맛의 초코 밀크쉐이크입니다.");
                } else {
                    speakText("Choco Shake is a chocolate milkshake with a smooth and creamy taste.");
                }
                break;
            case R.id.shakeba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 쉐이크는 부드럽고 크리미한 맛의 바닐라 밀크쉐이크입니다.");
                } else {
                    speakText("Vanilla Shake is a smooth and creamy vanilla milkshake.");
                }
                break;
            case R.id.drinkoran_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("신선한 오렌지로 만든 상큼한 주스로, 비타민 C를 함유하며 건강한 선택입니다.");
                } else {
                    speakText("Refreshing juice made from fresh oranges, packed with vitamin C and a healthy choice.");
                }
                break;
            case R.id.milk_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("고소하고 영양가 있는 우유로, 다양한 음식과 함께 즐길 수 있습니다.");
                } else {
                    speakText("It is nutritious and nutritious milk, and can be enjoyed with a variety of foods.");
                }
                break;
            case R.id.water_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("깨끗하고 청량한 물로, 목마를 해소할 수 있는 선택지입니다.");
                } else {
                    speakText("It is an option to relieve thirst with clean and refreshing water.");
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