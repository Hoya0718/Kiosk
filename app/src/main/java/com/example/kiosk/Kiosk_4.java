package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_4 extends AppCompatActivity {

    private TextToSpeech tts;

    private AudioManager audioManager;
    private int maxVolume;
    private myapp sound;
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

        float fontSizeLarge = getResources().getDimension(R.dimen.font_size_large);
        float fontSizeMedium = getResources().getDimension(R.dimen.font_size_medium);
        float fontSizeSmall = getResources().getDimension(R.dimen.font_size_small);

        text_size = (myapp) getApplication();
        sound = (myapp)getApplication();
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

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("키오스크의 음성 크기를 설정합니다. 작게, 중간, 크게로 음성 크기를 적용해보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can change the Volume size of the kiosk. Try small, medium, and large voice sizes.");
                    }
                }
            }
        });
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
    }

    public void volume_size_medium(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume =11, 0);
        currentVolume = 11;
        sound.setTtsVolume(11);
        if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
            speakText("크기가 어떠세요");
        else
            speakText("How's the volume");
    }


    public void volume_size_up(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        if (currentVolume < maxVolume) {

            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, 0);
            currentVolume += 1;
            sound.setTtsVolume(currentVolume);
            if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                speakText("소리를 키웁니다.");
            else
                speakText("Increases sound.");
        }
        else if(currentVolume == maxVolume){
            if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                speakText("최대 크기입니다.");
            else
                speakText("The maximum volume.");
        }
    }
    public void volume_size_down(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        if (currentVolume > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, 0);
            currentVolume -= 1;
            sound.setTtsVolume(currentVolume);
            if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                speakText("소리를 줄입니다.");
            else
                speakText("Reduce sound.");
        }
        else if(currentVolume == 0) {
            if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                Toast.makeText(getApplicationContext(),"최소 크기입니다.", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"The minimum volume.", Toast.LENGTH_LONG).show();
        }
    }
    public void goto_kiosk_02(View v) {
        tts.shutdown();
        Intent goto_kiosk_02 = new Intent(getApplicationContext(), Kiosk_2.class);
        startActivity(goto_kiosk_02);
    }



    public void goto_kiosk_03(View v) {
        tts.shutdown();
        Intent goto_kiosk_03 = new Intent(getApplicationContext(), Kiosk_3.class);
        startActivity(goto_kiosk_03);
    }

    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}