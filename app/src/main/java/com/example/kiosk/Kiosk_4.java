package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_4 extends AppCompatActivity {

    private myapp text_size;
    private Button vsd;
    private Button vsm;
    private Button vsu;
    private Button pre;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk04);
        text_size =(myapp)getApplication();
        vsd=findViewById(R.id.volume_size_down);
        vsm=findViewById(R.id.volume_size_medium);
        vsu=findViewById(R.id.volume_size_up);
        pre = findViewById(R.id.pre_Btn);
        next = findViewById(R.id.save_Btn);

        vsd.setTextSize(text_size.getId());
        vsm.setTextSize(text_size.getId());
        vsu.setTextSize(text_size.getId());
        pre.setTextSize(text_size.getId());
        next.setTextSize(text_size.getId());
    }

    public void goto_kiosk_03(View v){
        Intent goto_kiosk_03 = new Intent(getApplicationContext(), Kiosk_3.class);
        startActivity(goto_kiosk_03);
    }

    public void goto_kiosk_05(View v) {
        Intent goto_kiosk_05 = new Intent(getApplicationContext(), Kiosk_5.class);
        startActivity(goto_kiosk_05);
    }
}