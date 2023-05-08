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

public class Kiosk_17 extends AppCompatActivity {
    private String destination; //목적지
    private String bus;
    private String seat;
    private String price;
    private TextToSpeech tts;
    private myapp sound;
    private AnimationDrawable anim;
    private int currentVolume;
    private AudioManager audioManager;
    private myapp text_size;
    Handler handler = new Handler();

    private Button button_seoul; // 서울
    private Button button_gyeongi;
    private Button button_kangwon;
    private Button button_sejong;
    private Button button_chungnam;
    private Button button_chungbuk;
    private Button button_kwangju;
    private Button button_jeonbuk;
    private Button button_busan;
    private Button button_daegu;
    private Button button27;
    private Button button26;
    private Button button25;
    private Button button24;
    private Button button23;
    private Button button32;
    private Button button31;
    private Button button30;
    private Button button29;
    private Button button28;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button button37;
    private Button button18;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button85;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk17);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        button18 = findViewById(R.id.button18);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button85 = findViewById(R.id.button85);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26= findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29= findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32= findViewById(R.id.button32);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button36= findViewById(R.id.button36);
        button37 = findViewById(R.id.button37);
        button_seoul = findViewById(R.id.button_seoul);
        button_busan = findViewById(R.id.button_busan);
        button_chungbuk= findViewById(R.id.button_chungbuk);
        button_chungnam = findViewById(R.id.button_chungnam);
        button_daegu = findViewById(R.id.button_daegu);
        button_gyeongi= findViewById(R.id.button_gyeongi);
        button_jeonbuk = findViewById(R.id.button_jeonbuk);
        button_kwangju = findViewById(R.id.button_kwangju);
        button_sejong= findViewById(R.id.button_sejong);
        button_kangwon = findViewById(R.id.button_kangwon);

        button18.setTextSize(text_size.getId());
        button20.setTextSize(text_size.getId());
        button21.setTextSize(text_size.getId());
        button22.setTextSize(text_size.getId());
        button85.setTextSize(text_size.getId());
        button23.setTextSize(text_size.getId());
        button24.setTextSize(text_size.getId());
        button25.setTextSize(text_size.getId());
        button26.setTextSize(text_size.getId());
        button27.setTextSize(text_size.getId());
        button28.setTextSize(text_size.getId());
        button29.setTextSize(text_size.getId());
        button30.setTextSize(text_size.getId());
        button31.setTextSize(text_size.getId());
        button32.setTextSize(text_size.getId());
        button34.setTextSize(text_size.getId());
        button35.setTextSize(text_size.getId());
        button36.setTextSize(text_size.getId());
        button37.setTextSize(text_size.getId());
        button_sejong.setTextSize(text_size.getId());
        button_seoul.setTextSize(text_size.getId());
        button_gyeongi.setTextSize(text_size.getId());
        button_busan.setTextSize(text_size.getId());
        button_kangwon.setTextSize(text_size.getId());
        button_kwangju.setTextSize(text_size.getId());
        button_jeonbuk.setTextSize(text_size.getId());
        button_chungnam.setTextSize(text_size.getId());
        button_chungbuk.setTextSize(text_size.getId());
        button_daegu.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("ㅁ 버튼을 누르게 되면 앞글자가 ㅁ인 버스 정류장들이 나옵니다." +
                                "오른쪽에 새로 생긴 버튼 중에서 가고 싶은 곳 버튼을 클릭해주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("If you press the ㅁ button, bus stops with the first letter ㅁ appear." +
                                "Among the new buttons on the right, click the button where you want to go.");
                    }

                    button20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "마산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button21.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안공항");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button22.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "무주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    button85.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                            intent.putExtra("destination", "마량");
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
                    speakText("목적지 버튼은 오른쪽 부분에 있습니다.");
                else
                    speakText("The destination button is on the right side");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button18.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button18.getBackground();
                        anim.start();
                        button20.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button20.getBackground();
                        anim.start();
                        button21.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button21.getBackground();
                        anim.start();
                        button22.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button22.getBackground();
                        anim.start();
                        button85.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button85.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 12000);
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

