package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_16 extends AppCompatActivity {

    private Button button_seoul; // 서울

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16);

        button_seoul = findViewById(R.id.button_seoul);
        button_seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_16.this, Kiosk_16_1.class);
                startActivity(intent);
            }

        });
    }
}