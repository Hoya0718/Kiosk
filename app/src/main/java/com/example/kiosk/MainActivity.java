package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

import android.speech.tts.UtteranceProgressListener;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech tts;

    private Button practice_Btn;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practice_Btn = findViewById(R.id.practice_Btn);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("안녕하세요 교육용 키오스크입니다. 저를 따라오시면 키오스크의 사용이 쉬워질거에요. 처음 사용하시는 경우 연습을 눌러볼까요?");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("Hello, this is the training kiosk. Follow me and the kiosk will be easy to use. If this is your first time, let's hit practice?");
                    }
                }
            }
        });

        /*
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("연습은 여기에있어요 연습을 눌러보세요.");
                else
                    speakText("The practice button is here, click Practice");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        practice_Btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) practice_Btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
        */



        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("연습은 여기에있어요 연습을 눌러보세요.");
                                else
                                    speakText("The practice button is here, click Practice");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            practice_Btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)practice_Btn.getBackground();
                            anim.start();
                        }
                    }, 2000);
                    Log.d("delaySpeak", "onDone");
                    one=false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak", "onError");
            }
        });
    }

    private void speakText(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }

    public void goto_kiosk02(View v){
        tts.shutdown();
        Intent intent = new Intent(getApplicationContext(),Kiosk_2.class);
        startActivity(intent);
    }
    public void goto_Kiosk_R_Part(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_Part = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_Kiosk_R_Part);
    }
    public void change_to_korean(View v) {

        tts.shutdown();
        Locale newLocale = new Locale("ko");
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //Intent goto_Kiosk_R_Part = new Intent(this, Kiosk_R_Part.class);
        //startActivity(goto_Kiosk_R_Part);
    }
    public void change_to_english(View v) {

        tts.shutdown();
        Locale newLocale = new Locale("en");
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
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