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

    private TextView setting_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk04);
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

        setting_list = findViewById(R.id.setting_list);

        String content = setting_list.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        String word ="2. 음성 크기";
        int start = content.indexOf(word);
        int end = start + word.length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5500")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        setting_list.setText(spannableString);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });
    }

    public void volume_size_medium(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume =11, 0);
        currentVolume = 11;
        sound.setTtsVolume(11);
        tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
    }


    public void volume_size_up(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        if (currentVolume < maxVolume) {

            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, 0);
            currentVolume += 1;
            sound.setTtsVolume(currentVolume);
            tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else if(currentVolume == maxVolume){
            tts.speak("최대 크기입니다.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
    public void volume_size_down(View v) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        if (currentVolume > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, 0);
            currentVolume -= 1;
            sound.setTtsVolume(currentVolume);
            tts.speak("소리를 측정하세요.", TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else if(currentVolume == 0) {
            Toast.makeText(getApplicationContext(),"최소 크기입니다.", Toast.LENGTH_LONG).show();
        }
    }
    public void goto_kiosk_02(View v) {
        Intent goto_kiosk_02 = new Intent(getApplicationContext(), Kiosk_2.class);
        startActivity(goto_kiosk_02);
    }



    public void goto_kiosk_03(View v) {
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