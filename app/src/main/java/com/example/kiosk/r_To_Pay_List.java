package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class r_To_Pay_List extends AppCompatActivity {
    // TextView,Button 사용 선언----------------------------------------------------------------------------
    private TextView paper_num, to_total_money, to_money;
    private Button to_btn_card, to_btn_credit;
    // TextView, Button 사용 선언----------------------------------------------------------------------------
    private String text,value, fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_pay_list);
        paper_num = findViewById(R.id.paper_num);
        to_btn_card = findViewById(R.id.to_btn_card);
        to_btn_credit = findViewById(R.id.to_btn_coin);
        to_total_money = findViewById(R.id.to_total_money);
        to_money = findViewById(R.id.to_money);

        // 인텐트로 값 가져오기------------------------------------------------------------------------
        Intent intent = getIntent();

        value = intent.getStringExtra("value");
        text = intent.getStringExtra("text");
        fee = intent.getStringExtra("fee");
        paper_num.setText(text);
        to_total_money.setText(value);
        to_money.setText(fee);
    }

    public void goto_pay(View v){
        Intent goto_pay = new Intent(getApplicationContext(), r_To_Pay.class);
        goto_pay.putExtra("value", value);
        goto_pay.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_pay);
    }
    public void goto_get_num(View v) {
        finish();
        //Intent goto_get_num = new Intent(getApplicationContext(), TO_Get_Num.class);
        //startActivity(goto_get_num);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void bill(View v){
        Toast.makeText(getApplicationContext(),"지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}