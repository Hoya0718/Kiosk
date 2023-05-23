package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Total extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button canca;
    private Button add_car;
    private Button home;
    private Button help;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_total);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        canca = findViewById(R.id.canca_Btn);
        add_car = findViewById(R.id.add_car_Btn);
        home = findViewById(R.id.home_Btn);
        help = findViewById(R.id.help_Btn);

        canca.setTextSize(text_size.getId());
        add_car.setTextSize(text_size.getId());
        home.setTextSize(text_size.getId());
        help.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("지금까지 고른 버거의 항목들을 보여주는 화면입니다." +
                            "빅맥 세트가 추가되었습니다." +
                            "빅맥 세트의 구성은 빅맥, 후렌치 후라이, 코카콜라로 세팅되었습니다." +
                            "장바구니 추가 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This screen shows the items of the burgers you've selected so far." +
                            "The Big Mc set has been added." +
                            "The Big Mac set consists of a Big Mc, French fries, and Coca-Cola." +
                            "Please press the Add to Cart button.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("버튼은 여기에 있어요.");
                else
                    speakText("Button is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        add_car.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) add_car.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_M_E(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_M_E = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_End.class);
        startActivity(goto_Kiosk_R_F_M_E);
    }

    public void goto_Kiosk_R_F_M(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    private void speakText(String text) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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