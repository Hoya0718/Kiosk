package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_25 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private Button receipt;
    private Button acceptance;
    Handler handler = new Handler();

    private TextView hos_txt;
    private AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk25);
        text_size =(myapp)getApplication();
        receipt = findViewById(R.id.receipt_btn);
        acceptance = findViewById(R.id.acceptance_btn);
        hos_txt = findViewById(R.id.hos_txt);

        receipt.setTextSize(text_size.getId());
        acceptance.setTextSize(text_size.getId());
        hos_txt.setTextSize(text_size.getId());
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

        public void onInit(int status) {
            if (status != TextToSpeech.ERROR) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("병원 접수를 하기위해 보이는 창입니다. 접수하기를 눌러 병원접수를 할 수 있어요. 접수를 해볼까요?");
                } else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the window for making a medical intake. You can make an intake by tapping Submit. Let's do it.");
                }
            }
        }
    });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("접수하기는 여기에 있어요. 접수하기를 눌러보세요.");
                else
                    speakText("submission is here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        receipt.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) receipt.getBackground();
                        anim.start();
                    }
                }, 3000);
            }
        }, 10000);
    }

    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_26(View v){
            tts.shutdown();

        Intent goto_kiosk_26 = new Intent(getApplicationContext(),Kiosk_26.class);
        startActivity(goto_kiosk_26);
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