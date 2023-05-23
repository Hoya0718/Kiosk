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

public class Kiosk_R_Fastfood_Pay extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_pay);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("카드를 그림과 같이 꽂아주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Insert the card as shown in the picture.");
                }
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
        }
    }

    public void goto_Kiosk_R_H_C (View v){
        tts.shutdown();
        Intent goto_Kiosk_R_H_C = new Intent(getApplicationContext(), Kiosk_R_Congratulations.class);
        startActivity(goto_Kiosk_R_H_C);
    }

    public void goto_Kiosk_R_F_P_M(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Pay_Meth.class);
        goto_Kiosk_R_F_P_M.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_P_M);
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