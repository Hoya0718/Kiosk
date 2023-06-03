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
        Intent goto_Kiosk_R_H_A_C = new Intent(this, Kiosk_R_Hospital_Acceptance_Complete.class);
        if (ssn_2.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num_2 = ssn_2.getText().toString();

            char one = get_num_2.charAt(0);
            char two = get_num_2.charAt(1);
            char three = get_num_2.charAt(2);
            char four = get_num_2.charAt(3);
            char five = get_num_2.charAt(4);
            char six = get_num_2.charAt(5);
            char seven = get_num_2.charAt(7);

            if (three != '0' && three != '1') {
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (three == '1' && !(four == '0' || four == '1' || four == '2')) {
                Toast.makeText(getApplicationContext(), "유효하지 않은 월입니다.", Toast.LENGTH_LONG).show();
            } else if (five != '0' && five != '1' && five != '2' && five != '3') {
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (five == '3' && !(six == '0' || six == '1')) {
                Toast.makeText(getApplicationContext(), "유효하지 않은 일입니다.", Toast.LENGTH_LONG).show();
            } else if (checkInvalidDay(one,two,three,four,five,six)) {
                Toast.makeText(getApplicationContext(), "유효하지 않은 생년월일입니다.", Toast.LENGTH_LONG).show();
            } else if (!(seven == '1' || seven == '2' || seven == '3' || seven == '4')) {
                Toast.makeText(getApplicationContext(), "주민등록번호 뒷자리를 확인해주세요.", Toast.LENGTH_LONG).show();
            } else {
                startActivity(goto_Kiosk_R_H_A_C);
            }
        }
    }

    private boolean checkInvalidDay(char one, char two, char three, char four, char five, char six) {

        int year = Integer.parseInt(String.valueOf(one) + String.valueOf(two));
        int month = Integer.parseInt(String.valueOf(three) + String.valueOf(four));
        int day = Integer.parseInt(String.valueOf(five) + String.valueOf(six));

        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
            return true;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            return true;
        } else if (month == 2) {
            if ((year % 4 == 0 && (day < 1 || day > 29)) || (year % 4 != 0 && (day < 1 || day > 28))) {
                return true;
            }
        }

        return false;
    }

    public void goto_Back(View v) {
        Intent goto_Back = new Intent(getApplicationContext(), Kiosk_R_Hospital.class);
        startActivity(goto_Back);
    }
}