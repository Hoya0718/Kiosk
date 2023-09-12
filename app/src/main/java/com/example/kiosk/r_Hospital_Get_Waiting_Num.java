package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_Hospital_Get_Waiting_Num extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhospital_get_waiting_num);
    }
    public void goto_main(View view){
        Intent goto_main = new Intent(getApplicationContext(), r_Hospital_main.class);
        startActivity(goto_main);
    }
}