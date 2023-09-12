package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class r_To_Pay extends AppCompatActivity {
    // TextView, String-----------------------------------------------------------------------------
    private TextView total_money;
    private String value;
    // TextView, String-----------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_pay);
        total_money = findViewById(R.id.total_money);

        // Intent로 값 받기---------------------------------------------------------------------------
        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        total_money.setText(value);
        // Intent로 값 받기---------------------------------------------------------------------------
    }
    public void goto_card_Insert(View v){
        Intent goto_card_Insert = new Intent(getApplicationContext(), r_To_Card_Insert.class);
        startActivity(goto_card_Insert);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void goto_pay_list(View v){
        Intent goto_pay_list = new Intent(getApplicationContext(), r_To_Pay_List.class);
        startActivity(goto_pay_list);
    }
}