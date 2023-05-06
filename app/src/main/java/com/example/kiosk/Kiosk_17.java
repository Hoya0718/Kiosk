package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_17 extends AppCompatActivity {
    private String destination; //목적지
    private String bus;
    private String seat;
    private String price;
    private TextToSpeech tts;

    private Button button18; //마산 버튼
    private Button button20; //무안 버튼
    private Button button21; //무안공항 버튼
    private Button button22; //무주 버튼
    private Button button85; //마량 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk17);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("앞 글자가 ㅁ인 버스 정류장들이 나옵니다." +
                                "오른쪽의 주황색 버튼 중에서 가고 싶은 곳 버튼을 클릭해주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("Bus stops with the letter ㅁ in front appear." +
                                "From the orange buttons on the right, click the button where you want to go", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    button20 = findViewById(R.id.button20);
                    button18 = findViewById(R.id.button18);
                    button21 = findViewById(R.id.button21);
                    button22 = findViewById(R.id.button22);
                    button85 = findViewById(R.id.button85);

                    button20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "마산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button21.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안공항");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button22.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button85.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "마량");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}

