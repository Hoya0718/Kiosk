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

import java.util.Locale;

public class Kiosk_14_reserved extends AppCompatActivity {

    private TextView bus_infoinput, bus_birthdate, bus_birthdate_input;
    private TextToSpeech tts;
    private myapp sound;

    private CheckBox person_Information;

    private String get_num;
    private Button num0_btn, num1_btn,num2_btn,num3_btn,num4_btn,num5_btn,num6_btn,num7_btn,num8_btn,num9_btn,modify_btn, confirm_btn;
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

        person_Information = findViewById(R.id.person_Information);
        bus_infoinput = findViewById(R.id.bus_infoinput);
        bus_birthdate = findViewById(R.id.bus_birthdate);
        bus_birthdate_input = findViewById(R.id.bus_birthdate_input);
        modify_btn = findViewById(R.id.modify_btn);
        num0_btn = findViewById(R.id.num0_btn);
        num1_btn = findViewById(R.id.num1_btn);
        num2_btn = findViewById(R.id.num2_btn);
        num3_btn = findViewById(R.id.num3_btn);
        num4_btn = findViewById(R.id.num4_btn);
        num5_btn = findViewById(R.id.num5_btn);
        num6_btn = findViewById(R.id.num6_btn);
        num7_btn = findViewById(R.id.num7_btn);
        num8_btn = findViewById(R.id.num8_btn);
        num9_btn = findViewById(R.id.num9_btn);
        confirm_btn = findViewById(R.id.comfirm_btn);

        num0_btn.setTextSize(text_size.getId());
        num1_btn.setTextSize(text_size.getId());
        num2_btn.setTextSize(text_size.getId());
        num3_btn.setTextSize(text_size.getId());
        num4_btn.setTextSize(text_size.getId());
        num5_btn.setTextSize(text_size.getId());
        num6_btn.setTextSize(text_size.getId());
        num7_btn.setTextSize(text_size.getId());
        num8_btn.setTextSize(text_size.getId());
        num9_btn.setTextSize(text_size.getId());
        modify_btn.setTextSize(text_size.getId());
        confirm_btn.setTextSize(text_size.getId());
        bus_birthdate.setTextSize(text_size.getId());
        bus_infoinput.setTextSize(text_size.getId());
        person_Information.setTextSize(text_size.getId());
        bus_birthdate_input.setTextSize(text_size.getId());
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("접수를 하실려면 주민등록번호와 개인정보 수집 동의를 눌러주셔야 병원 접수가 됩니다. 주민등록번호를 입력하시고 네모 칸을 꼭 눌러주세요");
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
        }, 17000);
    }

    public void put_n(View view) {
        String current = bus_birthdate_input.getText().toString();


        switch (view.getId()) {
            case R.id.num0_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "0");
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-0");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;

            case R.id.num1_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "1");
                if(bus_birthdate_input.length()==7) {
                    bus_birthdate_input.setText(current + "-1");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num2_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "2");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-2");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num3_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "3");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-3");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num4_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "4");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-4");;
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num5_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "5");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-5");
                    if(bus_birthdate_input.length()==8)
                        bus_birthdate_input.setText(current + '*');
                }
                break;
            case R.id.num6_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "6");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-6");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num7_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "7");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-7");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num8_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "8");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-8");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num9_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + "9");
                if(bus_birthdate_input.length()==7){
                    bus_birthdate_input.setText(current + "-9");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.modify_btn:
                if(bus_birthdate_input.length() ==0){
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(),"주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),"Enter your social security number", Toast.LENGTH_LONG).show();
                }
                else if(bus_birthdate_input.length() == 8){
                    bus_birthdate_input.setText(current.substring(0, current.length() - 2));
                }
                else {
                    bus_birthdate_input.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_kiosk_14_reserved(View v) {
        if(person_Information.isChecked()) {
            if (bus_birthdate_input.length() == 14) {
                get_num = bus_birthdate_input.getText().toString();
                pn.setGet_pn(get_num);
                clickTime = System.currentTimeMillis();
                pn.setDay(clickTime);
                tts.shutdown();
                Intent goto_kiosk_14_reversed = new Intent(this,Kiosk_26_2.class);
                startActivity(goto_kiosk_14_reversed);
            }
            else {
                if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주민등록번호가 맞는지 확인해주세요.");
                    bus_birthdate_input.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) bus_birthdate_input.getBackground();
                    anim.start();
                    Toast.makeText(getApplicationContext(), "주민등록번호가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    speakText("Please verify your social security number");
                    bus_birthdate_input.setBackgroundResource(R.drawable.anim_list2);
                    anim = (AnimationDrawable) bus_birthdate_input.getBackground();
                    anim.start();
                    Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
                }
            }
        }
        else {
            if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                speakText("개인정보 수집 동의를 눌러주세요");
                person_Information.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) person_Information.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "개인정보 수집 동의를 눌러주세요.", Toast.LENGTH_LONG).show();
            }
            else{
                speakText("Agree to collect personal information.");
                person_Information.setBackgroundResource(R.drawable.anim_list);
                anim = (AnimationDrawable) person_Information.getBackground();
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
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}