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
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_R_Hospital_Acceptance extends AppCompatActivity {
    private TextView ssn_2 ;

    private Button num_0_2,num_1_2,num_2_2,num_3_2,num_4_2,num_5_2,num_6_2,num_7_2,num_8_2,num_9_2,check_2,cl_2;
    private myapp text_size;
    private String get_num_2;
    private TextView accept_info;
    private myapp pnpnpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_acceptance);

        ssn_2 = findViewById(R.id.SSN_2);
        text_size = (myapp)getApplication();
        pnpnpn = (myapp) getApplication();
        num_0_2 = findViewById(R.id.num_0_2);
        check_2 = findViewById(R.id.Check_2_2);
        cl_2 = findViewById(R.id.CL_2);
        num_1_2 = findViewById(R.id.num_1_2);
        num_2_2 = findViewById(R.id.num_2_2);
        num_3_2 = findViewById(R.id.num_3_2);
        num_4_2 = findViewById(R.id.num_4_2);
        num_5_2 = findViewById(R.id.num_5_2);
        num_6_2 = findViewById(R.id.num_6_2);
        num_7_2 = findViewById(R.id.num_7_2);
        num_8_2 = findViewById(R.id.num_8_2);
        num_9_2 = findViewById(R.id.num_9_2);
        accept_info =findViewById(R.id.accept_info);

        ssn_2.setTextSize(text_size.getId());
        accept_info.setTextSize(text_size.getId());
        check_2.setTextSize(text_size.getId());
        cl_2.setTextSize(text_size.getId());
        num_0_2.setTextSize(text_size.getId());
        num_1_2.setTextSize(text_size.getId());
        num_2_2.setTextSize(text_size.getId());
        num_3_2.setTextSize(text_size.getId());
        num_4_2.setTextSize(text_size.getId());
        num_5_2.setTextSize(text_size.getId());
        num_6_2.setTextSize(text_size.getId());
        num_7_2.setTextSize(text_size.getId());
        num_8_2.setTextSize(text_size.getId());
        num_9_2.setTextSize(text_size.getId());
    }

    public void put_n(View view) {
        String current = ssn_2.getText().toString();

        switch (view.getId()) {
            case R.id.num_0_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "0");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-0");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_1_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "1");
                if(ssn_2.length()==7) {
                    ssn_2.setText(current + "-1");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_2_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "2");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-2");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_3_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "3");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-3");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_4_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "4");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-4");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_5_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "5");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-5");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_6_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "6");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-6");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_7_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "7");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-7");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_8_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "8");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-8");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.num_9_2:
                ssn_2.setTextSize(text_size.getId());
                ssn_2.setText(current + "9");
                if(ssn_2.length()==7){
                    ssn_2.setText(current + "-9");
                }
                if (ssn_2.length() >= 9)
                    ssn_2.setText(current + '*');
                break;
            case R.id.CL_2:
                if(ssn_2.length() ==0){
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Enter your social security number.", Toast.LENGTH_LONG).show();}
                }
                else if(ssn_2.length() == 8){
                    ssn_2.setText(current.substring(0, current.length() - 2));
                }
                else {
                    ssn_2.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_Kiosk_R_H_A_C(View v) {

        Intent goto_Kiosk_R_H_A_C= new Intent(getApplicationContext(), Kiosk_R_Hospital_Acceptance_Complete.class);
        if(ssn_2.length() == 14) {
            get_num_2 = ssn_2.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);
            char pass = get_num_2.charAt(7);
            if (pass == '1' || pass == '2' || pass == '3' || pass == '4') {
                startActivity(goto_Kiosk_R_H_A_C);

            }
            else
                Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
        }
        else {
            if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호가 맞는지 확인해주세요.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Please verify your social security number.", Toast.LENGTH_LONG).show();}
        }
    }

    public void goto_Back(View v) {
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Back);
    }
}