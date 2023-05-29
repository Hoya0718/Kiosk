package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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


public class Kiosk_R_Bus_Reserved_1 extends AppCompatActivity {
    private int currentVolume;//
    private AudioManager audioManager;
    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    private Button b_cancel_btn;
    private Button b_payment_btn;
    private Button ticket_btn;
    private TextView textView17, bus_departuretime, bus_type, bus_takentime;
    Handler handler = new Handler();
    private boolean isColorChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk14_reserved_1);

        sound = (myapp) getApplication();
        text_size = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        ticket_btn = findViewById(R.id.ticket_btn);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);
        b_payment_btn = findViewById(R.id.b_payment_btn);
        textView17 = findViewById(R.id.textView17);
        bus_departuretime = findViewById(R.id.bus_departuretime);
        bus_type = findViewById(R.id.bus_type);
        bus_takentime = findViewById(R.id.bus_takentime);

        ticket_btn.setTextSize(text_size.getId());
        b_cancel_btn.setTextSize(text_size.getId());
        b_payment_btn.setTextSize(text_size.getId());
        textView17.setTextSize(text_size.getId());
        bus_departuretime.setTextSize(text_size.getId());
        bus_type.setTextSize(text_size.getId());
        bus_takentime.setTextSize(text_size.getId());

        ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isColorChanged) {
                    ticket_btn.setBackgroundColor(Color.LTGRAY);
                    isColorChanged = false;
                }
                else {
                    ticket_btn.setBackgroundColor(Color.RED);
                    isColorChanged = true;
                }
            }

        });

        b_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved_1.this, Kiosk_R_Bus_Reserved.class);
                tts.shutdown();
                startActivity(intent);
            }
        });

        b_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_Reserved_1.this, Kiosk_R_Bus_Congratulations.class);
                tts.shutdown();
                startActivity(intent);
            }
        });
    }
}

