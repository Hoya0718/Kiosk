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
                    speakText("단품을 골랐을 때 나오는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen that appears when you select a single item." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.minus_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("감소");
                } else {
                    speakText("minus");
                }
                break;
            case R.id.count_text:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("개수");
                } else {
                    speakText("count");
                }
                break;
            case R.id.plus_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("추가");
                } else {
                    speakText("plus");
                }
                break;
            case R.id.cancel_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("취소");
                } else {
                    speakText("cancel");
                }
                break;
            case R.id.add_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("장바구니 추가");
                } else {
                    speakText("add");
                }
                break;
        }
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