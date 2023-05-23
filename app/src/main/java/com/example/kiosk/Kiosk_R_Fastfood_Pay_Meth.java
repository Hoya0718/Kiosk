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

public class Kiosk_R_Fastfood_Pay_Meth extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button card;
    private Button cert;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_pay_meth);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        card = findViewById(R.id.card_Btn);
        cert = findViewById(R.id.cert_Btn);
        cancel = findViewById(R.id.cancel_Btn);

        card.setTextSize(text_size.getId());
        cert.setTextSize(text_size.getId());
        cancel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("결제 방법을 선택하는 화면입니다." +
                            "카드 결제 버튼를 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to select a payment method." +
                            "Please press the credit card payment button.");
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
                        card.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) card.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void goto_Kiosk_F_R_O_H(View v){
        tts.shutdown();
        Intent goto_Kiosk_F_R_O_H = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Order_Hist.class);
        startActivity(goto_Kiosk_F_R_O_H);
    }

    public void goto_Kiosk_F_R_P(View v){
        tts.shutdown();
        Intent goto_Kiosk_F_R_P = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Pay.class);
        startActivity(goto_Kiosk_F_R_P);
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