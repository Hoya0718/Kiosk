package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_R_Congratulations extends AppCompatActivity {

    private Button concon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_congratulations);

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        concon = findViewById(R.id.concon);
        if (myApp.getPracticeFastfoodCheck()) {
            long pTime = myApp.getR_F_Time();
            long diffTime = pTime - measTime;
            if (diffTime > 0) {
                concon.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요\n" +
                        "처음으로 돌아가기");
            } else {
                concon.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요\n" +
                        "처음으로 돌아가기");
            }
            if (measTime < myApp.getR_F_Time()){
                myApp.setR_F_Time(measTime);
            }
        } else if (myApp.getR_F_Time() != 0) {
            long rTime = myApp.getR_F_Time();
            long diffTime = rTime - measTime;
            if (diffTime > 0) {
                concon.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요\n" +
                        "처음으로 돌아가기");
            } else {
                concon.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                        "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요\n" +
                        "처음으로 돌아가기");
            }
            if (measTime < myApp.getR_F_Time()){
                myApp.setR_F_Time(measTime);
            }
        } else {
            concon.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "처음으로 돌아가기");
            myApp.setR_F_Time(measTime);
        }

    }
    public void goto_Kiosk_R_P(View v){
        Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_Kiosk_R_P);
    }
}