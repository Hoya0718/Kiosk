package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class TO_Get_Num extends AppCompatActivity {

    // Button, String-----------------------------------------------------------------------------
    private Button gnn_1, gnn_2, gnn_3, gnn_4, gnn_5, gnn_6, gnn_7, gnn_8, gnn_9;
    private String input, value, fee;
    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();

    // tts 사용 선언---------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_get_num);

        gnn_1 = findViewById(R.id.gnn_1);
        gnn_2 = findViewById(R.id.gnn_2);
        gnn_3 = findViewById(R.id.gnn_3);
        gnn_4 = findViewById(R.id.gnn_4);
        gnn_5 = findViewById(R.id.gnn_5);
        gnn_6 = findViewById(R.id.gnn_6);
        gnn_7 = findViewById(R.id.gnn_7);
        gnn_8 = findViewById(R.id.gnn_8);
        gnn_9 = findViewById(R.id.gnn_9);

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

    public void goto_pay_List(View v) {
        tts.shutdown();
        Intent goto_pay_List = new Intent(this, TO_Pay_list.class);
        fee="200";
        switch (v.getId()) {
            case R.id.gnn_1:
                value = "200";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_1.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_2:
                value = "400";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_2.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_3:
                value = "600";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_3.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_4:
                value = "800";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_4.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_5:
                value = "1000";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_5.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_6:
                value = "1200";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_6.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_7:
                value = "1400";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_7.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_8:
                value = "1600";
                goto_pay_List.putExtra("fee", fee);
                input = gnn_8.getText().toString();
                goto_pay_List.putExtra("value", value);
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_9:
                value = "1800";
                goto_pay_List.putExtra("fee", fee);
                input = gnn_9.getText().toString();
                goto_pay_List.putExtra("value", value);
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
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