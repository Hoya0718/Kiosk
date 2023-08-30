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

public class Intro_7_s extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_kiosk07_s);

        sound = (myapp) getApplication();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                    speakText("사이드 메뉴 화면입니다." +
                            "화면의 버튼을 누르면 메뉴에 대한 설명을 들을 수 있습니다." +
                            "흐름에 대한 설명을 듣고 싶으면 맥도날드 로고 버튼을 눌러주세요.");
                }
                else {
                    tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                    speakText("This is the side menu screen." +
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
                    speakText("추천메뉴에는 맥도날드의 대표적이고 맛있는 메뉴들로 이루어진 목록이 있어요.");
                } else {
                    speakText("The recommended menu contains a list of choices made up of McDonald's signature and delicious menu items.");
                }
                break;
            case R.id.burger_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("버거는 다양한 종류의 신선한 재료로 만들어진 햄버거로, 큰 사이즈, 고급 버전 등이 포함돼 있어요.");
                } else {
                    speakText("Burgers include hamburgers, Big Macs, and cheeseburgers made with a variety of fresh ingredients.");
                }
                break;
            case R.id.snack_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피스낵은 작은 크기의 간식 메뉴로, 감자튀김 등이 포함돼 있어요.");
                } else {
                    speakText("Happy Snack is a small-sized snack menu that includes French fries and more.");
                }
                break;
            case R.id.side_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("사이드는 추가적인 음식 메뉴로, 샐러드나 감자튀김 등이 포함돼 있어요.");
                } else {
                    speakText("Sides are additional food items, such as salad or French fries.");
                }
                break;
            case R.id.coffee_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("커피는 다양한 종류의 커피 음료로, 미국식, 우유 커피 등이 준비돼 있어요.");
                } else {
                    speakText("Coffee is a variety of coffee drinks, including Americano and latte.");
                }
                break;
            case R.id.dessert_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("디저트는 달콤한 음식으로, 아이스크림, 파이 등이 제공돼 있어요.");
                } else {
                    speakText("Desserts are sweet, with ice cream and pies served.");
                }
                break;
            case R.id.drink_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("음료는 다양한 음료수 메뉴로, 탄산 음료, 과일 주스 등이 포함돼 있어요.");
                } else {
                    speakText("Beverages include a variety of beverage menus, including sodas, juices, and coffee.");
                }
                break;
            case R.id.meal_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해피밀은 아침 식사 메뉴로, 작은 머핀 등 신선한 아침 음식이 제공돼요.");
                } else {
                    speakText("Happy Meal is the breakfast menu, and fresh breakfast items such as mini muffins are provided.");
                }
                break;

            case R.id.snacksan_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("상하이 치킨 스낵랩은 바삭한 피짜 치킨과 신선한 채소가 들어간 간식으로, 매콤한 소스가 특징이에요.");
                } else {
                    speakText("Shanghai Chicken Snack Wrap is a snack of crispy pizza chicken and fresh vegetables, featuring a spicy sauce.");
                }
                break;
            case R.id.snackshu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("슈림프 스낵랩은 새우와 신선한 채소가 들어간 간식으로, 매콤한 소스가 특징이에요.");
                } else {
                    speakText("Shrimp Snack Wrap is a snack with shrimp and fresh vegetables, featuring a spicy sauce.");
                }
                break;
            case R.id.mcnurget_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥너겟은 고소한 닭고기로 만든 작고 바삭한 고기볼로, 부담없이 즐길 수 있는 간식이에요.");
                } else {
                    speakText("McNuggets are small, crispy meat balls made from savory chicken, and are a light snack that you can enjoy.");
                }
                break;
            case R.id.huri_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("후렌치 후라이는 바삭한 감자튀김으로, 입맛을 자극하는 간식이에요.");
                } else {
                    speakText("French Fries are crispy French fries that stimulate your taste buds.");
                }
                break;
            case R.id.hashbra_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("해쉬 브라운은 감자튀김 토마토 맛으로, 입맛을 자극하는 간식이에요.");
                } else {
                    speakText("Hash Browns are a tomato flavored potato fries that will stimulate your taste buds.");
                }
                break;
            case R.id.chickentender_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("맥스파이시 치킨 텐더는 매콤한 치킨 텐더로, 풍부한 맛과 식감이 특징이에요.");
                } else {
                    speakText("McSpicy Chicken Tenders are spicy hamburgers and chicken tenders, featuring a rich taste and texture.");
                }
                break;
            case R.id.chezstick_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("골든 모짜렐라 치즈스틱은 바삭한 외피와 녹아든 모짜렐라 치즈로, 부드럽고 고소한 간식이에요.");
                } else {
                    speakText("Golden Mozzarella Cheese Sticks are a soft, savory snack with a crispy skin and melted mozzarella cheese.");
                }
                break;
            case R.id.cuol_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("코울슬로는 신선한 채소와 드레싱으로 만든 상큼한 샐러드로, 건강한 선택이에요.");
                } else {
                    speakText("Coleslaw is a salad made with fresh vegetables and dressing, and is a refreshing and healthy choice.");
                }
                break;
            case R.id.churu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("츄러스는 바삭한 외피와 부드러운 속으로, 달콤하게 맛볼 수 있는 디저트예요.");
                } else {
                    speakText("Churros are a sweet dessert with a crispy skin and soft inside.");
                }
                break;
            case R.id.icesu_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("딸기 선데이 아이스크림은 상큼한 딸기와 부드러운 아이스크림으로 만든 간단한 디저트로, 달콤한 맛이 일품이에요.");
                } else {
                    speakText("Strawberry Sunday Ice Cream is a simple dessert made with fresh strawberries and soft ice cream, a" +
                            "nd the sweet taste is excellent.");
                }
                break;
            case R.id.iceco_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("초코 선데이 아이스크림은 풍부한 초콜릿 소스와 바닐라 아이스크림이 어우러져 달콤하고 진한 디저트로 만들어져요.");
                } else {
                    speakText("Choco Sunday Ice Cream combines rich chocolate sauce and vanilla ice cream to form a sweet and rich dessert.");
                }
                break;
            case R.id.iceba_lay:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("바닐라 선데이 아이스크림은 부드럽고 고소한 바닐라 아이스크림에 달콤한 시럽과 훈제 아몬드가 어우러진 맛깔나는 디저트예요.");
                } else {
                    speakText("Vanilla Sunday Ice Cream is a delicious dessert that combines soft vanilla ice cream with sweet syrup and smoked almonds.");
                }
                break;

            case R.id.ord_his_Btn:
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    speakText("주문 내역은 주문한 음식과 메뉴에 대한 정보를 확인할 수 있는 기능을 제공해요.");
                } else {
                    speakText("Order history provides the ability to check information about the food and menu you ordered.");
                }
                break;
        }
    }

    public void goto_kiosk_07_s(View v){
        tts.shutdown();
        Intent goto_kiosk_07_s = new Intent(getApplicationContext(), Kiosk_7_s.class);
        startActivity(goto_kiosk_07_s);
    }

    public void goto_intro_kiosk_07_b(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_b = new Intent(getApplicationContext(), Intro_7_b.class);
        startActivity(goto_intro_kiosk_07_b);
    }

    public void goto_intro_kiosk_07_d(View v){
        tts.shutdown();
        Intent goto_intro_kiosk_07_d = new Intent(getApplicationContext(), Intro_7_d.class);
        startActivity(goto_intro_kiosk_07_d);
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