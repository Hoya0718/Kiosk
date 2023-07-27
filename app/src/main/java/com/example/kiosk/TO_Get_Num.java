package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TO_Get_Num extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_get_num);
    }

    public void goto_pay_List(View v){
        Intent goto_pay_List = new Intent(getApplicationContext(), TO_Pay_list.class);
        startActivity(goto_pay_List);
    }
}