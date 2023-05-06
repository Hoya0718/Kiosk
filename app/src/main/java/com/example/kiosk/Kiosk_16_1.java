package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_16_1 extends AppCompatActivity {
    private String destination; //목적지
    private String bus;
    private String seat;
    private String price;
    private TextToSpeech tts;

    private Button button23; //ㅁ 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16_1);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("kr")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("버튼을 누르게 되면 그 지역에 있는 버스 정류장들이 나옵니다." +
                                    "이번에는 앞글자를 사용해서 찾아보겠습니다." +
                                    "ㅁ 버튼을 눌러보세요", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("When you press the button, the bus stops in that area appear." +
                                "This time, let's use the first letter to find it." +
                                "Please press the ㅁ button", TextToSpeech.QUEUE_FLUSH, null, null);
                    }

                    button23 = findViewById(R.id.button23);

                    button23.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16_1.this, Kiosk_17.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}


