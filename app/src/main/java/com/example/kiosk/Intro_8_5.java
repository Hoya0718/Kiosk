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

public class Intro_8_5 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk08_5);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("고른 메뉴의 수량을 조절하는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is a screen to adjust the quantity of the selected menu." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.show_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("제품에 대한 자세한 정보와 설명을 확인할 수 있는 정보입니다.");
                } else {
                    speakText("This is information where you can find more details and explanations about the product.");
                }
                break;
            case R.id.minus_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("수량을 줄이는 동작으로, 주문 양을 조절할 수 있어요.");
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
                    speakText("수량을 늘리는 동작으로, 주문 양을 늘릴 수 있어요.");
                } else {
                    speakText("With the action of increasing the quantity, you can increase the amount you order.");
                }
                break;
            case R.id.cancel_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문하려는 내용을 변경하거나 취소할 때 사용하는 동작입니다.");
                } else {
                    speakText("This action is used when canceling or changing the contents of an order.");
                }
                break;
            case R.id.add_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("선택한 상품을 장바구니에 담아 나중에 한 번에 주문할 수 있도록 준비해요.");
                } else {
                    speakText("Place the selected products in your shopping cart, ready to be ordered at a later time.");
                }
                break;
        }
    }

    public void popup_kiosk_08_5(View v){
        tts.shutdown();
        Intent popup_kiosk_08_5 = new Intent(getApplicationContext(), Kiosk_8_5.class);
        startActivity(popup_kiosk_08_5);
    }

    public void goto_intro_kiosk_08_4(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_4 = new Intent(getApplicationContext(), Intro_8_4.class);
        startActivity(goto_intro_kiosk_08_4);
    }

    public void goto_intro_kiosk_08_6(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_6 = new Intent(getApplicationContext(), Intro_8_6.class);
        startActivity(goto_intro_kiosk_08_6);
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