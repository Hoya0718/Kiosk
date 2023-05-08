package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Locale;

public class Kiosk_3 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private Button vss;
    private Button vsm;
    private Button vsf;
    private Button pre;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk03);

        float fontSizeLarge = getResources().getDimension(R.dimen.font_size_large);
        float fontSizeMedium = getResources().getDimension(R.dimen.font_size_medium);
        float fontSizeSmall = getResources().getDimension(R.dimen.font_size_small);

        text_size =(myapp)getApplication();
        sound =(myapp)getApplication();
        vss = findViewById(R.id.volume_speed_slow);
        vsm = findViewById(R.id.volume_speed_medium);
        vsf = findViewById(R.id.volume_speed_fast);
        pre = findViewById(R.id.pre_Btn);
        next = findViewById(R.id.save_Btn);


        vss.setTextSize(text_size.getId());
        vsm.setTextSize(text_size.getId());
        vsf.setTextSize(text_size.getId());
        pre.setTextSize(text_size.getId());
        next.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("음성 속도를 바꿀수 있습니다. 느리게 보통 빠르게로 속도를 적용해보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can change the Volume speed of the kiosk. Try applying the speed from slow to normal to fast.");
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

    public void goto_kiosk_04(View v){
        tts.shutdown();
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }

    public void goto_kiosk_05(View v) {
        tts.shutdown();
        Intent goto_kiosk_05 = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }
    public void volume_speed_slow(View view) {
        tts.setSpeechRate(0.8f);
        sound.setTtsSpeed(0.8f);
        if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
            speakText("이 정도 속도 어떠세요?");
        else
            speakText("How's that for speed?");
    }
    public void volume_speed_medium(View view) {
        tts.setSpeechRate(1.0f);
        sound.setTtsSpeed(1.0f);
        if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
            speakText("이 정도 속도 어떠세요?");
        else
            speakText("How's that for speed?");
    }
    public void volume_speed_fast(View view) {
        tts.setSpeechRate(1.5f);
        sound.setTtsSpeed(1.5f);
        if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
            speakText("이 정도 속도 어떠세요?");
        else
            speakText("How's that for speed?");
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
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
