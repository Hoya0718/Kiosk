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

public class Kiosk_28 extends AppCompatActivity {

    Handler handler = new Handler();
    private AnimationDrawable anim;
    private TextToSpeech tts;
    private myapp sound;

    private myapp text_size;

    private TextView hos_accept_txt;

    private Button hosb_1;
    private Button acceptance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk28);

        text_size = (myapp) getApplication();
        acceptance = findViewById(R.id.acceptance);
        sound = (myapp) getApplication();
        hosb_1 = findViewById(R.id.hosb_1);
        hos_accept_txt = findViewById(R.id.hos_accept_txt);

        hos_accept_txt.setTextSize(text_size.getId());
        hosb_1.setTextSize(text_size.getId());
        acceptance.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("이제 수납 및 처방을 알아볼까요? 수납 및 처방으로 처방전을 발행할 수 있어요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Now let's look at Receive and Prescribe. You can issue prescriptions with Receiving and Prescribing.");
                    }
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("수납 및 처방전 발행은 여기에 있어요.");
                else
                    speakText("Storage and prescriptions are here.");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        acceptance.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) acceptance.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_29(View v) {

        tts.shutdown();
        Intent goto_kiosk_29 = new Intent(getApplicationContext(), Kiosk_29.class);
        startActivity(goto_kiosk_29);
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