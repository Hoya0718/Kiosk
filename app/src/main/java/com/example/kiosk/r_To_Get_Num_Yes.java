package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class r_To_Get_Num_Yes extends AppCompatActivity {

    private Button gn_1,gn_2,gn_3,gn_4,gn_5,gn_6,gn_7,gn_8,gn_9;
    private String input, value, fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_get_num_yes);
        gn_1 = findViewById(R.id.gn_1);
        gn_2 = findViewById(R.id.gn_2);
        gn_3 = findViewById(R.id.gn_3);
        gn_4 = findViewById(R.id.gn_4);
        gn_5 = findViewById(R.id.gn_5);
        gn_6 = findViewById(R.id.gn_6);
        gn_7 = findViewById(R.id.gn_7);
        gn_8 = findViewById(R.id.gn_8);
        gn_9 = findViewById(R.id.gn_9);
    }
    public void goto_pay_list(View v){
        Intent goto_pay_list = new Intent(this, r_To_Pay_List.class);
        fee = "0";
        switch (v.getId()) {
            case R.id.gn_1:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_1.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_2:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_2.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_3:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_3.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_4:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_4.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_5:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_5.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_6:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_6.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_7:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                goto_pay_list.putExtra("value", value);
                input = gn_7.getText().toString();
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_8:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                input = gn_8.getText().toString();
                goto_pay_list.putExtra("value", value);
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
            case R.id.gn_9:
                value="0";
                goto_pay_list.putExtra("fee", fee);
                input = gn_9.getText().toString();
                goto_pay_list.putExtra("value", value);
                goto_pay_list.putExtra("text", input);
                goto_pay_list.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
                startActivity(goto_pay_list);
                break;
        }
    }
    public void goto_fee(View v){
        Intent goto_fee = new Intent(getApplicationContext(), r_To_Is_Fee_Examption.class);
        goto_fee.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_fee);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
}