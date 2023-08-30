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

public class Intro_8_2 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_2);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("세트의 크기를 물어보는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen asks for the size of the set." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.set_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("세트는 메인 음식, 사이드 메뉴, 음료가 함께 포함된 조합으로, 한 끼 식사에 필요한 모든 것을 편리하게 제공해요.");
                } else {
                    speakText("A set is a combination of a main dish, side menu, and beverage, conveniently providing everything you need for one meal.");
                }
                break;
            case R.id.lar_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("라지세트는 보다 풍성한 식사를 위해 세트에 추가로 더 큰 사이드와 음료가 포함돼 있어, 더 다양한 선택을 즐길 수 있어요.");
                } else {
                    speakText("The Large Set includes an additional larger side and drink in the set for a heartier meal, allowing you more options.");
                }
                break;
        }
    }

    public void popup_kiosk_08_2(View v){
        tts.shutdown();
        Intent popup_kiosk_08_2 = new Intent(getApplicationContext(), Kiosk_8_2.class);
        startActivity(popup_kiosk_08_2);
    }

    public void goto_intro_kiosk_08_1(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_1 = new Intent(getApplicationContext(), Intro_8_1.class);
        startActivity(goto_intro_kiosk_08_1);
    }

    public void goto_intro_kiosk_08_3(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_3 = new Intent(getApplicationContext(), Intro_8_3.class);
        startActivity(goto_intro_kiosk_08_3);
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