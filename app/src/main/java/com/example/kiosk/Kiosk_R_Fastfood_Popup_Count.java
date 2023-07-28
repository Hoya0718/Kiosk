package com.example.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kiosk_R_Fastfood_Popup_Count extends AppCompatActivity {

    private int value;
    private int plus;
    private String plusName;
    private byte[] plusArray;

    private ImageView plus_img;
    private TextView plus_name_text;
    private TextView plus_money_text;

    private int count;
    private TextView count_text;

    private Bitmap plusBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_count);

        plus_img = findViewById(R.id.plus_img);
        plus_name_text = findViewById(R.id.plus_name_text);
        plus_money_text = findViewById(R.id.plus_money_text);

        count_text = findViewById(R.id.count_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            plus = intent.getIntExtra("plus", 0);
            plusName = intent.getStringExtra("plusName");
            plusArray = intent.getByteArrayExtra("plusImage");

            plus_money_text.setText(String.valueOf(plus));

            if (plusName != null) {
                plus_name_text.setText(plusName);
            }

            if (plusArray != null) {
                plusBitmap = BitmapFactory.decodeByteArray(plusArray, 0, plusArray.length);
                plus_img.setImageBitmap(plusBitmap);
            }
        }

        count = 1;
    }

    public void count_minus(View view) {
        if (count>1) {
            count--;
            count_text.setText(String.valueOf(count));
            plus_money_text.setText(String.valueOf(plus*count));
        }
    }

    public void count_plus(View view) {
        count++;
        count_text.setText(String.valueOf(count));
        plus_money_text.setText(String.valueOf(plus*count));
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_Plus(View view) {
        Intent goto_Kiosk_R_F_Plus = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Plus.class);

        value+=plus * count;

        myapp orderHistory = (myapp) getApplicationContext();
        Order order = new Order(plusName, plus, count, plusBitmap);
        orderHistory.addOrder(order);

        goto_Kiosk_R_F_Plus.putExtra("value", value);
        goto_Kiosk_R_F_Plus.putExtra("plus", plus * count);
        startActivity(goto_Kiosk_R_F_Plus);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}