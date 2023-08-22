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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Intro_8_7 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_7);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("메뉴 추천 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the menu recommendation screen." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.snackshu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈림프 스낵랩은 슈림프와 신선한 채소가 들어간 간식으로, 매콤한 소스가 특징입니다.");
                } else {
                    speakText("shup");
                }
                break;
            case R.id.mcnurget_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥너겟은 고소한 닭고기로 만든 작고 바삭한 고기볼로, 부담없이 즐길 수 있는 간식입니다.");
                } else {
                    speakText("mcnurget");
                }
                break;
            case R.id.desel_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("추천 메뉴 중 아무것도 선택하지 않을 때 사용되는 옵션입니다.");
                } else {
                    speakText("deselect");
                }
                break;
        }
    }

    public void popup_kiosk_08_7(View v){
        tts.shutdown();
        Intent popup_kiosk_08_7 = new Intent(getApplicationContext(), Kiosk_8_7.class);
        startActivity(popup_kiosk_08_7);
    }

    public void goto_intro_kiosk_08_6(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_6 = new Intent(getApplicationContext(), Intro_8_6.class);
        startActivity(goto_intro_kiosk_08_6);
    }

    public void goto_intro_kiosk_09(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_09 = new Intent(getApplicationContext(), Intro_9.class);
        startActivity(goto_intro_kiosk_09);
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