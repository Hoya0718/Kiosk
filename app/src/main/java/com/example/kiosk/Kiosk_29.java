package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Kiosk_29 extends AppCompatActivity {

    private TextView ssn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk29);

        ssn = findViewById(R.id.SSN);
    }
    public void put_n(View view) {
        String current = ssn.getText().toString();

        switch (view.getId()) {
            case R.id.num_0:
                ssn.setTextSize(20);
                ssn.setText(current + "0");
                if(ssn.length()==7){
                    ssn.setText(current + "-0");
                }
                break;
            case R.id.num_1:
                ssn.setTextSize(20);
                ssn.setText(current + "1");
                if(ssn.length()==7) {
                    ssn.setText(current + "-1");
                }
                break;
            case R.id.num_2:
                ssn.setTextSize(20);
                ssn.setText(current + "2");
                if(ssn.length()==7){
                    ssn.setText(current + "-2");
                }
                break;
            case R.id.num_3:
                ssn.setTextSize(20);
                ssn.setText(current + "3");
                if(ssn.length()==7){
                    ssn.setText(current + "-3");
                }
                break;
            case R.id.num_4:
                ssn.setTextSize(20);
                ssn.setText(current + "4");
                if(ssn.length()==7){
                    ssn.setText(current + "-4");
                }
                break;
            case R.id.num_5:
                ssn.setTextSize(20);
                ssn.setText(current + "5");
                if(ssn.length()==7){
                    ssn.setText(current + "-5");
                }
                break;
            case R.id.num_6:
                ssn.setTextSize(20);
                ssn.setText(current + "6");
                if(ssn.length()==7){
                    ssn.setText(current + "-6");
                }
                break;
            case R.id.num_7:
                ssn.setTextSize(20);
                ssn.setText(current + "7");
                if(ssn.length()==7){
                    ssn.setText(current + "-7");
                }
                break;
            case R.id.num_8:
                ssn.setTextSize(20);
                ssn.setText(current + "8");
                if(ssn.length()==7){
                    ssn.setText(current + "-8");
                }
                break;
            case R.id.num_9:
                ssn.setTextSize(20);
                ssn.setText(current + "9");
                if(ssn.length()==7){
                    ssn.setText(current + "-9");
                }
                break;
            case R.id.CL:
                if(ssn.length() ==0){
                    Toast.makeText(getApplicationContext(),"주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if(ssn.length() == 8){
                    ssn.setText(current.substring(0, current.length() - 2));
                }
                else {
                    ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_kiosk_30(View v) {
        Intent goto_kiosk_30= new Intent(getApplicationContext(), Kiosk_30.class);
        if(ssn.length() == 14)
            startActivity(goto_kiosk_30);
        else {
            Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
        }
    }
}