package com.example.kiosk;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
>>>>>>> origin/master

public class Kiosk_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk09);
    }
<<<<<<< HEAD
=======

    public void goto_kiosk_05(View v){
        Intent goto_kiosk_05 = new Intent(getApplicationContext(),Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }

    public void goto_kiosk_07(View v){
        Intent goto_kiosk_07 = new Intent(getApplicationContext(),Kiosk_7.class);
        startActivity(goto_kiosk_07);
    }

    public void goto_kiosk_08(View v){
        Intent goto_kiosk_08 = new Intent(getApplicationContext(),Kiosk_8.class);
        startActivity(goto_kiosk_08);
    }
>>>>>>> origin/master
}