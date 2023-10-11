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
    private String sideName;
    private byte[] burgerArray;

    private TextView askMission;
    private TextView showMission;
    private TextView burger_text;
    private TextView burger_txt;
    private TextView huri_text;
    private TextView chezstick_text;
    private TextView cuol_text;

    private ImageView huri_img;
    private ImageView chezstick_img;
    private ImageView cuol_img;

    private Bitmap sideBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_side);

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());
        askMission = findViewById(R.id.askMission);

        if (showMission.getText().toString().equals(" ")) {
            askMission.setText(" ");
        }

        burger_text = findViewById(R.id.burger_text);
        burger_txt = findViewById(R.id.burger_txt);

        huri_text = findViewById(R.id.huri_text);
        chezstick_text = findViewById(R.id.chezstick_text);
        cuol_text = findViewById(R.id.cuol_text);

        huri_img = findViewById(R.id.huri_img);
        chezstick_img = findViewById(R.id.chezstick_img);
        cuol_img = findViewById(R.id.cuol_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");

            if (burgerName != null) {
                burger_text.setText(burgerName);
                burger_txt.setText(burgerName);
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

        switch (view.getId()) {

            case R.id.huri_lay:
                side+=2000;
                sideName = huri_text.getText().toString();
                sideBitmap = ((BitmapDrawable)huri_img.getDrawable()).getBitmap();
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

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        float scale = (float) (1024/(float)sideBitmap.getWidth());
        int image_w = (int) (sideBitmap.getWidth() * scale);
        int image_h = (int) (sideBitmap.getHeight() * scale);
        Bitmap sideResize = Bitmap.createScaledBitmap(sideBitmap, image_w, image_h, true);
        sideResize.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] sideArray = stream.toByteArray();
        goto_Kiosk_R_F_P_D.putExtra("sideImage", sideArray);

        goto_Kiosk_R_F_P_D.putExtra("side", side);
        goto_Kiosk_R_F_P_D.putExtra("sideName", sideName);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_P_Sz(View view) {
        Intent goto_Kiosk_R_F_P_Sz = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Size.class);
        goto_Kiosk_R_F_P_Sz.putExtra("value", value);

        burgerName = burgerName.replaceAll("\\s-\\s((라지|Large)\\s)?(세트|Set)", "");

        goto_Kiosk_R_F_P_Sz.putExtra("burger", burger);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_Sz.putExtra("burgerImage", burgerArray);
        startActivity(goto_Kiosk_R_F_P_Sz);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}