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

import java.util.Locale;

public class Kiosk_26_2 extends AppCompatActivity {

    Handler handler = new Handler();
    private AnimationDrawable anim;
    private TextToSpeech tts;

    private myapp text_size;
    private myapp sound;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private String input;

    private TextView hos_department_txt;
    private myapp department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk26_2);

        text_size = (myapp) getApplication();
        sound = (myapp) getApplication();
        department = (myapp) getApplication();

        hos_department_txt = findViewById(R.id.hos_department_txt);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);

        hos_department_txt.setTextSize(text_size.getId());
        btn_1.setTextSize(text_size.getId());
        btn_2.setTextSize(text_size.getId());
        btn_3.setTextSize(text_size.getId());
        btn_4.setTextSize(text_size.getId());
        btn_5.setTextSize(text_size.getId());
        btn_6.setTextSize(text_size.getId());
        btn_7.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("진료과를 접수해볼까요? 진료과목 중 원하시는 과 하나를 선택해 보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Want to sign up for a specialty? Choose one of our medical specialties.");
                    }
                }
            }
        });

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                speakText("원하시는 진료과목이 없으시다면 정형외과를 눌러보세요.");
            else
                speakText("If you don't see the specialty you're looking for, try Orthopedics.");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    btn_4.setBackgroundResource(R.drawable.anim_list);
                    anim = (AnimationDrawable) btn_4.getBackground();
                    anim.start();

                }
            }, 3500);
        }
    }, 12000);
}
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void goto_kiosk_27(View v) {

        Intent goto_kiosk_27 = new Intent(getApplicationContext(),Kiosk_27.class);
        switch (v.getId()) {
            case R.id.btn_1:
                tts.shutdown();
                input = btn_1.getText().toString();
                department.setDepartment(btn_1.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_2:
                tts.shutdown();
                input = btn_2.getText().toString();
                department.setDepartment(btn_2.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_3:
                tts.shutdown();
                input = btn_3.getText().toString();
                department.setDepartment(btn_3.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_4:
                tts.shutdown();
                input = btn_4.getText().toString();
                department.setDepartment(btn_4.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_5:
                tts.shutdown();
                input = btn_5.getText().toString();
                department.setDepartment(btn_5.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_6:
                tts.shutdown();
                input = btn_6.getText().toString();
                department.setDepartment(btn_6.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_7:
                tts.shutdown();
                input = btn_7.getText().toString();
                department.setDepartment(btn_7.getText().toString());
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
        }
    }

    public void goto_Kiosk_H_M(View v) {
        tts.shutdown();
        Intent goto_Kiosk_H_M = new Intent(getApplicationContext(), Kiosk_25.class);
        startActivity(goto_Kiosk_H_M);
    }

    public void goto_Back(View v) {
        tts.shutdown();
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_26.class);
        startActivity(goto_Back);
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
