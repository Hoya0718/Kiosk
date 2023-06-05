package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.widget.Toast;


public class Kiosk_R_Bus_Main extends AppCompatActivity {

    private Button buy_ticket_btn;
    private Button reserved_ticket_btn;
    private Button refund_ticket_btn;
    private Button b_cancel_btn;
    private TextView textView11;



    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MMM/d/E요일", Locale.KOREAN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_main);
        

        buy_ticket_btn = findViewById(R.id.buy_ticket_btn);
        reserved_ticket_btn = findViewById(R.id.reserved_ticket_btn);
        refund_ticket_btn = findViewById(R.id.refund_ticket_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        textView11 = findViewById(R.id.textView11);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat format;

        if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
            format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm", Locale.KOREAN);
        else
            format = new SimpleDateFormat("yyyy/MMM/dd(E) \n HH:mm", Locale.ENGLISH);


        textView11.setText(format.format(c.getTime()));


        buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Main.this, Kiosk_R_Bus_Destination.class);
                startActivity(intent);
            }

        });
        reserved_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Main.this, Kiosk_R_Bus_Reserved.class);
                startActivity(intent);
            }
        });

        refund_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Main.this, Kiosk_R_Bus_Refund.class);
                startActivity(intent);
            }
        });

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Main.this, Kiosk_R_Part.class);

                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}
