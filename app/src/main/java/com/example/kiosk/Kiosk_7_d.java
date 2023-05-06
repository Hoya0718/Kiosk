package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_7_d extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button burger;
    private Button side;
    private Button drink;
    private Button ord_his;
    private Button home;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_d);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        burger = findViewById(R.id.burger_Btn);
        side = findViewById(R.id.side_Btn);
        drink = findViewById(R.id.drink_Btn);
        ord_his = findViewById(R.id.ord_his_Btn);
        home = findViewById(R.id.home_Btn);
        help = findViewById(R.id.help_Btn);

        burger.setTextSize(text_size.getId());
        side.setTextSize(text_size.getId());
        drink.setTextSize(text_size.getId());
        ord_his.setTextSize(text_size.getId());
        home.setTextSize(text_size.getId());
        help.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("음료 메뉴 화면입니다. 버거 메뉴 화면으로 돌아가주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the Drink menu screen. Return to the Burger menu screen.");
                }
            }
        });
    }

    public void goto_kiosk_06(View v){
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
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