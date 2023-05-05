package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_16 extends AppCompatActivity {

    private TextToSpeech tts;

    private Button button_seoul; // 서울

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("서울 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, null);

                    button_seoul = findViewById(R.id.button_seoul);
                    button_seoul.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_16_1.class);
                            startActivity(intent);
                        }

                    });
                }
            }
        });
    }
}

