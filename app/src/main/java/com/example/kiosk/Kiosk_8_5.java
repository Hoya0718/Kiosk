package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_8_5 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    private myapp text_size;
    private Button canca;
    private Button add_car;
    private Button home;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_5);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        canca = findViewById(R.id.canca_Btn);
        add_car = findViewById(R.id.add_car_Btn);
        home = findViewById(R.id.home_Btn);

        canca.setTextSize(text_size.getId());
        add_car.setTextSize(text_size.getId());
        home.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("지금까지 고른 버거의 항목들을 보여주는 화면입니다." +
                            "빅맥 세트가 추가되었습니다." +
                            "빅맥 세트의 구성은 빅맥, 후렌치 후라이, 코카콜라로 세팅되었습니다." +
                            "이 화면에서는 고른 메뉴의 수량을 조절할 수 있습니다." +
                            "취소 버튼을 누르면 이전 화면으로 가고," +
                            "장바구니 추가 버튼을 누르면 상단의 메뉴가 주문 내역에 추가됩니다." +
                            "장바구니 추가 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen shows the items of the burgers you've selected so far." +
                            "The Big Mc set has been added." +
                            "The Big Mc set consists of a Big Mc, French fries, and Coca-Cola." +
                            "On this screen, you can adjust the quantity of the selected menu." +
                            "If you press the cancel button, you go to the previous screen," +
                            "and if you press the add to cart button, the menu at the top is added to your order history." +
                            "Please press the Add to Cart button.");
                }
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
                                    speakText("버튼은 여기에 있어요.");
                                else
                                    speakText("Button is Here");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            add_car.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) add_car.getBackground();
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

    public void popup_kiosk_08_4(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_4 = new Intent(getApplicationContext(), Kiosk_8_4.class);
        startActivity(popup_kiosk_08_4);
    }

    public void popup_kiosk_08_6(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_6 = new Intent(getApplicationContext(), Kiosk_8_6.class);
        startActivity(popup_kiosk_08_6);
    }

    public void goto_kiosk_06(View view) {
        tts.shutdown();
        Intent popup_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(popup_kiosk_06);
    }

    public void goto_intro_kiosk_08_5(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_5 = new Intent(getApplicationContext(), Intro_8_5.class);
        startActivity(goto_intro_kiosk_08_5);
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