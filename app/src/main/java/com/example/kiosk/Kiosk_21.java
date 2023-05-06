package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Kiosk_21 extends AppCompatActivity {
    private String destination = "목적지"; //목적지
    private TextToSpeech tts;
    private TextView textView37; //목적지
    private TextView textView38; //버스종류, 좌석
    private TextView textView39; //표 가격
    private Button button64; //취소하기
    private Button button65; //결제하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk21);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("목적지는 맞게 골랐는지. 버스 종류와 좌석은 정확하게 골랐는지" +
                                " 확인해주시고, 맞게 고르셨다면 결제하기 버튼을 눌러주세요" +
                                "만약 잘못 고르셨다면 취소하기 버튼을 눌러서 " +
                                "이전 화면으로 돌아가실 수 있습니다.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("Make sure you have chosen the correct destination, bus type and seat" +
                                "If you have selected the right one, please click the checkout button" +
                                "If you make a mistake, you can click the Cancel button " +
                                "to return to the previous screen.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }

                    button64 = findViewById(R.id.button64);
                    button65 = findViewById(R.id.button65);

                    button64.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_14.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button65.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_22.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    textView37 = findViewById(R.id.textView37);
                    Intent intent = getIntent();
                    String destination = intent.getStringExtra("destination");
                    if(destination != null) {
                        textView37.setText(destination);
                    }

                    textView38 = findViewById(R.id.textView38);
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    Intent intent2 = getIntent();
                    String seat = intent2.getStringExtra("seat");
                    String busAndSeat = bus + "  /  " + seat;
                    if (seat != null) {
                        textView38.setText(busAndSeat);
                    }

                    textView39 = findViewById(R.id.textView39);
                    Intent intent3 = getIntent();
                    String price = intent3.getStringExtra("price");
                    if (price != null) {
                        textView39.setText(price);
                    }

                }
            }
        });
    }
}