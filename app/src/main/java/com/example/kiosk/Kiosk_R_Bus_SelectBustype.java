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

import java.util.Locale;

public class Kiosk_R_Bus_SelectBustype extends AppCompatActivity {

    private TextView textView18;//
    private TextView textView36;
    private TextView textView17;
    private TextView bus_departuretime;
    private TextView bus_type;
    private TextView bus_takentime;
    private TextView lastseat;

    private Button seat_selection1_btn;
    private Button seat_selection2_btn;
    private Button seat_selection3_btn;
    private Button soldout1_btn;
    private Button soldout2_btn;
    private Button soldout3_btn;
    private Button b_cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_selectbustype);

        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView36 = findViewById(R.id.textView36);
        bus_departuretime = findViewById(R.id.bus_departuretime);
        bus_type = findViewById(R.id.bus_type);
        bus_takentime = findViewById(R.id.bus_takentime);
        lastseat = findViewById(R.id.lastseat);

        seat_selection1_btn = findViewById(R.id.seat_selection1_btn);
        seat_selection2_btn = findViewById(R.id.seat_selection2_btn);
        seat_selection3_btn = findViewById(R.id.seat_selection3_btn);
        soldout1_btn = findViewById(R.id.soldout1_btn);
        soldout2_btn = findViewById(R.id.soldout2_btn);
        soldout3_btn = findViewById(R.id.soldout3_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");

        textView18 = findViewById(R.id.textView18);
        if (destination != null) {
            textView18.setText(destination);
        }

        seat_selection1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "우등버스");
                    intent.putExtra("price", "25,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Honor bus");
                    intent.putExtra("price", "25,000won");
                    startActivity(intent);
                }

            }
        });

        seat_selection2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "고속버스");
                    intent.putExtra("price", "20,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Express bus");
                    intent.putExtra("price", "20,000won");
                    startActivity(intent);
                }
            }
        });
        seat_selection3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_VerifyTicket.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "일반버스");
                    intent.putExtra("price", "15,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Regular bus");
                    intent.putExtra("price", "15,000won");
                    startActivity(intent);
                }
            }
        });

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_VerifyTicket.class);
                startActivity(intent);
            }
        });
    }
}




