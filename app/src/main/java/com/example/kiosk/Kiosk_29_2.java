package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kiosk_29_2 extends AppCompatActivity {

    private myapp pn;
    private TextView pnpn;
    private TextView department_2;
    private TextView treatment_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29_2);
        department_2 = findViewById(R.id.department_2);
        pn = (myapp) getApplication();
        pnpn = findViewById(R.id.pnpn);
        treatment_day = findViewById(R.id.treatment_day);
        department_2.setText(pn.getDepartment());
        treatment_day.setText(""+pn.getDay());
        pnpn.setText(pn.getGet_pn_2().substring(0,8));

    }
    public void goto_kiosk_30(View v){
        Intent goto_kiosk_30 = new Intent(this, Kiosk_30.class);
        startActivity(goto_kiosk_30);
    }
}