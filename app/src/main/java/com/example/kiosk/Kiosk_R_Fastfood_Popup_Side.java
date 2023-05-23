package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Side extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    private TextView french_text;
    private TextView french_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_3);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        cancel = findViewById(R.id.cancel_Btn);

        cancel.setTextSize(text_size.getId());

        french_text = findViewById(R.id.french_text);
        french_price = findViewById(R.id.french_price);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("빅맥 세트가 선택되었습니다. 사이드 메뉴에서 후렌치 후라이를 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Big Mc set was selected. Choose French fries from the side menu.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("후렌치 후라이는 여기에 있어요.");
                else
                    speakText("French fries is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        french_text.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) french_text.getBackground();
                        anim.start();

                        french_price.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) french_price.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        startActivity(goto_Kiosk_R_F_P_Sz);
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