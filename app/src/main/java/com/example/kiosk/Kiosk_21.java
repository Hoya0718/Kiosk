package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_21 extends AppCompatActivity {

    private Button button64;
    private Button button65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk21);

        button64 = findViewById(R.id.button64);
        button65 = findViewById(R.id.button65);
        button64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_21.this, Kiosk_16.class);
                startActivity(intent);
            }

        });
        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_21.this, Kiosk_22.class);
                startActivity(intent);
            }
        });

    }
}