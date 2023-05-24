package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Kiosk_19 extends AppCompatActivity {
    private TextToSpeech tts;
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private AnimationDrawable anim;
    Handler handler = new Handler();
    private myapp text_size;
    private TextView textView32;
    private TextView textView34;
    private TextView textView33;
    private Button b_soldout1_btn;
    private Button b_soldout2_btn;
    private Button b_soldout3_btn;
    private Button b_soldout4_btn;
    private Button b_soldout5_btn;
    private Button b_soldout6_btn;
    private Button b_soldout7_btn;
    private Button b_soldout8_btn;
    private Button b_soldout9_btn;
    private Button b_soldout10_btn;
    private Button b_soldout11_btn;
    private Button b_soldout12_btn;
    private Button b_4A_btn;
    private Button b_4B_btn;
    private Button b_3B_btn;
    private Button b_2B_btn;
    private Button b_5C_btn;
    private Button b_5D_btn;
    private Button b_2C_btn;
    private Button b_2D_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kiosk19);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        b_soldout1_btn = findViewById(R.id.b_soldout1_btn);
        b_soldout2_btn = findViewById(R.id.b_soldout2_btn);
        b_soldout3_btn = findViewById(R.id.b_soldout3_btn);
        b_soldout4_btn = findViewById(R.id.b_soldout4_btn);
        b_soldout5_btn = findViewById(R.id.b_soldout5_btn);
        b_soldout6_btn = findViewById(R.id.b_soldout6_btn);
        b_soldout7_btn = findViewById(R.id.b_soldout7_btn);
        b_soldout8_btn = findViewById(R.id.b_soldout8_btn);
        b_soldout9_btn = findViewById(R.id.b_soldout9_btn);
        b_soldout10_btn = findViewById(R.id.b_soldout10_btn);
        b_soldout11_btn = findViewById(R.id.b_soldout11_btn);
        b_soldout12_btn = findViewById(R.id.b_soldout12_btn);
        b_4A_btn = findViewById(R.id.b_4A_btn);
        b_4B_btn = findViewById(R.id.b_4B_btn);
        b_2B_btn = findViewById(R.id.b_2B_btn);
        b_3B_btn = findViewById(R.id.b_3B_btn);
        b_5C_btn = findViewById(R.id.b_5C_btn);
        b_5D_btn = findViewById(R.id.b_5D_btn);
        b_2C_btn = findViewById(R.id.b_2C_btn);
        b_2D_btn = findViewById(R.id.b_2D_btn);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);

        b_soldout1_btn.setTextSize(text_size.getId());
        b_soldout2_btn.setTextSize(text_size.getId());
        b_soldout3_btn.setTextSize(text_size.getId());
        b_soldout4_btn.setTextSize(text_size.getId());
        b_soldout5_btn.setTextSize(text_size.getId());
        b_soldout6_btn.setTextSize(text_size.getId());
        b_soldout7_btn.setTextSize(text_size.getId());
        b_soldout8_btn.setTextSize(text_size.getId());
        b_soldout9_btn.setTextSize(text_size.getId());
        b_soldout10_btn.setTextSize(text_size.getId());
        b_soldout11_btn.setTextSize(text_size.getId());
        b_soldout12_btn.setTextSize(text_size.getId());
        b_4A_btn.setTextSize(text_size.getId());
        b_4B_btn.setTextSize(text_size.getId());
        b_3B_btn.setTextSize(text_size.getId());
        b_2B_btn.setTextSize(text_size.getId());
        b_5C_btn.setTextSize(text_size.getId());
        b_5D_btn.setTextSize(text_size.getId());
        b_2C_btn.setTextSize(text_size.getId());
        b_2D_btn.setTextSize(text_size.getId());
        textView32.setTextSize(text_size.getId());
        textView33.setTextSize(text_size.getId());
        textView34.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("앉고 싶은 자리를 예매할 수 있는 화면입니다." +
                                "매진이라고 써진 좌석은 다른 사람이 이미 예약해서" +
                                "선택할 수 없는 좌석입니다. 다른 좌석을 골라주세요.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is a screen where you can reserve a seat you want to sit on." +
                                "Seats marked sold out are seats that have already been reserved by someone else and cannot be selected." +
                                "Choose a different seat");
                    }


                    b_3B_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                String seat = intent1.getStringExtra("seat");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 3B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else{
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                String seat = intent1.getStringExtra("seat");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 3B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });

                    b_4B_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 4B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 4B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_4A_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 4A");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 4A");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });


                    b_2B_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 2B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 2B");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_5D_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 5D");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 5D");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_5C_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 5C");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 5C");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_2C_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 2C");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 2C");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    b_2D_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "좌석 번호 : 2D");
                                String price = intent1.getStringExtra("price");
                                intent.putExtra("price", price);
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                Intent intent1 = getIntent();
                                String bus = intent1.getStringExtra("bus");
                                String destination = intent1.getStringExtra("destination");
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", bus);
                                intent.putExtra("seat", "Seat : 2D");
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
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("좌석 선택 버튼은 여기에 있어요.");
                else
                    speakText("The seat selection button is here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b_4A_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_4A_btn.getBackground();
                        anim.start();
                        b_4B_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_4B_btn.getBackground();
                        anim.start();
                        b_3B_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_3B_btn.getBackground();
                        anim.start();
                        b_2B_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_2B_btn.getBackground();
                        anim.start();
                        b_5C_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_5C_btn.getBackground();
                        anim.start();
                        b_5D_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_5D_btn.getBackground();
                        anim.start();
                        b_2C_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_2C_btn.getBackground();
                        anim.start();
                        b_2D_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_2D_btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 14000);
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