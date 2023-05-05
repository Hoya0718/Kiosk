package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("목적지는 알맞은지, 버스는 맞게 고르셨는지 확인하시고" +
                            "결제하기 버튼을 눌러서 결제를 해주세요." +
                            "만약 잘못 고르셨다면 취소하기 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);

                    button64 = findViewById(R.id.button64);
                    button65 = findViewById(R.id.button65);


                    button64.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_14.class);
                            startActivity(intent);
                        }
                    });

                    button65.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_22.class);
                            startActivity(intent);
                        }
                    });

                    textView37 = findViewById(R.id.textView37);
                    Intent intent = getIntent();
                    String destination = intent.getStringExtra("destination");
                    if (destination != null) {
                        textView37.setText(destination);
                    } else textView37.setText("도착 안함");

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