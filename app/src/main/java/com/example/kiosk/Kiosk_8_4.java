package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_4 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_4);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        cancel = findViewById(R.id.cancel_Btn);

        cancel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("후렌치 후라이가 선택되었습니다. 음료 메뉴에서 코카콜라를 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("French Fries is selected. From the drink menu, tap Coca-Cola.");
                }
            }
        });
    }

    public void popup_kiosk_08_5(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_5 = new Intent(getApplicationContext(), Kiosk_8_5.class);
        startActivity(popup_kiosk_08_5);
    }

    public void popup_kiosk_08_3(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_3 = new Intent(getApplicationContext(), Kiosk_8_3.class);
        startActivity(popup_kiosk_08_3);
    }

    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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