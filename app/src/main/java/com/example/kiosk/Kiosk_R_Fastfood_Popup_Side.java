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

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Side extends AppCompatActivity {

    private int value;
    private int burger;
    private int side;
    private String burgerName;
    private String burgerSize;
    private String sideName;
    private byte[] burgerArray;

    private TextView burger_text;
    private TextView size_text;

    private TextView snacksan_text;
    private TextView snackshu_text;
    private TextView mcnurget_text;
    private TextView huri_text;
    private TextView hashbra_text;
    private TextView chickentender_text;
    private TextView chezstick_text;
    private TextView cuol_text;
    private TextView churu_text;
    private TextView icesu_text;
    private TextView iceco_text;
    private TextView iceba_text;

    private ImageView snacksan_img;
    private ImageView snackshu_img;
    private ImageView mcnurget_img;
    private ImageView huri_img;
    private ImageView hashbra_img;
    private ImageView chickentender_img;
    private ImageView chezstick_img;
    private ImageView cuol_img;
    private ImageView churu_img;
    private ImageView icesu_img;
    private ImageView iceco_img;
    private ImageView iceba_img;

    private Bitmap sideBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_side);

        burger_text = findViewById(R.id.burger_text);
        size_text = findViewById(R.id.size_text);

        snacksan_text = findViewById(R.id.snacksan_text);
        snackshu_text = findViewById(R.id.snackshu_text);
        mcnurget_text = findViewById(R.id.mcnurget_text);
        huri_text = findViewById(R.id.huri_text);
        hashbra_text = findViewById(R.id.hashbra_text);
        chickentender_text = findViewById(R.id.chickentender_text);
        chezstick_text = findViewById(R.id.chezstick_text);
        cuol_text = findViewById(R.id.cuol_text);
        churu_text = findViewById(R.id.churu_text);
        icesu_text = findViewById(R.id.icesu_text);
        iceco_text = findViewById(R.id.iceco_text);
        iceba_text = findViewById(R.id.iceba_text);

        snacksan_img = findViewById(R.id.snacksan_img);
        snackshu_img = findViewById(R.id.snackshu_img);
        mcnurget_img = findViewById(R.id.mcnurget_img);
        huri_img = findViewById(R.id.huri_img);
        hashbra_img = findViewById(R.id.hashbra_img);
        chickentender_img = findViewById(R.id.chickentender_img);
        chezstick_img = findViewById(R.id.chezstick_img);
        cuol_img = findViewById(R.id.cuol_img);
        churu_img = findViewById(R.id.churu_img);
        icesu_img = findViewById(R.id.icesu_img);
        iceco_img = findViewById(R.id.iceco_img);
        iceba_img = findViewById(R.id.iceba_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");
            burgerSize = intent.getStringExtra("burgerSize");

            if (burgerName != null) {
                burger_text.setText(burgerName);
            }
            if (burgerSize != null) {
                size_text.setText(burgerSize);
            }
        }

        side = 0;
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        goto_Kiosk_R_F_P_D.putExtra("value", value);

        goto_Kiosk_R_F_P_D.putExtra("burger", burger);
        goto_Kiosk_R_F_P_D.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_D.putExtra("burgerImage", burgerArray);
        goto_Kiosk_R_F_P_D.putExtra("burgerSize", burgerSize);

        switch (view.getId()) {

            case R.id.snacksan_lay:
                side+=3000;
                sideName = snacksan_text.getText().toString();
                sideBitmap = ((BitmapDrawable)snacksan_img.getDrawable()).getBitmap();
                break;

            case R.id.snackshu_lay:
                side+=2300;
                sideName = snackshu_text.getText().toString();
                sideBitmap = ((BitmapDrawable)snackshu_img.getDrawable()).getBitmap();
                break;

            case R.id.mcnurget_lay:
                side+=2900;
                sideName = mcnurget_text.getText().toString();
                sideBitmap = ((BitmapDrawable)mcnurget_img.getDrawable()).getBitmap();
                break;

            case R.id.huri_lay:
                side+=2000;
                sideName = huri_text.getText().toString();
                sideBitmap = ((BitmapDrawable)huri_img.getDrawable()).getBitmap();
                break;

            case R.id.hashbra_lay:
                side+=1300;
                sideName = hashbra_text.getText().toString();
                sideBitmap = ((BitmapDrawable)hashbra_img.getDrawable()).getBitmap();
                break;

            case R.id.chickentender_lay:
                side+=1200;
                sideName = chickentender_text.getText().toString();
                sideBitmap = ((BitmapDrawable)chickentender_img.getDrawable()).getBitmap();
                break;

            case R.id.chezstick_lay:
                side+=2500;
                sideName = chezstick_text.getText().toString();
                sideBitmap = ((BitmapDrawable)chezstick_img.getDrawable()).getBitmap();
                break;

            case R.id.cuol_lay:
                side+=1900;
                sideName = cuol_text.getText().toString();
                sideBitmap = ((BitmapDrawable)cuol_img.getDrawable()).getBitmap();
                break;

            case R.id.churu_lay:
                side+=1000;
                sideName = churu_text.getText().toString();
                sideBitmap = ((BitmapDrawable)churu_img.getDrawable()).getBitmap();
                break;

            case R.id.icesu_lay:
                side+=2100;
                sideName = icesu_text.getText().toString();
                sideBitmap = ((BitmapDrawable)icesu_img.getDrawable()).getBitmap();
                break;

            case R.id.iceco_lay:
                side+=2100;
                sideName = iceco_text.getText().toString();
                sideBitmap = ((BitmapDrawable)iceco_img.getDrawable()).getBitmap();
                break;

            case R.id.iceba_lay:
                side+=1600;
                sideName = iceba_text.getText().toString();
                sideBitmap = ((BitmapDrawable)iceba_img.getDrawable()).getBitmap();
                break;

        }

//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        float scale = (float) (1024/(float)sideBitmap.getWidth());
//        int image_w = (int) (sideBitmap.getWidth() * scale);
//        int image_h = (int) (sideBitmap.getHeight() * scale);
//        Bitmap sideResize = Bitmap.createScaledBitmap(sideBitmap, image_w, image_h, true);
//        sideResize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] sideArray = stream.toByteArray();
//        goto_Kiosk_R_F_P_D.putExtra("sideImage", sideArray);

        goto_Kiosk_R_F_P_D.putExtra("side", side);
        goto_Kiosk_R_F_P_D.putExtra("sideName", sideName);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("value", value);

        goto_Kiosk_R_F_P_Sz.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerImage", burgerArray);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerSize", burgerSize);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}