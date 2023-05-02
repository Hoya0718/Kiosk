package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_23 extends AppCompatActivity {

    private Button button67; //처음으로 돌아가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk23);

        button67 = findViewById(R.id.button67);
        button67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_23.this, Kiosk_13.class);
                startActivity(intent);
            }

        });

    }
}