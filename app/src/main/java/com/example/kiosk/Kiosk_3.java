package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_3 extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp text_size;
    private Button vss;
    private Button vsm;
    private Button vsf;
    private Button pre;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk03);
        text_size =(myapp)getApplication();
        vss = findViewById(R.id.volume_speed_slow);
        vsm = findViewById(R.id.volume_speed_medium);
        vsf = findViewById(R.id.volume_speed_fast);
        pre = findViewById(R.id.pre_Btn);
        next = findViewById(R.id.save_Btn);


        vss.setTextSize(text_size.getId());
        vsm.setTextSize(text_size.getId());
        vsf.setTextSize(text_size.getId());
        pre.setTextSize(text_size.getId());
        next.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });
    }

    public void goto_kiosk_02(View v){
        Intent goto_kiosk_02 = new Intent(getApplicationContext(), Kiosk_2.class);
        startActivity(goto_kiosk_02);
    }

    public void goto_kiosk_04(View v) {
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }
    public void volume_speed_slow(View view) {
        tts.setSpeechRate(0.8f);
        tts.speak("이 정도 속도 어떠세요?.", TextToSpeech.QUEUE_FLUSH, null,null);
    }
    public void volume_speed_medium(View view) {
        tts.setSpeechRate(1.0f);
        tts.speak("이 정도 속도 어떠세요?.", TextToSpeech.QUEUE_FLUSH, null,null);
    }
    public void volume_speed_fast(View view) {
        tts.setSpeechRate(1.5f);
        tts.speak("이 정도 속도 어떠세요?.", TextToSpeech.QUEUE_FLUSH, null,null);
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
