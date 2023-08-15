package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Intro_8_6 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_6);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 메뉴 화면으로 돌아왔습니다." +
                            "빅맥 세트가 주문 내역에 추가되어서 왼쪽 하단에 가격이 증가했습니다." +
                            "장바구니를 결제하기 위해서는 주문 내역 화면으로 가야합니다." +
                            "주문 내역 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("You have returned to the Burger Menu screen." +
                            "The Big Mc set has been added to your order history, so the price has increased in the bottom left corner." +
                            "You need to go to the order history screen to pay for the cart." +
                            "Please press the order history button.");
                }
            }
        });
    }

    public void popup_kiosk_08_6(View v){
        tts.shutdown();
        Intent popup_kiosk_08_6 = new Intent(getApplicationContext(), Kiosk_8_6.class);
        startActivity(popup_kiosk_08_6);
    }

    public void goto_intro_kiosk_08_5(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_5 = new Intent(getApplicationContext(), Intro_8_5.class);
        startActivity(goto_intro_kiosk_08_5);
    }

    public void goto_intro_kiosk_08_7(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_7 = new Intent(getApplicationContext(), Intro_8_7.class);
        startActivity(goto_intro_kiosk_08_7);
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