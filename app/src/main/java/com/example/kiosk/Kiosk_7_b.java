package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_7_b extends AppCompatActivity {

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

    private TextView bigmc_text;
    private TextView bigmc_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk07_b);

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

        bigmc_text = findViewById(R.id.bigmc_text);
        bigmc_price = findViewById(R.id.bigmc_price);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 메뉴 화면입니다. 빅맥 세트 한 개를 주문해보겠습니다." +
                            "세트의 구성으로는 후렌치 후라이, 코카콜라를 골라보겠습니다." +
                            "메뉴에서 빅맥을 골라주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the burger menu screen. Let's order a Big Mc set." +
                            "For the composition of the set, I'll choose French fries and Coca-Cola." +
                            "Choose a Big Mc from the menu, please.");
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("빅맥은 여기에 있어요.");
                else
                    speakText("Big Mc is Here");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bigmc_text.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) bigmc_text.getBackground();
                        anim.start();

                        bigmc_price.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) bigmc_price.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 15000);
    }

    public void goto_kiosk_06(View v){
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void goto_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }

    public void popup_kiosk_08_1(View view) {
        tts.shutdown();
        Intent popup_kiosk_08_1 = new Intent(getApplicationContext(), Kiosk_8_1.class);
        startActivity(popup_kiosk_08_1);
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