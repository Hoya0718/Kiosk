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

import java.util.Locale;

public class Kiosk_R_Bus_SelectBustype extends AppCompatActivity {

    private TextView textView18;//
    private TextView textView36;
    private TextView textView17;
    private TextView bus_departuretime;
    private TextView bus_type;
    private TextView bus_takentime;
    private TextView lastseat;

    private Button seat_selection1_1_btn, seat_selection1_2_btn, seat_selection1_3_btn, seat_selection1_4_btn;
    private Button seat_selection2_1_btn, seat_selection2_2_btn, seat_selection2_3_btn, seat_selection2_4_btn;
    private Button seat_selection3_1_btn, seat_selection3_2_btn, seat_selection3_3_btn, seat_selection3_4_btn;
    private Button seat_selection4_1_btn, seat_selection4_2_btn, seat_selection4_3_btn, seat_selection4_4_btn;
    private Button seat_selection5_1_btn, seat_selection5_2_btn, seat_selection5_3_btn, seat_selection5_4_btn;
    private Button seat_selection6_1_btn, seat_selection6_2_btn, seat_selection6_3_btn, seat_selection6_4_btn;

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

        seat_selection1_1_btn = findViewById(R.id.seat_selection1_1_btn);
        seat_selection1_2_btn = findViewById(R.id.seat_selection1_2_btn);
        seat_selection1_3_btn = findViewById(R.id.seat_selection1_3_btn);
        seat_selection1_4_btn = findViewById(R.id.seat_selection1_4_btn);
        seat_selection2_1_btn = findViewById(R.id.seat_selection2_1_btn);
        seat_selection2_2_btn = findViewById(R.id.seat_selection2_2_btn);
        seat_selection2_3_btn = findViewById(R.id.seat_selection2_3_btn);
        seat_selection2_4_btn = findViewById(R.id.seat_selection2_4_btn);
        seat_selection3_1_btn = findViewById(R.id.seat_selection3_1_btn);
        seat_selection3_2_btn = findViewById(R.id.seat_selection3_2_btn);
        seat_selection3_3_btn = findViewById(R.id.seat_selection3_3_btn);
        seat_selection3_4_btn = findViewById(R.id.seat_selection3_4_btn);
        seat_selection4_1_btn = findViewById(R.id.seat_selection4_1_btn);
        seat_selection4_2_btn = findViewById(R.id.seat_selection4_2_btn);
        seat_selection4_3_btn = findViewById(R.id.seat_selection4_3_btn);
        seat_selection4_4_btn = findViewById(R.id.seat_selection4_4_btn);
        seat_selection5_1_btn = findViewById(R.id.seat_selection5_1_btn);
        seat_selection5_2_btn = findViewById(R.id.seat_selection5_2_btn);
        seat_selection5_3_btn = findViewById(R.id.seat_selection5_3_btn);
        seat_selection5_4_btn = findViewById(R.id.seat_selection5_4_btn);
        seat_selection6_1_btn = findViewById(R.id.seat_selection6_1_btn);
        seat_selection6_2_btn = findViewById(R.id.seat_selection6_2_btn);
        seat_selection6_3_btn = findViewById(R.id.seat_selection6_3_btn);
        seat_selection6_4_btn = findViewById(R.id.seat_selection6_4_btn);

        b_cancel_btn = findViewById(R.id.b_cancel_btn);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");

        //목적지 표시
        textView18 = findViewById(R.id.textView18);
        if (destination != null) {
            textView18.setText(destination);
        }

        seat_selection1_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "8시 30분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "우등버스");
                    intent.putExtra("price", "25,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "8 : 30");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Honor bus");
                    intent.putExtra("price", "25,000won");
                    startActivity(intent);
                }

            }
        });

        seat_selection1_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "8시 30분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "우등버스");
                    intent.putExtra("price", "25,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "8 : 30");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Honor bus");
                    intent.putExtra("price", "25,000won");
                    startActivity(intent);
                }

            }
        });

        seat_selection1_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "8시 30분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "우등버스");
                    intent.putExtra("price", "25,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "8 : 30");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Honor bus");
                    intent.putExtra("price", "25,000won");
                    startActivity(intent);
                }

            }
        });

        seat_selection1_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "8시 30분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "우등버스");
                    intent.putExtra("price", "25,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "8 : 30");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Honor bus");
                    intent.putExtra("price", "25,000won");
                    startActivity(intent);
                }

            }
        });

        seat_selection5_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "9시 40분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "고속버스");
                    intent.putExtra("price", "20,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "09 : 40");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Express bus");
                    intent.putExtra("price", "20,000won");
                    startActivity(intent);
                }
            }
        });

        seat_selection5_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "9시 40분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "고속버스");
                    intent.putExtra("price", "20,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "09 : 40");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Express bus");
                    intent.putExtra("price", "20,000won");
                    startActivity(intent);
                }
            }
        });
        seat_selection5_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "9시 40분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "고속버스");
                    intent.putExtra("price", "20,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "09 : 40");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Express bus");
                    intent.putExtra("price", "20,000won");
                    startActivity(intent);
                }
            }
        });
        seat_selection5_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "9시 40분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "고속버스");
                    intent.putExtra("price", "20,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "09 : 40");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "Express bus");
                    intent.putExtra("price", "20,000won");
                    startActivity(intent);
                }
            }
        });

        seat_selection6_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "10시 00분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "일반버스");
                    intent.putExtra("price", "15,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "10 : 00");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "regular bus");
                    intent.putExtra("price", "15,000won");
                    startActivity(intent);
                }
            }
        });

        seat_selection6_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "10시 00분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "일반버스");
                    intent.putExtra("price", "15,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "10 : 00");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "regular bus");
                    intent.putExtra("price", "15,000won");
                    startActivity(intent);
                }
            }
        });

        seat_selection6_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "10시 00분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "일반버스");
                    intent.putExtra("price", "15,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "10 : 00");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "regular bus");
                    intent.putExtra("price", "15,000won");
                    startActivity(intent);
                }
            }
        });

        seat_selection6_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                    intent.putExtra("departuretime", "10시 00분");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "일반버스");
                    intent.putExtra("price", "15,000원");
                    startActivity(intent);
                } else {
                    intent.putExtra("departuretime", "10 : 00");
                    intent.putExtra("destination", destination);
                    intent.putExtra("bus", "regular bus");
                    intent.putExtra("price", "15,000won");
                    startActivity(intent);
                }
            }
        });

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectBustype.this, Kiosk_R_Bus_SelectSeat.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}






