package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
    private AnimationDrawable anim;
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
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("접수하기 위한 절차입니다. 접수를 하기위해 주민등록번호를 입력해주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is the procedure for submitting an application. Please enter your social security number to register.");
                    }
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed());
                sound.getTtsVolume();
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("아래의 숫자를 통해 주민등록번호를 입력하실 수 있어요.");
                else
                    speakText("You can enter your social security number through the numbers below.");
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
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(),"주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),"Enter your social security number", Toast.LENGTH_LONG).show();
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
                if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주민등록번호가 맞는지 확인해주세요.");
                    ssn.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) ssn.getBackground();
                    anim.start();
                    Toast.makeText(getApplicationContext(), "주민등록번호가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    speakText("Please verify your social security number");
                    ssn.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) ssn.getBackground();
                    anim.start();
                    Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
                }
            }
        }
        else {
            if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                speakText("개인정보 수집 동의를 눌러주세요");
                personal_Information.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) personal_Information.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "개인정보 수집 동의를 눌러주세요.", Toast.LENGTH_LONG).show();
            }
            else{
                speakText("Agree to collect personal information.");
                personal_Information.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) personal_Information.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "Agree to collect personal information.", Toast.LENGTH_LONG).show();
            }

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