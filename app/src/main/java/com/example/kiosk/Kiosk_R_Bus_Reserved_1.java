package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kiosk_R_Bus_Reserved_1 extends AppCompatActivity {
    private Button b_cancel_btn;
    private Button b_payment_btn;
    private TextView textView17, bus_departuretime, bus_type, bus_takentime;
    Handler handler = new Handler();
    private boolean isAnyButtonClicked = false;

    private Button ticket_departure_btn;
    private Button ticket_destination_btn;
    private Button ticket_check_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_reserved_1);

        ticket_departure_btn = findViewById(R.id.ticket_departure_btn);
        ticket_destination_btn = findViewById(R.id.ticket_destination_btn);
        ticket_check_btn = findViewById(R.id.ticket_check_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);
        textView17 = findViewById(R.id.textView17);
        bus_departuretime = findViewById(R.id.bus_departuretime);
        bus_type = findViewById(R.id.bus_type);
        bus_takentime = findViewById(R.id.bus_takentime);


        ticket_departure_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnyButtonClicked) {
                    ticket_departure_btn.setBackgroundColor(Color.CYAN);
                    ticket_destination_btn.setBackgroundColor(Color.CYAN);
                    ticket_check_btn.setBackgroundColor(Color.CYAN);
                    isAnyButtonClicked = true;
                    b_payment_btn.setEnabled(true);
                } else {
                    ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                    isAnyButtonClicked = false;
                    b_payment_btn.setEnabled(false);
                }
            }
        });
        ticket_destination_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnyButtonClicked) {
                    ticket_departure_btn.setBackgroundColor(Color.CYAN);
                    ticket_destination_btn.setBackgroundColor(Color.CYAN);
                    ticket_check_btn.setBackgroundColor(Color.CYAN);
                    isAnyButtonClicked = true;
                    b_payment_btn.setEnabled(true);
                } else {
                    ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                    isAnyButtonClicked = false;
                    b_payment_btn.setEnabled(false);
                }
            }

        });
        ticket_check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnyButtonClicked) {
                    ticket_departure_btn.setBackgroundColor(Color.CYAN);
                    ticket_destination_btn.setBackgroundColor(Color.CYAN);
                    ticket_check_btn.setBackgroundColor(Color.CYAN);
                    isAnyButtonClicked = true;
                    b_payment_btn.setEnabled(true);
                } else {
                    ticket_departure_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_destination_btn.setBackgroundColor(Color.LTGRAY);
                    ticket_check_btn.setBackgroundColor(Color.LTGRAY);
                    isAnyButtonClicked = false;
                    b_payment_btn.setEnabled(false);
                }
            }

        });

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved_1.this, Kiosk_R_Bus_Congratulations.class);
                startActivity(intent);
            }
        });

        b_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved_1.this, Kiosk_R_Bus_Congratulations.class);
                startActivity(intent);
            }
        });

        b_payment_btn.setEnabled(false);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}





