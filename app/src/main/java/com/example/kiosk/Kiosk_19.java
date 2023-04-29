package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_19 extends AppCompatActivity {

    private Button button49; //버스 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk19);

        button49 = findViewById(R.id.button49);
        button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                startActivity(intent);
            }

        });

    }
}