package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

public class Kiosk_R_Fastfood_Order_Hist extends AppCompatActivity {

    private int value;

    private TextView value_text;

    private ImageView menu_img;
    private TextView menu_name_text;
    private TextView menu_count_text;
    private TextView menu_price_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_order_hist);

        myapp orderHistory = (myapp) getApplicationContext();
        List<Order> orderList = orderHistory.getOrderList();

        menu_img = findViewById(R.id.menu_img);
        menu_name_text = findViewById(R.id.menu_name_text);
        menu_count_text = findViewById(R.id.menu_count_text);
        menu_price_text = findViewById(R.id.menu_price_text);

        menu_img.setImageBitmap(orderList.get(0).getOrderBitmap());
        menu_name_text.setText(orderList.get(0).getOrderName());
        menu_count_text.setText(String.valueOf(orderList.get(0).getOrderCount()));
        menu_price_text.setText(String.valueOf(orderList.get(0).getOrderPrice()));

        value_text = findViewById(R.id.value_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
            value_text.setText(String.valueOf(value));
        }
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);

        myapp orderHistory = (myapp) getApplicationContext();
        orderHistory.clearOrderList();

        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_P_M(View v){
        Intent goto_Kiosk_R_F_P_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Pay_Meth.class);
        goto_Kiosk_R_F_P_M.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_P_M);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}