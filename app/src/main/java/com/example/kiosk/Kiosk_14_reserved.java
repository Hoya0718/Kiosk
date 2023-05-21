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

public class Kiosk_14_reserved extends AppCompatActivity {

    private TextView bus_infoinput;
    private TextView bus_birthdate, bus_birthdate_input;
    private TextView phone, phonenumber;
    private TextToSpeech tts;
    private myapp sound;


    private String get_num;
    private Button num_0, num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, cl, check;
    private myapp pn;

    private myapp text_size;
    private long clickTime;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14_reserved);

        pn = (myapp) getApplication();
        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();

        num_0 = findViewById(R.id.num_0);
        cl = findViewById(R.id.CL);
        num_1 = findViewById(R.id.num_1);
        num_2 = findViewById(R.id.num_2);
        num_3 = findViewById(R.id.num_3);
        num_4 = findViewById(R.id.num_4);
        num_5 = findViewById(R.id.num_5);
        num_6 = findViewById(R.id.num_6);
        num_7 = findViewById(R.id.num_7);
        num_8 = findViewById(R.id.num_8);
        num_9 = findViewById(R.id.num_9);
        check = findViewById(R.id.Check_2);
        bus_infoinput = findViewById(R.id.bus_infoinput);
        bus_birthdate = findViewById(R.id.bus_birthdate);
        phone = findViewById(R.id.phone);
        phonenumber = findViewById(R.id.phonenumber);

        num_0.setTextSize(text_size.getId());
        num_1.setTextSize(text_size.getId());
        num_2.setTextSize(text_size.getId());
        num_3.setTextSize(text_size.getId());
        num_4.setTextSize(text_size.getId());
        num_5.setTextSize(text_size.getId());
        num_6.setTextSize(text_size.getId());
        num_7.setTextSize(text_size.getId());
        num_8.setTextSize(text_size.getId());
        num_9.setTextSize(text_size.getId());
        cl.setTextSize(text_size.getId());
        check.setTextSize(text_size.getId());
        bus_birthdate.setTextSize(text_size.getId());
        bus_birthdate_input.setTextSize(text_size.getId());
        phone.setTextSize(text_size.getId());
        phonenumber.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("접수를 하실려면 주민등록번호를 입력해야해요. 주민등록번호를 입력해보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You'll need to enter your social security number to register. Try entering your social security number.");
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
        String current = bus_birthdate.getText().toString();

        switch (view.getId()) {
            case R.id.num_0:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "0");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-0");
                }
                break;
            case R.id.num_1:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "1");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-1");
                }
                break;
            case R.id.num_2:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "2");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-2");
                }
                break;
            case R.id.num_3:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "3");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-3");
                }
                break;
            case R.id.num_4:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "4");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-4");
                }
                break;
            case R.id.num_5:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "5");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-5");
                }
                break;
            case R.id.num_6:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "6");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-6");
                }
                break;
            case R.id.num_7:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "7");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-7");
                }
                break;
            case R.id.num_8:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "8");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-8");
                }
                break;
            case R.id.num_9:
                bus_birthdate.setTextSize(text_size.getId());
                bus_birthdate.setText(current + "9");
                if (bus_birthdate.length() == 6) {
                    bus_birthdate.setText(current + "-9");
                }
                break;
            case R.id.CL:
                if (bus_birthdate.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (bus_birthdate.length() == 8) {
                    bus_birthdate.setText(current.substring(0, current.length() - 2));
                } else {
                    bus_birthdate.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }

    public void goto_kiosk_26_2(View v) {
        if (bus_birthdate.length() == 6) {
            get_num = bus_birthdate.getText().toString();
            pn.setGet_pn(get_num);
            clickTime = System.currentTimeMillis();
            pn.setDay(clickTime);
            tts.shutdown();
            Intent goto_kiosk_26_2 = new Intent(this, Kiosk_26_2.class);
            startActivity(goto_kiosk_26_2);
        } else {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                speakText("주민등록번호가 맞는지 확인해주세요.");
                bus_birthdate.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) bus_birthdate.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "주민등록번호가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                speakText("Please verify your social security number");
                bus_birthdate.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) bus_birthdate.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
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
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}