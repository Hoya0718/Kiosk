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

public class Kiosk_8_4 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    private TextView coca_text;
    private TextView coca_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_4);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        cancel = findViewById(R.id.cancel_Btn);

        cancel.setTextSize(text_size.getId());

        coca_text = findViewById(R.id.coca_text);
        coca_price = findViewById(R.id.coca_price);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("후렌치 후라이가 선택되었습니다. 음료 메뉴에서 코카콜라를 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("French fries were selected. Please choose Coca-Cola from the drink menu.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("코카콜라는 여기에 있어요.");
                else
                    speakText("Coca-Cola is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        coca_text.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) coca_text.getBackground();
                        anim.start();

                        coca_price.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) coca_price.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void popup_kiosk_08_5(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_5 = new Intent(getApplicationContext(), Kiosk_8_5.class);
        startActivity(popup_kiosk_08_5);
    }

    public void popup_kiosk_08_3(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_3 = new Intent(getApplicationContext(), Kiosk_8_3.class);
        startActivity(popup_kiosk_08_3);
    }

    private void speakText(String text) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
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