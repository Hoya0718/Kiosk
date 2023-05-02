package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Kiosk_14 extends AppCompatActivity {

    private Button button9; //버스 버튼
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/M/d");
    TextView textView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14);

        textView11 = (TextView)findViewById(R.id.textView11);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat format;

        format = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        textView11.setText(format.format(c.getTime()));

        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_14.this, Kiosk_15.class);
                startActivity(intent);
            }

        });

    }
}