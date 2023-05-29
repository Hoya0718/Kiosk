package com.example.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Reco extends AppCompatActivity {

    private int value;
    private int reco;
    private String recoName;
    private Bitmap recoBitmap;

    private TextView snackshu_text;
    private TextView mcnurget_text;

    private ImageView snackshu_img;
    private ImageView mcnurget_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_reco);

        snackshu_text = findViewById(R.id.snackshu_text);
        mcnurget_text = findViewById(R.id.mcnurget_text);

        snackshu_img = findViewById(R.id.snackshu_img);
        mcnurget_img = findViewById(R.id.mcnurget_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
        }

        reco = 0;
    }

    public void goto_Kiosk_R_F_O_H(View view){
        Intent goto_Kiosk_R_F_O_H = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Order_Hist.class);

        switch (view.getId()) {

            case R.id.snackshu_lay:
                reco+=2300;
                recoName = snackshu_text.getText().toString();
                recoBitmap = ((BitmapDrawable)snackshu_img.getDrawable()).getBitmap();
                break;

            case R.id.mcnurget_lay:
                reco+=2900;
                recoName = mcnurget_text.getText().toString();
                recoBitmap = ((BitmapDrawable)mcnurget_img.getDrawable()).getBitmap();
                break;

        }

        value+=reco;

        myapp orderHistory = (myapp) getApplicationContext();
        Order order = new Order(recoName, reco, 1, recoBitmap);
        orderHistory.addOrder(order);

        goto_Kiosk_R_F_O_H.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_O_H);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}