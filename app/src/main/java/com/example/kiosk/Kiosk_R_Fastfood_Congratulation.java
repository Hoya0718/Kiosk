package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Kiosk_R_Fastfood_Congratulation extends AppCompatActivity {
    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;
    private MainDao mainDao;
    private TextView con_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_congratulation);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();

        adapter = new MainAdapter(Kiosk_R_Fastfood_Congratulation.this, dataList);



        RoomDB db = Room.databaseBuilder(getApplicationContext(), RoomDB.class, "Time_DB")
                .fallbackToDestructiveMigration()     //스키마 버젼 변경 가능
                .allowMainThreadQueries()             // 메인 스레드에서 DB에 IO가능하게
                .build();

        mainDao = db.mainDao();

        MainData data = new MainData(); //객체 인스턴스 생성

        int myId = database.mainDao().getLastInsertedId();

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long beforePopTime = myApp.getR_F_Pop_Time();
        long beforePayTime = myApp.getR_F_Pay_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;        // 전체
        long payTime = (afterTime - beforePayTime) / 1000;      // 결제
        long popTime = (beforePayTime - beforePopTime) / 1000;  // 세부
        long menuTime = (beforePopTime - beforeTime) / 1000;    // 메뉴
        myApp.set_meansTime(measTime);
        myApp.set_meansTime(payTime);
        myApp.set_meansTime(popTime);
        myApp.set_meansTime(menuTime);

        List<Order> orderList = myApp.getOrderList();
        String checkMission = myApp.getCheckFastfoodMission();
        String missionComplete = "실패";
        for (Order order : orderList) {
            if (order.getOrderName().equals(checkMission)) {
                missionComplete = "성공";
                break;
            }
        }

        con_text = findViewById(R.id.con_text);
        if (myApp.getPracticeFastfoodCheck()) {
            long pTime = myApp.getR_F_Time();
            long diffTime;
            if (pTime > measTime) {
                diffTime = pTime - measTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요\n");
            } else {
                diffTime = measTime - pTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요");
            }
            if (measTime < myApp.getR_F_Time()){
                myApp.setR_F_Time(measTime);
            }
        } else if (myApp.getR_F_Time() != 0) {
            long rTime = myApp.getR_F_Time();
            long diffTime;
            if (rTime > measTime) {
                diffTime = rTime - measTime;
                con_text.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요");
            } else {
                diffTime = measTime - rTime;
                con_text.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요");
            }
            if (measTime < myApp.getR_F_Time()){
                myApp.setR_F_Time(measTime);
            }
        } else {
            con_text.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "구간별 소요 시간\n" +
                    "메뉴 선택 : " + (menuTime / 60) + "분 " + (menuTime % 60) + "초\n" +
                    "세부 선택 : " + (popTime / 60) + "분 " + (popTime % 60) + "초\n" +
                    "결제 : " + (payTime / 60) + "분 " + (payTime % 60) + "초");
            data.setTime((menuTime / 60) + "분 " + (menuTime % 60) + "초");
            data.setDetail((popTime / 60) + "분 " + (popTime % 60) + "초");
            data.setCredit((payTime / 60) + "분 " + (payTime % 60) + "초");
            database.mainDao().insert(data);
            database.mainDao().update2(myId,(menuTime / 60) + "분 " + (menuTime % 60) + "초\n");
            database.mainDao().update3(myId,(popTime / 60) + "분 " + (popTime % 60) + "초\n");
            database.mainDao().update4(myId,(payTime / 60) + "분 " + (payTime % 60) + "초\n");
            database.mainDao().deleteNullNameData();
            myApp.setR_F_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = con_text.getText().toString();
            String appendedText = currentText + "\n임무 성공 여부 : " + missionComplete;
            con_text.setText(appendedText);
        }

    }

    public void goto_Kiosk_R_P(View v){
        Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), Kiosk_R_Part.class);

        myapp myApp = (myapp) getApplicationContext();
        myApp.clearOrderList();
        myApp.setCheckFastfoodMission("X");
        myApp.setMissionCheck(false);

        startActivity(goto_Kiosk_R_P);
    }
}