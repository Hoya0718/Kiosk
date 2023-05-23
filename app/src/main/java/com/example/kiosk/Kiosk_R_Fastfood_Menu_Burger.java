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

        value = 0;
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
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_M_S(View v){
        Intent goto_Kiosk_R_F_M_S = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Side.class);
        startActivity(goto_Kiosk_R_F_M_S);
    }

    public void goto_Kiosk_R_F_M_D(View v){
        Intent goto_Kiosk_R_F_M_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Drink.class);
        startActivity(goto_Kiosk_R_F_M_D);
    }

    public void goto_Kiosk_R_F_P_St(View view) {
        Intent popup_Kiosk_R_F_P_St = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Set.class);
        switch (view.getId()) {
            case R.id.b1955_lay:
                value+=6400;
                money_text.setText(String.valueOf(value));
                String burger1955 = b1955_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burger1955);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.batodi_lay:
                value+=5800;
                money_text.setText(String.valueOf(value));
                String burgerbatodi = batodi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbatodi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.bigmc_lay:
                value+=5200;
                money_text.setText(String.valueOf(value));
                String burgerbigmc = bigmc_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbigmc);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.mcchi_lay:
                value+=3500;
                money_text.setText(String.valueOf(value));
                String burgermcchi = mcchi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgermcchi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.mccri_lay:
                value+=5900;
                money_text.setText(String.valueOf(value));
                String burgermccri = mccri_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgermccri);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.quater_lay:
                value+=5500;
                money_text.setText(String.valueOf(value));
                String burgerquater = quater_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerquater);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.sanhi_lay:
                value+=5200;
                money_text.setText(String.valueOf(value));
                String burgersanhi = sanhi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersanhi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.susu_lay:
                value+=4700;
                money_text.setText(String.valueOf(value));
                String burgersusu = susu_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersusu);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.subi_lay:
                value+=5800;
                money_text.setText(String.valueOf(value));
                String burgersubi = subi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgersubi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.bulgogi_lay:
                value+=2300;
                money_text.setText(String.valueOf(value));
                String burgerbulgogi = bulgogi_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerbulgogi);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.cheeze_lay:
                value+=2700;
                money_text.setText(String.valueOf(value));
                String burgercheeze = cheeze_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgercheeze);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
            case R.id.ham_lay:
                value+=2500;
                money_text.setText(String.valueOf(value));
                String burgerham = ham_text.getText().toString();
                popup_Kiosk_R_F_P_St.putExtra("name", burgerham);
                popup_Kiosk_R_F_P_St.putExtra("value", value);
                startActivity(popup_Kiosk_R_F_P_St);
                break;
        }
    }

    public void goto_Kiosk_R_F_P_R(View view) {
        Intent goto_Kiosk_R_F_P_R = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Reco.class);
        startActivity(goto_Kiosk_R_F_P_R);
    }
}