package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kiosk_29_2 extends AppCompatActivity {

    private myapp pn;
    private TextView pnpn;
    private TextView department_2;
    private TextView treatment_day;

    private CheckBox check_Money;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29_2);
        department_2 = findViewById(R.id.department_2);
        pn = (myapp) getApplication();
        pnpn = findViewById(R.id.pnpn);
        treatment_day = findViewById(R.id.treatment_day);
        department_2.setText(pn.getDepartment());
        pnpn.setText(pn.getGet_pn_2().substring(0,8));
        String formattedTime = sdf.format(new Date(pn.getDay()));
        treatment_day.setText(formattedTime);
        check_Money = findViewById(R.id.check_Money);
    }
    public void goto_kiosk_30(View v){
        if(check_Money.isChecked()) {
            Intent goto_kiosk_30 = new Intent(this, Kiosk_30.class);
            startActivity(goto_kiosk_30);
        }
        else
            Toast.makeText(getApplicationContext(), "체크박스를 확인해주세요", Toast.LENGTH_LONG).show();
    }
}