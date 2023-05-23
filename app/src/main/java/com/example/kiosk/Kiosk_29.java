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
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_29 extends AppCompatActivity {

    Handler handler = new Handler();
    private AnimationDrawable anim;
    private TextView ssn_2 ;
    private TextToSpeech tts;
    private myapp sound;

    private Button num_0_2,num_1_2,num_2_2,num_3_2,num_4_2,num_5_2,num_6_2,num_7_2,num_8_2,num_9_2,check_2,cl_2;
    private myapp text_size;
    private String get_num_2;
    private TextView accept_info;
    private myapp pnpnpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29);

        ssn_2 = findViewById(R.id.SSN_2);
        text_size = (myapp)getApplication();
        pnpnpn = (myapp) getApplication();
        sound = (myapp) getApplication();
        num_0_2 = findViewById(R.id.num_0_2);
        check_2 = findViewById(R.id.Check_2_2);
        cl_2 = findViewById(R.id.CL_2);
        num_1_2 = findViewById(R.id.num_1_2);
        num_2_2 = findViewById(R.id.num_2_2);
        num_3_2 = findViewById(R.id.num_3_2);
        num_4_2 = findViewById(R.id.num_4_2);
        num_5_2 = findViewById(R.id.num_5_2);
        num_6_2 = findViewById(R.id.num_6_2);
        num_7_2 = findViewById(R.id.num_7_2);
        num_8_2 = findViewById(R.id.num_8_2);
        num_9_2 = findViewById(R.id.num_9_2);
        accept_info =findViewById(R.id.accept_info);

        ssn_2.setTextSize(text_size.getId());
        accept_info.setTextSize(text_size.getId());
        check_2.setTextSize(text_size.getId());
        cl_2.setTextSize(text_size.getId());
        num_0_2.setTextSize(text_size.getId());
        num_1_2.setTextSize(text_size.getId());
        num_2_2.setTextSize(text_size.getId());
        num_3_2.setTextSize(text_size.getId());
        num_4_2.setTextSize(text_size.getId());
        num_5_2.setTextSize(text_size.getId());
        num_6_2.setTextSize(text_size.getId());
        num_7_2.setTextSize(text_size.getId());
        num_8_2.setTextSize(text_size.getId());
        num_9_2.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("처방전을 받기 전 본인 확인을 위해 주민등록번호를 입력해야합니다. 주민등록번호를 입력해보세요.");
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
        String current = ssn_2.getText().toString();

        switch (view.getId()) {
            case R.id.num_0_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "0");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-0");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_1_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "1");
                if(ssn_2.length()==7) {
                    ssn_2.setText(current + "-1");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_2_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "2");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-2");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_3_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "3");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-3");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_4_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "4");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-4");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_5_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "5");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-5");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_6_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "6");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-6");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_7_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "7");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-7");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_8_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "8");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-8");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_9_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "9");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-9");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.CL_2:
                if(ssn_2.length() ==0){
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Enter your social security number.", Toast.LENGTH_LONG).show();}
                }
                else if(ssn_2.length() == 8){
                    ssn_2.setText(current.substring(0, current.length() - 2));
                }
                else {
                    ssn_2.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_kiosk_29_2(View v) {

        Intent goto_kiosk_29_2 = new Intent(getApplicationContext(), Kiosk_29_2.class);
        if (ssn_2.length() == 14) {
            tts.shutdown();
            get_num_2 = ssn_2.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);
            char pass = get_num_2.charAt(7);
            if (pass == '1' || pass == '2' || pass == '3' || pass == '4') {
                startActivity(goto_kiosk_29_2);

            } else
                Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
        

        }
        else {
                if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주민등록번호가 맞는지 확인해주세요.");
                    ssn_2.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) ssn_2.getBackground();
                    anim.start();
                    Toast.makeText(getApplicationContext(), "주민등록번호가 맞는지 확인해주세요.", Toast.LENGTH_LONG).show();
                }
                else{
                    ssn_2.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) ssn_2.getBackground();
                    anim.start();
                    speakText("Please verify your social security number.");
                    Toast.makeText(getApplicationContext(), "Please verify your social security number.", Toast.LENGTH_LONG).show();}
        }
    }

    public void goto_Kiosk_H_M(View v) {
        tts.shutdown();
        Intent goto_Kiosk_H_M = new Intent(getApplicationContext(), Kiosk_25.class);
        startActivity(goto_Kiosk_H_M);

    }

    public void goto_back(View v) {
        tts.shutdown();
        Intent goto_back = new Intent(getApplicationContext(), Kiosk_28.class);
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