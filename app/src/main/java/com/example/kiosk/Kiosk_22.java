package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Kiosk_22 extends AppCompatActivity {

    private Button button66; // 취소하기
    private ImageView imageView3; //이미지 터치시 다음 화면 전환

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk22);

        button66 = findViewById(R.id.button66);
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_22.this, Kiosk_14.class);
                startActivity(intent);
            }

        });

        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_22.this, Kiosk_23.class);
                startActivity(intent);
            }
        });

    }
}