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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Kiosk_29_2 extends AppCompatActivity {

    private myapp pn;
    private TextView pnpn;
    private TextView department_2;
    private TextView treatment_day;
    private TextToSpeech tts;
    private myapp sound;

    private CheckBox check_Money;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29_2);
        department_2 = findViewById(R.id.department_2);
        pn = (myapp) getApplication();
        pnpn = findViewById(R.id.pnpn);
        treatment_day = findViewById(R.id.treatment_day);
        department_2.setText(pn.getDepartment());
        pnpn.setText(pn.getGet_pn_2().substring(0,8));
        String formattedTime = sdf.format(new Date(pn.getDay()));
        treatment_day.setText(formattedTime);
        check_Money = findViewById(R.id.check_Money);

        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("kr")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("처방전 발행 전을 보여주는 화면입니다. 본인이 맞는지 확인하시고 수납여부를 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is the screen before the prescription is filled. Make sure you are who you say you are and tap Accept.");
                    }
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed()) ;
                sound.getTtsVolume();
                if (getResources().getConfiguration().locale.getLanguage().equals("kr"))
                    tts.speak("수납여부는 여기에있고 지불하기는 여기에 있어요.", TextToSpeech.QUEUE_FLUSH, null, null);
                else
                    tts.speak("The checkout is here and the payment is here.", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        }, 15000);

    }
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
    }

    public void goto_kiosk_30(View v){
        if(check_Money.isChecked()) {
            tts.shutdown();
            Intent goto_kiosk_30 = new Intent(this, Kiosk_30.class);
            startActivity(goto_kiosk_30);
        }
        else
            if(getResources().getConfiguration().locale.getLanguage().equals("kr"))
                Toast.makeText(getApplicationContext(), "체크박스를 확인해주세요", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Check CheckBox", Toast.LENGTH_LONG).show();
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