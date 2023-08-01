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

public class Kiosk_8_5 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_5);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("지금까지 고른 버거의 항목들을 보여주는 화면입니다." +
                            "빅맥 세트가 추가되었습니다." +
                            "빅맥 세트의 구성은 빅맥, 후렌치 후라이, 코카콜라로 세팅되었습니다." +
                            "이 화면에서는 고른 메뉴의 수량을 조절할 수 있습니다." +
                            "취소 버튼을 누르면 이전 화면으로 가고," +
                            "장바구니 추가 버튼을 누르면 상단의 메뉴가 주문 내역에 추가됩니다." +
                            "장바구니 추가 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen shows the items of the burgers you've selected so far." +
                            "The Big Mc set has been added." +
                            "The Big Mc set consists of a Big Mc, French fries, and Coca-Cola." +
                            "On this screen, you can adjust the quantity of the selected menu." +
                            "If you press the cancel button, you go to the previous screen," +
                            "and if you press the add to cart button, the menu at the top is added to your order history." +
                            "Please press the Add to Cart button.");
                }
            }
        });
    }

    public void popup_kiosk_08_4(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void popup_kiosk_08_6(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_6 = new Intent(getApplicationContext(), Kiosk_8_6.class);
        startActivity(popup_kiosk_08_6);
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