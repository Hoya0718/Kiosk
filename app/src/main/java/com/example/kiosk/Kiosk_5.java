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

public class Kiosk_5 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button fastfood;
    private Button bus;
    private Button hospital;
    private Button samuso_btn;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk05);

        anim = new AnimationDrawable();

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        fastfood = findViewById(R.id.fastfood_btn);
        bus = findViewById(R.id.bus_btn);
        hospital = findViewById(R.id.hospital_btn);
        samuso_btn = findViewById(R.id.samuso_btn);

        fastfood.setTextSize(text_size.getId());
        bus.setTextSize(text_size.getId());
        hospital.setTextSize(text_size.getId());
        samuso_btn.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("다양한 키오스크의 상황을 지원합니다. 어떤 상황을 연습할지 골라보세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Press the button you want.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("네 개의 상황 중 하나를 골라보세요.");
                else
                    speakText("Button is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fastfood.setBackgroundResource(R.drawable.anim_list_degree);
                        anim = (AnimationDrawable) fastfood.getBackground();
                        anim.start();
                        bus.setBackgroundResource(R.drawable.anim_list_degree);
                        anim = (AnimationDrawable) bus.getBackground();
                        anim.start();
                        hospital.setBackgroundResource(R.drawable.anim_list_degree);
                        anim = (AnimationDrawable) hospital.getBackground();
                        anim.start();
                        samuso_btn.setBackgroundResource(R.drawable.anim_list_degree);
                        anim = (AnimationDrawable) samuso_btn.getBackground();
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
        Intent goto_kiosk_25 = new Intent(getApplicationContext(),Hospital_Main.class);
        startActivity(goto_kiosk_25);
    }
    public void goto_Kiosk_Main(View v){
        tts.shutdown();
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
    }
    public void goto_Back(View v){
        tts.shutdown();
        Intent goto_Back = new Intent(getApplicationContext(),Kiosk_3.class);
        startActivity(goto_Back);
    }
    public void goto_P_TO(View v){
        Intent goto_P_TO = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_P_TO);
    }

    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        //
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