package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_5 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;
    private myapp text_size;
    private Button fastfood;
    private Button bus;
    private Button hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk05);
        text_size = (myapp) getApplication();
        fastfood = findViewById(R.id.fastfood_btn);
        bus = findViewById(R.id.bus_btn);
        hospital = findViewById(R.id.hospital_btn);

        fastfood.setTextSize(text_size.getId());
        bus.setTextSize(text_size.getId());
        hospital.setTextSize(text_size.getId());

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    tts.speak("음식점 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    tts.speak("Press the restaurant button.", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    public void goto_kiosk_06(View v) {
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_14(View v){
        tts.shutdown();
        Intent goto_kiosk_14 = new Intent(getApplicationContext(),Kiosk_14.class);
        startActivity(goto_kiosk_14);
    }

    public void goto_kiosk_25(View v){
        tts.shutdown();
        Intent goto_kiosk_25 = new Intent(getApplicationContext(),Kiosk_25.class);
        startActivity(goto_kiosk_25);
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