package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class Kiosk_R_Hospital_Receipt_Complete extends AppCompatActivity {
    private TextView day;
    private TextView hos_department_2;
    private TextView hos_98;

    private String text;
    private myapp pn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_receipt_complete);


        pn = (myapp) getApplication();
        day = findViewById(R.id.hos_day);
        hos_98 = findViewById(R.id.hos_98);
        hos_department_2 = findViewById(R.id.hos_department_2);


        hos_98.setText(pn.getGet_pn().substring(0,6));
        Intent intent = getIntent();
        text = intent.getStringExtra("text");
        hos_department_2.setText(text);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy/MM/dd(E)-HH:mm:ss", Locale.KOREAN);
        day.setText(format.format(c.getTime()));

    }

    public void goto_Kiosk_Main(View v){
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_Main);
    }
    public void goto_Back(View v){
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Department.class);
        startActivity(goto_Back);
    }
    public void goto_Kiosk_R_H_C(View v){
        Intent goto_Kiosk_R_H_C = new Intent(getApplicationContext(), Kiosk_R_Hospital_Receipt_Congratulation.class);
        goto_Kiosk_R_H_C.putExtra("text", text);
        startActivity(goto_Kiosk_R_H_C);
    }
}