package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_15 extends AppCompatActivity {

    private Button button15; //도착지 버튼
    private Button button16; //홈 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk15);

        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_15.this, Kiosk_16.class);
                startActivity(intent);
            }

        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_15.this, Kiosk_14.class);
                startActivity(intent);
            }

        });

    }
}