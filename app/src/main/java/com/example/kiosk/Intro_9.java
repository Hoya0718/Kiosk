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

public class Intro_9 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk09);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("주문 내역 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the order history screen." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.delete_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("선택한 항목을 제거하거나 삭제하는 동작으로, 주문 내역에서 해당 항목을 없앱니다.");
                } else {
                    speakText("An action to remove or delete the selected item, removing it from the order history.");
                }
                break;
            case R.id.minus_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("수량을 감소시키는 동작으로, 주문하는 양을 조절할 수 있습니다.");
                } else {
                    speakText("With the action of decreasing the quantity, you can adjust the amount you order.");
                }
                break;
            case R.id.count_text:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문할 상품의 개수를 나타내는 숫자입니다.");
                } else {
                    speakText("A number representing the number of products to be ordered.");
                }
                break;
            case R.id.plus_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("수량을 증가시키는 동작으로, 주문하는 양을 늘릴 수 있습니다.");
                } else {
                    speakText("With the action of increasing the quantity, you can increase the amount you order.");
                }
                break;
            case R.id.more_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("이미 주문한 내역에 더 많은 상품을 추가로 주문하고자 할 때 사용하는 동작입니다.");
                } else {
                    speakText("This action is used when you want to order more products in addition to what you have already ordered.");
                }
                break;
            case R.id.complete_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("모든 주문 과정을 마치고, 결제 화면으로 넘어갑니다.");
                } else {
                    speakText("After completing all ordering processes, proceed to the payment screen.");
                }
                break;
        }
    }

    public void goto_kiosk_09(View v){
        tts.shutdown();
        Intent goto_kiosk_09 = new Intent(getApplicationContext(), Kiosk_9.class);
        startActivity(goto_kiosk_09);
    }

    public void goto_intro_kiosk_08_7(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_7 = new Intent(getApplicationContext(), Intro_8_7.class);
        startActivity(goto_intro_kiosk_08_7);
    }

    public void goto_kiosk_10(View v){
        tts.shutdown();
        Intent goto_kiosk_10 = new Intent(getApplicationContext(), Kiosk_10.class);
        startActivity(goto_kiosk_10);
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