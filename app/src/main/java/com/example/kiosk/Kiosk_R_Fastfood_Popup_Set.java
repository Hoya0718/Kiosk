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

public class Kiosk_R_Fastfood_Popup_Set extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button set;
    private Button sig;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    private String intentString;
    private String intentInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_set);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        set = findViewById(R.id.set_Btn);
        sig = findViewById(R.id.sig_Btn);
        cancel = findViewById(R.id.cancel_Btn);

        set.setTextSize(text_size.getId());
        sig.setTextSize(text_size.getId());
        cancel.setTextSize(text_size.getId());

        Intent intent = getIntent();
        if (intent != null) {
            intentString = intent.getStringExtra("name");
            intentInt = intent.getStringExtra("value");
        }

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("세트 메뉴 여부를 물어보는 화면입니다. 세트 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen asks for a set menu. Please press the Set button.");
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

    public void goto_Kiosk_R_F_P_Sz(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("name", intentString);
        goto_Kiosk_R_F_P_Sz.putExtra("value", intentInt);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }

    public void goto_Kiosk_R_F_M_Bp(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_M_Bp = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        startActivity(goto_Kiosk_R_F_M_Bp);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        startActivity(goto_Kiosk_R_F_M_B);
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