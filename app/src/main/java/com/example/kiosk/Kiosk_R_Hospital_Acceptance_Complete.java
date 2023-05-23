package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kiosk_R_Hospital_Acceptance_Complete extends AppCompatActivity {

    private CheckBox check_Money;
    private TextView department;
    private TextView treatment_day;
    private TextView pnpn;
    private myapp pn;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_acceptance_complete);

        pn = (myapp) getApplication();
        pnpn = findViewById(R.id.pnpn);
        department = (findViewById(R.id.department_2));
        check_Money = (findViewById(R.id.check_Money));
        treatment_day = (findViewById(R.id.treatment_day));

        department.setText(pn.getDepartment());
        pnpn.setText(pn.getGet_pn_2().substring(0,6));
        String formattedTime = sdf.format(new Date(pn.getDay()));
        treatment_day.setText(formattedTime);


    }

    public void goto_Kiosk_R_H_P(View v){
        if(check_Money.isChecked()) {
            Intent goto_Kiosk_R_H_P = new Intent(this, Kiosk_R_Hospital_Pay.class);
            startActivity(goto_Kiosk_R_H_P);
        }
        else
        if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
            Toast.makeText(getApplicationContext(), "수납여부를 확인해주세요", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Check CheckBox", Toast.LENGTH_LONG).show();
        }
    }
    public void goto_Kiosk_H_Main(View v){
        Intent goto_Kiosk_H_Main = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_H_Main);
    }
    public void goto_Back(View v) {
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital_Acceptance.class);
        startActivity(goto_Back);
    }
}