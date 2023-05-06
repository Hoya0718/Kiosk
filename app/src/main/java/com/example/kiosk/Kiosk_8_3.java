package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_3 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_3);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        cancel = findViewById(R.id.cancel_Btn);

        cancel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("빅맥 세트가 선택되었습니다. 사이드 메뉴에서 후렌치 후라이를 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Big Mc set is selected. From the side menu, tap French Fries.");
                }
            }
        });
    }

    public void popup_kiosk_08_4(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void popup_kiosk_08_2(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_2 = new Intent(getApplicationContext(), Kiosk_8_2.class);
        startActivity(popup_kiosk_08_2);
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