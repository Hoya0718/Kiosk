package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_5 extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_5);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("지금까지 고른 버거의 항목들을 보여주는 화면입니다. 장바구니 추가 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
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

    public void goto_kiosk_06(View view) {
        tts.shutdown();
        Intent popup_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(popup_kiosk_06);
    }

    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }
}