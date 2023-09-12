package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Hospital_Main extends AppCompatActivity {


    TextView select_text;
    Button h_prescription_btn;
    String content;
    SpannableString spannableString;
    private TextToSpeech tts;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_main);


        // btn--------------------------------------------------------------------------------------

        h_prescription_btn = findViewById(R.id.h_prescription_btn);

        // btn--------------------------------------------------------------------------------------

        select_text = findViewById(R.id.select_text);
        content = select_text.getText().toString(); //텍스트 가져옴
        spannableString = new SpannableString(content); //객체 생성

        String word = "원하시는 업무";
        int start = content.indexOf(word);
        int end = start + word.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0055FF")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.2f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        select_text.setText(spannableString);

        //tts 시작--------------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("안녕하세요 병원 키오스크입니다. 진단서 출력을 하는 과정을 배워보겠습니다. 수납 처방전을 눌러보세요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("Hello, this is the hospital kiosk. Let's learn how to print a prescription. Tap Accept Prescription.");
                    }
                }
            }
        });

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;

            @Override
            public void onStart(String delaySpeak) {
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                if (one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("수납 처방전은 여기에있어요 눌러보세요.");
                                else
                                    speakText("The storage prescription is here, tap it.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            h_prescription_btn.setBackgroundResource(R.drawable.h_anim_blue_gray);
                            anim = (AnimationDrawable) h_prescription_btn.getBackground();
                            anim.start();
                        }
                    }, 3000);
                    Log.d("delaySpeak", "onDone");
                    one = false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak", "onError");
            }
        });
    }


    //여기도 추가


    // onDestroy가 두개라 하나로 합쳐줌
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }

    private void speakText(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }

    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
    // tts 끝---------------------------------------------------------------------------------------

    public void goto_prescription(View v){ //수납처방전 버튼
        tts.shutdown();
        Intent goto_prescription = new Intent(getApplicationContext(), Hospital_Prescription.class);
        startActivity(goto_prescription);
    }

    public void goto_medical_record(View v){ //진료기록, 영상CD복사,번호표 버튼
        tts.shutdown();
        Intent goto_medical_record = new Intent(getApplicationContext(), Hospital_Medical_Record.class);
        startActivity(goto_medical_record);
    }
    public void goto_kiosk_main(View v){ //키오스크 메인 버튼
        tts.shutdown();
        Intent goto_kiosk_main = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_main);
    }

}