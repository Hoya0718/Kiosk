package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Kiosk_16 extends AppCompatActivity implements View.OnClickListener {

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    private int currentVolume;
    private AudioManager audioManager;
    Handler handler = new Handler();

    private Button seoul_btn, incheon_btn, kangwon_btn, sejong_btn;
    private Button chungnam_btn, chungbuk_btn, kwangju_btn, jeonbuk_btn;
    private Button busan_btn, daegu_btn, giyeok_btn, nieun_btn;
    private Button digeut_btn, rieul_btn, mieum_btn, bieup_btn;
    private Button siot_btn, ieung_btn, jieut_btn, chieut_btn;
    private Button kieuk_btn, tieut_btn, pieup_btn, hieut_btn;

    // 서울
    private Button central_btn, eastseoul_btn;
    // 인천/경기
    private Button incheonairport_btn, sungnam_btn;
    private Button suwon_btn, ansan_btn, yongin_btn;
    // 강원
    private Button gangneung_btn, chunchun_btn, sokcho_btn;
    // 대전/세종
    private Button daejun_bus_btn, sejong_bus_btn;
    // 충남
    private Button nonsan_btn, cheonan_btn, gongju_btn;
    // 충북
    private Button cheongju_btn, jechun_btn, chungju_btn;
    // 광주/전남
    private Button kwangju_bus_btn, suncheon_btn, damyang_btn, naju_btn;
    // 전북
    private Button jeonju_btn, gunsan_btn, namwon_btn;
    // 부산/경남
    private Button busan_bus_btn, ulsan_btn, gimhae_btn;
    // 대구/경북
    private Button eastdaegu_btn, westdaegu_btn, gyeongju_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        giyeok_btn = findViewById(R.id.giyeok_btn); nieun_btn = findViewById(R.id.nieun_btn);
        digeut_btn = findViewById(R.id.digeut_btn); rieul_btn = findViewById(R.id.rieul_btn);
        mieum_btn = findViewById(R.id.mieum_btn); bieup_btn = findViewById(R.id.bieup_btn);
        siot_btn = findViewById(R.id.siot_btn); ieung_btn = findViewById(R.id.ieung_btn);
        jieut_btn = findViewById(R.id.jieut_btn); chieut_btn = findViewById(R.id.chieut_btn);
        kieuk_btn = findViewById(R.id.kieuk_btn); tieut_btn = findViewById(R.id.tieut_btn);
        pieup_btn= findViewById(R.id.pieup_btn); hieut_btn = findViewById(R.id.hieut_btn);
        seoul_btn = findViewById(R.id.seoul_btn); busan_btn = findViewById(R.id.busan_btn);
        chungbuk_btn = findViewById(R.id.chungbuk_btn); chungnam_btn = findViewById(R.id.chungnam_btn);
        daegu_btn = findViewById(R.id.daegu_btn); incheon_btn = findViewById(R.id.incheon_btn);
        jeonbuk_btn = findViewById(R.id.jeonbuk_btn); kwangju_btn = findViewById(R.id.kwangju_btn);
        sejong_btn = findViewById(R.id.sejong_btn); kangwon_btn = findViewById(R.id.kangwon_btn);
        central_btn = findViewById(R.id.central_btn); eastseoul_btn = findViewById(R.id.eastseoul_btn);
        incheonairport_btn = findViewById(R.id.incheonairport_btn);
        sungnam_btn = findViewById(R.id.sungnam_btn); suwon_btn = findViewById(R.id.suwon_btn);
        ansan_btn = findViewById(R.id.ansan_btn); yongin_btn = findViewById(R.id.yongin_btn);
        gangneung_btn = findViewById(R.id.gangneung_btn); chunchun_btn = findViewById(R.id.chunchun_btn);
        sokcho_btn = findViewById(R.id.sokcho_btn); daejun_bus_btn = findViewById(R.id.daejun_bus_btn);
        sejong_bus_btn = findViewById(R.id.sejong_bus_btn); nonsan_btn = findViewById(R.id.nonsan_btn);
        cheonan_btn = findViewById(R.id.cheonan_btn); gongju_btn = findViewById(R.id.gongju_btn);
        cheongju_btn = findViewById(R.id.cheongju_btn); chungju_btn = findViewById(R.id.chungju_btn);
        jechun_btn = findViewById(R.id.jechun_btn); kwangju_bus_btn = findViewById(R.id.kwangju_bus_btn);
        suncheon_btn = findViewById(R.id.suncheon_btn); damyang_btn = findViewById(R.id.damyang_btn);
        naju_btn = findViewById(R.id.naju_btn); jeonju_btn = findViewById(R.id.jeonju_btn);
        gunsan_btn = findViewById(R.id.gunsan_btn); namwon_btn = findViewById(R.id.namwon_btn);
        busan_bus_btn = findViewById(R.id.busan_bus_btn); ulsan_btn = findViewById(R.id.ulsan_btn);
        gimhae_btn = findViewById(R.id.gimhae_btn); eastdaegu_btn = findViewById(R.id.eastdaegu_btn);
        westdaegu_btn = findViewById(R.id.westdaegu_btn); gyeongju_btn = findViewById(R.id.gyeongju_btn);

        giyeok_btn.setTextSize(text_size.getId()); nieun_btn.setTextSize(text_size.getId());
        digeut_btn.setTextSize(text_size.getId()); rieul_btn.setTextSize(text_size.getId());
        mieum_btn.setTextSize(text_size.getId()); bieup_btn.setTextSize(text_size.getId());
        siot_btn.setTextSize(text_size.getId()); ieung_btn.setTextSize(text_size.getId());
        jieut_btn.setTextSize(text_size.getId()); chieut_btn.setTextSize(text_size.getId());
        kieuk_btn.setTextSize(text_size.getId()); tieut_btn.setTextSize(text_size.getId());
        pieup_btn.setTextSize(text_size.getId()); hieut_btn.setTextSize(text_size.getId());
        sejong_btn.setTextSize(text_size.getId()); seoul_btn.setTextSize(text_size.getId());
        incheon_btn.setTextSize(text_size.getId()); busan_btn.setTextSize(text_size.getId());
        kangwon_btn.setTextSize(text_size.getId()); kwangju_btn.setTextSize(text_size.getId());
        jeonbuk_btn.setTextSize(text_size.getId()); chungnam_btn.setTextSize(text_size.getId());
        chungbuk_btn.setTextSize(text_size.getId()); daegu_btn.setTextSize(text_size.getId());
        central_btn.setTextSize(text_size.getId()); eastseoul_btn.setTextSize(text_size.getId());
        incheonairport_btn.setTextSize(text_size.getId());
        sungnam_btn.setTextSize(text_size.getId()); suwon_btn.setTextSize(text_size.getId());
        ansan_btn.setTextSize(text_size.getId()); yongin_btn.setTextSize(text_size.getId());
        gangneung_btn.setTextSize(text_size.getId()); chunchun_btn.setTextSize(text_size.getId());
        sokcho_btn.setTextSize(text_size.getId()); daejun_bus_btn.setTextSize(text_size.getId());
        sejong_bus_btn.setTextSize(text_size.getId()); nonsan_btn.setTextSize(text_size.getId());
        cheonan_btn.setTextSize(text_size.getId()); gongju_btn.setTextSize(text_size.getId());
        cheongju_btn.setTextSize(text_size.getId()); chungju_btn.setTextSize(text_size.getId());
        jechun_btn.setTextSize(text_size.getId()); kwangju_bus_btn.setTextSize(text_size.getId());
        suncheon_btn.setTextSize(text_size.getId()); damyang_btn.setTextSize(text_size.getId());
        naju_btn.setTextSize(text_size.getId()); jeonju_btn.setTextSize(text_size.getId());
        gunsan_btn.setTextSize(text_size.getId()); namwon_btn.setTextSize(text_size.getId());
        busan_bus_btn.setTextSize(text_size.getId()); ulsan_btn.setTextSize(text_size.getId());
        gimhae_btn.setTextSize(text_size.getId()); eastdaegu_btn.setTextSize(text_size.getId());
        westdaegu_btn.setTextSize(text_size.getId()); gyeongju_btn.setTextSize(text_size.getId());

        busan_btn.setOnClickListener(this); jeonbuk_btn.setOnClickListener(this);
        seoul_btn.setOnClickListener(this); incheon_btn.setOnClickListener(this);
        kwangju_btn.setOnClickListener(this); sejong_btn.setOnClickListener(this);
        kangwon_btn.setOnClickListener(this); daegu_btn.setOnClickListener(this);
        chungbuk_btn.setOnClickListener(this); chungnam_btn.setOnClickListener(this);
        giyeok_btn.setOnClickListener(this); nieun_btn.setOnClickListener(this);
        digeut_btn.setOnClickListener(this); rieul_btn.setOnClickListener(this);
        mieum_btn.setOnClickListener(this); bieup_btn.setOnClickListener(this);
        siot_btn.setOnClickListener(this); ieung_btn.setOnClickListener(this);
        jieut_btn.setOnClickListener(this); chieut_btn.setOnClickListener(this);
        kieuk_btn.setOnClickListener(this); tieut_btn.setOnClickListener(this);
        pieup_btn.setOnClickListener(this); hieut_btn.setOnClickListener(this);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("이곳에서는 목적지를 선택하실 수 있습니다. 서울, 강원 등의 버튼을 누르면 그 지역에 있는 버스 정류장을 찾을 수 있습니다." +
                                    "또 ㄱ,ㄴ,ㄷ 버튼을 누르면 그 단어로 시작하는 정류장들을 찾을 수 있습니다." +
                                    "동서울 버스 정류장을 찾아볼까요? 서울 버튼 혹은 ㄷ 버튼을 눌러주세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Here you can choose your destination. If you press a button for Seoul, Gangwon, etc., you can find bus stops in that area." +
                                "Also, if you press the ㄱ, ㄴ, ㄷ buttons, you can find stops starting with that word." +
                                "Shall we find the East Seoul bus stop? Please press the Seoul button or the ㄷ button.");
                    }

                    eastseoul_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "동서울");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    central_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "센트럴시티");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    incheonairport_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "인천공항");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    sungnam_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "성남");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    suwon_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "수원");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    ansan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "안산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    yongin_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "용인");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    gangneung_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "강릉");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    chunchun_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "춘천");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    sokcho_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "속초");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    daejun_bus_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "대전");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    sejong_bus_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "세종");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    nonsan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "논산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    cheonan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "천안");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    gongju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "공주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    cheongju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "청주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    jechun_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "제천");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    chungju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "충주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    kwangju_bus_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "광주(유스퀘어)");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    suncheon_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "순천");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    damyang_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "담양");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    naju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "나주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    jeonju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "전주");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    gunsan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "군산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    namwon_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "남원");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    busan_bus_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "부산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    ulsan_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "울산");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    gimhae_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "김해");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    eastdaegu_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "동대구");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    westdaegu_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "서대구");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    gyeongju_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "경주");
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
                                    speakText("서울 버튼, ㄷ 버튼을  눌러서 동서울을 찾을 수 있습니다.");
                                else
                                    speakText("Buy ticket button is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            seoul_btn.setBackgroundResource(R.drawable.anim_list);
                            digeut_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) seoul_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) digeut_btn.getBackground();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seoul_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (eastseoul_btn.getVisibility() == View.GONE) {
                    eastseoul_btn.setVisibility(View.VISIBLE);
                    central_btn.setVisibility(View.VISIBLE);
                }
                else {
                    eastseoul_btn.setVisibility(View.GONE);
                    central_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.incheon_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (incheonairport_btn.getVisibility() == View.GONE) {
                    incheonairport_btn.setVisibility(View.VISIBLE);
                    sungnam_btn.setVisibility(View.VISIBLE);
                    suwon_btn.setVisibility(View.VISIBLE);
                    ansan_btn.setVisibility(View.VISIBLE);
                    yongin_btn.setVisibility(View.VISIBLE);
                }
                else {
                    incheonairport_btn.setVisibility(View.GONE);
                    sungnam_btn.setVisibility(View.GONE);
                    suwon_btn.setVisibility(View.GONE);
                    ansan_btn.setVisibility(View.GONE);
                    yongin_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.kangwon_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (gangneung_btn.getVisibility() == View.GONE) {
                    gangneung_btn.setVisibility(View.VISIBLE);
                    sokcho_btn.setVisibility(View.VISIBLE);
                    chunchun_btn.setVisibility(View.VISIBLE);
                }
                else {
                    gangneung_btn.setVisibility(View.GONE);
                    sokcho_btn.setVisibility(View.GONE);
                    chunchun_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.sejong_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (daejun_bus_btn.getVisibility() == View.GONE) {
                    daejun_bus_btn.setVisibility(View.VISIBLE);
                    sejong_bus_btn.setVisibility(View.VISIBLE);
                }
                else {
                    daejun_bus_btn.setVisibility(View.GONE);
                    sejong_bus_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.chungnam_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (nonsan_btn.getVisibility() == View.GONE) {
                    nonsan_btn.setVisibility(View.VISIBLE);
                    cheonan_btn.setVisibility(View.VISIBLE);
                    gongju_btn.setVisibility(View.VISIBLE);
                }
                else {
                    nonsan_btn.setVisibility(View.GONE);
                    cheonan_btn.setVisibility(View.GONE);
                    gongju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.chungbuk_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (cheongju_btn.getVisibility() == View.GONE) {
                    cheongju_btn.setVisibility(View.VISIBLE);
                    chungju_btn.setVisibility(View.VISIBLE);
                    jechun_btn.setVisibility(View.VISIBLE);
                }
                else {
                    cheongju_btn.setVisibility(View.GONE);
                    chungju_btn.setVisibility(View.GONE);
                    jechun_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.kwangju_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (kwangju_bus_btn.getVisibility() == View.GONE) {
                    kwangju_bus_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.VISIBLE);
                    damyang_btn.setVisibility(View.VISIBLE);
                    naju_btn.setVisibility(View.VISIBLE);
                }
                else {
                    kwangju_bus_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.GONE);
                    damyang_btn.setVisibility(View.GONE);
                    naju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.jeonbuk_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (jeonju_btn.getVisibility() == View.GONE) {
                    jeonju_btn.setVisibility(View.VISIBLE);
                    gunsan_btn.setVisibility(View.VISIBLE);
                    namwon_btn.setVisibility(View.VISIBLE);
                }
                else {
                    jeonju_btn.setVisibility(View.GONE);
                    gunsan_btn.setVisibility(View.GONE);
                    namwon_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.busan_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (busan_bus_btn.getVisibility() == View.GONE) {
                    busan_bus_btn.setVisibility(View.VISIBLE);
                    ulsan_btn.setVisibility(View.VISIBLE);
                    gimhae_btn.setVisibility(View.VISIBLE);
                }
                else {
                    busan_bus_btn.setVisibility(View.GONE);
                    ulsan_btn.setVisibility(View.GONE);
                    gimhae_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.daegu_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (eastdaegu_btn.getVisibility() == View.GONE) {
                    eastdaegu_btn.setVisibility(View.VISIBLE);
                    westdaegu_btn.setVisibility(View.VISIBLE);
                    gyeongju_btn.setVisibility(View.VISIBLE);
                }
                else {
                    eastdaegu_btn.setVisibility(View.GONE);
                    westdaegu_btn.setVisibility(View.GONE);
                    gyeongju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.giyeok_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(gangneung_btn.getVisibility() == View.GONE) {
                    gangneung_btn.setVisibility(View.VISIBLE);
                    gyeongju_btn.setVisibility(View.VISIBLE);
                    gunsan_btn.setVisibility(View.VISIBLE);
                    kwangju_bus_btn.setVisibility(View.VISIBLE);
                    gongju_btn.setVisibility(View.VISIBLE);
                    gimhae_btn.setVisibility(View.VISIBLE);
                }
                else {
                    gangneung_btn.setVisibility(View.GONE);
                    gyeongju_btn.setVisibility(View.GONE);
                    gunsan_btn.setVisibility(View.GONE);
                    kwangju_bus_btn.setVisibility(View.GONE);
                    gongju_btn.setVisibility(View.GONE);
                    gimhae_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.nieun_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(nonsan_btn.getVisibility() == View.GONE) {
                    nonsan_btn.setVisibility(View.VISIBLE);
                    naju_btn.setVisibility(View.VISIBLE);
                    namwon_btn.setVisibility(View.VISIBLE);
                }
                else {
                    nonsan_btn.setVisibility(View.GONE);
                    naju_btn.setVisibility(View.GONE);
                    namwon_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.digeut_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(eastseoul_btn.getVisibility() == View.GONE) {
                    eastseoul_btn.setVisibility(View.VISIBLE);
                    daejun_bus_btn.setVisibility(View.VISIBLE);
                    damyang_btn.setVisibility(View.VISIBLE);
                    eastdaegu_btn.setVisibility(View.VISIBLE);
                }
                else {
                    eastseoul_btn.setVisibility(View.GONE);
                    daejun_bus_btn.setVisibility(View.GONE);
                    damyang_btn.setVisibility(View.GONE);
                    eastdaegu_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.bieup_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(busan_bus_btn.getVisibility() == View.GONE) {
                    busan_bus_btn.setVisibility(View.VISIBLE);
                }
                else {
                    busan_bus_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.siot_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(central_btn.getVisibility() == View.GONE) {
                    central_btn.setVisibility(View.VISIBLE);
                    suwon_btn.setVisibility(View.VISIBLE);
                    sejong_btn.setVisibility(View.VISIBLE);
                    sokcho_btn.setVisibility(View.VISIBLE);
                    suncheon_btn.setVisibility(View.VISIBLE);
                    westdaegu_btn.setVisibility(View.VISIBLE);
                    sungnam_btn.setVisibility(View.VISIBLE);
                }
                else {
                    central_btn.setVisibility(View.GONE);
                    suwon_btn.setVisibility(View.GONE);
                    sejong_btn.setVisibility(View.GONE);
                    sokcho_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.GONE);
                    westdaegu_btn.setVisibility(View.GONE);
                    sungnam_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.ieung_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(incheonairport_btn.getVisibility() == View.GONE) {
                    incheonairport_btn.setVisibility(View.VISIBLE);
                    ansan_btn.setVisibility(View.VISIBLE);
                    yongin_btn.setVisibility(View.VISIBLE);
                    ulsan_btn.setVisibility(View.VISIBLE);
                }
                else {
                    incheonairport_btn.setVisibility(View.GONE);
                    ansan_btn.setVisibility(View.GONE);
                    yongin_btn.setVisibility(View.GONE);
                    ulsan_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.jieut_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(jeonju_btn.getVisibility() == View.GONE) {
                    jeonju_btn.setVisibility(View.VISIBLE);
                    jechun_btn.setVisibility(View.VISIBLE);
                }
                else {
                    jeonju_btn.setVisibility(View.GONE);
                    jechun_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.chieut_btn:
                eastseoul_btn.setVisibility(View.GONE); central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE); sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE); ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE); gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE); sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE); sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE); cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE); cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE); chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE); suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE); naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE); gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE); busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE); gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE); westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if(chunchun_btn.getVisibility() == View.GONE) {
                    chunchun_btn.setVisibility(View.VISIBLE);
                    cheonan_btn.setVisibility(View.VISIBLE);
                    cheongju_btn.setVisibility(View.VISIBLE);
                    chungju_btn.setVisibility(View.VISIBLE);
                }
                else {
                    chunchun_btn.setVisibility(View.GONE);
                    cheonan_btn.setVisibility(View.GONE);
                    cheongju_btn.setVisibility(View.GONE);
                    chungju_btn.setVisibility(View.GONE);
                }
                break;
        }
    }


    private void performSearch(String query) {
        Toast.makeText(this, "검색어 : " + query, Toast.LENGTH_SHORT).show();
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


