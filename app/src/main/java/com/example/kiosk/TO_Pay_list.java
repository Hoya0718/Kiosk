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

 public class TO_Pay_list extends AppCompatActivity {

     // TextView 사용 선언----------------------------------------------------------------------------
     private Button to_btn_card, to_btn_credit;
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
        setContentView(R.layout.activity_to_pay_list);

        to_btn_card = findViewById(R.id.to_btn_card);
        to_btn_credit = findViewById(R.id.to_btn_coin);
        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("결제를 통해 인쇄물을 받을 수 있어요. 카드 결제 또는 현금 결제를 선택해주세요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("You can pay to get your printouts. Choose to pay by card or cash.");
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
                                    speakText("결제 방식을 선택해 보세요.");
                                else
                                    speakText("Choose your payment method");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            to_btn_card.setBackgroundResource(R.drawable.to_anim_orange_gray);
                            anim = (AnimationDrawable) to_btn_card.getBackground();
                            anim.start();

                            to_btn_credit.setBackgroundResource(R.drawable.to_anim_orange_gray);
                            anim = (AnimationDrawable) to_btn_credit.getBackground();
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

     public void goto_pay(View v){
        tts.shutdown();
        Intent goto_pay = new Intent(getApplicationContext(), TO_Pay.class);
        startActivity(goto_pay);
     }
     public void goto_get_num(View v){
         tts.shutdown();
         Intent goto_get_num = new Intent(getApplicationContext(), TO_Get_Num.class);
         startActivity(goto_get_num);
     }
     public void goto_to_main(View v){
         tts.shutdown();
         Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
         startActivity(goto_to_main);
     }
}