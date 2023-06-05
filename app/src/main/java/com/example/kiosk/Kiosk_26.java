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

public class Kiosk_26 extends AppCompatActivity {

    private TextView ssn ,hos_bar_txt;
    private TextToSpeech tts;
    private myapp sound;

    private CheckBox personal_Information;

    private String get_num;
    private Button num_0, num_1,num_2,num_3,num_4,num_5,num_6,num_7,num_8,num_9,cl, check;
    private myapp pn;
    Handler handler = new Handler();
    private myapp text_size;
    private long clickTime;
    private AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk26);

        pn = (myapp) getApplication();
        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();

        personal_Information = findViewById(R.id.personal_Information);
        ssn = findViewById(R.id.SSN);
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
        hos_bar_txt = findViewById(R.id.hos_bar_txt);

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
        hos_bar_txt.setTextSize(text_size.getId());
        personal_Information.setTextSize(text_size.getId());
        ssn.setTextSize(text_size.getId());
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("접수를 하실려면 주민등록번호와 개인정보 수집 동의를 눌러주셔야 병원 접수가 됩니다. 개인정보 수집 동의를 눌러주신 후 주민등록번호를 입력하시고 확인을 눌러주세요");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("You'll need to enter your social security number to register. Try entering your social security number.");
                    }
                }
            }
        });

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.setSpeechRate(sound.getTtsSpeed());
                sound.getTtsVolume();
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("아래의 숫자를 통해 주민등록번호를 입력하실 수 있어요.");
                else
                    speakText("You can enter your social security number through the numbers below.");
            }
        }, 17000);*/

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {

            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("아래의 숫자를 통해 주민등록번호를 입력하실 수 있어요.");
                                else
                                    speakText("You can enter your social security number through the numbers below.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
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
        String current = ssn.getText().toString();


        switch (view.getId()) {
            case R.id.num_0:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '0');
                if (ssn.length() == 7) {
                    ssn.setText(current + "-0");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;

            case R.id.num_1:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '1');
                if(ssn.length()==7) {
                    ssn.setText(current + "-1");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_2:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '2');
                if(ssn.length()==7){
                    ssn.setText(current + "-2");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_3:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '3');
                if(ssn.length()==7){
                    ssn.setText(current + "-3");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_4:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '4');
                if(ssn.length()==7){
                    ssn.setText(current + "-4");;
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_5:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '5');
                if(ssn.length()==7) {
                    ssn.setText(current + "-5");
                }
                if(ssn.length()>=9)
                        ssn.setText(current + '*');
                break;
            case R.id.num_6:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + '6');
                if(ssn.length()==7){
                    ssn.setText(current + "-6");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_7:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current +'7');
                if(ssn.length()==7){
                    ssn.setText(current +"-7");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current +'*');
                break;
            case R.id.num_8:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current +'8');
                if(ssn.length()==7){
                    ssn.setText(current +"-8");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current +'*');
                break;
            case R.id.num_9:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current +'9');
                if(ssn.length()==7){
                    ssn.setText(current +"-9");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current +'*');
                break;
            case R.id.CL:
                if(ssn.length() ==0){
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(),"주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),"Enter your social security number", Toast.LENGTH_LONG).show();
                }
                else if(ssn.length() == 8){
                    ssn.setText(current.substring(0, current.length() - 2));
            }
                else {
                    ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_kiosk_26_2(View v) {
        Intent goto_kiosk_26_2 = new Intent(this, Kiosk_26_2.class);
        if (!personal_Information.isChecked()) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "개인정보 수집 동의를 눌러주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Agree to collect personal information.", Toast.LENGTH_LONG).show();
            }
        } else if (ssn.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num = ssn.getText().toString();

            char one = get_num.charAt(0);
            char two = get_num.charAt(1);
            char three = get_num.charAt(2);
            char four = get_num.charAt(3);
            char five = get_num.charAt(4);
            char six = get_num.charAt(5);
            char seven = get_num.charAt(7);

            pn.setGet_pn(get_num);
            clickTime = System.currentTimeMillis();
            pn.setDay(clickTime);

            if (three != '0' && three != '1') {
                speakText("유효하지 않은 월입니다.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (three == '1' && !(four == '0' || four == '1' || four == '2')) {
                speakText("유효하지 않은 월입니다.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (five != '0' && five != '1' && five != '2' && five != '3') {
                speakText("유효하지 않은 일입니다.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (five == '3' && !(six == '0' || six == '1')) {
                speakText("유효하지 않은 일입니다.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (checkInvalidDay(one,two,three,four,five,six)) {
                speakText("유효하지 않은 생년월일입니다.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "유효하지 않은 생년월일입니다.", Toast.LENGTH_LONG).show();
            } else if (!(seven == '1' || seven == '2' || seven == '3' || seven == '4')) {
                speakText("주민등록번호 뒷자리를 확인해주세요.");
                ssn.setBackgroundResource(R.drawable.anim_list2);
                anim = (AnimationDrawable) ssn.getBackground();
                anim.start();
                Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
            } else {
                startActivity(goto_kiosk_26_2);
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

    public void goto_Back(View v){
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_25.class);
        startActivity(goto_Back);
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