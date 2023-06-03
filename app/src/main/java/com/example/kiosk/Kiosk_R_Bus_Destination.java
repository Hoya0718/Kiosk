package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_R_Bus_Destination extends AppCompatActivity {
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM dd (E)", Locale.KOREAN);

    private Button destination_btn; //도착지 버튼
    private Button b_homescreen_btn; //홈 버튼
    private TextView textView10;
    private TextView textView102;
    private TextView textView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_destination);

        destination_btn = findViewById(R.id.destination_btn);
        b_homescreen_btn = findViewById(R.id.b_homescreen_btn);
        textView10 = findViewById(R.id.textView10);
        textView15 = findViewById(R.id.textView15);
        textView102 = findViewById(R.id.textView102);

        textView10 = (TextView) findViewById(R.id.textView10);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat format;

        if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
            format = new SimpleDateFormat("yyyy/MM/dd(E)", Locale.KOREAN);
        else
            format = new SimpleDateFormat("yyyy/MMM/dd(E)", Locale.ENGLISH);
        textView10.setText(format.format(c.getTime()));

        destination_btn = findViewById(R.id.destination_btn);
        b_homescreen_btn = findViewById(R.id.b_homescreen_btn);
        destination_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Destination.this, Kiosk_R_Bus_SelectDestination.class);
                startActivity(intent);
            }
        });
        b_homescreen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Destination.this, Kiosk_R_Bus_Main.class);
                startActivity(intent);
            }
        });

    }
}




