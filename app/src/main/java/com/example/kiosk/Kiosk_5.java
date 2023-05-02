package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_5 extends AppCompatActivity {

    private myapp text_size;
    private Button fastfood;
    private Button bus;
    private Button hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk05);
        text_size =(myapp)getApplication();
        fastfood = findViewById(R.id.fastfood_btn);
        bus = findViewById(R.id.bus_btn);
        hospital = findViewById(R.id.hospital_btn);

        fastfood.setTextSize(text_size.getId());
        bus.setTextSize(text_size.getId());
        hospital.setTextSize(text_size.getId());
    }
    public void goto_kiosk_06(View v) {
        Intent goto_kiosk_06 = new Intent(getApplicationContext(), Kiosk_6.class);
        startActivity(goto_kiosk_06);
    }

    public void goto_kiosk_14(View v){
        Intent goto_kiosk_14 = new Intent(getApplicationContext(),Kiosk_14.class);
        startActivity(goto_kiosk_14);
    }

    public void goto_kiosk_25(View v){
        Intent goto_kiosk_25 = new Intent(getApplicationContext(),Kiosk_25.class);
        startActivity(goto_kiosk_25);
    }
}