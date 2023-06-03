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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_9 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button add_ord;
    private Button com;
    private Button home;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk09);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        add_ord = findViewById(R.id.add_ord_Btn);
        com = findViewById(R.id.com_Btn);
        home = findViewById(R.id.home_Btn);

        add_ord.setTextSize(text_size.getId());
        com.setTextSize(text_size.getId());
        home.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("주문 내역에 빅맥 세트가 추가되었습니다." +
                            "이 화면에서는 메뉴를 삭제 또는 수량을 조절할 수 있습니다." +
                            "추가 주문을 누르면 버거 선택 화면으로 돌아가서 다른 메뉴를 고를 수 있습니다." +
                            "결제 방법을 고르기 위해서는 주문 완료 버튼을 눌러야합니다." +
                            "주문 완료 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("The Big Mc set has been added to your order history." +
                            "On this screen, you can delete the menu or adjust the quantity." +
                            "Pressing More Order will take you back to the burger selection screen where you can choose another menu item." +
                            "To choose a payment method, you must press the Complete Order button." +
                            "Please press the order completion button.");
                }
            }
        });

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
//                    speakText("주문 완료 버튼은 여기에 있어요.");
//                else
//                    speakText("Button is Here");
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        com.setBackgroundResource(R.drawable.anim_list);
//                        anim = (AnimationDrawable) com.getBackground();
//                        anim.start();
//                    }
//                }, 2000);
//            }
//        }, 12000);

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
                            com.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) com.getBackground();
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

    public void goto_kiosk_06(View v){
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_10(View v) {
        tts.shutdown();
        Intent goto_kiosk_10 = new Intent(getApplicationContext(), Kiosk_10.class);
        startActivity(goto_kiosk_10);
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