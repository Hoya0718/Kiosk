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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_22 extends AppCompatActivity {
    private TextToSpeech tts;
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private AnimationDrawable anim;
    Handler handler = new Handler();
    private myapp text_size;
    private Button button66; // 취소해
    private TextView textView40;
    private ImageView imageView3; //이미지 터치시 다음 화면 전환

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk22);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        button66 = findViewById(R.id.button66);
        textView40 = findViewById(R.id.textView40);

        button66.setTextSize(text_size.getId());
        textView40.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("마지막 단계입니다. 카드를 그림과 같이 꽂아주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is the last step. Insert the card as shown in the picture");
                    }
                    button66 = findViewById(R.id.button66);
                    button66.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_22.this, Kiosk_14.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });

                    imageView3 = findViewById(R.id.imageView3);
                    imageView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_22.this, Kiosk_23.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                }
            }
        });
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
