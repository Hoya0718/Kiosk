package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
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


public class Kiosk_14_reserved_1 extends AppCompatActivity {
    private int currentVolume;
    private AudioManager audioManager;
    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    private Button b_cancel_btn;
    private Button b_payment_btn;
    private Button ticket_departure_btn, ticket_destination_btn, ticket_check_btn;
    private TextView textView17, bus_departuretime, bus_type, bus_takentime;
    Handler handler = new Handler();
    private boolean isColorChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14_reserved_1);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        ticket_departure_btn = findViewById(R.id.ticket_departure_btn);
        ticket_destination_btn = findViewById(R.id.ticket_destination_btn);
        ticket_check_btn = findViewById(R.id.ticket_check_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);
        textView17 = findViewById(R.id.textView17);
        bus_departuretime = findViewById(R.id.bus_departuretime);
        bus_type = findViewById(R.id.bus_type);
        bus_takentime = findViewById(R.id.bus_takentime);

        ticket_departure_btn.setTextSize(text_size.getId());
        ticket_destination_btn.setTextSize(text_size.getId());
        ticket_check_btn.setTextSize(text_size.getId());
        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());
        textView17.setTextSize(text_size.getId());
        bus_departuretime.setTextSize(text_size.getId());
        bus_type.setTextSize(text_size.getId());
        bus_takentime.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정

                        speakText("여기서는 예매한 승차권을 확인하고 뽑을 수 있습니다." +
                                "예매한 승차권 버튼을 클릭하고 발권하기 버튼을 누르면 티켓이 출력됩니다." +
                                "버튼을 누르면 버튼의 색깔이 파란색으로 바뀌면서 눌린 걸 확인하실 수 있습니다. " +
                                "승차권 버튼을 누르고, 발권하기 버튼을 눌러주세요");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Here you can check and pick up your reserved tickets." +
                                "Click the reserved ticket button and click the issue ticket button to print the ticket." +
                                "Press the ticket button, then press the issue ticket button");
                    }

                    ticket_departure_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isColorChanged) {
                                ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                                isColorChanged = false;
                            }
                            else {
                                ticket_departure_btn.setBackgroundColor(Color.CYAN);
                                ticket_destination_btn.setBackgroundColor(Color.CYAN);
                                ticket_check_btn.setBackgroundColor(Color.CYAN);
                                isColorChanged = true;
                            }
                        }

                    });
                    ticket_destination_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isColorChanged) {
                                ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                                isColorChanged = false;
                            }
                            else {
                                ticket_departure_btn.setBackgroundColor(Color.CYAN);
                                ticket_destination_btn.setBackgroundColor(Color.CYAN);
                                ticket_check_btn.setBackgroundColor(Color.CYAN);
                                isColorChanged = true;
                            }
                        }

                    });
                    ticket_check_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isColorChanged) {
                                ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                                ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                                isColorChanged = false;
                            }
                            else {
                                ticket_departure_btn.setBackgroundColor(Color.CYAN);
                                ticket_destination_btn.setBackgroundColor(Color.CYAN);
                                ticket_check_btn.setBackgroundColor(Color.CYAN);
                                isColorChanged = true;
                            }
                        }

                    });

                    b_cancel_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14_reserved_1.this, Kiosk_14.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    b_payment_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14_reserved_1.this, Kiosk_23.class);
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
                                    speakText("발권하기 버튼은 여기에 있어요.");
                                else
                                    speakText("The button to issue a ticket is here.");
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
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}

