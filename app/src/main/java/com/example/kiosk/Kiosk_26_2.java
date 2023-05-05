package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_26_2 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private String input;
    private myapp department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk26_2);

        sound = (myapp) getApplication();
        department = (myapp) getApplication();

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("원하시는 진료과목을 선택해주세요.");
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();

                tts.speak("원하시는 진료과목이 없으시다면 아무 진료과목을 눌러보세요.",
                        TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 15000);
    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void goto_kiosk_27(View v) {

        Intent goto_kiosk_27 = new Intent(this,Kiosk_27.class);
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
}
