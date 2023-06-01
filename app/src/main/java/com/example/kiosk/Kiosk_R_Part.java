package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Kiosk_R_Part extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_part);
    }

    // 배열에서 랜덤한 값 가져오기
    private String getRandomValue(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public void goto_Kiosk_R_F_M (View v){

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
                getString(R.string.snacksan),
                getString(R.string.snackshu),
                getString(R.string.mcnurget),
                getString(R.string.huri),
                getString(R.string.hashbra),
                getString(R.string.chickentender),
                getString(R.string.chezstick),
                getString(R.string.cuol),
                getString(R.string.churu),
                getString(R.string.icesu),
                getString(R.string.iceco),
                getString(R.string.iceba)
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

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 다음 화면으로 넘어가는 코드 작성
                Intent goto_Kiosk_R_F_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Fastfood_Main.class);
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
    }

    public void goto_Kiosk_R_Bus (View v){

        String[] bus_destination = {
                "센트럴시티","동서울",
                "인천","인천공항","성남","수원","안산","용인",
                "강릉","춘천","속초",
                "대전","세종",
                "논산","천안","공주",
                "청주","제천","충주",
                "광주(유스퀘어)","순천","담양","나주",
                "전주","군산","남원",
                "부산","울산","김해",
                "동대구","서대구","경주"
        };

        String[] bus_type = {"우등버스","고속버스"};

        String[] bus_seat = {"3","4","5","6","10","14","15","16"};

        String randomDestination = getRandomValue(bus_destination);
        String randomBusType = getRandomValue(bus_type);
        String randomSeat = getRandomValue(bus_seat);

        // 팝업 띄우기
        AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
        builder.setTitle("임무");
        builder.setMessage("버스를 예매하는 임무입니다.\n아래와 같은 버스를 예매하세요.\n" +
                "\n목적지 : " + randomDestination +
                "\n버스 종류 : " + randomBusType +
                "\n좌석 : " + randomSeat);

        myapp myApp = (myapp) getApplicationContext();
        String checkBusMission = randomDestination + " - " + randomBusType + " - " + randomSeat;
        myApp.setCheckBusMission(checkBusMission);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 다음 화면으로 넘어가는 코드 작성
                Intent goto_Kiosk_R_B_M = new Intent(Kiosk_R_Part.this, Kiosk_R_Bus_Main.class);
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
    }

    public void goto_Kiosk_R_Hospital (View v){

        String[] hospital_department = {
                getString(R.string.cardiology),
                getString(R.string.respiratory),
                getString(R.string.neurosurgery),
                getString(R.string.department_Family_Medicine),
                getString(R.string.urology),
                getString(R.string.orthopedics),
                getString(R.string.gastroenterology),
        };

        String randomDepartment = getRandomValue(hospital_department);

        // 팝업 띄우기
        AlertDialog.Builder builder = new AlertDialog.Builder(Kiosk_R_Part.this);
        builder.setTitle("임무");
        builder.setMessage("진료과를 접수하는 임무입니다.\n아래와 같은 부서를 접수하세요.\n" +
                "\n부서 : " + randomDepartment);

        myapp myApp = (myapp) getApplicationContext();
        String checkHospitalMission = randomDepartment;
        myApp.setCheckHospitalMission(checkHospitalMission);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 다음 화면으로 넘어가는 코드 작성
                Intent goto_Kiosk_R_H = new Intent(Kiosk_R_Part.this, Kiosk_R_Hospital.class);
                startActivity(goto_Kiosk_R_H);
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

    public void goto_Kiosk_Main (View v){
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
    }

}