package com.example.kiosk;

import static java.util.Locale.KOREAN;

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
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Hospital_Pay_List extends AppCompatActivity {

    private TextView h_txt_ssn, treatment_day_1;
    private Button credit_one;
    private myapp pn;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    private TextToSpeech tts;
    Handler handler = new Handler();
    private AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_pay_list);

        //TextView 선언------------------------------------------------------------------------------

        h_txt_ssn = findViewById(R.id.h_txt_ssn);
        treatment_day_1 = findViewById(R.id.treatment_day_1);

        //TextView 종료------------------------------------------------------------------------------

        //Button------------------------------------------------------------------------------------

        credit_one = findViewById(R.id.credit_one);

        //Button------------------------------------------------------------------------------------

        //myapp 선언---------------------------------------------------------------------------------

        pn = (myapp) getApplication();

        //myapp 종료---------------------------------------------------------------------------------

        h_txt_ssn.setText(pn.getH_ssn());

        String formattedTime = sdf.format(date);
        treatment_day_1.setText(formattedTime);

        //tts 시작--------------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("처방전을 뽑기위한 마지막 단계입니다. \n" +
                                "금액을 지불하시면 처방전을 뽑을 수 있어요.\n" +
                                "원하시는 진료과 처방전을 뽑기위해서는 우측에 있는 네모칸을 누르시면됩니다.\n");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is the final step to pick up your prescription. \n" +
                                "Pay the money and you'll be able to fill your prescription.\n" +
                                "To pick up a prescription for your favorite doctor, click on the square on the right.\n");
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
                            credit_one.setBackgroundResource(R.drawable.h_anim_blue_gray);
                            anim = (AnimationDrawable) credit_one.getBackground();
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

    public void goto_pay(View v){
        tts.shutdown();
        Intent goto_pay = new Intent(getApplicationContext(), Hospital_Pay.class);
        startActivity(goto_pay);
    }
    public void goto_Hospital_Main(View v){
        tts.shutdown();
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), Hospital_Main.class);
        startActivity(goto_Hospital_Main);
    }
}