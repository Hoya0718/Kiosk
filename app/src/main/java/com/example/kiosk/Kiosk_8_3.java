package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_3 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    private myapp text_size;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    private TextView huri_text;
    private TextView huri_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_3);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        cancel = findViewById(R.id.cancel_Btn);

        cancel.setTextSize(text_size.getId());

        huri_text = findViewById(R.id.huri_text);
        huri_price = findViewById(R.id.huri_price);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("빅맥 세트가 선택되었습니다." +
                            "이제 사이드 메뉴와 음료만 고르면 됩니다." +
                            "사이드 메뉴에서 가장 인기있는 후렌치 후라이를 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Big Mc set is selected." +
                            "Now I just have to choose a side menu and a drink." +
                            "Choose the most popular French fries from the side menu.");
                }
            }
        });

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
                                    speakText("후렌치 후라이는 여기에 있어요.");
                                else
                                    speakText("French fries is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            huri_text.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) huri_text.getBackground();
                            anim.start();

                            huri_price.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) huri_price.getBackground();
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

    public void popup_kiosk_08_2(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_2 = new Intent(getApplicationContext(), Kiosk_8_2.class);
        startActivity(popup_kiosk_08_2);
    }

    public void popup_kiosk_08_4(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void goto_intro_kiosk_08_3(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_3 = new Intent(getApplicationContext(), Intro_8_3.class);
        startActivity(goto_intro_kiosk_08_3);
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