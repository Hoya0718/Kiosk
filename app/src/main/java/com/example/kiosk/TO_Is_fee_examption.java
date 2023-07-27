package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_Is_fee_examption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_is_fee_examption);
    }

    public void goto_get_Num(View v){
        Intent goto_get_Num = new Intent(getApplicationContext(), TO_Get_Num.class);
        startActivity(goto_get_Num);
    }
}