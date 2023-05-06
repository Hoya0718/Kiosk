package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_18 extends AppCompatActivity {
    private TextToSpeech tts;
    private TextView textView18; // 목적지 텍스트 뷰

    private Button button17; //좌석 선택 버튼
    private Button button41; //좌석 선택 버튼
    private Button button42; //좌석 선택 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk18);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("kr")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("가고 싶은 곳을 고르셨나요?" +
                                "그럼 이제 버스 종류, 출발 시간을 보고" +
                                "타고 싶은 버스를 고르기 위해 좌석 선택 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("Have you chosen where you want to go? " +
                                "Then press the seat select button to see the bus type, " +
                                "departure time and select the bus you want to ride.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    Intent intent = getIntent();
                    String destination = intent.getStringExtra("destination");

                    //목적지 표시
                    textView18 = findViewById(R.id.textView18);
                    if (destination != null) {
                        textView18.setText(destination);
                    }

                    button17 = findViewById(R.id.button17);
                    button41 = findViewById(R.id.button41);
                    button42 = findViewById(R.id.button42);

                    button17.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            intent.putExtra("destination", destination);
                            intent.putExtra("bus", "우등버스");
                            intent.putExtra("price", "25,000원");
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });
                    button41.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            intent.putExtra("destination", destination);
                            intent.putExtra("bus", "고속버스");
                            intent.putExtra("price", "20,000원");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                    button42.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            intent.putExtra("destination", destination);
                            intent.putExtra("bus", "일반버스");
                            intent.putExtra("price", "15,000원");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}




