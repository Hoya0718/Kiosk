package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;

import java.util.Locale;

public class TO_Issuance_info extends AppCompatActivity {

    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_issuance_info);
    }

    public void goto_add(View v){
        tts.shutdown();
        Intent goto_add = new Intent(getApplicationContext(), TO_ADD.class);
        startActivity(goto_add);
    }
    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
    public void goto_to_ssn2(View v){
        tts.shutdown();
        Intent goto_to_ssn2 = new Intent(getApplicationContext(), TO_SSN2.class);
        startActivity(goto_to_ssn2);
    }
}