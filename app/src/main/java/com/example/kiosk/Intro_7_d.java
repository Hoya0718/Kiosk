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

public class Intro_7_d extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_d);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("음료 메뉴 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the drink menu screen." +
                            "Press the button on the screen to hear the explanation of the menu." +
                            "If you would like an explanation of the flow, please press the McDonald's logo button.");
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

            case R.id.drinkcoca_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코카콜라는 캐러멜 풍미의 대표적인 탄산음료입니다.");
                } else {
                    speakText("Coca-Cola is a typical carbonated soft drink with a caramel flavor.");
                }
                break;
            case R.id.drinkspri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("스프라이트는 상쾌한 레몬-라임 맛의 탄산음료입니다.");
                } else {
                    speakText("Sprite is a refreshing lemon-lime flavored soda.");
                }
                break;
            case R.id.drinkhwan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("환타는 풍부한 오렌지 향의 탄산음료입니다.");
                } else {
                    speakText("Fanta is a carbonated soft drink with a rich orange flavor.");
                }
                break;
            case R.id.drinkcoze_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코카콜라제로는 칼로리가 없는 버전의 코카콜라로, 시원하면서도 가벼운 선택지입니다.");
                } else {
                    speakText("Coca-Cola Zero is a calorie-free version of Coca-Cola, a cool, lightweight option.");
                }
                break;
            case R.id.chistr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 칠러는 과일 향기와 시원함이 어우러진 음료로, 딸기의 풍부한 맛을 즐길 수 있습니다.");
                } else {
                    speakText("Strawberry chiller is a drink with a fruity aroma and coolness, " +
                            "allowing you to enjoy the rich taste of strawberries.");
                }
                break;
            case R.id.chijadu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("자두 칠러는 과일 향기와 시원함이 어우러진 음료로, 자두의 풍부한 맛을 즐길 수 있습니다.");
                } else {
                    speakText("Plum chiller is a drink with a fruity aroma and coolness, " +
                            "allowing you to enjoy the rich taste of plums.");
                }
                break;
            case R.id.shakestr_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 쉐이크는 부드럽고 크리미한 맛의 딸기 밀크쉐이크입니다.");
                } else {
                    speakText("Strawberry Shake is a strawberry milkshake with a smooth and creamy taste.");
                }
                break;
            case R.id.shakecho_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 쉐이크는 부드럽고 크리미한 맛의 초코 밀크쉐이크입니다.");
                } else {
                    speakText("Choco Shake is a chocolate milkshake with a smooth and creamy taste.");
                }
                break;
            case R.id.shakeba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 쉐이크는 부드럽고 크리미한 맛의 바닐라 밀크쉐이크입니다.");
                } else {
                    speakText("Vanilla Shake is a smooth and creamy vanilla milkshake.");
                }
                break;
            case R.id.drinkoran_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("신선한 오렌지로 만든 상큼한 주스로, 비타민 C를 함유하며 건강한 선택입니다.");
                } else {
                    speakText("Refreshing juice made from fresh oranges, packed with vitamin C and a healthy choice.");
                }
                break;
            case R.id.milk_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("고소하고 영양가 있는 우유로, 다양한 음식과 함께 즐길 수 있습니다.");
                } else {
                    speakText("It is nutritious and nutritious milk, and can be enjoyed with a variety of foods.");
                }
                break;
            case R.id.water_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("깨끗하고 청량한 물로, 목마를 해소할 수 있는 선택지입니다.");
                } else {
                    speakText("It is an option to relieve thirst with clean and refreshing water.");
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

    public void goto_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_kiosk_07_d = new Intent(getApplicationContext(), Kiosk_7_d.class);
        startActivity(goto_kiosk_07_d);
    }

    public void goto_intro_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_s = new Intent(getApplicationContext(), Intro_7_s.class);
        startActivity(goto_intro_kiosk_07_s);
    }

    public void goto_intro_kiosk_08_1(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_08_1 = new Intent(getApplicationContext(), Intro_8_1.class);
        startActivity(goto_intro_kiosk_08_1);
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