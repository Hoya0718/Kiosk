package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Menu_Burger extends AppCompatActivity {

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

    private int value;
    private TextView money_text;
    private TextView b1955_text;
    private TextView batodi_text;
    private TextView mcchi_text;
    private TextView mccri_text;
    private TextView quater_text;
    private TextView sanhi_text;
    private TextView susu_text;
    private TextView subi_text;
    private TextView bulgogi_text;
    private TextView cheeze_text;
    private TextView ham_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_burger);

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

        value = 0;
        money_text = findViewById(R.id.money_text);
        b1955_text = findViewById(R.id.b1955_text);
        batodi_text = findViewById(R.id.batodi_text);
        bigmc_text = findViewById(R.id.bigmc_text);
        mcchi_text = findViewById(R.id.mcchi_text);
        mccri_text = findViewById(R.id.mccri_text);
        quater_text = findViewById(R.id.quater_text);
        sanhi_text = findViewById(R.id.sanhi_text);
        susu_text = findViewById(R.id.susu_text);
        subi_text = findViewById(R.id.subi_text);
        bulgogi_text = findViewById(R.id.bulgogi_text);
        cheeze_text = findViewById(R.id.cheeze_text);
        ham_text = findViewById(R.id.ham_text);


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

    public void goto_Kiosk_R_F_M(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_S(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_F_M_S = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Side.class);
        startActivity(goto_Kiosk_R_F_M_S);
    }

    public void goto_Kiosk_R_F_M_D(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_F_M_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Drink.class);
        startActivity(goto_Kiosk_R_F_M_D);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        Intent popup_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_8_1.class);
        switch (view.getId()) {
            case R.id.b1955_lay:
                tts.shutdown();
                value+=6400;
                money_text.setText(String.valueOf(value));
                String burger1955 = b1955_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burger1955);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.batodi_lay:
                tts.shutdown();
                value+=5800;
                String burgerbatodi = batodi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbatodi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.bigmc_lay:
                tts.shutdown();
                value+=5200;
                String burgerbigmc = bigmc_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbigmc);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.mcchi_lay:
                tts.shutdown();
                value+=3500;
                String burgermcchi = mcchi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgermcchi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.mccri_lay:
                tts.shutdown();
                value+=5900;
                String burgermccri = mccri_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgermccri);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.quater_lay:
                tts.shutdown();
                value+=5500;
                String burgerquater = quater_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerquater);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.sanhi_lay:
                tts.shutdown();
                value+=5200;
                String burgersanhi = sanhi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersanhi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.susu_lay:
                tts.shutdown();
                value+=4700;
                String burgersusu = susu_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersusu);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.subi_lay:
                tts.shutdown();
                value+=5800;
                String burgersubi = subi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersubi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.bulgogi_lay:
                tts.shutdown();
                value+=2300;
                String burgerbulgogi = bulgogi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbulgogi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.cheeze_lay:
                tts.shutdown();
                value+=2700;
                String burgercheeze = cheeze_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgercheeze);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.ham_lay:
                tts.shutdown();
                value+=2500;
                String burgerham = ham_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerham);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
        }
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        tts.shutdown();
        Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
        startActivity(goto_Kiosk_R_F_P_R);
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