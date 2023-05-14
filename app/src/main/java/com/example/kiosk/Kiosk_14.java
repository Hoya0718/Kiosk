package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.widget.Toast;


public class Kiosk_14 extends AppCompatActivity {
    private int currentVolume;
    private AudioManager audioManager;
    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    private Button buy_ticket_btn;
    private Button reserved_ticket_btn;
    private Button refund_ticket_btn;
    private TextView textView11;
    Handler handler = new Handler();


    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MMM/d/E요일", Locale.KOREAN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        buy_ticket_btn = findViewById(R.id.buy_ticket_btn);
        reserved_ticket_btn = findViewById(R.id.reserved_ticket_btn);
        refund_ticket_btn = findViewById(R.id.refund_ticket_btn);
        textView11 = findViewById(R.id.textView11);

        buy_ticket_btn.setTextSize(text_size.getId());
        reserved_ticket_btn.setTextSize(text_size.getId());
        refund_ticket_btn.setTextSize(text_size.getId());
        textView11.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정

                        speakText("여기서는 승차권을 구매하실 수 있고, 예매한 승차권을 확인하실 수도 있습니다." +
                                "또 잘못 예매한 승차권을 환불하실 수 있습니다." +
                                "우선 승차권을 예매하는 방법에 대해 배워보겠습니다." +
                                "승차권 구매 버튼을 눌러주세요");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can purchase tickets here, and you can also check tickets you have reserved." +
                                "First, let's learn how to book tickets. Please click the buy ticket button");
                    }


                    textView11 = (TextView) findViewById(R.id.textView11);

                    Calendar c = Calendar.getInstance();

                    SimpleDateFormat format;

                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm", Locale.KOREAN);
                    else
                        format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm", Locale.ENGLISH);


                    textView11.setText(format.format(c.getTime()));

                    buy_ticket_btn = findViewById(R.id.buy_ticket_btn);

                    buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14.this, Kiosk_15.class);
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
                        buy_ticket_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) buy_ticket_btn.getBackground();
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


