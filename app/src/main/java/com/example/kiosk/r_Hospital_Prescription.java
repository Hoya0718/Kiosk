package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class r_Hospital_Prescription extends AppCompatActivity {

    TextView card_txt, barcode_txt, to_txt_ssn;

    private String get_num_2;
    private myapp text_size, pnpnpn, pn;
    private long clickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_prescription);

        //myapp
        text_size = (myapp) getApplication();
        pnpnpn = (myapp) getApplication();
        pn = (myapp) getApplication();
        //myapp
        //txt
        card_txt = findViewById(R.id.card_txt);
        barcode_txt = findViewById(R.id.barcode_txt);
        to_txt_ssn = findViewById(R.id.ssn_txt_1_1);
        //txt
    }
    public void put_n(View view) {
        String current = to_txt_ssn.getText().toString();

        switch (view.getId()) {
            case R.id.h_btn_0_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '0');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-0");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;

            case R.id.h_btn_1_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '1');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-1");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_2_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '2');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-2");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_3_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '3');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-3");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_4_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '4');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-4");
                    ;
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_5_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '5');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-5");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_6_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '6');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-6");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_7_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '7');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-7");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_8_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '8');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-8");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_9_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '9');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-9");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.h_btn_cancel_1:
                if (to_txt_ssn.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (to_txt_ssn.length() == 8) {
                    to_txt_ssn.setText(current.substring(0, current.length() - 2));
                } else {
                    to_txt_ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
    public void goto_progress(View v) {
        Intent goto_progress = new Intent(this, r_Hospital_In_Progress.class);
        if (to_txt_ssn.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num_2 = to_txt_ssn.getText().toString();
            pnpnpn.setGet_pn_2(get_num_2);

            char one = get_num_2.charAt(0);
            char two = get_num_2.charAt(1);
            char three = get_num_2.charAt(2);
            char four = get_num_2.charAt(3);
            char five = get_num_2.charAt(4);
            char six = get_num_2.charAt(5);
            char seven = get_num_2.charAt(7);

            pn.setH_ssn(to_txt_ssn.getText().toString());
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
    public void goto_Hospital_Main(View v){
        Intent goto_Hospital_Main = new Intent(getApplicationContext(), r_Hospital_main.class);
        startActivity(goto_Hospital_Main);
    }
}