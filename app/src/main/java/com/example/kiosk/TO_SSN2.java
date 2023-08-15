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
import android.widget.Toast;

import java.util.Locale;

public class TO_SSN2 extends AppCompatActivity {

    // textView 사용 선언----------------------------------------------------------------------------
    private TextView txt_num, to_txt_ssn;
    // textView 사용 선언----------------------------------------------------------------------------


    // Button 사용 선언------------------------------------------------------------------------------
    private Button to_btn_1, to_btn_2, to_btn_3, to_btn_4, to_btn_5, to_btn_6, to_btn_7, to_btn_8, to_btn_9, to_btn_0, to_btn_cancel, to_btn_all_delete;
    // Button 사용 선언------------------------------------------------------------------------------


    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------


    // myapp 사용 선언-------------------------------------------------------------------------------
    private myapp text_size;
    // myapp 사용 선언-------------------------------------------------------------------------------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_ssn2);

        to_txt_ssn= findViewById(R.id.to_txt_ssn);

        to_btn_0 = findViewById(R.id.to_btn_0);
        to_btn_1 = findViewById(R.id.to_btn_1);
        to_btn_2 = findViewById(R.id.to_btn_2);
        to_btn_3 = findViewById(R.id.to_btn_3);
        to_btn_4 = findViewById(R.id.to_btn_4);
        to_btn_5 = findViewById(R.id.to_btn_5);
        to_btn_6 = findViewById(R.id.to_btn_6);
        to_btn_7 = findViewById(R.id.to_btn_7);
        to_btn_8 = findViewById(R.id.to_btn_8);
        to_btn_9 = findViewById(R.id.to_btn_9);
        to_btn_cancel = findViewById(R.id.to_btn_cancel);
        to_btn_all_delete = findViewById(R.id.to_btn_all_delete);

        //tts 시작----------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("본인인증을 하는 단계입니다. 주민등록번호로 인증을 할 수 있어요.  주민등록번호를 입력 후 확인 버튼을 눌러보세요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is the step to verify your identity. You can verify with your social security number. Enter your social security number and press the Confirm button.");
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
                                    speakText("화면의 숫자를 통해 주민등록번호를 입력하실 수 있어요.");
                                else
                                    speakText("You can enter your social security number through the numbers below.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
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

    public void put_n(View view) {
        String current = txt_num.getText().toString();

        switch (view.getId()) {
            case R.id.to_btn_0:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '0');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-0");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;

            case R.id.to_btn_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '1');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-1");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_2:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '2');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-2");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_3:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '3');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-3");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_4:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '4');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-4");
                    ;
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_5:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '5');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-5");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_6:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '6');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-6");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_7:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '7');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-7");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_8:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '8');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-8");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_9:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '9');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-9");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.to_btn_cancel:
                if (txt_num.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (txt_num.length() == 8) {
                    txt_num.setText(current.substring(0, current.length() - 2));
                } else {
                    txt_num.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }

    public void goto_to_main(View v){
        tts.shutdown();
        Intent goto_to_main = new Intent(getApplicationContext(), Town_Office.class);
        startActivity(goto_to_main);
    }
    public void goto_to_ssn(View v){
        tts.shutdown();
        Intent goto_to_ssn = new Intent(getApplicationContext(), TO_SSN.class);
        startActivity(goto_to_ssn);
    }
    public void goto_to_issuance(View v){
        tts.shutdown();
        Intent goto_to_issuance = new Intent(getApplicationContext(), TO_Issuance_info.class);
        startActivity(goto_to_issuance);
    }
}