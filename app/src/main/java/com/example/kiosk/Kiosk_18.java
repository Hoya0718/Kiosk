package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kiosk_18 extends AppCompatActivity {

    private TextView textView18; // 목적지 텍스트 뷰

    private Button button17; //좌석 선택 버튼
    private Button button41; //좌석 선택 버튼
    private Button button42; //좌석 선택 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk18);

        button17 = findViewById(R.id.button17);
        button41 = findViewById(R.id.button41);
        button42 = findViewById(R.id.button42);

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                intent.putExtra("bus", "우등버스 1");
                startActivity(intent);
            }

        });
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                intent.putExtra("bus", "고속버스 2");
                startActivity(intent);
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_18.this, Kiosk_19.class);
                intent.putExtra("bus", "일반버스 2");
                startActivity(intent);
            }
        });

        textView18 = findViewById(R.id.textView18);
        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");
        if (destination != null && !destination.isEmpty()) {
            textView18.setText(destination);
        }

    }
}




