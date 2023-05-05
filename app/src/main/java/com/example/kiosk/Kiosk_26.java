package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_26 extends AppCompatActivity {

    private TextView ssn ;
    private TextToSpeech tts;
    private myapp sound;

    private CheckBox personal_Information;

    private String get_num;

    private myapp pn;

    private long clickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk26);

        personal_Information = findViewById(R.id.personal_Information);
        ssn = findViewById(R.id.SSN);
        pn = (myapp) getApplication();
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("접수하기 위한 절차입니다. 접수를 하기위해 주민등록번호를 입력해주세요.");
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();

                tts.speak("아래의 숫자를 통해 주민등록번호를 입력하실 수 있어요.",
                        TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 15000);
    }

    public void put_n(View view) {
        String current = ssn.getText().toString();


        switch (view.getId()) {
            case R.id.num_0:
                ssn.setTextSize(20);
                ssn.setText(current + "0");
                if(ssn.length()==7){
                    ssn.setText(current + "-0");
                }
                break;
            case R.id.num_1:
                ssn.setTextSize(20);
                ssn.setText(current + "1");
                if(ssn.length()==7) {
                    ssn.setText(current + "-1");
                }
                break;
            case R.id.num_2:
                ssn.setTextSize(20);
                ssn.setText(current + "2");
                if(ssn.length()==7){
                    ssn.setText(current + "-2");
                }
                break;
            case R.id.num_3:
                ssn.setTextSize(20);
                ssn.setText(current + "3");
                if(ssn.length()==7){
                    ssn.setText(current + "-3");
                }
                break;
            case R.id.num_4:
                ssn.setTextSize(20);
                ssn.setText(current + "4");
                if(ssn.length()==7){
                    ssn.setText(current + "-4");
                }
                break;
            case R.id.num_5:
                ssn.setTextSize(20);
                ssn.setText(current + "5");
                if(ssn.length()==7){
                    ssn.setText(current + "-5");
                }
                break;
            case R.id.num_6:
                ssn.setTextSize(20);
                ssn.setText(current + "6");
                if(ssn.length()==7){
                    ssn.setText(current + "-6");
                }
                break;
            case R.id.num_7:
                ssn.setTextSize(20);
                ssn.setText(current + "7");
                if(ssn.length()==7){
                    ssn.setText(current + "-7");
                }
                break;
            case R.id.num_8:
                ssn.setTextSize(20);
                ssn.setText(current + "8");
                if(ssn.length()==7){
                    ssn.setText(current + "-8");
                }
                break;
            case R.id.num_9:
                ssn.setTextSize(20);
                ssn.setText(current + "9");
                if(ssn.length()==7){
                    ssn.setText(current + "-9");
                }
                break;
            case R.id.CL:
                if(ssn.length() ==0){
                    Toast.makeText(getApplicationContext(),"주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if(ssn.length() == 8){
                    ssn.setText(current.substring(0, current.length() - 2));
            }
                else {
                    ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_kiosk_26_2(View v) {
        if(personal_Information.isChecked()) {
            if (ssn.length() == 14) {
                get_num = ssn.getText().toString();
                pn.setGet_pn(get_num);
                clickTime = System.currentTimeMillis();
                pn.setDay(clickTime);
                tts.shutdown();
                Intent goto_kiosk_26_2 = new Intent(this,Kiosk_26_2.class);
                startActivity(goto_kiosk_26_2);
            }
            else {
                tts.speak("주민등록번호를 입력해주세요", TextToSpeech.QUEUE_FLUSH, null, null);
                Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
            }
        }
        else {
            tts.speak("개인정보 수집 동의를 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            Toast.makeText(getApplicationContext(), "개인정보 수집 동의를 눌러주세요.", Toast.LENGTH_LONG).show();
        }
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