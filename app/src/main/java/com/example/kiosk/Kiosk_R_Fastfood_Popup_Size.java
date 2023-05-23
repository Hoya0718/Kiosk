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

public class Kiosk_R_Fastfood_Popup_Size extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button set;
    private Button large;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    private TextView burger_text;

    private String intentString;
    private String intentInt;

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

        burger_text = findViewById(R.id.burger_text);

        Intent intent = getIntent();
        if (intent != null) {
            intentString = intent.getStringExtra("name");
            intentInt = intent.getStringExtra("value");
            if (intentString != null) {
                burger_text.setText(intentString);
            }
        }

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

    public void goto_Kiosk_R_F_P_Sd(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Set.class);
        startActivity(goto_Kiosk_R_F_P_St);
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