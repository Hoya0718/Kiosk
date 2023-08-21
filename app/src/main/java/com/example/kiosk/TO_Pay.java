package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class TO_Pay extends AppCompatActivity {


    // TextView, String-----------------------------------------------------------------------------
    private TextView total_money;
    private String value;
    // TextView, String-----------------------------------------------------------------------------

    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------


    // anim 사용 선언--------------------------------------------------------------------------------
    private AnimationDrawable anim;
    // anim 사용 선언--------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_pay);

        total_money = findViewById(R.id.total_money);

        // Intent로 값 받기---------------------------------------------------------------------------
        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        total_money.setText(value);
        // Intent로 값 받기---------------------------------------------------------------------------

        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("카드 결제 방식을 골라보세요. 카드와 모바일페이가 있어요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("Choose a card payment method. I have card and mobile pay.");
                    }
                }
            }
        });
    }


    //여기도 추가


    // onDestroy가 두개라 하나로 합쳐줌
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }

    private void speakText(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }

    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
    // tts 끝---------------------------------------------------------------------------------------

    public void goto_card_Insert(View v){
        tts.shutdown();
        Intent goto_card_Insert = new Intent(getApplicationContext(), TO_Card_Insert.class);
        startActivity(goto_card_Insert);
    }
    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
    public void goto_pay_list(View v){
        tts.shutdown();
        Intent goto_pay_list = new Intent(getApplicationContext(), TO_Pay_list.class);
        startActivity(goto_pay_list);
    }
}