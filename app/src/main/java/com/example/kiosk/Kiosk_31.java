package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_31 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private Button goto_5;
    private myapp text_size;

    public Kiosk_31() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk31);
        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        goto_5 =findViewById(R.id.concon);

        goto_5.setTextSize(text_size.getId());

        myapp myApp = (myapp) getApplicationContext();
        if (myApp.getR_H_R_Time() != 0 || myApp.getR_H_A_Time() != 0) {
            myApp.setPracticeHospitalCheck(true);
        }

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("축하드립니다. 병원의 모든 단계를 완료했습니다. 실전도 한번 해보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Congratulations. You've completed all the steps in the walkthrough. It's time to try it out for real.");
                    }
                }
            }
        });
    }

    private void speakText(String text){
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_5(View v) {
        tts.shutdown();
        Intent goto_kiosk_5 = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_5);

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