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
    private Button concon;
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

        concon = findViewById(R.id.concon);
        if (myApp.getPracticeHospitalCheck()) {
            long pTime = myApp.getR_H_R_Time();
            long diffTime = pTime - measTime;
            concon.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                    "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "소요 시간 차이 : " + (diffTime / 60) + "분 " + (diffTime % 60) + "초\n");
        } else if (myApp.getR_H_R_Time() != 0) {
            long rTime = myApp.getR_H_R_Time();
            long diffTime = rTime - measTime;
            concon.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                    "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "소요 시간 차이 : " + (diffTime / 60) + "분 " + (diffTime % 60) + "초\n");
            if (measTime < myApp.getR_H_R_Time()){
                myApp.setR_H_R_Time(measTime);
            }
        } else {
            concon.setText("접수 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "처음으로 돌아가기");
            myApp.setR_H_R_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = concon.getText().toString();
            String appendedText = currentText + "\n" + "임무 성공 여부 : " + missionComplete;
            concon.setText(appendedText);
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