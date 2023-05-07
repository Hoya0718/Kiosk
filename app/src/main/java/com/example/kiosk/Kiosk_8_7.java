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

public class Kiosk_8_7 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button desel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_7);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        desel = findViewById(R.id.desel_Btn);

        desel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("메뉴 추천 화면입니다." +
                            "더 이상 추가할 메뉴가 없으므로 선택 안함 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the menu recommendation screen." +
                            "There are no more menu items to add, so please press the Unselect button.");
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
                        desel.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) desel.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void goto_kiosk_09(View v){
        tts.shutdown();
        Intent goto_kiosk_09 = new Intent(getApplicationContext(),Kiosk_9.class);
        startActivity(goto_kiosk_09);
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