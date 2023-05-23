package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_R_Hospital_Department extends AppCompatActivity {

    private myapp text_size;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private String input;

    private TextView hos_department_txt;
    private myapp department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_department);

        text_size = (myapp) getApplication();
        department = (myapp) getApplication();

        hos_department_txt = findViewById(R.id.hos_department_txt);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);

        hos_department_txt.setTextSize(text_size.getId());
        btn_1.setTextSize(text_size.getId());
        btn_2.setTextSize(text_size.getId());
        btn_3.setTextSize(text_size.getId());
        btn_4.setTextSize(text_size.getId());
        btn_5.setTextSize(text_size.getId());
        btn_6.setTextSize(text_size.getId());
        btn_7.setTextSize(text_size.getId());
    }

    public void goto_Kiosk_R_H_R_C(View v) {

        Intent goto_Kiosk_R_H_R_C = new Intent(this,Kiosk_R_Hospital_Receipt_Complete.class);
        switch (v.getId()) {
            case R.id.btn_1:
                input = btn_1.getText().toString();
                department.setDepartment(btn_1.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_2:
                input = btn_2.getText().toString();
                department.setDepartment(btn_2.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_3:
                input = btn_3.getText().toString();
                department.setDepartment(btn_3.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_4:
                input = btn_4.getText().toString();
                department.setDepartment(btn_4.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_5:
                input = btn_5.getText().toString();
                department.setDepartment(btn_5.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_6:
                input = btn_6.getText().toString();
                department.setDepartment(btn_6.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
            case R.id.btn_7:
                input = btn_7.getText().toString();
                department.setDepartment(btn_7.getText().toString());
                goto_Kiosk_R_H_R_C.putExtra("text", input);
                startActivity(goto_Kiosk_R_H_R_C);
                break;
        }
    }
    public void goto_Kiosk_H_Main(View v){
        Intent goto_Kiosk_H_Main = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_H_Main);
    }
    public void goto_Back(View v) {
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Receipt.class);
        startActivity(goto_Back);
    }
}
