package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kiosk_21 extends AppCompatActivity {
    private String destination = "목적지"; //목적지

    private TextView textView37; //목적지
    private TextView textView38; //버스종류, 좌석
    private Button button64; //취소하기
    private Button button65; //결제하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk21);

        button64 = findViewById(R.id.button64);
        button65 = findViewById(R.id.button65);


        button64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_21.this, Kiosk_14.class);
                startActivity(intent);
            }
        });

        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Kiosk_21.this, Kiosk_22.class);
                startActivity(intent);
            }
        });

        textView37 = findViewById(R.id.textView37);
        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");
        if(destination != null && !destination.isEmpty()) {
            textView37.setText(destination);
        }

        textView38 = findViewById(R.id.textView38);
        Intent intent1 = getIntent();
        String bus = intent1.getStringExtra("bus");
        Intent intent2 = getIntent();
        String seat = intent2.getStringExtra("seat");
        String busAndSeat = bus + "  /  " + seat;
        if (seat != null) {
            textView38.setText(busAndSeat);
        }
    }
}