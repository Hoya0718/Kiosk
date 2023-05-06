package com.example.kiosk;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_2 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp text_size;
    private TextView korean_text;

    private myapp sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk02);

        float fontSizeLarge = getResources().getDimension(R.dimen.font_size_large);
        float fontSizeMedium = getResources().getDimension(R.dimen.font_size_medium);
        float fontSizeSmall = getResources().getDimension(R.dimen.font_size_small);

        sound = (myapp) getApplication();

        text_size =(myapp) getApplication();
        korean_text = findViewById(R.id.korean_text);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("키오스크의 글자 크기를 설정합니다. 작게, 중간, 크게로 글자 크기를 적용해보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Set the font size for the kiosk. Try small, medium, and large font sizes.");
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
    public void goto_main(View v){
        tts.shutdown();
        Intent goto_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_main);
    }
    public void goto_kiosk_04(View v){
        tts.shutdown();
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }
    public void be_down(View v){
        tts.shutdown();
        korean_text.setTextSize(Dimension.SP,16);
        text_size.setId(16);
    }
    public void be_medium(View v){
        tts.shutdown();
        korean_text.setTextSize(Dimension.SP,22);
        text_size.setId(22);
    }
    public void be_up(View v){
        tts.shutdown();
        korean_text.setTextSize(Dimension.SP,26);
        text_size.setId(26);
    }
}