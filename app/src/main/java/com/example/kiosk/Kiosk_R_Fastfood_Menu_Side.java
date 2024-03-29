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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class Kiosk_R_Fastfood_Menu_Side extends AppCompatActivity {

    private int value;
    private int side;
    private String sideName;

    private TextView money_text;
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
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_side);

        money_text = findViewById(R.id.money_text);

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
            money_text.setText(String.valueOf(value));
        }

        side = 0;
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);

        myapp orderHistory = (myapp) getApplicationContext();
        orderHistory.clearOrderList();

        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_B(View v){
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_M_D(View v){
        Intent goto_Kiosk_R_F_M_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Drink.class);
        goto_Kiosk_R_F_M_D.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_D);
    }

    public void goto_Kiosk_R_F_P_C(View view){
        Intent goto_Kiosk_R_F_P_C = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Count.class);
        goto_Kiosk_R_F_P_C.putExtra("value", value);

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

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        float scale = (float) (1024/(float)sideBitmap.getWidth());
        int image_w = (int) (sideBitmap.getWidth() * scale);
        int image_h = (int) (sideBitmap.getHeight() * scale);
        Bitmap sideResize = Bitmap.createScaledBitmap(sideBitmap, image_w, image_h, true);
        sideResize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] sideArray = stream.toByteArray();
        goto_Kiosk_R_F_P_C.putExtra("plusImage", sideArray);

        goto_Kiosk_R_F_P_C.putExtra("plus", side);
        goto_Kiosk_R_F_P_C.putExtra("plusName", sideName);
        startActivity(goto_Kiosk_R_F_P_C);
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        if (value != 0) {
            Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
            goto_Kiosk_R_F_P_R.putExtra("value", value);
            startActivity(goto_Kiosk_R_F_P_R);
        }
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }

    public void n_sup(View v){
        Toast.makeText(getApplicationContext(), "지원하지 않는 기능입니다.", Toast.LENGTH_LONG).show();
    }
}