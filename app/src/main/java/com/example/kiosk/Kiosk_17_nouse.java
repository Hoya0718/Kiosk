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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_17_nouse extends AppCompatActivity {
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

    private Button seoul_btn; // 서울
    private Button incheon_btn;
    private Button kangwon_btn;
    private Button sejong_btn;
    private Button chungnam_btn;
    private Button chungbuk_btn;
    private Button kwangju_btn;
    private Button jeonbuk_btn;
    private Button busan_btn;
    private Button daegu_btn;
    private Button giyeok_btn;
    private Button nieun_btn;
    private Button digeut_btn;
    private Button rieul_btn;
    private Button mieum_btn;
    private Button bieub_btn;
    private Button siot_btn;
    private Button ieung_btn;
    private Button jieut_btn;
    private Button chieut_btn;
    private Button kieuk_btn;
    private Button tieut_btn;
    private Button pieup_btn;
    private Button hieut_btn;
    private Button muan_btn;
    private Button muanairport_btn;
    private Button maryang_btn;
    private Button muju_btn;
    private Button masan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk17_nouse);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        muan_btn = findViewById(R.id.muan_btn);
        muanairport_btn = findViewById(R.id.muanairport_btn);
        muju_btn = findViewById(R.id.muju_btn);
        maryang_btn = findViewById(R.id.maryang_btn);
        masan_btn = findViewById(R.id.masan_btn);
        giyeok_btn = findViewById(R.id.giyeok_btn);
        nieun_btn = findViewById(R.id.nieun_btn);
        digeut_btn = findViewById(R.id.digeut_btn);
        rieul_btn = findViewById(R.id.rieul_btn);
        mieum_btn = findViewById(R.id.mieum_btn);
        bieub_btn = findViewById(R.id.bieup_btn);
        siot_btn = findViewById(R.id.siot_btn);
        ieung_btn = findViewById(R.id.ieung_btn);
        jieut_btn = findViewById(R.id.jieut_btn);
        chieut_btn = findViewById(R.id.chieut_btn);
        kieuk_btn = findViewById(R.id.kieuk_btn);
        tieut_btn = findViewById(R.id.tieut_btn);
        pieup_btn = findViewById(R.id.pieup_btn);
        hieut_btn = findViewById(R.id.hieut_btn);
        seoul_btn = findViewById(R.id.seoul_btn);
        busan_btn = findViewById(R.id.busan_btn);
        chungbuk_btn = findViewById(R.id.chungbuk_btn);
        chungnam_btn = findViewById(R.id.chungnam_btn);
        daegu_btn = findViewById(R.id.daegu_btn);
        incheon_btn = findViewById(R.id.incheon_btn);
        jeonbuk_btn = findViewById(R.id.jeonbuk_btn);
        kwangju_btn = findViewById(R.id.kwangju_btn);
        sejong_btn = findViewById(R.id.sejong_btn);
        kangwon_btn = findViewById(R.id.kangwon_btn);

        giyeok_btn.setTextSize(text_size.getId());
        nieun_btn.setTextSize(text_size.getId());
        digeut_btn.setTextSize(text_size.getId());
        rieul_btn.setTextSize(text_size.getId());
        mieum_btn.setTextSize(text_size.getId());
        bieub_btn.setTextSize(text_size.getId());
        siot_btn.setTextSize(text_size.getId());
        ieung_btn.setTextSize(text_size.getId());
        jieut_btn.setTextSize(text_size.getId());
        chieut_btn.setTextSize(text_size.getId());
        kieuk_btn.setTextSize(text_size.getId());
        tieut_btn.setTextSize(text_size.getId());
        pieup_btn.setTextSize(text_size.getId());
        hieut_btn.setTextSize(text_size.getId());
        muju_btn.setTextSize(text_size.getId());
        muanairport_btn.setTextSize(text_size.getId());
        muan_btn.setTextSize(text_size.getId());
        maryang_btn.setTextSize(text_size.getId());
        masan_btn.setTextSize(text_size.getId());
        sejong_btn.setTextSize(text_size.getId());
        seoul_btn.setTextSize(text_size.getId());
        incheon_btn.setTextSize(text_size.getId());
        busan_btn.setTextSize(text_size.getId());
        kangwon_btn.setTextSize(text_size.getId());
        kwangju_btn.setTextSize(text_size.getId());
        jeonbuk_btn.setTextSize(text_size.getId());
        chungnam_btn.setTextSize(text_size.getId());
        chungbuk_btn.setTextSize(text_size.getId());
        daegu_btn.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("ㅁ 버튼을 누르게 되면 앞글자가 ㅁ인 버스 정류장들이 나옵니다." +
                                "오른쪽에 새로 생긴 버튼 중에서 가고 싶은 곳 버튼을 클릭해주세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("If you press the ㅁ button, bus stops with the first letter ㅁ appear." +
                                "Among the new buttons on the right, click the button where you want to go.");
                    }

                    muan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17_nouse.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    masan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17_nouse.this, Kiosk_18.class);
                            intent.putExtra("destination", "마산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    muanairport_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17_nouse.this, Kiosk_18.class);
                            intent.putExtra("destination", "무안공항");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    muju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17_nouse.this, Kiosk_18.class);
                            intent.putExtra("destination", "무주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    maryang_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_17_nouse.this, Kiosk_18.class);
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
                        muan_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) muan_btn.getBackground();
                        anim.start();
                        muanairport_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) muanairport_btn.getBackground();
                        anim.start();
                        muju_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) muju_btn.getBackground();
                        anim.start();
                        maryang_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) maryang_btn.getBackground();
                        anim.start();
                        masan_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) masan_btn.getBackground();
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

