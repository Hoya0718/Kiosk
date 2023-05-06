package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_16 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private int currentVolume;
    private AudioManager audioManager;
    private myapp text_size;

    private Button button_seoul; // 서울
    private Button button_gyeongi;
    private Button button_kangwon;
    private Button button_sejong;
    private Button button_chungnam;
    private Button button_chungbuk;
    private Button button_kwangju;
    private Button button_jeonbuk;
    private Button button_busan;
    private Button button_daegu;
    private Button button27;
    private Button button26;
    private Button button25;
    private Button button24;
    private Button button23;
    private Button button32;
    private Button button31;
    private Button button30;
    private Button button29;
    private Button button28;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button button37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26= findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29= findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32= findViewById(R.id.button32);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button36= findViewById(R.id.button36);
        button37 = findViewById(R.id.button37);
        button_seoul = findViewById(R.id.button_seoul);
        button_busan = findViewById(R.id.button_busan);
        button_chungbuk= findViewById(R.id.button_chungbuk);
        button_chungnam = findViewById(R.id.button_chungnam);
        button_daegu = findViewById(R.id.button_daegu);
        button_gyeongi= findViewById(R.id.button_incheon);
        button_jeonbuk = findViewById(R.id.button_jeonbuk);
        button_kwangju = findViewById(R.id.button_kwangju);
        button_sejong= findViewById(R.id.button_sejong);
        button_kangwon = findViewById(R.id.button_kangwon);

        button23.setTextSize(text_size.getId());
        button24.setTextSize(text_size.getId());
        button25.setTextSize(text_size.getId());
        button26.setTextSize(text_size.getId());
        button27.setTextSize(text_size.getId());
        button28.setTextSize(text_size.getId());
        button29.setTextSize(text_size.getId());
        button30.setTextSize(text_size.getId());
        button31.setTextSize(text_size.getId());
        button32.setTextSize(text_size.getId());
        button34.setTextSize(text_size.getId());
        button35.setTextSize(text_size.getId());
        button36.setTextSize(text_size.getId());
        button37.setTextSize(text_size.getId());
        button_sejong.setTextSize(text_size.getId());
        button_seoul.setTextSize(text_size.getId());
        button_gyeongi.setTextSize(text_size.getId());
        button_busan.setTextSize(text_size.getId());
        button_kangwon.setTextSize(text_size.getId());
        button_kwangju.setTextSize(text_size.getId());
        button_jeonbuk.setTextSize(text_size.getId());
        button_chungnam.setTextSize(text_size.getId());
        button_chungbuk.setTextSize(text_size.getId());
        button_daegu.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("목적지를 찾을 수 있는 방법은 다양합니다" +
                                "지역에 맞게 찾을 수 있고. 앞 글자를 검색할 수 있습니다." +
                                "우선 서울 버튼을 눌러보세요", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("There are many ways to find your destination" +
                                "You can search according to the region, and you can search by the preceding letter" +
                                "First, press the Seoul button");
                    }

                    button_seoul = findViewById(R.id.button_seoul);
                    button_seoul.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_16_1.class);
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

