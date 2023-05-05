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
                    tts.speak("목적지를 찾을 수 있는 방법은 다양합니다." +
                            "지역에 맞게 찾을 수 있고, 앞 글자를 검색할 수 있습니다." +
                            "우선 서울 버튼을 눌러보세요.", TextToSpeech.QUEUE_FLUSH, null, null);

                    button_seoul = findViewById(R.id.button_seoul);
                    button_seoul.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_16_1.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });
                }
            }
        });
    }
}

