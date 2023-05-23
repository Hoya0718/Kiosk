package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Menu_Burger extends AppCompatActivity {

    private int value;
    private TextView money_text;
    private int burger;

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
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burger1955 = b1955_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burger1955);
                break;
            case R.id.batodi_lay:
                burger+=5800;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgerbatodi = batodi_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerbatodi);
                break;
            case R.id.bigmc_lay:
                burger+=5200;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgerbigmc = bigmc_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerbigmc);
                break;
            case R.id.mcchi_lay:
                burger+=3500;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgermcchi = mcchi_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgermcchi);
                break;
            case R.id.mccri_lay:
                burger+=5900;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgermccri = mccri_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgermccri);
                break;
            case R.id.quater_lay:
                burger+=5500;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgerquater = quater_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerquater);
                break;
            case R.id.sanhi_lay:
                burger+=5200;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgersanhi = sanhi_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgersanhi);
                break;
            case R.id.susu_lay:
                burger+=4700;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgersusu = susu_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgersusu);
                break;
            case R.id.subi_lay:
                burger+=5800;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgersubi = subi_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgersubi);
                break;
            case R.id.bulgogi_lay:
                burger+=2300;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgerbulgogi = bulgogi_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerbulgogi);
                break;
            case R.id.cheeze_lay:
                burger+=2700;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgercheeze = cheeze_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgercheeze);
                break;
            case R.id.ham_lay:
                burger+=2500;
                goto_Kiosk_R_F_P_St.putExtra("burger", burger);
                String burgerham = ham_text.getText().toString();
                goto_Kiosk_R_F_P_St.putExtra("burgerName", burgerham);
                break;
        }
        startActivity(goto_Kiosk_R_F_P_St);
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        if (value != 0) {
            Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
            goto_Kiosk_R_F_P_R.putExtra("value", value);
            startActivity(goto_Kiosk_R_F_P_R);
        }
    }
}