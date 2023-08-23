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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Intro_7_b extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_b);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("버거 메뉴를 고르는 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the screen to choose a burger menu." +
                            "You can hear the explanation of the menu by pressing the button on the screen." +
                            "For an explanation of the flow, please click the McDonald's logo button.");
                }
            }
        });
    }

    public void fastfoodIntro(View view) {
        switch (view.getId()) {
            case R.id.reco_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("추천메뉴에는 맥도날드의 대표적이고 맛있는 메뉴들로 구성된 선택 목록이 있습니다.");
                } else {
                    speakText("The recommended menu contains a list of choices made up of McDonald's signature and delicious menu items.");
                }
                break;
            case R.id.burger_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("버거는 다양한 종류의 신선한 재료로 만든 햄버거로, 빅맥, 치즈버거 등이 포함됩니다.");
                } else {
                    speakText("Burgers include hamburgers, Big Macs, and cheeseburgers made with a variety of fresh ingredients.");
                }
                break;
            case R.id.snack_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피스낵은 작은 사이즈의 간식 메뉴로, 감자튀김 등이 포함되어 있습니다.");
                } else {
                    speakText("Happy Snack is a small-sized snack menu that includes French fries and more.");
                }
                break;
            case R.id.side_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("사이드는 부가적인 음식 메뉴로, 샐러드나 감자튀김 등이 포함됩니다.");
                } else {
                    speakText("Sides are additional food items, such as salad or French fries.");
                }
                break;
            case R.id.coffee_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("커피는 다양한 종류의 커피 음료로, 아메리카노, 라떼 등이 준비되어 있습니다.");
                } else {
                    speakText("Coffee is a variety of coffee drinks, including Americano and latte.");
                }
                break;
            case R.id.dessert_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("디저트는 달콤한 음식으로, 아이스크림, 파이 등이 제공됩니다.");
                } else {
                    speakText("Desserts are sweet, with ice cream and pies served.");
                }
                break;
            case R.id.drink_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("음료는 다양한 음료수 메뉴로, 소다, 주스, 커피 등이 포함되어 있습니다.");
                } else {
                    speakText("Beverages include a variety of beverage menus, including sodas, juices, and coffee.");
                }
                break;
            case R.id.meal_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피밀은 아침 식사 메뉴로, 미니 머핀 등 신선한 아침 음식이 제공됩니다.");
                } else {
                    speakText("Happy Meal is the breakfast menu, and fresh breakfast items such as mini muffins are provided.");
                }
                break;

            case R.id.b1955_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("일구오오버거는 고소한 특별 소스와 신선한 재료로 만들어진 클래식한 햄버거입니다.");
                } else {
                    speakText("1955 Burger is a classic hamburger made with special savory sauce and fresh ingredients.");
                }
                break;
            case R.id.batodi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("베이컨 토마토 디럭스는 풍부한 베이컨과 신선한 토마토가 들어간 프리미엄 버거입니다.");
                } else {
                    speakText("Bacon Tomato Deluxe is a premium burger with rich bacon and fresh tomatoes.");
                }
                break;
            case R.id.bigmc_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("빅맥은 이중 패티와 특별한 소스로 맛을 낸 대표적인 맥도날드 햄버거입니다.");
                } else {
                    speakText("The Big Mc is the signature McDonald's hamburger seasoned with a double patty and special sauce.");
                }
                break;
            case R.id.mcchi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥치킨버거는 신선한 치킨 패티로 만든 버거로, 부드러운 맛과 풍미를 선사합니다.");
                } else {
                    speakText("Mcchicken Burger is a burger made with fresh chicken patties, offering a mild taste and flavor.");
                }
                break;
            case R.id.mccri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥크리스피 버거는 고소한 크리스피 치킨 패티가 특징이며, 바삭한 식감이 돋보입니다.");
                } else {
                    speakText("The McCrispy Burger features a savory Crispy Chicken Patty with a crispy texture.");
                }
                break;
            case R.id.quater_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("쿼터파운드 치즈 버거는 1/4 파운드 패티와 치즈가 들어간 푸짐한 햄버거로, 고기의 풍미가 느껴집니다.");
                } else {
                    speakText("The Quarter Pounder Cheeseburger is a hearty hamburger with a 1/4 pound patty and cheese, " +
                            "so you can feel the flavor of the meat.");
                }
                break;
            case R.id.sanhi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥스파이시 상하이 버거는 특별한 향신료와 소스로 맛을 낸 중국 풍의 매콤한 버거입니다.");
                } else {
                    speakText("McSpicy Shanghai Burger is a Chinese-style spicy burger seasoned with special spices and sauce.");
                }
                break;
            case R.id.susu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈슈버거는 신선한 생선 패티로 만든 맥도날드의 피쉬 버거 시리즈입니다.");
                } else {
                    speakText("Choushuburger is a McDonald's fish burger series made with fresh fish patties.");
                }
                break;
            case R.id.subi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈비버거는 신선한 생선 패티로 만든 맥도날드의 피쉬 버거 시리즈입니다.");
                } else {
                    speakText("Schwieburger is McDonald's fish burger series made with fresh fish patties.");
                }
                break;
            case R.id.bulgogi_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("불고기버거는 불고기 스타일의 소스로 양념한 버거로, 독특한 맛을 즐길 수 있습니다.");
                } else {
                    speakText("The Bulgogi Burger is a burger seasoned with a Bulgogi-style sauce, allowing you to enjoy a unique taste.");
                }
                break;
            case R.id.cheeze_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("치즈버거는 클래식한 햄버거에 치즈를 추가한 메뉴로, 담백하고 간단한 맛이 특징입니다.");
                } else {
                    speakText("Cheeseburger is a menu with cheese added to the classic hamburger, " +
                            "and is characterized by a light and simple taste.");
                }
                break;
            case R.id.ham_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("햄버거는 맥도날드의 대표적인 햄버거로, 신선한 재료와 소스로 구성되어 있습니다.");
                } else {
                    speakText("The hamburger is McDonald's signature hamburger and is made up of fresh ingredients and sauces.");
                }
                break;

            case R.id.ord_his_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문 내역은 주문한 음식과 메뉴에 대한 정보를 확인할 수 있는 기능을 제공합니다.");
                } else {
                    speakText("Order history provides the ability to check information about the food and menu you ordered.");
                }
                break;
        }
    }

    public void goto_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_kiosk_07_b = new Intent(getApplicationContext(), Kiosk_7_b.class);
        startActivity(goto_kiosk_07_b);
    }

    public void goto_kiosk_06(View v){
        tts.shutdown();
        Intent goto_kiosk_06 = new Intent(getApplicationContext(),Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_intro_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_s = new Intent(getApplicationContext(), Intro_7_s.class);
        startActivity(goto_intro_kiosk_07_s);
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