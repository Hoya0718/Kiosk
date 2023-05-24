package com.example.kiosk;

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
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_6 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button store;
    private Button takeout;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk06);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        store = findViewById(R.id.store_Btn);
        takeout = findViewById(R.id.takeout_Btn);

        store.setTextSize(text_size.getId());
        takeout.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("식사할 장소를 고르는 화면입니다." +
                            "매장에서 드신다면 매장 버튼을, 포장해서 가져가신다면 포장 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to choose a place to eat." +
                            "If you eat at the store, press the store button." +
                            "If you take it out and take it home, press the packaging button.");
                }
            }
        });

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
//                    speakText("버튼은 여기에 있어요.");
//                else
//                    speakText("Button is Here");
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        store.setBackgroundResource(R.drawable.anim_list);
//                        anim = (AnimationDrawable) store.getBackground();
//                        anim.start();
//
//                        takeout.setBackgroundResource(R.drawable.anim_list);
//                        anim = (AnimationDrawable) takeout.getBackground();
//                        anim.start();
//                    }
//                }, 2000);
//            }
//        }, 10000);

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                // TTS가 말하기 시작했습니다.
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                // TTS가 말하기 끝났습니다.
                // 다른 코드를 실행합니다.

                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("버튼은 여기에 있어요.");
                                else
                                    speakText("Button is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            store.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) store.getBackground();
                            anim.start();

                            takeout.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) takeout.getBackground();
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

    public void goto_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_Back(View v){
        tts.shutdown();
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_Back);
    }

    private void speakText(String text) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
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