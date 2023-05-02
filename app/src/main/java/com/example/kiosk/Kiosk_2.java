package com.example.kiosk;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_2 extends AppCompatActivity {

    private myapp text_size;
    private TextView korean_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk02);
        text_size =(myapp) getApplication();
        korean_text = findViewById(R.id.korean_text);

    }
    public void goto_main(View v){
        Intent goto_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_main);
    }
    public void goto_kiosk_04(View v){
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }
    public void be_down(View v){
        korean_text.setTextSize(Dimension.SP,16);
        text_size.setId(16);
    }
    public void be_medium(View v){
        korean_text.setTextSize(Dimension.SP,18);
        text_size.setId(18);
    }
    public void be_up(View v){
        korean_text.setTextSize(Dimension.SP,26);
        text_size.setId(26);
    }
}