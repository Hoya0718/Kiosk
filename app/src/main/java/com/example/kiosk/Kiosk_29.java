package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_29 extends AppCompatActivity {

    private TextView ssn ;
    private TextToSpeech tts;
    private myapp sound;

    private String get_num_2;

    private myapp pnpnpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29);

        ssn = findViewById(R.id.SSN);

        pnpnpn = (myapp) getApplication();
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("처방전을 받기 전 본인 확인을 위해 주민등록번호를 입력해야합니다. 주민등록번호를 입력해주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Before you receive your prescription, you will need to enter your social security number to verify your identity. Please enter your social security number.");
                    }
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("아래에 숫자를 통해 주민등록번호를 입력하실 수 있어요.");
                else
                    speakText("You can enter your social security number via the numbers below.");
            }
        }, 15000);


    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Enter your social security number.", Toast.LENGTH_LONG).show();}
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
    public void goto_kiosk_29_2(View v) {

        Intent goto_kiosk_29_2= new Intent(getApplicationContext(), Kiosk_29_2.class);
        if(ssn.length() == 14) {
            tts.shutdown();
            get_num_2 = ssn.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);
            startActivity(goto_kiosk_29_2);
        }
        else {
                if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주민등록번호를 입력해주세요");
                    Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else{
                    speakText("Enter your social security number.");
                    Toast.makeText(getApplicationContext(), "Enter your social security number.", Toast.LENGTH_LONG).show();}
        }
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