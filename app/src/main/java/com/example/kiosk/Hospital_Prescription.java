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
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Hospital_Prescription extends AppCompatActivity {
    TextView card_txt, barcode_txt, txt_num;
    String content_1;
    Button h_btn_1, h_btn_2, h_btn_3, h_btn_4, h_btn_5, h_btn_6, h_btn_7, h_btn_8, h_btn_9, h_btn_0, h_btn_cancel, h_btn_check;
    SpannableString spannableString_1, spannableString_2;
    private String get_num_2;
    private myapp text_size, pnpnpn, pn;
    private long clickTime;
    private TextToSpeech tts;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_prescription);


        //myapp
        text_size = (myapp) getApplication();
        pnpnpn = (myapp) getApplication();
        pn = (myapp) getApplication();
        //myapp

        //txt
        card_txt = findViewById(R.id.card_txt);
        barcode_txt = findViewById(R.id.barcode_txt);
        txt_num = findViewById(R.id.txt_num1);
        //txt

        //btn
        h_btn_0 = findViewById(R.id.h_btn_0_1);
        h_btn_1 = findViewById(R.id.h_btn_1_1);
        h_btn_2 = findViewById(R.id.h_btn_2_1);
        h_btn_3 = findViewById(R.id.h_btn_3_1);
        h_btn_4 = findViewById(R.id.h_btn_4_1);
        h_btn_5 = findViewById(R.id.h_btn_5_1);
        h_btn_6 = findViewById(R.id.h_btn_6_1);
        h_btn_7 = findViewById(R.id.h_btn_7_1);
        h_btn_8 = findViewById(R.id.h_btn_8_1);
        h_btn_9 = findViewById(R.id.h_btn_9_1);
        h_btn_cancel = findViewById(R.id.h_btn_cancel_1);
        h_btn_check = findViewById(R.id.h_btn_check_1);
        //btn

        // card_txt의 spannableString ----------------------------------------

        content_1 = card_txt.getText().toString(); //텍스트 가져옴
        spannableString_1 = new SpannableString(content_1); //객체 생성

        String word_1 = "진료카드가 없으신 분은\n진료카드번호 또는 주민등록번호를\n입력 후 확인 버튼을 누르세요.";
        spannableString_1 = new SpannableString(word_1);

        spannableString_1.setSpan(new ForegroundColorSpan(Color.parseColor("#0055FF")), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new StyleSpan(Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new RelativeSizeSpan(1.4f), 0, 11, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 13, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new StyleSpan(Typeface.BOLD), 13, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new RelativeSizeSpan(1.2f), 13, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new StyleSpan(Typeface.BOLD), 23, 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 23, 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new RelativeSizeSpan(1.2f), 23, 29, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        card_txt.setText(spannableString_1);

        // card_txt의 spannableString ----------------------------------------


        String word_2 = "빠른 처리를 원하시는 분은\n진료카드/영수증의 바코드를\n아래 바코드 대는 곳에 읽혀주세요.";
        spannableString_2 = new SpannableString(word_2);


        spannableString_2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new AbsoluteSizeSpan(90), 0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 15, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new AbsoluteSizeSpan(80), 15, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 25, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new AbsoluteSizeSpan(70), 25, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 33, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new AbsoluteSizeSpan(70), 33, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        barcode_txt.setText(spannableString_2);

        //tts 시작--------------------------------------------------------------------------------------

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("처방전을 받기 전 본인인증을 하는 단계입니다. 주민등록번호로 인증을 할 수 있어요.  주민등록번호를 입력 후 확인 버튼을 눌러보세요.");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("This is the step to verify your identity before receiving a prescription. You can verify with your social security number, so let's enter your social security number and hit the confirm button.");
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
            case R.id.h_btn_0_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '0');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-0");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;

            case R.id.h_btn_1_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '1');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-1");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_2_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '2');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-2");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_3_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '3');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-3");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_4_1:
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
            case R.id.h_btn_5_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '5');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-5");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_6_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '6');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-6");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_7_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '7');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-7");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_8_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '8');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-8");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_9_1:
                txt_num.setTextSize(text_size.getId());
                txt_num.setText(current + '9');
                txt_num.setTextSize(30);

                if (txt_num.length() == 7) {
                    txt_num.setText(current + "-9");
                }
                if (txt_num.length() >= 9)
                    txt_num.setText(current + '*');
                break;
            case R.id.h_btn_cancel_1:
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

    public void goto_progress(View v) {
        Intent goto_progress = new Intent(this, Hospital_in_progress.class);
        if (txt_num.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num_2 = txt_num.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);

            char one = get_num_2.charAt(0);
            char two = get_num_2.charAt(1);
            char three = get_num_2.charAt(2);
            char four = get_num_2.charAt(3);
            char five = get_num_2.charAt(4);
            char six = get_num_2.charAt(5);
            char seven = get_num_2.charAt(7);

            pn.setH_ssn(txt_num.getText().toString());
            clickTime = System.currentTimeMillis();
            pn.setDay(clickTime);

            if (three != '0' && three != '1') {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (three == '1' && !(four == '0' || four == '1' || four == '2')) {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (five != '0' && five != '1' && five != '2' && five != '3') {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (five == '3' && !(six == '0' || six == '1')) {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (checkInvalidDay(one,two,three,four,five,six)) {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 생년월일입니다.", Toast.LENGTH_LONG).show();
            } else if (!(seven == '1' || seven == '2' || seven == '3' || seven == '4')) {
                h_btn_cancel.setBackgroundResource(R.drawable.h_anim_orange_gray);
                anim = (AnimationDrawable) h_btn_cancel.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
            } else {
                tts.shutdown();
                startActivity(goto_progress);
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
    public void goto_Hospital_Main(View v){
        tts.shutdown();
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), Hospital_Main.class);
        startActivity(goto_Hospital_Main);
    }
}