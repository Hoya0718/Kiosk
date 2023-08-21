package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class to_get_num_yes extends AppCompatActivity {

    // Button, String-------------------------------------------------------------------------------
    private Button gn_1,gn_2,gn_3,gn_4,gn_5,gn_6,gn_7,gn_8,gn_9;
    private String input, value, fee;
    // Button, String-------------------------------------------------------------------------------
    // tts 사용 선언----------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_get_num_yes);

        gn_1 = findViewById(R.id.gn_1);
        gn_2 = findViewById(R.id.gn_2);
        gn_3 = findViewById(R.id.gn_3);
        gn_4 = findViewById(R.id.gn_4);
        gn_5 = findViewById(R.id.gn_5);
        gn_6 = findViewById(R.id.gn_6);
        gn_7 = findViewById(R.id.gn_7);
        gn_8 = findViewById(R.id.gn_8);
        gn_9 = findViewById(R.id.gn_9);


        //tts 시작-----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("신청 부수를 선택할 수 있는 화면입니다. 몇 부를 인쇄 할건지 숫자를 누르면 돼요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is the screen where you can choose how many copies of the application you want to print, just press the number.");
                    }
                }
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

    public void goto_pay_list(View v){
        tts.shutdown();
        Intent goto_pay_list = new Intent(this, TO_Pay_list.class);
        fee = "0";
        switch (v.getId()) {
            case R.id.gn_1:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_1.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_2:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_2.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_3:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_3.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_4:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_4.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_5:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_5.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_6:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_6.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_7:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_7.getText().toString();
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_8:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                input = gn_8.getText().toString();
                goto_pay_list.putExtra("value", value);
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
            case R.id.gn_9:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                input = gn_9.getText().toString();
                goto_pay_list.putExtra("value", value);
                goto_pay_list.putExtra("text", input);
                startActivity(goto_pay_list);
                break;
        }
    }
    public void goto_fee(View v){
        tts.shutdown();
        Intent goto_fee = new Intent(getApplicationContext(), TO_Is_fee_examption.class);
        startActivity(goto_fee);
    }
    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
}