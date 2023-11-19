package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_R_Fastfood_Pay_Table extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_pay_table);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
        }
    }

    public void goto_Kiosk_F_R_O_H(View v){
        Intent goto_Kiosk_R_F_O_H = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Order_Hist.class);
        goto_Kiosk_R_F_O_H.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_O_H);
    }

    public void goto_Kiosk_R_F_P_M(View v){
        Intent goto_Kiosk_R_F_P_M = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Pay_Meth.class);
        goto_Kiosk_R_F_P_M.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_P_M);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }

    public void n_sup(View v){
        Toast.makeText(getApplicationContext(), "지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}