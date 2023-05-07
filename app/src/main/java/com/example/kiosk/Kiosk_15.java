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

    private TextToSpeech tts;
    private int currentVolume;
    private AudioManager audioManager;

    private myapp sound;
    private myapp text_size;

    private Button button15; //도착지 버튼
    private Button button16; //홈 버튼
    private TextView textView10;
    private TextView textView102;
    private TextView textView15;

    public AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk15);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        textView10 = findViewById(R.id.textView10);
        textView15 = findViewById(R.id.textView15);
        textView102 = findViewById(R.id.textView102);

        button15.setTextSize(text_size.getId());
        button16.setTextSize(text_size.getId());
        textView10.setTextSize(text_size.getId());
        textView15.setTextSize(text_size.getId());
        textView102.setTextSize(text_size.getId());



        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("이 화면에서는 도착지를 선택할 수 있습니다." +
                                "목적지 버튼을 눌러주세요" +
                                "만약 처음 화면으로 돌아가고 싶으시면 처음 화면으로 돌아가기" +
                                "버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
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
                        format = new SimpleDateFormat("yyyy/MM/dd(E) \n HH:mm:ss", Locale.KOREAN);
                    else
                        format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm:ss", Locale.ENGLISH);
                    textView10.setText(format.format(c.getTime()));

                    button15 = findViewById(R.id.button15);
                    button16 = findViewById(R.id.button16);
                    button15.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_15.this, Kiosk_16.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                    button16.setOnClickListener(new View.OnClickListener() {
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
        final Handler Handler = new Handler();

        Handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                button15.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable)button15.getBackground();
                anim.start();
            }
        }, 2000);
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