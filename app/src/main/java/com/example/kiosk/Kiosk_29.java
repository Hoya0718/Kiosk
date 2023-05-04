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
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                tts.speak("진료비 영수증 또는 진료안내서의 바코드를 아래 리더기에 대주세요. 바코드가 없으시다면 진료카드 번호 또는 주민등록번호 입력 후 확인을 눌러주세요",
                        TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 3000);

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
    public void goto_kiosk_29_2(View v) {

        Intent goto_kiosk_29_2= new Intent(getApplicationContext(), Kiosk_29_2.class);
        if(ssn.length() == 14) {
            tts.shutdown();
            get_num_2 = ssn.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);
            startActivity(goto_kiosk_29_2);
        }
        else {
            tts.speak("주민등록번호를 입력해주세요", TextToSpeech.QUEUE_FLUSH, null, null);
            Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
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