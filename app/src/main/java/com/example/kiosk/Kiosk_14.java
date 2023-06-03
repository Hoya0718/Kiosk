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
                                "승차권 구매, 예매한 승차권 확인, 승차권 환불 기능중 배우고 싶은 기능의 버튼을 눌러보세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You can purchase tickets here, and you can also check tickets you have reserved." +
                                "And also get a refund for tickets that you have incorrectly reserved" +
                                "Press the button of the function you want to learn among ticket purchase, ticket confirmation, and ticket refund functions.");
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
                    reserved_ticket_btn = findViewById(R.id.reserved_ticket_btn);
                    refund_ticket_btn = findViewById(R.id.refund_ticket_btn);

                    buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14.this, Kiosk_15.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });

                    reserved_ticket_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14.this, Kiosk_14_reserved.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    refund_ticket_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_14.this, Kiosk_14_refund.class);
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
                                    speakText("여기 있는 세 가지 버튼 중 한가지 버튼을 눌러주세요" +
                                            "첫 번째 버튼은 승차권을 구매하는 버튼" +
                                            "두 번째 버튼은 예매한 승차권을 확인하고 뽑는 버튼" +
                                            "세 번째 버튼은 예매한 승차권을 환불하는 버튼입니다.");
                                else
                                    speakText("Please press one of the three buttons here" +
                                            "The first button is a button to purchase a ticket" +
                                            "The second button is a button that checks and draws tickets you have reserved." +
                                            "The third button is a button to refund the reserved ticket.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            buy_ticket_btn.setBackgroundResource(R.drawable.anim_list);
                            reserved_ticket_btn.setBackgroundResource(R.drawable.anim_list);
                            refund_ticket_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) buy_ticket_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) reserved_ticket_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) refund_ticket_btn.getBackground();
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


