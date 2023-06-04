package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Kiosk_R_Hospital_Receipt extends AppCompatActivity {

    private TextView ssn, hos_bar_txt;


    private CheckBox personal_Information;

    private String get_num;
    private Button num_0, num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, cl, check;
    private myapp pn;

    private myapp text_size;
    private long clickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_hospital_receipt);

        myapp myApp = (myapp) getApplicationContext();
        myApp.setR_Time(System.currentTimeMillis());

        pn = (myapp) getApplication();
        text_size = (myapp) getApplication();

        personal_Information = findViewById(R.id.personal_Information);
        ssn = findViewById(R.id.SSN);
        num_0 = findViewById(R.id.num_0);
        cl = findViewById(R.id.CL);
        num_1 = findViewById(R.id.num_1);
        num_2 = findViewById(R.id.num_2);
        num_3 = findViewById(R.id.num_3);
        num_4 = findViewById(R.id.num_4);
        num_5 = findViewById(R.id.num_5);
        num_6 = findViewById(R.id.num_6);
        num_7 = findViewById(R.id.num_7);
        num_8 = findViewById(R.id.num_8);
        num_9 = findViewById(R.id.num_9);
        check = findViewById(R.id.Check_2);
        hos_bar_txt = findViewById(R.id.hos_bar_txt);

        num_0.setTextSize(text_size.getId());
        num_1.setTextSize(text_size.getId());
        num_2.setTextSize(text_size.getId());
        num_3.setTextSize(text_size.getId());
        num_4.setTextSize(text_size.getId());
        num_5.setTextSize(text_size.getId());
        num_6.setTextSize(text_size.getId());
        num_7.setTextSize(text_size.getId());
        num_8.setTextSize(text_size.getId());
        num_9.setTextSize(text_size.getId());
        cl.setTextSize(text_size.getId());
        check.setTextSize(text_size.getId());
        hos_bar_txt.setTextSize(text_size.getId());
        personal_Information.setTextSize(text_size.getId());
        ssn.setTextSize(text_size.getId());

    }


    public void put_n(View view) {
        String current = ssn.getText().toString();

        switch (view.getId()) {
            case R.id.num_0:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "0");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-0");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;

            case R.id.num_1:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "1");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-1");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_2:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "2");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-2");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_3:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "3");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-3");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_4:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "4");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-4");
                    ;
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_5:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "5");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-5");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_6:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "6");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-6");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_7:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "7");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-7");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_8:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "8");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-8");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.num_9:
                ssn.setTextSize(text_size.getId());
                ssn.setText(current + "9");
                if (ssn.length() == 7) {
                    ssn.setText(current + "-9");
                }
                if (ssn.length() >= 9)
                    ssn.setText(current + '*');
                break;
            case R.id.CL:
                if (ssn.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (ssn.length() == 8) {
                    ssn.setText(current.substring(0, current.length() - 2));
                } else {
                    ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }

    public void goto_Kiosk_R_H_D(View v) {
        Intent goto_Kiosk_R_H_D = new Intent(this, Kiosk_R_Hospital_Department.class);
        if (!personal_Information.isChecked()) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "개인정보 수집 동의를 눌러주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Agree to collect personal information.", Toast.LENGTH_LONG).show();
            }
        } else if (ssn.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num = ssn.getText().toString();

            char one = get_num.charAt(0);
            char two = get_num.charAt(1);
            char three = get_num.charAt(2);
            char four = get_num.charAt(3);
            char five = get_num.charAt(4);
            char six = get_num.charAt(5);
            char seven = get_num.charAt(7);

            pn.setGet_pn(get_num);
            clickTime = System.currentTimeMillis();
            pn.setDay(clickTime);

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
                startActivity(goto_Kiosk_R_H_D);
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