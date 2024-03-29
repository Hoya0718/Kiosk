package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.CheckBox;

import java.util.Locale;
import java.util.Random;

public class Kiosk_R_Part extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp sound;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_part);

        sound = (myapp) getApplication();

        checkBox = findViewById(R.id.checkBox);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("좌측 상단에 있는 임무를 누르면 각 상황별로 임무를 부여하게됩니다. 임무를 해보고싶으시다면 임무를 누르고 상황을 선택해 보세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Tap Missions in the top left corner and you will be given a mission for each situation. If you're interested in trying out a mission, tap Missions and select a situation.");
                    }
                }
            }
        });
    }

    // 배열에서 랜덤한 값 가져오기
    private String getRandomValue(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public void goto_Kiosk_R_F_M (View v){

        if (checkBox.isChecked()) {

            String[] fastfood_burger = {
                    getString(R.string.b1955),
                    getString(R.string.batodi),
                    getString(R.string.big_mc),
                    getString(R.string.mcchi),
                    getString(R.string.mccri),
                    getString(R.string.quater),
                    getString(R.string.sanhi),
                    getString(R.string.subi),
                    getString(R.string.susu),
                    getString(R.string.bulgogi),
                    getString(R.string.cheeze),
                    getString(R.string.ham)
            };

            String[] fastfood_size = {
                    getString(R.string.set_menu),
                    getString(R.string.large_menu)
            };

            String[] fastfood_side = {
                    getString(R.string.huri),
                    getString(R.string.chezstick),
                    getString(R.string.cuol)
            };

            String[] fastfood_drink = {
                    getString(R.string.chistr),
                    getString(R.string.chijadu),
                    getString(R.string.drinkoran),
                    getString(R.string.shakestr),
                    getString(R.string.shakecho),
                    getString(R.string.shakeba),
                    getString(R.string.drinkcoca),
                    getString(R.string.drinkcoze),
                    getString(R.string.drinkspri),
                    getString(R.string.drinkhwan),
                    getString(R.string.milk),
                    getString(R.string.water)
            };

            String randomBurger = getRandomValue(fastfood_burger);
            String randomSize = getRandomValue(fastfood_size);
            String randomSide = getRandomValue(fastfood_side);
            String randomDrink = getRandomValue(fastfood_drink);

            // 팝업 띄우기
            AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
            builder.setTitle("임무");
            builder.setMessage("버거 세트를 주문하는 임무입니다.\n아래와 같은 버거를 주문하세요.\n" +
                    "\n버거 : " + randomBurger +
                    "\n사이즈 : " + randomSize +
                    "\n사이드 : " + randomSide +
                    "\n음료 : " + randomDrink);

            myapp myApp = (myapp) getApplicationContext();
            String checkFastfoodMission = randomBurger + " - " + randomSize + " - " + randomSide + " - " + randomDrink;
            myApp.setCheckFastfoodMission(checkFastfoodMission);
            myApp.setMissionCheck(true);

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 다음 화면으로 넘어가는 코드 작성
                    Intent goto_Kiosk_R_F_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Fastfood_Main.class);
                    tts.shutdown();
                    startActivity(goto_Kiosk_R_F_M);
                }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 취소 버튼을 눌렀을 때 동작할 코드 작성
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            Intent goto_Kiosk_R_F_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Fastfood_Main.class);
            myapp myApp = (myapp) getApplicationContext();
            myApp.setCheckFastfoodMission(" ");
            myApp.setMissionCheck(false);
            tts.shutdown();
            startActivity(goto_Kiosk_R_F_M);
        }
    }

    public void goto_Kiosk_R_Bus (View v){

        if (checkBox.isChecked()) {

            String[] bus_destination = {
                    getString(R.string.central), getString(R.string.eastseoul),
                    getString(R.string.incheon_bus),getString(R.string.incheonairport),getString(R.string.sungnam),
                    getString(R.string.suwon),getString(R.string.ansan),getString(R.string.yongin),
                    getString(R.string.gangneung),getString(R.string.chuncheon),getString(R.string.sokcho),
                    getString(R.string.daejun),getString(R.string.sejong),
                    getString(R.string.nonsan),getString(R.string.cheonan),getString(R.string.gongju),
                    getString(R.string.cheongju),getString(R.string.jechun),getString(R.string.chungju),
                    getString(R.string.kwangjuu),getString(R.string.suncheon),getString(R.string.damyang),getString(R.string.naju),
                    getString(R.string.jeonju),getString(R.string.gunsan),getString(R.string.namwon),
                    getString(R.string.busan),getString(R.string.ulsan),getString(R.string.gimhae),
                    getString(R.string.eastdaegu),getString(R.string.westdaegu),getString(R.string.gyeongju)
            };

            String[] bus_time = {getString(R.string._8_30_), getString(R.string._9_40_), getString(R.string._10_00_)};

            String[] bus_seat = {getString(R.string.b_3),getString(R.string.b_4),getString(R.string.b_5),getString(R.string.b_6),
                    getString(R.string.b_10),getString(R.string.b_14),getString(R.string.b_15),getString(R.string.b_16)};

            String randomDestination = getRandomValue(bus_destination);
            String randomBusTime = getRandomValue(bus_time);
            String randomSeat = getRandomValue(bus_seat);

            // 팝업 띄우기
            AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
            builder.setTitle("임무");
            builder.setMessage("버스를 예매하는 임무입니다.\n아래와 같은 버스를 예매하세요.\n" +
                    "\n목적지 : " + randomDestination +
                    "\n버스 시간 : " + randomBusTime +
                    "\n좌석 : " + randomSeat); 

            myapp myApp = (myapp) getApplicationContext();
            String checkBusMission = randomDestination + " - " + randomBusTime + " - " + randomSeat;
            myApp.setCheckBusMission(checkBusMission);
            myApp.setMissionCheck(true);

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 다음 화면으로 넘어가는 코드 작성
                    Intent goto_Kiosk_R_B_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Bus_Main.class);
                    tts.shutdown();
                    startActivity(goto_Kiosk_R_B_M);
                }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 취소 버튼을 눌렀을 때 동작할 코드 작성
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            Intent goto_Kiosk_R_B_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Bus_Main.class);
            myapp myApp = (myapp) getApplicationContext();
            myApp.setCheckFastfoodMission(" ");
            myApp.setMissionCheck(false);
            tts.shutdown();
            startActivity(goto_Kiosk_R_B_M);
        }
    }

//    public void goto_Kiosk_R_Hospital (View v){
//
//        if (checkBox.isChecked()) {
//
//            String[] hospital_department = {
//                    getString(R.string.cardiology),
//                    getString(R.string.respiratory),
//                    getString(R.string.neurosurgery),
//                    getString(R.string.department_Family_Medicine),
//                    getString(R.string.urology),
//                    getString(R.string.orthopedics),
//                    getString(R.string.gastroenterology),
//            };
//
//            String randomDepartment = getRandomValue(hospital_department);
//
//            // 팝업 띄우기
//            AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
//            builder.setTitle("임무");
//            builder.setMessage("진료과를 접수하는 임무입니다.\n아래와 같은 부서를 접수하세요.\n" +
//                    "\n부서 : " + randomDepartment);
//
//            myapp myApp = (myapp) getApplicationContext();
//            String checkHospitalMission = randomDepartment;
//            myApp.setCheckHospitalMission(checkHospitalMission);
//            myApp.setMissionCheck(true);
//
//            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    // 다음 화면으로 넘어가는 코드 작성
//                    Intent goto_Kiosk_R_H = new Intent(Kiosk_R_Part.this, Kiosk_R_Hospital.class);
//                    tts.shutdown();
//                    startActivity(goto_Kiosk_R_H);
//                }
//            });
//            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    // 취소 버튼을 눌렀을 때 동작할 코드 작성
//                    dialog.dismiss();
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//
//        } else {
//            Intent goto_Kiosk_R_H = new Intent(Kiosk_R_Part.this, Kiosk_R_Hospital.class);
//            tts.shutdown();
//            startActivity(goto_Kiosk_R_H);
//        }
//    }
    public void a(View v){
        tts.shutdown();
        Intent a = new Intent(getApplicationContext(),r_Hospital_main.class);
        startActivity(a);
    }
    public void goto_Kiosk_Main (View v){
        tts.shutdown();
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
    }
    public void goto_PTO(View v){
        if (checkBox.isChecked()) {

            String[] TO_destination = {
                    getString(R.string.select_all), getString(R.string.select_all_not)
            };

            String randomDestination = getRandomValue(TO_destination);

            // 팝업 띄우기
            AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
            builder.setTitle("임무");
            builder.setMessage("동사무소의 세부사항을 선택하는 임무입니다.\n아래와 같은 세부사항을 선택하세요.\n" +
                    "\n세부사항 : " + randomDestination);

            myapp myApp = (myapp) getApplicationContext();
            String checkTOMission = randomDestination;
            myApp.setCheckTOMission(checkTOMission);
            myApp.setMissionCheck(true);

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 다음 화면으로 넘어가는 코드 작성
                    Intent P_TO = new Intent(Kiosk_R_Part.this, P_TO.class);
                    tts.shutdown();
                    startActivity(P_TO);
                }
            });
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 취소 버튼을 눌렀을 때 동작할 코드 작성
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
            tts.shutdown();
            myapp myApp = (myapp) getApplicationContext();
            myApp.setCheckTOMission(" ");
            myApp.setMissionCheck(false);
            Intent goto_PTO = new Intent(getApplicationContext(), P_TO.class);
            startActivity(goto_PTO);
        }
    }
    private void speakText(String text) {
        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
    protected void onPause () {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }

}