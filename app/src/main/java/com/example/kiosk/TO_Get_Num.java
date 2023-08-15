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

public class TO_Get_Num extends AppCompatActivity {

    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_get_num);

        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("신청 부수를 선택할 수 있는 화면입니다. 몇 부를 인쇄 할건지 숫자를 누르면 돼요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is the screen where you can choose how many copies of the application you want to print, just press the number.");
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

    public void goto_pay_List(View v){
        tts.shutdown();
        Intent goto_pay_List = new Intent(getApplicationContext(), TO_Pay_list.class);
        startActivity(goto_pay_List);
    }
    public void goto_fee(View v){
        tts.shutdown();
        Intent goto_fee = new Intent(getApplicationContext(), TO_Is_fee_examption.class);
        startActivity(goto_fee);
    }
    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
}