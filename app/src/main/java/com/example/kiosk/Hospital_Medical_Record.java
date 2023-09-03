package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Hospital_Medical_Record extends AppCompatActivity {

    private TextView to_txt_ssn1;
    private myapp text_size;
    private String get_num_2;
    private myapp pnpnpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);

        to_txt_ssn1 = findViewById(R.id.to_txt_ssn1);
        text_size = (myapp) getApplication();
        pnpnpn = (myapp) getApplication();
    }


    public void put_n(View view){
        String current = to_txt_ssn1.getText().toString();

        switch(view.getId()){

            case R.id.h_btn_1_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '1');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-1");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;

            case R.id.h_btn_2_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '2');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-2");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_3_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '3');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-3");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_4_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '4');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-4");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_5_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '5');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-5");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_6_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '6');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-6");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_7_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '7');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-7");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_8_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '8');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-8");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_9_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '9');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-9");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_0_2:
                to_txt_ssn1.setTextSize(text_size.getId());
                to_txt_ssn1.setText(current + '0');
                to_txt_ssn1.setTextSize(30);

                if (to_txt_ssn1.length() == 7) {
                    to_txt_ssn1.setText(current + "-0");
                }
                if (to_txt_ssn1.length() >= 9)
                    to_txt_ssn1.setText(current + '*');
                break;
            case R.id.h_btn_cancel_2:
                if (to_txt_ssn1.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (to_txt_ssn1.length() == 8) {
                    to_txt_ssn1.setText(current.substring(0, current.length() - 2));
                } else {
                    to_txt_ssn1.setText(current.substring(0, current.length() - 1));
                }
                break;
            case R.id.h_btn_visitor:
                Intent intent2 = new Intent(getApplicationContext(),get_WaitingNum.class);
                startActivity(intent2);

        }
    }
    public void goto_progress(View v) {
        Intent goto_progress = new Intent(this, get_WaitingNum.class);
        if (to_txt_ssn1.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num_2 = to_txt_ssn1.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);
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
                startActivity(goto_progress);
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
    public void goto_Hospital_Main(View v) {
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), Hospital_Main.class);
        startActivity(goto_Hospital_Main);
    }
}