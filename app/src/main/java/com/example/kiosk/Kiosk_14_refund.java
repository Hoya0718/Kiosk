package com.example.kiosk;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
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

                        speakText("여기서는 승차권을 구매하실 수 있고, 예매한 승차권을 확인하실 수도 있습니다." +
                                "또 잘못 예매한 승차권을 환불하실 수 있습니다." +
                                "우선 승차권을 예매하는 방법에 대해 배워보겠습니다." +
                                "승차권 구매 버튼을 눌러주세요");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can purchase tickets here, and you can also check tickets you have reserved." +
                                "First, let's learn how to book tickets. Please click the buy ticket button");
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
                            Intent intent = new Intent(Kiosk_14_refund.this, Kiosk_15.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                }
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("승차권 구매 버튼은 여기에 있어요.");
                else
                    speakText("Buy ticket button is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b_payment_btn.setBackgroundResource(R.drawable.anim_list);
                        b_cancel_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_payment_btn.getBackground();
                        anim.start();
                        anim = (AnimationDrawable) b_cancel_btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 20000);
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
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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

