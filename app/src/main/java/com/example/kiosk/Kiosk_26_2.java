package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kiosk_26_2 extends AppCompatActivity {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk26_2);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
    }
    public void goto_kiosk_27(View v) {

        Intent goto_kiosk_27 = new Intent(this,Kiosk_27.class);
        switch (v.getId()) {
            case R.id.btn_1:
                input = btn_1.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_2:
                input = btn_2.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_3:
                input = btn_3.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_4:
                input = btn_4.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_5:
                input = btn_5.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
            case R.id.btn_6:
                input = btn_6.getText().toString();
                goto_kiosk_27.putExtra("text", input);
                startActivity(goto_kiosk_27);
                break;
        }
    }
}
