package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class r_To_Ssn2 extends AppCompatActivity {
    // textView 사용 선언----------------------------------------------------------------------------
    private TextView to_txt_ssn;
    // textView 사용 선언----------------------------------------------------------------------------
    // myapp 사용 선언-------------------------------------------------------------------------------
    private myapp text_size ;
    // myapp 사용 선언-------------------------------------------------------------------------------
    private String get_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_ssn2);
        text_size = (myapp)getApplication();
        to_txt_ssn = findViewById(R.id.to_txt_ssn);
    }
    public void put_n(View view) {
        String current = to_txt_ssn.getText().toString();

        switch (view.getId()) {
            case R.id.to_btn_0:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '0');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-0");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;

            case R.id.to_btn_1:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '1');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-1");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_2:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '2');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-2");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_3:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '3');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-3");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_4:
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
            case R.id.to_btn_5:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '5');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-5");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_6:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '6');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-6");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_7:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '7');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-7");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_8:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '8');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-8");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_9:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(current + '9');
                to_txt_ssn.setTextSize(30);

                if (to_txt_ssn.length() == 7) {
                    to_txt_ssn.setText(current + "-9");
                }
                if (to_txt_ssn.length() >= 9)
                    to_txt_ssn.setText(current + '*');
                break;
            case R.id.to_btn_del:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setTextSize(30);
                if(to_txt_ssn.length() == 8){
                    to_txt_ssn.setText(current.substring(0, current.length() - 2));
                } else {
                    to_txt_ssn.setText(current.substring(0, current.length() - 1));
                    break;
                }
            case R.id.to_btn_all_delete:
                to_txt_ssn.setTextSize(text_size.getId());
                to_txt_ssn.setText(null);
                to_txt_ssn.setTextSize(30);
                break;
        }
    }

    public void goto_to_issuance(View v) {
        Intent goto_to_issuance = new Intent(this, r_To_Issuance_Info.class);
        if(to_txt_ssn.length() != 14) {
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                Toast.makeText(getApplicationContext(), "주민등록번호의 길이가 맞는지 확인해 주세요.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please verify your social security number", Toast.LENGTH_LONG).show();
            }
        } else {
            get_num = to_txt_ssn.getText().toString();

            char one = get_num.charAt(0);
            char two = get_num.charAt(1);
            char three = get_num.charAt(2);
            char four = get_num.charAt(3);
            char five = get_num.charAt(4);
            char six = get_num.charAt(5);
            char seven = get_num.charAt(7);


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
                startActivity(goto_to_issuance);
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

    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void goto_to_ssn(View v){
        Intent goto_to_ssn = new Intent(getApplicationContext(), r_To_Ssn.class);
        startActivity(goto_to_ssn);
    }
}