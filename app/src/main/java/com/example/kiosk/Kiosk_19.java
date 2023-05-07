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
    private Button button43;
    private Button button44;
    private Button button45;
    private Button button46;
    private Button button53;
    private Button button54;
    private Button button47;
    private Button button48;
    private Button button55;
    private Button button56;
    private Button button57;
    private Button button58;
    private Button button50;
    private Button button49;
    private Button button59;
    private Button button60;
    private Button button51;
    private Button button52;
    private Button button61;
    private Button button62;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kiosk19);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        button43 = findViewById(R.id.button43);
        button44 = findViewById(R.id.button44);
        button45 = findViewById(R.id.button45);
        button46 = findViewById(R.id.button46);
        button47 = findViewById(R.id.button47);
        button48 = findViewById(R.id.button48);
        button49 = findViewById(R.id.button49);
        button50 = findViewById(R.id.button50);
        button51 = findViewById(R.id.button51);
        button52 = findViewById(R.id.button52);
        button53 = findViewById(R.id.button53);
        button54 = findViewById(R.id.button54);
        button55 = findViewById(R.id.button55);
        button56 = findViewById(R.id.button56);
        button57 = findViewById(R.id.button57);
        button58 = findViewById(R.id.button58);
        button59 = findViewById(R.id.button59);
        button60 = findViewById(R.id.button60);
        button61 = findViewById(R.id.button61);
        button62 = findViewById(R.id.button62);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);

        button43.setTextSize(text_size.getId());
        button44.setTextSize(text_size.getId());
        button45.setTextSize(text_size.getId());
        button46.setTextSize(text_size.getId());
        button47.setTextSize(text_size.getId());
        button48.setTextSize(text_size.getId());
        button49.setTextSize(text_size.getId());
        button50.setTextSize(text_size.getId());
        button51.setTextSize(text_size.getId());
        button52.setTextSize(text_size.getId());
        button53.setTextSize(text_size.getId());
        button54.setTextSize(text_size.getId());
        button55.setTextSize(text_size.getId());
        button56.setTextSize(text_size.getId());
        button57.setTextSize(text_size.getId());
        button58.setTextSize(text_size.getId());
        button59.setTextSize(text_size.getId());
        button60.setTextSize(text_size.getId());
        button61.setTextSize(text_size.getId());
        button62.setTextSize(text_size.getId());
        textView32.setTextSize(text_size.getId());
        textView33.setTextSize(text_size.getId());
        textView34.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("매진이라고 써진 회색 좌석은 다른 사람이 이미 예약해서" +
                                "선택할 수 없는 좌석입니다. 다른 좌석을 골라주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Gray seats with Sold out are seats that have already been" +
                                "reserved by someone else and and cannot be selected" +
                                "Choose a different seat");
                    }


                    button45.setOnClickListener(new View.OnClickListener() {
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

                    button47.setOnClickListener(new View.OnClickListener() {
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
                    button48.setOnClickListener(new View.OnClickListener() {
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


                    button49.setOnClickListener(new View.OnClickListener() {
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
                    button53.setOnClickListener(new View.OnClickListener() {
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
                    button54.setOnClickListener(new View.OnClickListener() {
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
                    button59.setOnClickListener(new View.OnClickListener() {
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
                    button60.setOnClickListener(new View.OnClickListener() {
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
                        button45.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button45.getBackground();
                        anim.start();
                        button47.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button47.getBackground();
                        anim.start();
                        button48.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button48.getBackground();
                        anim.start();
                        button49.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button49.getBackground();
                        anim.start();
                        button53.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button53.getBackground();
                        anim.start();
                        button54.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button54.getBackground();
                        anim.start();
                        button59.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button59.getBackground();
                        anim.start();
                        button60.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) button60.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
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
}