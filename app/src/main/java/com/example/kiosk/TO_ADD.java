package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_ADD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_add);
    }

    public void goto_fee_Exam(View v){
        Intent goto_fee_Exam = new Intent(getApplicationContext(), TO_Is_fee_examption.class);
        startActivity(goto_fee_Exam);
    }
}