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
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_30_2 extends AppCompatActivity {

    private myapp text_size;

    private TextView t1_2, t2_2, t3_2, t4_2, t5_2, t6_2, t7_2, t8_2;

    private Button chch;
    private TextToSpeech tts;
    private myapp sound;
    private Handler handler;
    private Runnable runnable;

    private AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30_2);
        handler = new Handler();
        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();

        t1_2 = findViewById(R.id.t1_2);
        t2_2 = findViewById(R.id.t2_2);
        t3_2 = findViewById(R.id.t3_2);
        t4_2 = findViewById(R.id.t4_2);
        t5_2 = findViewById(R.id.t5_2);
        t6_2 = findViewById(R.id.t6_2);
        t7_2 = findViewById(R.id.t7_2);
        t8_2 = findViewById(R.id.t8_2);
        chch = findViewById(R.id.chch);

        t1_2.setTextSize(text_size.getId());
        t2_2.setTextSize(text_size.getId());
        t3_2.setTextSize(text_size.getId());
        t4_2.setTextSize(text_size.getId());
        t5_2.setTextSize(text_size.getId());
        t6_2.setTextSize(text_size.getId());
        t7_2.setTextSize(text_size.getId());
        t8_2.setTextSize(text_size.getId());
        chch.setTextSize(text_size.getId());
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("결제 완료 창을 보여줍니다. 실제 키오스크는 아래에 처방전이 나옵니다. 확인을 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("The payment completion window appears. Below you will see your prescription.");
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
                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("접수하기는 여기에 있고 수납하기는 여기에 있어요. 접수하기나 수납하기를 눌러보세요.");
                                else
                                    speakText("Receive is here and File is here. Tap Receive or File to get started");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            chch.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)chch.getBackground();
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

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }
    public void goto_kiosk_31(View v){
        tts.shutdown();
        Intent goto_kiosk_31 = new Intent(this, Kiosk_31.class);
        startActivity(goto_kiosk_31);

    }

    public void goto_Kiosk_H_M(View v) {
        tts.shutdown();
        Intent goto_Kiosk_H_M = new Intent(getApplicationContext(), Kiosk_25.class);
        startActivity(goto_Kiosk_H_M);

    }

    public void goto_Back(View v) {
        tts.shutdown();
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_30.class);
        startActivity(goto_Back);

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