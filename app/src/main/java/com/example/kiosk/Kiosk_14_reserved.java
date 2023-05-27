package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
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
    private Button b_cancel_btn, b_payment_btn;
    private myapp pn;

    private myapp text_size;
    private long clickTime;
    private AnimationDrawable anim;
    Handler handler = new Handler();
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
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);

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
        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());
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

                b_cancel_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Kiosk_14_reserved.this, Kiosk_14.class);
                        tts.shutdown();
                        startActivity(intent);
                    }
                });

                b_payment_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Kiosk_14_reserved.this, Kiosk_14_reserved_1.class);
                        tts.shutdown();
                        startActivity(intent);
                    }
                });
            }


        });
        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                // TTS가 말하기 시작했습니다.
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                // TTS가 말하기 끝났습니다.
                // 다른 코드를 실행합니다.

                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("조회하기 버튼은 여기에 있어요.");
                                else
                                    speakText("The inquiry button is here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            b_payment_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) b_payment_btn.getBackground();
                            anim.start();
                        }
                    }, 2000);
                    Log.d("delaySpeak", "onDone");
                    one=false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak", "onError");
            }
        });


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

    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
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