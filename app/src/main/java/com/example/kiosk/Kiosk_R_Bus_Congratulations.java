package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Kiosk_R_Bus_Congratulations extends AppCompatActivity {
    private Button concon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_congratulations);

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");

        String checkMission = myApp.getCheckHospitalMission();
        String missionComplete = "실패";

        if (text.equals(checkMission)) {
            missionComplete = "성공";
        }

        concon = findViewById(R.id.concon);
        if (myApp.getPracticeFastfoodCheck()) {
            long pTime = myApp.getR_F_Time();
            long diffTime = pTime - measTime;
            concon.setText("연습 전 소요 시간 : " + (pTime / 60) + "분 " + (pTime % 60) + "초\n" +
                    "연습 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "소요 시간 차이 : " + (diffTime / 60) + "분 " + (diffTime % 60) + "초\n");
        } else if (myApp.getR_F_Time() != 0) {
            long rTime = myApp.getR_F_Time();
            long diffTime = rTime - measTime;
            concon.setText("실전 전 소요 시간 : " + (rTime / 60) + "분 " + (rTime % 60) + "초\n" +
                    "실전 후 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "소요 시간 차이 : " + (diffTime / 60) + "분 " + (diffTime % 60) + "초\n");
            if (measTime < myApp.getR_F_Time()){
                myApp.setR_F_Time(measTime);
            }
        } else {
            concon.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "처음으로 돌아가기");
            myApp.setR_F_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = concon.getText().toString();
            String appendedText = currentText + "\n" + "임무 성공 여부 : " + missionComplete;
            concon.setText(appendedText);
        }

        concon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Congratulations.this, Kiosk_R_Part.class);
                startActivity(intent);
            }

        });
    }
}

