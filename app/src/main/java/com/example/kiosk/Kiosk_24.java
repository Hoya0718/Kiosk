package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_24 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private Button fastfood;
    private Button bus;
    private Button hospital;

    Handler handler = new Handler();
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk24);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        fastfood = findViewById(R.id.fastfood_btn);
        bus = findViewById(R.id.bus_btn);
        hospital = findViewById(R.id.hospital_btn);

        fastfood.setTextSize(text_size.getId());
        bus.setTextSize(text_size.getId());
        hospital.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("병원에 있는 키오스크를 교육하는 단계입니다. 병원 버튼을 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("To train a kiosk in a hospital, press the Hospital button.");
                    }
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("병원은 여기에있어요.");
                else
                    speakText("Hospital is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hospital.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) hospital.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
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

    public void goto_Kiosk_Main(View v){
        tts.shutdown();
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
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
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}