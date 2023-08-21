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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TO_SSN2 extends AppCompatActivity {

    // textView 사용 선언----------------------------------------------------------------------------
    private TextView  to_txt_ssn;
    // textView 사용 선언----------------------------------------------------------------------------

    // tts 사용 선언---------------------------------------------------------------------------------
    private TextToSpeech tts;
    Handler handler = new Handler();
    // tts 사용 선언---------------------------------------------------------------------------------


    // myapp 사용 선언-------------------------------------------------------------------------------
    private myapp text_size ;
    // myapp 사용 선언-------------------------------------------------------------------------------
    private String get_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_ssn2);

        text_size = (myapp)getApplication();
        to_txt_ssn = findViewById(R.id.to_txt_ssn);


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
        String current = to_txt_ssn.getText().toString();

        switch (view.getId()) {
            case R.id.to_btn_0:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '0');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-0");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;

            case R.id.to_btn_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '1');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-1");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_2:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '2');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-2");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_3:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '3');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-3");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_4:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '4');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-4");
                    ;
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_5:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '5');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-5");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_6:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '6');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-6");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_7:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '7');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-7");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_8:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '8');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-8");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_9:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '9');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-9");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_del:
                to_txt_ssn.setTextSize(text_size.getId());
                if(to_txt_ssn.length() == 8){
                    to_txt_ssn.setText(current.substring(0, current.length() - 2));
                } else {
                    to_txt_ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
            case R.id.to_btn_all_delete:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(null);
                to_txt_ssn.setTextSize(30);
                break;
        }
    }

    public void goto_to_issuance(View v) {
        tts.shutdown();
        Intent goto_to_issuance = new Intent(this, TO_Issuance_info.class);
    if(to_txt_ssn.length() != 14) {
        if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
            Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
        }
    } else {
        get_num = to_txt_ssn.getText().toString();

        char one = get_num.charAt(0);
        char two = get_num.charAt(1);
        char three = get_num.charAt(2);
        char four = get_num.charAt(3);
        char five = get_num.charAt(4);
        char six = get_num.charAt(5);
        char seven = get_num.charAt(7);


        if (three != '0' && three != '1') {
            Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
        } else if (three == '1' && !(four == '0' || four == '1' || four == '2')) {
            Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
        } else if (five != '0' && five != '1' && five != '2' && five != '3') {
            Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
        } else if (five == '3' && !(six == '0' || six == '1')) {
            Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
        } else if (checkInvalidDay(one,two,three,four,five,six)) {
            Toast.makeText(getApplicationContext(), "유효하지 않은 생년월일입니다.", Toast.LENGTH_LONG).show();
        } else if (!(seven == '1' || seven == '2' || seven == '3' || seven == '4')) {
            Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
        } else {
            startActivity(goto_to_issuance);
        }
    }
    }
    private boolean checkInvalidDay(char one, char two, char three, char four, char five, char six) {

        int year = Integer.parseInt(String.valueOf(one) + String.valueOf(two));
        int month = Integer.parseInt(String.valueOf(three) + String.valueOf(four));
        int day = Integer.parseInt(String.valueOf(five) + String.valueOf(six));

        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
            return true;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            return true;
        } else if (month == 2) {
            if ((year % 4 == 0 && (day < 1 || day > 29)) || (year % 4 != 0 && (day < 1 || day > 28))) {
                return true;
            }
        }

        return false;
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

}