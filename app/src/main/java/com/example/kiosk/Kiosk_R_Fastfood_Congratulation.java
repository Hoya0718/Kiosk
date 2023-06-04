package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Kiosk_R_Fastfood_Congratulation extends AppCompatActivity {

    private Button goto_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_congratulation);

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        long minutes = measTime / 60; // 분 계산
        long seconds = measTime % 60; // 초 계산

        List<Order> orderList = myApp.getOrderList();
        String checkMission = myApp.getCheckFastfoodMission();
        String missionComplete = "실패";
        for (Order order : orderList) {
            if (order.getOrderName().equals(checkMission)) {
                missionComplete = "성공";
                break;
            }
        }

        goto_5 = findViewById(R.id.concon);
        if (myApp.getPracticeFastfoodCheck()) {

        } else if (myApp.getMissionCheck()) {
            goto_5.setText("소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "임무 성공 여부 : " + missionComplete + "\n" +
                    "처음으로 돌아가기");
        } else {
            goto_5.setText("소요 시간 : " + minutes + "분 " + seconds + "초\n" +
                    "처음으로 돌아가기");
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