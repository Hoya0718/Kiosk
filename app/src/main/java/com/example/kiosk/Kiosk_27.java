package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_27 extends AppCompatActivity {

    private TextView hos_complete_txt;

    private TextView hos_wating;

    private TextView hos_third;

    private TextView hos_waiting_n;

    private TextView  hos_1212;

    private TextView   hos_birthdate;

    private TextView   hos_name;

    private TextView   hos_Hond;

    private TextView department;
    private TextView day;
    private TextView birthday;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    private TextToSpeech tts;
    private myapp sound;

    private myapp text_size;

    private Button print_receipt;
    private myapp pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk27);

        pn = (myapp) getApplication();
        text_size = (myapp) getApplication();

        hos_complete_txt = findViewById(R.id.hos_complete_txt);
        hos_wating = findViewById(R.id.hos_wating);
        hos_third = findViewById(R.id.hos_third);
        hos_waiting_n = findViewById(R.id.hos_wating_n);
        hos_1212 = findViewById(R.id.hos_1212);
        hos_birthdate = findViewById(R.id.hos_birthdate);
        hos_name = findViewById(R.id.hos_name);
        hos_Hond = findViewById(R.id.hos_Hond);
        print_receipt = findViewById(R.id.print_receipt);
        department =findViewById(R.id.hos_department_2);
        day =findViewById(R.id.hos_day);
        birthday=findViewById(R.id.hos_98);

        hos_1212.setTextSize(text_size.getId());
        hos_complete_txt.setTextSize(text_size.getId());
        hos_wating.setTextSize(text_size.getId());
        hos_third.setTextSize(text_size.getId());
        hos_waiting_n.setTextSize(text_size.getId());
        hos_birthdate.setTextSize(text_size.getId());
        hos_name.setTextSize(text_size.getId());
        hos_Hond.setTextSize(text_size.getId());
        print_receipt.setTextSize(text_size.getId());
        department.setTextSize(text_size.getId());
        day.setTextSize(text_size.getId());
        birthday.setTextSize(text_size.getId());

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy/MM/dd(E)-HH:mm:ss", Locale.KOREAN);
        day.setText(format.format(c.getTime()));

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        department.setText(text);

        birthday.setText(pn.getGet_pn().substring(0,6));
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("접수가 완료되었습니다. 접수증 출력을 눌러주세요. 실제 병원에서는 아래에 접수증이 출력이될거에요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("The registration has been completed, please click Print Receipt. In a real hospital, you will see a receipt below.");
                    }
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("접수증 출력은 여기에 있어요.");
                else
                    speakText("Here's a printout of the receipt.");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        print_receipt.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) print_receipt.getBackground();
                        anim.start();
                    }
                }, 2500);
            }
        }, 10000);
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

    public void goto_Kiosk_H_M(View v) {
        tts.shutdown();
        Intent goto_Kiosk_H_M = new Intent(getApplicationContext(), Kiosk_25.class);
        startActivity(goto_Kiosk_H_M);
    }

    public void goto_back(View v) {
        tts.shutdown();
        Intent goto_back = new Intent(getApplicationContext(), Kiosk_26.class);
        startActivity(goto_back);
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