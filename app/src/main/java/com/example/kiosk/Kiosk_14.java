package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
    private TextToSpeech tts;
    private myapp sound;
    Animation Scale;
    private Button button9;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MMM/d/E요일", Locale.KOREAN);
    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("이 화면에서는 버스 표를 구매하실 수 있습니다." +
                                "승차권 구매 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("From this screen you can purchase bus tickets." +
                                "Click the buy ticket button");
                    }


                    textView11 = (TextView) findViewById(R.id.textView11);

                    Calendar c = Calendar.getInstance();

                    SimpleDateFormat format;

                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm:ss", Locale.KOREAN);
                    else
                        format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm:ss", Locale.ENGLISH);


                    textView11.setText(format.format(c.getTime()));

                    button9 = findViewById(R.id.button9);

                    Scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                    button9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            button9.startAnimation(Scale);
                            Intent intent = new Intent(Kiosk_14.this, Kiosk_15.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });
                }
            }
        });
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


