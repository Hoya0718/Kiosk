package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
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

    private TextView textView18;
    private TextView textView36;
    private TextView textView17;
    private TextView textView51;
    private TextView textView52;
    private TextView textView53;
    private TextView textView54;
    private TextView textView45;
    private TextView textView20;
    private TextView textView21;
    private TextView textView46;
    private TextView textView22;
    private TextView textView23;
    private TextView textView47;
    private TextView textView24;
    private TextView textView25;
    private TextView textView48;
    private TextView textView26;
    private TextView textView27;
    private TextView textView49;
    private TextView textView28;
    private TextView textView29;
    private TextView textView50;
    private TextView textView30;
    private TextView textView31;

    private Button button17;
    private Button button41;
    private Button button42;
    private Button button86;
    private Button button87;
    private Button button88;

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
        textView51 = findViewById(R.id.textView51);
        textView52 = findViewById(R.id.textView52);
        textView53 = findViewById(R.id.textView53);
        textView54 = findViewById(R.id.textView54);
        textView45 = findViewById(R.id.textView45);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView46 = findViewById(R.id.textView46);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView47 = findViewById(R.id.textView47);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView48 = findViewById(R.id.textView48);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView49 = findViewById(R.id.textView49);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView50 = findViewById(R.id.textView50);
        textView30 = findViewById(R.id.textView30);
        textView31 = findViewById(R.id.textView31);
        button17 = findViewById(R.id.button17);
        button87 = findViewById(R.id.button87);
        button88 = findViewById(R.id.button88);
        button86 = findViewById(R.id.button86);
        button41 = findViewById(R.id.button41);
        button42 = findViewById(R.id.button42);

        textView17.setTextSize(text_size.getId());
        textView36.setTextSize(text_size.getId());
        textView18.setTextSize(text_size.getId());
        textView51.setTextSize(text_size.getId());
        textView52.setTextSize(text_size.getId());
        textView53.setTextSize(text_size.getId());
        textView54.setTextSize(text_size.getId());
        textView45.setTextSize(text_size.getId());
        textView20.setTextSize(text_size.getId());
        textView21.setTextSize(text_size.getId());
        textView46.setTextSize(text_size.getId());
        textView22.setTextSize(text_size.getId());
        textView23.setTextSize(text_size.getId());
        textView47.setTextSize(text_size.getId());
        textView24.setTextSize(text_size.getId());
        textView25.setTextSize(text_size.getId());
        textView48.setTextSize(text_size.getId());
        textView26.setTextSize(text_size.getId());
        textView27.setTextSize(text_size.getId());
        textView49.setTextSize(text_size.getId());
        textView28.setTextSize(text_size.getId());
        textView29.setTextSize(text_size.getId());
        textView50.setTextSize(text_size.getId());
        textView31.setTextSize(text_size.getId());
        textView31.setTextSize(text_size.getId());
        button17.setTextSize(text_size.getId());
        button87.setTextSize(text_size.getId());
        button88.setTextSize(text_size.getId());
        button86.setTextSize(text_size.getId());
        button41.setTextSize(text_size.getId());
        button42.setTextSize(text_size.getId());

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

                    button17 = findViewById(R.id.button17);
                    button41 = findViewById(R.id.button41);
                    button42 = findViewById(R.id.button42);

                    button17.setOnClickListener(new View.OnClickListener() {
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

                    button41.setOnClickListener(new View.OnClickListener() {
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
                    button42.setOnClickListener(new View.OnClickListener() {
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




