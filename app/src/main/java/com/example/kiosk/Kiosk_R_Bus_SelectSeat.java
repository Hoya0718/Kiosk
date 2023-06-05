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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Kiosk_R_Bus_SelectSeat extends AppCompatActivity {
    private TextView textView32;
    private TextView textView34;
    private TextView textView33;
    private Button b_1_btn, b_2_btn, b_3_btn, b_4_btn, b_5_btn;
    private Button b_6_btn, b_7_btn, b_8_btn, b_9_btn, b_10_btn;
    private Button b_11_btn, b_12_btn, b_13_btn, b_14_btn, b_15_btn;
    private Button b_16_btn, b_17_btn, b_18_btn, b_19_btn, b_20_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_selectseat);

        b_1_btn = findViewById(R.id.b_1_btn);
        b_2_btn = findViewById(R.id.b_2_btn);
        b_3_btn = findViewById(R.id.b_3_btn);
        b_4_btn = findViewById(R.id.b_4_btn);
        b_5_btn = findViewById(R.id.b_5_btn);
        b_6_btn = findViewById(R.id.b_6_btn);
        b_7_btn = findViewById(R.id.b_7_btn);
        b_8_btn = findViewById(R.id.b_8_btn);
        b_9_btn = findViewById(R.id.b_9_btn);
        b_10_btn = findViewById(R.id.b_10_btn);
        b_11_btn = findViewById(R.id.b_11_btn);
        b_12_btn = findViewById(R.id.b_12_btn);
        b_13_btn = findViewById(R.id.b_13_btn);
        b_14_btn = findViewById(R.id.b_14_btn);
        b_15_btn = findViewById(R.id.b_15_btn);
        b_16_btn = findViewById(R.id.b_16_btn);
        b_17_btn = findViewById(R.id.b_17_btn);
        b_18_btn = findViewById(R.id.b_18_btn);
        b_19_btn = findViewById(R.id.b_19_btn);
        b_20_btn = findViewById(R.id.b_20_btn);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);


        b_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "3번");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String destination = intent1.getStringExtra("destination");
                    String bus = intent1.getStringExtra("bus");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "3");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });

        b_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "4번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "4");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "5번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "5");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });


        b_6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "6번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "6");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "10번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "10");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_14_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "14번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    String seat = intent1.getStringExtra("seat");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "14");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_15_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "15번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "15");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
        b_16_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectSeat.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "16번");
                    intent.putExtra("price", price);
                    startActivity(intent);
                } else {
                    Intent intent1 = getIntent();
                    String departuretime = intent1.getStringExtra("departuretime");
                    String bus = intent1.getStringExtra("bus");
                    String destination = intent1.getStringExtra("destination");
                    String price = intent1.getStringExtra("price");
                    intent.putExtra("departuretime", departuretime);
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", bus);
                    intent.putExtra("seat", "16");
                    intent.putExtra("price", price);
                    startActivity(intent);
                }
            }
        });
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}



