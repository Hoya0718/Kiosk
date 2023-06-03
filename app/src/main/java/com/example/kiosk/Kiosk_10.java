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

public class Kiosk_10 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button card;
    private Button cert;
    private Button cancel;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk10);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        card = findViewById(R.id.card_Btn);
        cert = findViewById(R.id.cert_Btn);
        cancel = findViewById(R.id.cancel_Btn);

        card.setTextSize(text_size.getId());
        cert.setTextSize(text_size.getId());
        cancel.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("주문이 완료되었습니다." +
                            "결제 방법으로는 카드 결제와 모바일 상품권이 있습니다." +
                            "카드 결제를 선택하면 카드를 카드 리더기에 대야하고," +
                            "모바일 상품권을 선택하면 모바일의 QR코드를 QR코드 리더기에 비추어야합니다." +
                            "카드 결제를 눌러주세요");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("Your order has been completed." +
                            "Payment methods include credit card payment and mobile gift certificates." +
                            "If you choose to pay by card, you must swipe your card over the card reader," +
                            "If you choose a mobile gift certificate, you need to show the mobile's QR code to the QR code reader." +
                            "Choose a credit card payment");
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
//                        card.setBackgroundResource(R.drawable.anim_list);
//                        anim = (AnimationDrawable) card.getBackground();
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
                                    speakText("카드 결제는 여기에 있어요.");
                                else
                                    speakText("Card payment is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            card.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) card.getBackground();
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

    public void goto_kiosk_09(View v){
        tts.shutdown();
        Intent goto_kiosk_09 = new Intent(getApplicationContext(), Kiosk_9.class);
        startActivity(goto_kiosk_09);
    }

    public void goto_kiosk_11(View v){
        tts.shutdown();
        Intent goto_kiosk_11 = new Intent(getApplicationContext(),Kiosk_11.class);
        startActivity(goto_kiosk_11);
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