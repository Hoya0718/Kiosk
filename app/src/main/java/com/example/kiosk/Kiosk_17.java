package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_17 extends AppCompatActivity {
    private String destination; //목적지
    private String bus;
    private String seat;
    private String price;

    private Button button19; //목포 버튼
    private Button button18; //마산 버튼
    private Button button20; //무안 버튼
    private Button button21; //무안공항 버튼
    private Button button22; //무주 버튼
    private Button button85; //마량 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk17);

        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button18 = findViewById(R.id.button18);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button85 = findViewById(R.id.button85);

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "목포");
                startActivity(intent);
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "무안");
                startActivity(intent);
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "마산");
                startActivity(intent);
            }
        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "무안공항");
                startActivity(intent);
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "무주");
                startActivity(intent);
            }
        });

        button85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "마량");
                startActivity(intent);
            }
        });
    }
}

