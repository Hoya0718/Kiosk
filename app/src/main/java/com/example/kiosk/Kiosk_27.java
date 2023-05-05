package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_27 extends AppCompatActivity {


    private TextView department;
    private TextView day;
    private TextView birthday;

    private TextToSpeech tts;
    private myapp sound;

    private myapp pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk27);

        pn = (myapp) getApplication();

        department =findViewById(R.id.department);
        day =findViewById(R.id.day);
        birthday=findViewById(R.id.birthday);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy/MM/dd(E)-HH:mm:ss", Locale.KOREAN);
        day.setText(format.format(c.getTime()));

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        department.setText(text);

        birthday.setText(pn.getGet_pn().substring(0,8));
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("접수가 완료되었습니다. 접수증 출력을 눌러주세요.");
                }
            }
        });
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void goto_kiosk_28(View v) {
        tts.shutdown();
        Intent goto_kiosk_28 = new Intent(getApplicationContext(), Kiosk_28.class);
        startActivity(goto_kiosk_28);
    }
}