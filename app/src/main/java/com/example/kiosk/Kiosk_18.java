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

import java.util.Locale;

public class Kiosk_18 extends AppCompatActivity {
    private TextToSpeech tts;
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private myapp text_size;
    private AnimationDrawable anim;
    Handler handler = new Handler();

    private TextView textView18;
    private TextView textView36;
    private TextView textView17;
    private TextView bus_departuretime;
    private TextView bus_type;
    private TextView bus_takentime;
    private TextView lastseat;

    private Button seat_selection1_btn;
    private Button seat_selection2_btn;
    private Button seat_selection3_btn;
    private Button soldout1_btn;
    private Button soldout2_btn;
    private Button soldout3_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk18);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView36 = findViewById(R.id.textView36);
        bus_departuretime = findViewById(R.id.bus_departuretime);
        bus_type = findViewById(R.id.bus_type);
        bus_takentime = findViewById(R.id.bus_takentime);
        lastseat = findViewById(R.id.lastseat);

        seat_selection1_btn = findViewById(R.id.seat_selection1_btn);
        seat_selection2_btn = findViewById(R.id.seat_selection2_btn);
        seat_selection3_btn = findViewById(R.id.seat_selection3_btn);
        soldout1_btn = findViewById(R.id.soldout1_btn);
        soldout2_btn = findViewById(R.id.soldout2_btn);
        soldout3_btn = findViewById(R.id.soldout3_btn);

        textView17.setTextSize(text_size.getId());
        textView36.setTextSize(text_size.getId());
        textView18.setTextSize(text_size.getId());
        bus_departuretime.setTextSize(text_size.getId());
        bus_type.setTextSize(text_size.getId());
        bus_takentime.setTextSize(text_size.getId());
        lastseat.setTextSize(text_size.getId());
        seat_selection1_btn.setTextSize(text_size.getId());
        seat_selection2_btn.setTextSize(text_size.getId());
        seat_selection3_btn.setTextSize(text_size.getId());
        soldout1_btn.setTextSize(text_size.getId());
        soldout2_btn.setTextSize(text_size.getId());
        soldout3_btn.setTextSize(text_size.getId());


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("가고 싶은 곳을 고르셨나요?" +
                                "그럼 이제 버스 종류, 출발 시간을 보고" +
                                "타고 싶은 버스를 고르기 위해 좌석 선택 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Have you chosen where you want to go? " +
                                "Then press the seat select button to see the bus type, " +
                                "departure time and select the bus you want to ride.");
                    }
                    Intent intent = getIntent();
                    String destination = intent.getStringExtra("destination");

                    //목적지 표시
                    textView18 = findViewById(R.id.textView18);
                    if (destination != null) {
                        textView18.setText(destination);
                    }

                    seat_selection1_btn = findViewById(R.id.seat_selection1_btn);
                    seat_selection2_btn = findViewById(R.id.seat_selection2_btn);
                    seat_selection3_btn = findViewById(R.id.seat_selection3_btn);

                    seat_selection1_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "우등버스");
                                intent.putExtra("price", "25,000원");
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "Honor bus");
                                intent.putExtra("price", "25,000won");
                                tts.shutdown();
                                startActivity(intent);
                            }

                        }
                    });

                    seat_selection2_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "고속버스");
                                intent.putExtra("price", "20,000원");
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else {
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "Express bus");
                                intent.putExtra("price", "20,000won");
                                tts.shutdown();
                                startActivity(intent);
                            }
                        }
                    });
                    seat_selection3_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "일반버스");
                                intent.putExtra("price", "15,000원");
                                tts.shutdown();
                                startActivity(intent);
                            }
                            else{
                                intent.putExtra("destination", destination);
                                intent.putExtra("bus", "Regular bus");
                                intent.putExtra("price", "15,000won");
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
                    speakText("좌석 선택 버튼은 여기에있어요.");
                else
                    speakText("The seat selection button is here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        seat_selection1_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) seat_selection1_btn.getBackground();
                        anim.start();
                        seat_selection2_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) seat_selection2_btn.getBackground();
                        anim.start();
                        seat_selection3_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) seat_selection3_btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 11000);
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




