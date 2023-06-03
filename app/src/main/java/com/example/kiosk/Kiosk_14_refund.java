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
    private int currentVolume;//
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
                                "환불 규정의 경우 출발 2일전, 출발 1일전, 출발 전 1시간 이내 등 시간마다" +
                                "환불되는 가격이 다를 수 있으므로 꼭 확인해주세요." +
                                "규정 표를 확인하셨다면, 승차권을 투입구에 넣어주세요." +
                                "환불하지 않으실 거라면 아래쪽에 있는 취소하기 버튼을 눌러주세요");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can refund the tickets you have purchased here." +
                                "Please check the refund policy table in the center of the screen." +
                                "Regarding the refund policy, the refunded price may vary for each hour, such as 2 days before departure, 1 day before departure, and within 1 hour before departure, so please check it." +
                                "After checking the rule table, insert the ticket into the slot. If you do not wish to receive a refund, please click the Cancel button at the bottom.");
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

