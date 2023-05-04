package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Kiosk_16_1 extends AppCompatActivity {
    private String destination; //목적지
    private String bus;
    private String seat;
    private String price;

    private Button button23; //ㅁ 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16_1);

        button23 = findViewById(R.id.button23);

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_16_1.this, Kiosk_17.class);
                startActivity(intent);
            }
        });
    }
}


