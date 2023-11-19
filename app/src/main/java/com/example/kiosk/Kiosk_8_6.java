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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_6 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    private myapp text_size;
    private Button add_ord_Btn;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_6);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        add_ord_Btn = findViewById(R.id.add_ord_Btn);

        add_ord_Btn.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 단품을 골랐을 때 나오는 화면입니다." +
                            "수량을 확인하고 장바구니 추가를 눌러주세요." +
                            "버튼에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen that appears when you choose a single burger." +
                            "Check the quantity and click Add to Cart." +
                            "For an explanation of the button, please click the McDonald's logo button.");
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
                                    speakText("버튼은 여기에 있어요.");
                                else
                                    speakText("Button is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            add_ord_Btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) add_ord_Btn.getBackground();
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

    public void popup_kiosk_08_5(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_5 = new Intent(getApplicationContext(), Kiosk_8_5.class);
        startActivity(popup_kiosk_08_5);
    }

    public void popup_kiosk_08_7(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_7 = new Intent(getApplicationContext(), Kiosk_8_7.class);
        startActivity(popup_kiosk_08_7);
    }

    public void goto_intro_kiosk_08_6(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_6 = new Intent(getApplicationContext(), Intro_8_6.class);
        startActivity(goto_intro_kiosk_08_6);
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

    public void n_sup(View v){
        Toast.makeText(getApplicationContext(), "지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}