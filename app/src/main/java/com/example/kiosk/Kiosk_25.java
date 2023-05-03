package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_25 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private Button receipt;
    private Button acceptance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk25);
        text_size =(myapp)getApplication();
        receipt = findViewById(R.id.receipt_btn);
        acceptance = findViewById(R.id.acceptance_btn);

        receipt.setTextSize(text_size.getId());
        acceptance.setTextSize(text_size.getId());

        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                tts.speak("접수 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 3000);
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
}