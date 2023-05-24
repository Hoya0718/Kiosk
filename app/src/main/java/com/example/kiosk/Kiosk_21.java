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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Kiosk_21 extends AppCompatActivity {
    private String destination = "목적지"; //목적지
    private String price = "표 가격";
    private String seat = "좌석 번호";

    private TextView textView5, textView6, textView12, textView14, textView16, textView20;
    private TextToSpeech tts;
    private int currentVolume;
    private AudioManager audioManager;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    Handler handler = new Handler();

    private Button b_cancel_btn; //취소하기
    private Button b_payment_btn; //결제하기


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk21);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView12 = findViewById(R.id.textView12);
        textView14 = findViewById(R.id.textView14);
        textView16 = findViewById(R.id.textView16);
        textView20 = findViewById(R.id.textView20);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);

        textView5.setTextSize(text_size.getId());
        textView6.setTextSize(text_size.getId());
        textView12.setTextSize(text_size.getId());
        textView14.setTextSize(text_size.getId());
        textView16.setTextSize(text_size.getId());
        textView20.setTextSize(text_size.getId());
        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());

        Intent intent = getIntent();

        String destination = intent.getStringExtra("desnination");
        String bus = intent.getStringExtra("bus");
        String seat = intent.getStringExtra("seat");

        textView5.setText(destination);
        textView16.setText(bus);
        textView20.setText(seat);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("목적지는 맞게 골랐는지. 버스 종류와 좌석은 정확하게 골랐는지" +
                                " 확인해주시고, 맞게 고르셨다면 결제하기 버튼을 눌러주세요" +
                                "만약 잘못 고르셨다면 취소하기 버튼을 눌러서 " +
                                "이전 화면으로 돌아가실 수 있습니다.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Make sure you have chosen the correct destination, bus type and seat" +
                                "If you have selected the right one, please click the checkout button" +
                                "If you make a mistake, you can click the Cancel button " +
                                "to return to the previous screen.");
                    }


                    b_cancel_btn = findViewById(R.id.b_cancel_btn);
                    b_payment_btn = findViewById(R.id.b_payment_btn);

                    b_cancel_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_14.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                    b_payment_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_22.class);
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
                    speakText("결제하기 버튼은 여기에있어요.");
                else
                    speakText("The payment button is here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b_payment_btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) b_payment_btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 16000);
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