package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_23 extends AppCompatActivity {
    private TextToSpeech tts;
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private myapp text_size;
    private AnimationDrawable anim;
    Handler handler = new Handler();
    private Button button67; //처음으로 돌아가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk23);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        button67 = findViewById(R.id.button67);

        button67.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("축하드립니다. 버스 연습 단계가 완료되었습니다" +
                                "처음으로 돌아가기 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Congratulations. Bus practice phase is complete" +
                                "Please click the back button");
                    }
                    button67 = findViewById(R.id.button67);
                    button67.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_23.this, Kiosk_24.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });

                }
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("처음으로 돌아가는 버튼은 여기에 있어요.");
                else
                    speakText("The button to go back to the beginning is here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button67.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button67.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 8000);
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
}
