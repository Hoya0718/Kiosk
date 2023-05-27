package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_15 extends AppCompatActivity {
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM dd (E)", Locale.KOREAN);

    private TextToSpeech tts;//
    private int currentVolume;
    private AudioManager audioManager;

    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;

    private Button destination_btn; //도착지 버튼
    private Button b_homescreen_btn; //홈 버튼
    private TextView textView10;
    private TextView textView102;
    private TextView textView15;

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk15);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        destination_btn = findViewById(R.id.destination_btn);
        b_homescreen_btn = findViewById(R.id.b_homescreen_btn);
        textView10 = findViewById(R.id.textView10);
        textView15 = findViewById(R.id.textView15);
        textView102 = findViewById(R.id.textView102);

        destination_btn.setTextSize(text_size.getId());
        b_homescreen_btn.setTextSize(text_size.getId());
        textView10.setTextSize(text_size.getId());
        textView15.setTextSize(text_size.getId());
        textView102.setTextSize(text_size.getId());



        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("이 화면에서는 가고 싶은 곳을 선택할 수 있습니다." +
                                "가고 싶은 곳을 고르기 위해서 목적지 버튼을 눌러주세요." +
                                "만약 처음 화면으로 돌아가고 싶으시면 화면 아래쪽에 있는 처음 화면으로 돌아가기" +
                                "버튼을 눌러주세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This screen allows you to select your destination." +
                                "Please click the destination button" +
                                "If you want to return to the first screen, " +
                                "click the Back to Home Screen button.");
                    }

                    textView10 = (TextView) findViewById(R.id.textView10);

                    Calendar c = Calendar.getInstance();

                    SimpleDateFormat format;

                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        format = new SimpleDateFormat("yyyy/MM/dd(E)", Locale.KOREAN);
                    else
                        format = new SimpleDateFormat("yyyy/MMM/dd(E)", Locale.ENGLISH);
                    textView10.setText(format.format(c.getTime()));

                    destination_btn = findViewById(R.id.destination_btn);
                    b_homescreen_btn = findViewById(R.id.b_homescreen_btn);
                    destination_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_15.this, Kiosk_16.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                    b_homescreen_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_15.this, Kiosk_14.class);
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
                                    speakText("도착지를 선택할 수 있는 버튼은 여기 있습니다");
                                else
                                    speakText("The button to select your destination is here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            destination_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) destination_btn.getBackground();
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