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

    private Button button19; //목포 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk17);

        button19 = findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_17.this, Kiosk_18.class);
                intent.putExtra("destination", "목포");
                startActivity(intent);
            }
        });
    }
}

