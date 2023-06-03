package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_R_Bus_VerifyTicket extends AppCompatActivity {
    private SimpleDateFormat mFormat = new SimpleDateFormat(" YY MM dd (E)", Locale.KOREAN);
    private String departuretime = "출발 시간";
    private String destination = "목적지";
    private String price = "표 가격";
    private String seat = "좌석 번호";

    private TextView textView3, textView5, textView6, textView9, textView12, textView14, textView16, textView20, textView21, textView22;

    private Button b_cancel_btn; //취소하기
    private Button b_payment_btn; //결제하기


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_verifyticket);

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView9 = findViewById(R.id.textView9);
        textView12 = findViewById(R.id.textView12);
        textView14 = findViewById(R.id.textView14);
        textView16 = findViewById(R.id.textView16);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);


        Intent intent = getIntent();
        String departuretime = intent.getStringExtra("departuretime");
        String destination = intent.getStringExtra("destination");
        String bus = intent.getStringExtra("bus");
        String seat = intent.getStringExtra("seat");
        String price = intent.getStringExtra("price");

        textView3.setText(departuretime);
        textView5.setText(destination);
        textView16.setText(bus);
        textView20.setText(seat);
        textView21.setText(price);


        Calendar c = Calendar.getInstance();

        SimpleDateFormat format;

        if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
            format = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm", Locale.KOREAN);
        else
            format = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm", Locale.ENGLISH);

        textView22.setText(format.format(c.getTime()));


        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_VerifyTicket.this, Kiosk_R_Bus_Main.class);
                startActivity(intent);
            }
        });

        b_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_VerifyTicket.this, Kiosk_R_Bus_Congratulations.class);
                startActivity(intent);
            }
        });

    }
}




