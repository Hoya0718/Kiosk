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
import android.widget.Button;

import java.util.Locale;

public class Town_Office extends AppCompatActivity {


    // Button 선언----------------------------------------------------------------------------------
    private Button ssn_btn;
    // Button 선언----------------------------------------------------------------------------------


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
        setContentView(R.layout.activity_town_office);

        ssn_btn = findViewById(R.id.ssn_btn);
        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("동사무소 무인민원발급기를 보여주는 창입니다. 연습을 하기위해 주민등록 등본을 발급해 보실까요?");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is a window showing an unmanned citizen application machine at the local government office. To practice, let's issue a resident registration certificate.");
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
                                    speakText("주민등록 발급은 여기서 할 수 있어요.");
                                else
                                    speakText("You can get a national ID here.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            ssn_btn.setBackgroundResource(R.drawable.to_anim_orange_gray);
                            anim = (AnimationDrawable) ssn_btn.getBackground();
                            anim.start();
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

    public void goto_SSN(View v){
        tts.shutdown();
        Intent goto_SSN = new Intent(getApplicationContext(), TO_SSN.class);
        startActivity(goto_SSN);
    }

    public void goto_Main(View v){
        tts.shutdown();
        Intent goto_Main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_Main);
    }
}