package com.example.kiosk;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
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

public class Kiosk_14_refund extends AppCompatActivity {
    private int currentVolume;
    private AudioManager audioManager;
    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;

    private Button b_cancel_btn, b_payment_btn;

    private TextView textView2, textView19, textView43;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14_refund);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);
        textView2 = findViewById(R.id.textView2);
        textView19 = findViewById(R.id.textView19);
        textView43 = findViewById(R.id.textView43);

        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());
        textView2.setTextSize(text_size.getId());
        textView19.setTextSize(text_size.getId());
        textView43.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정

                        speakText("여기서는 구매한 승차권을 환불하실 수 있습니다." +
                                "화면 중앙에 환불 규정 표를 확인해주세요." +
                                "환불 규정의 경우 출발 2일전, 당일날 출발하는 승차권을 발권하는 시간 기준으로 1시간 이내의 경우에는 전액 환불이 가능합니다." +
                                "출발 1일전부터 출발 1시간 전까지는 전액 환불이 아닌 5%의 취소 수수료가 붙습니다." +
                                "출발 전 1시간 이내에는 10%의 취소 수수료가 붙습니다." +
                                "만약 버스가 출발해버렸다면 시외 버스의 경우에는 출발 후 6시간 이내에는 30%의 취소 수수료가 붙고 출발 6시간 이후에는 환불이 불가능합니다." +
                                "고속 버스의 경우에는 버스 도착시간 이전에 환불할 시 30%의 취소 수수료가 붙고 버스가 도착한 이후에는 환불이 불가능합니다." +
                                "최종 취소 수수료는 하단의 환불 버튼을 누르는 시간을 기준으로 위의 안내 기준에 따라 계산됩니다." +
                                "이 점 유의하시고 환불하기 버튼을 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can refund the tickets you have purchased here. Check the Foundation Rules Table in the center of the screen" +
                                "In the case of the refund policy, a full refund is possible if it is less than 1 hour from the time of issuing the ticket for departure on the same day, 2 days before departure." +
                                "From 1 day before departure to 1 hour before departure, a 5% cancellation fee is charged, not a full refund." +
                                "A 10% cancellation fee applies within 1 hour prior to departure. If the bus has departed, a 30% cancellation fee is charged for intercity buses within 6 hours of departure, and refunds are not possible after 6 hours of departure." +
                                "In the case of express buses, a 30% cancellation fee is charged if refunded before the bus arrives, and refunds are not possible after the bus arrives." +
                                "The final cancellation fee will be calculated according to the guideline above based on the time the refund button at the bottom is pressed. " +
                                "Please note this point and click the refund button.");
                    }

                    b_cancel_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14_refund.this, Kiosk_14.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });

                    b_payment_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14_refund.this, Kiosk_23.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
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
                                    speakText("환불하기 버튼은 여기에 있어요.");
                                else
                                    speakText("The refund button is here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            b_payment_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) b_payment_btn.getBackground();
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
    private void startButtonBorderAnimation(Button button) {
        AnimationDrawable buttonBorderAnimation = (AnimationDrawable) button.getBackground();
        if (buttonBorderAnimation != null) {
            buttonBorderAnimation.start();
        }
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
            tts.stop();
        }
        super.onPause();
    }
}

