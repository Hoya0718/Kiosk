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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Kiosk_19 extends AppCompatActivity {
    private TextToSpeech tts;//
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private AnimationDrawable anim;
    Handler handler = new Handler();
    private myapp text_size;
    private TextView textView32;
    private TextView textView34;
    private TextView textView33;
    private Button b_1_btn, b_2_btn, b_3_btn, b_4_btn, b_5_btn;
    private Button b_6_btn, b_7_btn, b_8_btn, b_9_btn, b_10_btn;
    private Button b_11_btn, b_12_btn, b_13_btn, b_14_btn, b_15_btn;
    private Button b_16_btn, b_17_btn, b_18_btn, b_19_btn, b_20_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kiosk19);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        b_1_btn = findViewById(R.id.b_1_btn);
        b_2_btn = findViewById(R.id.b_2_btn);
        b_3_btn = findViewById(R.id.b_3_btn);
        b_4_btn = findViewById(R.id.b_4_btn);
        b_5_btn = findViewById(R.id.b_5_btn);
        b_6_btn = findViewById(R.id.b_6_btn);
        b_7_btn = findViewById(R.id.b_7_btn);
        b_8_btn = findViewById(R.id.b_8_btn);
        b_9_btn = findViewById(R.id.b_9_btn);
        b_10_btn = findViewById(R.id.b_10_btn);
        b_11_btn = findViewById(R.id.b_11_btn);
        b_12_btn = findViewById(R.id.b_12_btn);
        b_13_btn = findViewById(R.id.b_13_btn);
        b_14_btn = findViewById(R.id.b_14_btn);
        b_15_btn = findViewById(R.id.b_15_btn);
        b_16_btn = findViewById(R.id.b_16_btn);
        b_17_btn = findViewById(R.id.b_17_btn);
        b_18_btn = findViewById(R.id.b_18_btn);
        b_19_btn = findViewById(R.id.b_19_btn);
        b_20_btn = findViewById(R.id.b_20_btn);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);

        b_1_btn.setTextSize(text_size.getId());
        b_2_btn.setTextSize(text_size.getId());
        b_3_btn.setTextSize(text_size.getId());
        b_4_btn.setTextSize(text_size.getId());
        b_5_btn.setTextSize(text_size.getId());
        b_6_btn.setTextSize(text_size.getId());
        b_7_btn.setTextSize(text_size.getId());
        b_8_btn.setTextSize(text_size.getId());
        b_9_btn.setTextSize(text_size.getId());
        b_10_btn.setTextSize(text_size.getId());
        b_11_btn.setTextSize(text_size.getId());
        b_12_btn.setTextSize(text_size.getId());
        b_13_btn.setTextSize(text_size.getId());
        b_14_btn.setTextSize(text_size.getId());
        b_15_btn.setTextSize(text_size.getId());
        b_16_btn.setTextSize(text_size.getId());
        b_17_btn.setTextSize(text_size.getId());
        b_18_btn.setTextSize(text_size.getId());
        b_19_btn.setTextSize(text_size.getId());
        b_20_btn.setTextSize(text_size.getId());
        textView32.setTextSize(text_size.getId());
        textView33.setTextSize(text_size.getId());
        textView34.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("앉고 싶은 좌석를 예매할 수 있는 화면입니다. 버스 좌석 번호는 앞 자리의 운전석을 기준으로 배정되어있습니다." +
                                "매진이라고 써진 좌석은 다른 사람이 이미 예약해서 선택할 수 없는 좌석입니다." +
                                "매진이 써지지 않은 다른 좌석을 골라주세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is a screen where you can reserve a seat you want to sit on." +
                                "Bus seat numbers are occupied based on the production seat in the front seat." +
                                "Seats marked sold out are seats that have already been reserved by someone else and cannot be selected." +
                                "Choose a different seat");
                    }


                    b_3_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                String seat = intent1.getStringExtra("seat");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "3번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else{
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String destination = intent1.getStringExtra("destination");
                                String bus = intent1.getStringExtra("bus");
                                String seat = intent1.getStringExtra("seat");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "3");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });

                    b_4_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "4번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "4");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_5_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "5번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "5");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });


                    b_6_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "6번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "6");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_10_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "10번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "10");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_14_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "14번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "14");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_15_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "15번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "15");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_16_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "16번");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String departuretime = intent1.getStringExtra("departuretime");
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("departuretime", departuretime);
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "16");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
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
                                    speakText("앉고 싶은 좌석을 선택해주세요.");
                                else
                                    speakText("Please select the seat you would like to sit on.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            b_3_btn.setBackgroundResource(R.drawable.anim_list);
                            b_4_btn.setBackgroundResource(R.drawable.anim_list);
                            b_5_btn.setBackgroundResource(R.drawable.anim_list);
                            b_6_btn.setBackgroundResource(R.drawable.anim_list);
                            b_10_btn.setBackgroundResource(R.drawable.anim_list);
                            b_14_btn.setBackgroundResource(R.drawable.anim_list);
                            b_15_btn.setBackgroundResource(R.drawable.anim_list);
                            b_16_btn.setBackgroundResource(R.drawable.anim_list);

                            anim = (AnimationDrawable) b_3_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_4_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_5_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_6_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_10_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_14_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_15_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) b_16_btn.getBackground();
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