package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class r_To_Get_Num extends AppCompatActivity {
    // Button, String-----------------------------------------------------------------------------
    private Button gnn_1, gnn_2, gnn_3, gnn_4, gnn_5, gnn_6, gnn_7, gnn_8, gnn_9;
    private String input, value, fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_get_num);

        gnn_1 = findViewById(R.id.gnn_1);
        gnn_2 = findViewById(R.id.gnn_2);
        gnn_3 = findViewById(R.id.gnn_3);
        gnn_4 = findViewById(R.id.gnn_4);
        gnn_5 = findViewById(R.id.gnn_5);
        gnn_6 = findViewById(R.id.gnn_6);
        gnn_7 = findViewById(R.id.gnn_7);
        gnn_8 = findViewById(R.id.gnn_8);
        gnn_9 = findViewById(R.id.gnn_9);
    }

    public void goto_pay_List(View v) {
        Intent goto_pay_List = new Intent(this, r_To_Pay_List.class);
        fee="200";
        switch (v.getId()) {
            case R.id.gnn_1:
                value = "200";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_1.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_2:
                value = "400";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_2.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_3:
                value = "600";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_3.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_4:
                value = "800";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_4.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_5:
                value = "1000";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_5.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_6:
                value = "1200";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_6.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_7:
                value = "1400";
                goto_pay_List.putExtra("fee", fee);
                goto_pay_List.putExtra("value", value);
                input = gnn_7.getText().toString();
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_8:
                value = "1600";
                goto_pay_List.putExtra("fee", fee);
                input = gnn_8.getText().toString();
                goto_pay_List.putExtra("value", value);
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
            case R.id.gnn_9:
                value = "1800";
                goto_pay_List.putExtra("fee", fee);
                input = gnn_9.getText().toString();
                goto_pay_List.putExtra("value", value);
                goto_pay_List.putExtra("text", input);
                startActivity(goto_pay_List);
                break;
        }
    }

    public void goto_fee(View v){
        Intent goto_fee = new Intent(getApplicationContext(), r_To_Is_Fee_Examption.class);
        startActivity(goto_fee);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
}