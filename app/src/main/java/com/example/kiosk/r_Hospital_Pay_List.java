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

import java.text.SimpleDateFormat;
import java.util.Date;

public class r_Hospital_Pay_List extends AppCompatActivity {

    private TextView h_txt_ssn, treatment_day_1;
    private Button credit_one;
    private myapp pn;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_pay_list);

        h_txt_ssn = findViewById(R.id.h_txt_ssn);
        treatment_day_1 = findViewById(R.id.treatment_day_1);

        //TextView 종료------------------------------------------------------------------------------

        //Button------------------------------------------------------------------------------------

        credit_one = findViewById(R.id.credit_one);

        //Button------------------------------------------------------------------------------------

        //myapp 선언---------------------------------------------------------------------------------

        pn = (myapp) getApplication();

        //myapp 종료---------------------------------------------------------------------------------

        h_txt_ssn.setText(pn.getH_ssn());

        String formattedTime = sdf.format(date);
        treatment_day_1.setText(formattedTime);
    }
    public void goto_pay(View v){
        Intent goto_pay = new Intent(getApplicationContext(), r_Hospital_Pay.class);
        startActivity(goto_pay);
    }
    public void goto_Hospital_Main(View v){
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), r_Hospital_main.class);
        startActivity(goto_Hospital_Main);
    }
}