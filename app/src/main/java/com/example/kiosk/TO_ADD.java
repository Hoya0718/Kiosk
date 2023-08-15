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

public class TO_ADD extends AppCompatActivity {

    // TextView 사용 선언----------------------------------------------------------------------------
    private TextView to_btn_check_1;
    // TextView 사용 선언----------------------------------------------------------------------------

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
        setContentView(R.layout.activity_to_add);

        to_btn_check_1 = findViewById(R.id.to_btn_check_1);
        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("주민등록 등본 사항을 보여주는 창입니다. 내역 중 필요한 사항이 있으면 포함을 누르고 하단에 있는 확인 버튼을 누르면 돼요. ");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is a window that shows the details of your vital records. If you need any of the details, just hit Include and hit the OK button at the bottom.");
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
                                    speakText("확인은 여기 있어요.");
                                else
                                    speakText("Here's the confirmation");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            to_btn_check_1.setBackgroundResource(R.drawable.to_anim_orange_gray);
                            anim = (AnimationDrawable) to_btn_check_1.getBackground();
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

    public void goto_fee_Exam(View v){
        tts.shutdown();
        Intent goto_fee_Exam = new Intent(getApplicationContext(), TO_Is_fee_examption.class);
        startActivity(goto_fee_Exam);
    }
    public void goto_to_issuance(View v){
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