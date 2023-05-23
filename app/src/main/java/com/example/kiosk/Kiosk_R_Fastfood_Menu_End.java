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

public class Kiosk_R_Fastfood_Menu_End extends AppCompatActivity {

    private TextToSpeech tts;

    private myapp sound;

    private myapp text_size;
    private Button burger;
    private Button side;
    private Button drink;
    private Button ord_his;
    private Button home;
    private Button help;

    private AnimationDrawable anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk08_6);

        sound = (myapp) getApplication();

        text_size = (myapp) getApplication();

        burger = findViewById(R.id.burger_Btn);
        side = findViewById(R.id.side_Btn);
        drink = findViewById(R.id.drink_Btn);
        ord_his = findViewById(R.id.ord_his_Btn);
        home = findViewById(R.id.home_Btn);
        help = findViewById(R.id.help_Btn);

        burger.setTextSize(text_size.getId());
        side.setTextSize(text_size.getId());
        drink.setTextSize(text_size.getId());
        ord_his.setTextSize(text_size.getId());
        home.setTextSize(text_size.getId());
        help.setTextSize(text_size.getId());

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 메뉴 화면으로 돌아왔습니다." +
                            "좌측 하단에 가격이 추가되었습니다." +
                            "이제 결제 단계로 넘어가보겠습니다." +
                            "주문 내역 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("You have returned to the Burger Menu screen." +
                            "Price added to bottom left." +
                            "Now let's move on to the payment phase." +
                            "Please press the order history button.");
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
                        ord_his.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) ord_his.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
        startActivity(goto_Kiosk_R_F_P_R);
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