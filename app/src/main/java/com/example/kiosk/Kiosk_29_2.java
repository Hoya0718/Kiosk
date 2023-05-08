package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Kiosk_29_2 extends AppCompatActivity {
    Handler handler = new Handler();
    private AnimationDrawable anim;
    private myapp pn;
    private Button pay_for_;
    private TextView pnpn;
    private TextView department_2;
    private TextView treatment_day;
    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private CheckBox check_Money;

    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29_2);
        department_2 = findViewById(R.id.department_2);
        pn = (myapp) getApplication();
        pnpn = findViewById(R.id.pnpn);
        treatment_day = findViewById(R.id.treatment_day);
        text_size = (myapp) getApplication();

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t10);
        t11 = findViewById(R.id.t11);
        t12= findViewById(R.id.t12);
        t13 = findViewById(R.id.t13);
        pay_for_ = findViewById(R.id.pay_for_);

        t1.setTextSize(text_size.getId());
        t2.setTextSize(text_size.getId());
        t3.setTextSize(text_size.getId());
        t4.setTextSize(text_size.getId());
        t5.setTextSize(text_size.getId());
        t6.setTextSize(text_size.getId());
        t7.setTextSize(text_size.getId());
        t8.setTextSize(text_size.getId());
        t9.setTextSize(text_size.getId());
        t10.setTextSize(text_size.getId());
        t11.setTextSize(text_size.getId());
        t12.setTextSize(text_size.getId());
        t13.setTextSize(text_size.getId());
        department_2.setTextSize(text_size.getId());
        pnpn.setTextSize(text_size.getId());
        treatment_day.setTextSize(text_size.getId());
        pay_for_.setTextSize(text_size.getId());

        department_2.setText(pn.getDepartment());
        pnpn.setText(pn.getGet_pn_2().substring(0,6));
        String formattedTime = sdf.format(new Date(pn.getDay()));
        treatment_day.setText(formattedTime);
        check_Money = findViewById(R.id.check_Money);
        sound = (myapp) getApplication();
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("처방전 발행을 보여주는 화면입니다. 본인이 맞는지 확인하시고 수납여부를 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("This is the screen before the prescription is filled. Make sure you are who you say you are and tap Accept.");
                    }
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("수납여부는 여기에있고 지불하기는 여기에 있어요.");
                else
                    speakText("The checkout is here and the payment is here.e");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        check_Money.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) check_Money.getBackground();
                        anim.start();
                        pay_for_.setBackgroundResource(R.drawable.anim_list2);
                        anim = (AnimationDrawable) pay_for_.getBackground();
                        anim.start();
                    }
                }, 3000);
            }
        }, 10000);

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
            if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                check_Money.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) check_Money.getBackground();
                anim.start();

                Toast.makeText(getApplicationContext(), "체크박스를 확인해주세요", Toast.LENGTH_LONG).show();
            }
            else
            {
                check_Money.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) check_Money.getBackground();
                anim.start();
            Toast.makeText(getApplicationContext(), "Check CheckBox", Toast.LENGTH_LONG).show();
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
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}