package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Kiosk_R_Bus_SelectSeat extends AppCompatActivity {
    private TextView textView32, textView33, textView34;
    private Button b_soldout1_btn, b_soldout2_btn, b_soldout3_btn;
    private Button b_soldout4_btn, b_soldout5_btn, b_soldout6_btn;
    private Button b_soldout7_btn, b_soldout8_btn, b_soldout9_btn;
    private Button b_soldout10_btn, b_soldout11_btn, b_soldout12_btn;

    private Button b_4A_btn, b_4B_btn, b_3B_btn, b_2B_btn;
    private Button b_5C_btn, b_5D_btn, b_2C_btn, b_2D_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_selectseat);

        b_soldout1_btn = findViewById(R.id.b_soldout1_btn);
        b_soldout2_btn = findViewById(R.id.b_soldout2_btn);
        b_soldout3_btn = findViewById(R.id.b_soldout3_btn);
        b_soldout4_btn = findViewById(R.id.b_soldout4_btn);
        b_soldout5_btn = findViewById(R.id.b_soldout5_btn);
        b_soldout6_btn = findViewById(R.id.b_soldout6_btn);
        b_soldout7_btn = findViewById(R.id.b_soldout7_btn);
        b_soldout8_btn = findViewById(R.id.b_soldout8_btn);
        b_soldout9_btn = findViewById(R.id.b_soldout9_btn);
        b_soldout10_btn = findViewById(R.id.b_soldout10_btn);
        b_soldout11_btn = findViewById(R.id.b_soldout11_btn);
        b_soldout12_btn = findViewById(R.id.b_soldout12_btn);
        b_4A_btn = findViewById(R.id.b_4A_btn);
        b_4B_btn = findViewById(R.id.b_4B_btn);
        b_2B_btn = findViewById(R.id.b_2B_btn);
        b_3B_btn = findViewById(R.id.b_3B_btn);
        b_5C_btn = findViewById(R.id.b_5C_btn);
        b_5D_btn = findViewById(R.id.b_5D_btn);
        b_2C_btn = findViewById(R.id.b_2C_btn);
        b_2D_btn = findViewById(R.id.b_2D_btn);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);


        b_3B_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 3B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else{
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 3B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });

        b_4B_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 4B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 4B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                                startActivity(intent);
                }
            }
        });
        b_4A_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 4A");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 4A");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });


        b_2B_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 2B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 2B");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_5D_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 5D");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 5D");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_5C_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 5C");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 5C");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_2C_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 2C");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 2C");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_2D_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "좌석 번호 : 2D");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
                else {
                    Intent intent1 = getIntent();
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "Seat : 2D");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
    }
}

