package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_13 extends AppCompatActivity {
    private int currentVolume;
    private AudioManager audioManager;

    private TextToSpeech tts;
    private myapp sound;
    private AnimationDrawable anim;

    private myapp text_size;
    private Button fastfood_btn;
    private Button bus_btn;
    private Button hospital_btn;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk13);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        fastfood_btn = findViewById(R.id.fastfood_btn);
        bus_btn = findViewById(R.id.bus_btn);
        hospital_btn = findViewById(R.id.hospital_btn);

        fastfood_btn.setTextSize(text_size.getId());
        bus_btn.setTextSize(text_size.getId());
        hospital_btn.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("이번에는 버스 키오스크에 대해 배워보도록 하겠습니다." +
                            "버스 버튼을 눌러주세요");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This time, let's learn about bus kiosks." +
                            "Press the bus button.");
                }
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("버스 버튼은 여기에 있어요.");
                else
                    speakText("Bus button is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bus_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) bus_btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 7000);
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