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

public class Kiosk_R_Fastfood_Popup_Drink extends AppCompatActivity {

    private int value;
    private int burger;
    private int side;
    private int drink;
    private String burgerName;
    private String sideName;
    private String drinkName;
    private byte[] burgerArray;
    private byte[] sideArray;

    private TextView askMission;
    private TextView showMission;
    private TextView burger_text;
    private TextView burger_txt;
    private TextView side_text;
    private TextView chistr_text;
    private TextView chijadu_text;
    private TextView drinkoran_text;
    private TextView shakestr_text;
    private TextView shakecho_text;
    private TextView shakeba_text;
    private TextView drinkcoca_text;
    private TextView drinkcoze_text;
    private TextView drinkspri_text;
    private TextView drinkhwan_text;
    private TextView milk_text;
    private TextView water_text;

    private ImageView chistr_img;
    private ImageView chijadu_img;
    private ImageView drinkoran_img;
    private ImageView shakestr_img;
    private ImageView shakecho_img;
    private ImageView shakeba_img;
    private ImageView drinkcoca_img;
    private ImageView drinkcoze_img;
    private ImageView drinkspri_img;
    private ImageView drinkhwan_img;
    private ImageView milk_img;
    private ImageView water_img;

    private Bitmap drinkBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_drink);

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());
        askMission = findViewById(R.id.askMission);

        if (showMission.getText().toString().equals(" ")) {
            askMission.setText(" ");
        }

        burger_text = findViewById(R.id.burger_text);
        burger_txt = findViewById(R.id.burger_txt);
        side_text = findViewById(R.id.side_text);

        chistr_text = findViewById(R.id.chistr_text);
        chijadu_text = findViewById(R.id.chijadu_text);
        drinkoran_text = findViewById(R.id.drinkoran_text);
        shakestr_text = findViewById(R.id.shakestr_text);
        shakecho_text = findViewById(R.id.shakecho_text);
        shakeba_text = findViewById(R.id.shakeba_text);
        drinkcoca_text = findViewById(R.id.drinkcoca_text);
        drinkcoze_text = findViewById(R.id.drinkcoze_text);
        drinkspri_text = findViewById(R.id.drinkspri_text);
        drinkhwan_text = findViewById(R.id.drinkhwan_text);
        milk_text = findViewById(R.id.milk_text);
        water_text = findViewById(R.id.water_text);

        chistr_img = findViewById(R.id.chistr_img);
        chijadu_img = findViewById(R.id.chijadu_img);
        drinkoran_img = findViewById(R.id.drinkoran_img);
        shakestr_img = findViewById(R.id.shakestr_img);
        shakecho_img = findViewById(R.id.shakecho_img);
        shakeba_img = findViewById(R.id.shakeba_img);
        drinkcoca_img = findViewById(R.id.drinkcoca_img);
        drinkcoze_img = findViewById(R.id.drinkcoze_img);
        drinkspri_img = findViewById(R.id.drinkspri_img);
        drinkhwan_img = findViewById(R.id.drinkhwan_img);
        milk_img = findViewById(R.id.milk_img);
        water_img = findViewById(R.id.water_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");
            burger = intent.getIntExtra("burger", 0);

            side = intent.getIntExtra("side", 0);
            sideName = intent.getStringExtra("sideName");
            sideArray = intent.getByteArrayExtra("sideImage");

            if (burgerName != null) {
                burger_text.setText(burgerName);
                burger_txt.setText(burgerName);
            }
            if (sideName != null) {
                side_text.setText(sideName);
            }
        }

        drink = 0;
    }

    public void goto_Kiosk_R_F_P_T(View view) {
        Intent goto_Kiosk_R_F_P_T = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Total.class);
        goto_Kiosk_R_F_P_T.putExtra("value", value);

        goto_Kiosk_R_F_P_T.putExtra("burger", burger);
        goto_Kiosk_R_F_P_T.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_T.putExtra("burgerImage", burgerArray);

        goto_Kiosk_R_F_P_T.putExtra("side", side);
        goto_Kiosk_R_F_P_T.putExtra("sideName", sideName);
        goto_Kiosk_R_F_P_T.putExtra("sideImage", sideArray);

        switch (view.getId()) {

            case R.id.chistr_lay:
                drink+=2000;
                drinkName = chistr_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)chistr_img.getDrawable()).getBitmap();
                break;

            case R.id.chijadu_lay:
                drink+=2000;
                drinkName = chijadu_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)chijadu_img.getDrawable()).getBitmap();
                break;

            case R.id.drinkoran_lay:
                drink+=1600;
                drinkName = drinkoran_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)drinkoran_img.getDrawable()).getBitmap();
                break;

            case R.id.shakestr_lay:
                drink+=2800;
                drinkName = shakestr_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)shakestr_img.getDrawable()).getBitmap();
                break;

            case R.id.shakecho_lay:
                drink+=2800;
                drinkName = shakecho_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)shakecho_img.getDrawable()).getBitmap();
                break;

            case R.id.shakeba_lay:
                drink+=2800;
                drinkName = shakeba_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)shakeba_img.getDrawable()).getBitmap();
                break;

            case R.id.drinkcoca_lay:
                drink+=1700;
                drinkName = drinkcoca_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)drinkcoca_img.getDrawable()).getBitmap();
                break;

            case R.id.drinkcoze_lay:
                drink+=1700;
                drinkName = drinkcoze_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)drinkcoze_img.getDrawable()).getBitmap();
                break;

            case R.id.drinkspri_lay:
                drink+=1700;
                drinkName = drinkspri_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)drinkspri_img.getDrawable()).getBitmap();
                break;

            case R.id.drinkhwan_lay:
                drink+=1700;
                drinkName = drinkhwan_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)drinkhwan_img.getDrawable()).getBitmap();
                break;

            case R.id.milk_lay:
                drink+=1600;
                drinkName = milk_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)milk_img.getDrawable()).getBitmap();
                break;

            case R.id.water_lay:
                drink+=1300;
                drinkName = water_text.getText().toString();
                drinkBitmap = ((BitmapDrawable)water_img.getDrawable()).getBitmap();
                break;

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        float scale = (float) (1024/(float)drinkBitmap.getWidth());
        int image_w = (int) (drinkBitmap.getWidth() * scale);
        int image_h = (int) (drinkBitmap.getHeight() * scale);
        Bitmap drinkResize = Bitmap.createScaledBitmap(drinkBitmap, image_w, image_h, true);
        drinkResize.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] drinkArray = stream.toByteArray();
        goto_Kiosk_R_F_P_T.putExtra("drinkImage", drinkArray);

        goto_Kiosk_R_F_P_T.putExtra("drink", drink);
        goto_Kiosk_R_F_P_T.putExtra("drinkName", drinkName);
        startActivity(goto_Kiosk_R_F_P_T);
    }

    public void goto_Kiosk_R_F_P_Sd(View view) {
        Intent goto_Kiosk_R_F_P_Sd = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Side.class);
        goto_Kiosk_R_F_P_Sd.putExtra("value", value);

        goto_Kiosk_R_F_P_Sd.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sd.putExtra("burgerImage", burgerArray);

        goto_Kiosk_R_F_P_Sd.putExtra("side", side);
        goto_Kiosk_R_F_P_Sd.putExtra("sideName", sideName);
        goto_Kiosk_R_F_P_Sd.putExtra("sideImage", sideArray);
        startActivity(goto_Kiosk_R_F_P_Sd);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}