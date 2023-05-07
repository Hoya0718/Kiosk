package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_2 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button set;
    private Button large;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_2);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        set = findViewById(R.id.set_Btn);
        large = findViewById(R.id.lar_Btn);
        cancel = findViewById(R.id.cancel_Btn);

        set.setTextSize(text_size.getId());
        large.setTextSize(text_size.getId());
        cancel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("세트의 크기를 물어보는 화면입니다. 세트 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen asks for the size of the set. Please press the set button.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("버튼은 여기에 있어요.");
                else
                    speakText("Button is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        set.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) set.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void popup_kiosk_08_3(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_3 = new Intent(getApplicationContext(), Kiosk_8_3.class);
        startActivity(popup_kiosk_08_3);
    }

    public void popup_kiosk_08_1(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_1 = new Intent(getApplicationContext(), Kiosk_8_1.class);
        startActivity(popup_kiosk_08_1);
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