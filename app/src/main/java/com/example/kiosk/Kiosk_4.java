package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_4 extends AppCompatActivity {

    private TextToSpeech tts;

    private AudioManager audioManager;
    private int maxVolume;
    private int currentVolume;
    private myapp text_size;
    private Button vsd;
    private Button vsm;
    private Button vsu;
    private Button pre;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk04);
        text_size = (myapp) getApplication();
        vsd = findViewById(R.id.volume_size_down);
        vsm = findViewById(R.id.volume_size_medium);
        vsu = findViewById(R.id.volume_size_up);
        pre = findViewById(R.id.pre_Btn);
        next = findViewById(R.id.save_Btn);

        vsd.setTextSize(text_size.getId());
        vsm.setTextSize(text_size.getId());
        vsu.setTextSize(text_size.getId());
        pre.setTextSize(text_size.getId());
        next.setTextSize(text_size.getId());

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });
    }

    public void goto_kiosk_03(View v) {
        Intent goto_kiosk_03 = new Intent(getApplicationContext(), Kiosk_3.class);
        startActivity(goto_kiosk_03);
    }

    public void goto_kiosk_05(View v) {
        Intent goto_kiosk_05 = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void volume_size_up(View v) {
        if (currentVolume < maxVolume) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, 0);
            currentVolume += 1;
            tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public void volume_size_medium(View v) {
        if (currentVolume < maxVolume) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, 0);
            currentVolume = 10;
            tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public void volume_size_down(View v) {
        if (currentVolume > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, 0);
            currentVolume -= 1;
            tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}