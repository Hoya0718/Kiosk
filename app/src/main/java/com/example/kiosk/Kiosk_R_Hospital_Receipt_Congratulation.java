package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.List;

public class Kiosk_R_Hospital_Receipt_Congratulation extends AppCompatActivity {

    private myapp myApp;
    private TextView con_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_receipt_congratulatoin);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");

        myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        String checkMission = myApp.getCheckHospitalMission();
        String missionComplete = "실패";

        if (text.equals(checkMission)) {
            missionComplete = "성공";
        }

        con_text = findViewById(R.id.con_text);
        if (myApp.getPracticeFastfoodCheck()) {
            long pTime = myApp.getR_H_R_Time();
            long diffTime;
            if (pTime > measTime) {
                diffTime = pTime - measTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 빨랐어요");
            } else {
                diffTime = measTime - pTime;
                con_text.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                        "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                        "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 늦었어요");
            }
            if (measTime < myApp.getR_H_R_Time()){
                myApp.setR_H_R_Time(measTime);
            }
        } else if (myApp.getR_H_R_Time() != 0) {
            long rTime = myApp.getR_H_R_Time();
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
            if (measTime < myApp.getR_H_R_Time()){
                myApp.setR_H_R_Time(measTime);
            }
        } else {
            con_text.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초");
            myApp.setR_H_R_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = con_text.getText().toString();
            String appendedText = currentText + "\n임무 성공 여부 : " + missionComplete;
            con_text.setText(appendedText);
        }

    }

    public void goto_Kiosk_R_H(View v){
        Intent goto_Kiosk_R_H = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), Kiosk_R_Part.class);

        myapp myApp = (myapp) getApplicationContext();
        if(myApp.getMissionCheck()){
            myApp.setCheckHospitalMission("X");
            myApp.setMissionCheck(false);
            startActivity(goto_Kiosk_R_P);
        } else {
            myApp.setCheckHospitalMission("X");
            myApp.setMissionCheck(false);
            startActivity(goto_Kiosk_R_H);
        }
    }
}