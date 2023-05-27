package com.example.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class Kiosk_R_Fastfood_Menu_Burger extends AppCompatActivity {

    private int value;
    private int burger;
    private String burgerName;

    private TextView money_text;


    private TextView b1955_text;
    private TextView batodi_text;
    private TextView bigmc_text;
    private TextView mcchi_text;
    private TextView mccri_text;
    private TextView quater_text;
    private TextView sanhi_text;
    private TextView susu_text;
    private TextView subi_text;
    private TextView bulgogi_text;
    private TextView cheeze_text;
    private TextView ham_text;

    private ImageView b1955_img;
    private ImageView batodi_img;
    private ImageView bigmc_img;
    private ImageView mcchi_img;
    private ImageView mccri_img;
    private ImageView quater_img;
    private ImageView sanhi_img;
    private ImageView susu_img;
    private ImageView subi_img;
    private ImageView bulgogi_img;
    private ImageView cheeze_img;
    private ImageView ham_img;

    private Bitmap burgerBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_menu_burger);

        money_text = findViewById(R.id.money_text);

        b1955_text = findViewById(R.id.b1955_text);
        batodi_text = findViewById(R.id.batodi_text);
        bigmc_text = findViewById(R.id.bigmc_text);
        mcchi_text = findViewById(R.id.mcchi_text);
        mccri_text = findViewById(R.id.mccri_text);
        quater_text = findViewById(R.id.quater_text);
        sanhi_text = findViewById(R.id.sanhi_text);
        susu_text = findViewById(R.id.susu_text);
        subi_text = findViewById(R.id.subi_text);
        bulgogi_text = findViewById(R.id.bulgogi_text);
        cheeze_text = findViewById(R.id.cheeze_text);
        ham_text = findViewById(R.id.ham_text);

        b1955_img = findViewById(R.id.b1955_img);
        batodi_img = findViewById(R.id.batodi_img);
        bigmc_img = findViewById(R.id.bigmc_img);
        mcchi_img = findViewById(R.id.mcchi_img);
        mccri_img = findViewById(R.id.mccri_img);
        quater_img = findViewById(R.id.quater_img);
        sanhi_img = findViewById(R.id.sanhi_img);
        susu_img = findViewById(R.id.susu_img);
        subi_img = findViewById(R.id.subi_img);
        bulgogi_img = findViewById(R.id.bulgogi_img);
        cheeze_img = findViewById(R.id.cheeze_img);
        ham_img = findViewById(R.id.ham_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
            money_text.setText(String.valueOf(value));
        }

        burger = 0;
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_S(View v){
        Intent goto_Kiosk_R_F_M_S = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Side.class);
        goto_Kiosk_R_F_M_S.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_S);
    }

    public void goto_Kiosk_R_F_M_D(View v){
        Intent goto_Kiosk_R_F_M_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Drink.class);
        goto_Kiosk_R_F_M_D.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_D);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        Intent goto_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Set.class);
        goto_Kiosk_R_F_P_St.putExtra("value", value);

        switch (view.getId()) {

            case R.id.b1955_lay:
                burger+=6400;
                burgerName = b1955_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)b1955_img.getDrawable()).getBitmap();
                break;

            case R.id.batodi_lay:
                burger+=5800;
                burgerName = batodi_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)batodi_img.getDrawable()).getBitmap();
                break;

            case R.id.bigmc_lay:
                burger+=5200;
                burgerName = bigmc_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)bigmc_img.getDrawable()).getBitmap();
                break;

            case R.id.mcchi_lay:
                burger+=3500;
                burgerName = mcchi_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)mcchi_img.getDrawable()).getBitmap();
                break;

            case R.id.mccri_lay:
                burger+=5900;
                burgerName = mccri_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)mccri_img.getDrawable()).getBitmap();
                break;

            case R.id.quater_lay:
                burger+=5500;
                burgerName = quater_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)quater_img.getDrawable()).getBitmap();
                break;

            case R.id.sanhi_lay:
                burger+=5200;
                burgerName = sanhi_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)sanhi_img.getDrawable()).getBitmap();
                break;

            case R.id.susu_lay:
                burger+=4700;
                burgerName = susu_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)susu_img.getDrawable()).getBitmap();
                break;

            case R.id.subi_lay:
                burger+=5800;
                burgerName = subi_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)subi_img.getDrawable()).getBitmap();
                break;

            case R.id.bulgogi_lay:
                burger+=2300;
                burgerName = bulgogi_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)bulgogi_img.getDrawable()).getBitmap();
                break;

            case R.id.cheeze_lay:
                burger+=2700;
                burgerName = cheeze_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)cheeze_img.getDrawable()).getBitmap();
                break;

            case R.id.ham_lay:
                burger+=2500;
                burgerName = ham_text.getText().toString();
                burgerBitmap = ((BitmapDrawable)ham_img.getDrawable()).getBitmap();
                break;

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        float scale = (float) (1024/(float)burgerBitmap.getWidth());
        int image_w = (int) (burgerBitmap.getWidth() * scale);
        int image_h = (int) (burgerBitmap.getHeight() * scale);
        Bitmap burgerResize = Bitmap.createScaledBitmap(burgerBitmap, image_w, image_h, true);
        burgerResize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] burgerArray = stream.toByteArray();
        goto_Kiosk_R_F_P_St.putExtra("burgerImage", burgerArray);

        goto_Kiosk_R_F_P_St.putExtra("burger", burger);
        goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerName);
        startActivity(goto_Kiosk_R_F_P_St);
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
}