package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class r_To_misson extends AppCompatActivity {

    private myapp myApp;
    private TextView con_text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_misson);

        myApp = (myapp) getApplication();
        con_text2 = findViewById(R.id.con_text2);
        Intent intent = getIntent();
        String destination = intent.getStringExtra("TO_destination");


        String text = destination;

        String checkMission = myApp.getCheckTOMission();
        String missionComplete = "실패";

        if (text.equals(checkMission)) {
            missionComplete = "성공";
        }

        if (myApp.getMissionCheck()) {
            String currentText = con_text2.getText().toString();
            String appendedText = currentText + "\n임무 성공 여부 : " + missionComplete;
            con_text2.setText(appendedText);
        }

    }

    public void goto_Kiosk_R_P(View v){
        Intent goto_Kiosk_R_P = new Intent (getApplicationContext(),Kiosk_R_Part.class);
        startActivity(goto_Kiosk_R_P);
    }
}