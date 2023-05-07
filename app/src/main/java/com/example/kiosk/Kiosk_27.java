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


    private TextView department;
    private TextView day;
    private TextView birthday;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    private TextToSpeech tts;
    private myapp sound;

    private Button print_receipt;
    private myapp pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk27);

        pn = (myapp) getApplication();

        print_receipt = findViewById(R.id.print_receipt);
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

    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }
}