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

import java.util.Locale;

public class TO_Is_fee_examption extends AppCompatActivity {

    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_is_fee_examption);

        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("수수료 면제 여부를 선택하는 창입니다.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("A window to choose whether to waive the fee.");
                    }
                }
            }
        });

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;

            @Override
            public void onStart(String delaySpeak) {
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                if (one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("수수료 면제 대상자이시다면 예를 아니면 아니요를 누르시면 돼요.");
                                else
                                    speakText("If you qualify for a fee waiver, you can either say yes or no.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");

                        }
                    }, 4000);
                    Log.d("delaySpeak", "onDone");
                    one = false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak", "onError");
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

    public void goto_get_Num(View v){
        tts.shutdown();
        Intent goto_get_Num = new Intent(getApplicationContext(), TO_Get_Num.class);
        startActivity(goto_get_Num);
    }
    public void goto_add(View v){
        tts.shutdown();
        Intent goto_to_issuance = new Intent(getApplicationContext(), TO_Issuance_info.class);
        startActivity(goto_to_issuance);
    }
    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
}