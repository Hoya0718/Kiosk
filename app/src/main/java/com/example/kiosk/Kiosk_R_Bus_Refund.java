package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_R_Bus_Refund extends AppCompatActivity {

    private Button b_cancel_btn, b_payment_btn;

    private TextView textView2, textView19, textView43;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_refund);

        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);
        textView2 = findViewById(R.id.textView2);
        textView19 = findViewById(R.id.textView19);
        textView43 = findViewById(R.id.textView43);

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Refund.this, Kiosk_R_Bus_Congratulations.class);
                startActivity(intent);
            }

        });

        b_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Refund.this, Kiosk_R_Bus_Congratulations.class);
                startActivity(intent);
            }
        });
    }
}



