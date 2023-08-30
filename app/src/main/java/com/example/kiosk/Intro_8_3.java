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
                    speakText("세트 구성 중 사이드 메뉴를 고르는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to choose a side menu during set composition." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.huri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("후렌치 후라이는 바삭한 감자튀김으로, 입맛을 자극하는 간식이에요.");
                } else {
                    speakText("French Fries are crispy French fries that stimulate your taste buds.");
                }
                break;
            case R.id.cuol_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코울슬로는 신선한 채소와 드레싱으로 만든 상큼한 샐러드로, 건강한 선택이에요.");
                } else {
                    speakText("Coleslaw is a salad made with fresh vegetables and dressing, and is a refreshing and healthy choice.");
                }
                break;
            case R.id.chezstick_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("골든 모짜렐라 치즈스틱은 바삭한 외피와 녹아든 모짜렐라 치즈로, 부드럽고 고소한 간식이에요.");
                } else {
                    speakText("Golden Mozzarella Cheese Sticks are a soft, savory snack with a crispy skin and melted mozzarella cheese.");
                }
                break;
        }
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