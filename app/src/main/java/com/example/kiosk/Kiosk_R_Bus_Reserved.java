package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Kiosk_R_Bus_Reserved extends AppCompatActivity {

    private TextView bus_infoinput, bus_birthdate, bus_birthdate_input;
    private TextToSpeech tts;
    private myapp sound;

    private CheckBox person_Information;

    private String get_num;
    private Button num_0, num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, modify_btn, confirm_btn;
    private Button b_cancel_btn, b_payment_btn;
    private myapp pn;
    Handler handler = new Handler();
    private myapp text_size;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14_reserved);

        pn = (myapp) getApplication();
        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();

        person_Information = findViewById(R.id.person_Information);
        bus_infoinput = findViewById(R.id.bus_infoinput);
        bus_birthdate = findViewById(R.id.bus_birthdate);
        bus_birthdate_input = findViewById(R.id.bus_birthdate_input);
        num_0 = findViewById(R.id.num0_btn);
        num_1 = findViewById(R.id.num1_btn);
        num_2 = findViewById(R.id.num2_btn);
        num_3 = findViewById(R.id.num3_btn);
        num_4 = findViewById(R.id.num4_btn);
        num_5 = findViewById(R.id.num5_btn);
        num_6 = findViewById(R.id.num6_btn);
        num_7 = findViewById(R.id.num7_btn);
        num_8 = findViewById(R.id.num8_btn);
        num_9 = findViewById(R.id.num9_btn);
        modify_btn = findViewById(R.id.modify_btn);
        confirm_btn = findViewById(R.id.confirm_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);

        bus_infoinput.setTextSize(text_size.getId());
        bus_birthdate.setTextSize(text_size.getId());
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
        modify_btn.setTextSize(text_size.getId());
        confirm_btn.setTextSize(text_size.getId());
        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());
        person_Information.setTextSize(text_size.getId());
        bus_birthdate_input.setTextSize(text_size.getId());

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved.this, Kiosk_R_Bus_Main.class);
                startActivity(intent);
            }
        });

        b_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved.this, Kiosk_R_Bus_Reserved_1.class);
                startActivity(intent);
            }
        });
    }

    public void put_n(View view) {
        String current = bus_birthdate_input.getText().toString();


        switch (view.getId()) {
            case R.id.num0_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '0');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-0");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;

            case R.id.num1_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '1');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-1");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num2_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '2');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-2");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num3_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '3');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-3");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num4_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '4');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-4");
                    ;
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num5_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '5');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-5");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num6_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '6');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-6");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num7_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '7');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-7");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num8_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '8');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-8");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.num9_btn:
                bus_birthdate_input.setTextSize(text_size.getId());
                bus_birthdate_input.setText(current + '9');
                if (bus_birthdate_input.length() == 7) {
                    bus_birthdate_input.setText(current + "-9");
                }
                if (bus_birthdate_input.length() >= 9)
                    bus_birthdate_input.setText(current + '*');
                break;
            case R.id.modify_btn:
                if (bus_birthdate_input.length() == 0) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        Toast.makeText(getApplicationContext(), "주민등록번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Enter your social security number", Toast.LENGTH_LONG).show();
                } else if (bus_birthdate_input.length() == 8) {
                    bus_birthdate_input.setText(current.substring(0, current.length() - 2));
                } else {
                    bus_birthdate_input.setText(current.substring(0, current.length() - 1));
                    break;
                }
        }
    }
}
