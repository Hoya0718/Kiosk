package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_15 extends AppCompatActivity {
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM dd (E)", Locale.KOREAN);
    TextView textView10;
    private TextToSpeech tts;

    private Button button15; //도착지 버튼
    private Button button16; //홈 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk15);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        tts.speak("이 화면에서는 도착지를 선택할 수 있습니다." +
                                "목적지 버튼을 눌러주세요" +
                                "만약 처음 화면으로 돌아가고 싶으시면 처음 화면으로 돌아가기" +
                                "버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        tts.speak("This screen allows you to select your destination." +
                                "Please click the destination button" +
                                "If you want to return to the first screen, " +
                                "click the Back to Home Screen button.", TextToSpeech.QUEUE_FLUSH, null, null);
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
    }
}