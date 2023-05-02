package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_25 extends AppCompatActivity {
    private myapp text_size;
    private Button receipt;
    private Button acceptance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk25);
        text_size =(myapp)getApplication();
        receipt = findViewById(R.id.receipt_btn);
        acceptance = findViewById(R.id.acceptance_btn);

        receipt.setTextSize(text_size.getId());
        acceptance.setTextSize(text_size.getId());
    }
    public void goto_kiosk_26(View v){
        Intent goto_kiosk_26 = new Intent(getApplicationContext(),Kiosk_26.class);
        startActivity(goto_kiosk_26);
    }
}