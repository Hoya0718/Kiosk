package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_23 extends AppCompatActivity {
    private TextToSpeech tts;
    private Button button67; //처음으로 돌아가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk23);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("축하드립니다. 버스 연습 단계가 완료되었습니다" +
                                "처음으로 돌아가기 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("Congratulations. Bus practice phase is complete" +
                                "Please click the back button", TextToSpeech.QUEUE_FLUSH, null, null);
                    }

                    button67 = findViewById(R.id.button67);
                    button67.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_23.this, Kiosk_24.class);
                            tts.shutdown();
                            startActivity(intent);
                        }

                    });

                }
            }
        });
    }
}
