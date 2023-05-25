package com.example.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Kiosk_R_Fastfood_Popup_Total extends AppCompatActivity {

    private int value;
    private int burger;
    private int side;
    private int drink;
    private int total;
    private int count;
    private String burgerName;
    private String burgerSize;
    private String sideName;
    private String drinkName;
    private byte[] burgerArray;
    private byte[] sideArray;
    private byte[] drinkArray;

    private TextView burger_text;
    private TextView size_text;
    private TextView total_text;

    private TextView set_burger_text;
    private TextView set_side_text;
    private TextView set_drink_text;

    private ImageView set_burger_img;
    private ImageView set_side_img;
    private ImageView set_drink_img;

    private TextView count_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_total);

        burger_text = findViewById(R.id.burger_text);
        size_text = findViewById(R.id.size_text);
        total_text = findViewById(R.id.total_text);

        set_burger_text = findViewById(R.id.set_burger_text);
        set_side_text = findViewById(R.id.set_side_text);
        set_drink_text = findViewById(R.id.set_drink_text);

        set_burger_img = findViewById(R.id.set_burger_img);
        set_side_img = findViewById(R.id.set_side_img);
        set_drink_img = findViewById(R.id.set_drink_img);

        count_text = findViewById(R.id.count_text);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");
            burgerSize = intent.getStringExtra("burgerSize");

            side = intent.getIntExtra("side", 0);
            sideName = intent.getStringExtra("sideName");
            sideArray = intent.getByteArrayExtra("sideImage");

            drink = intent.getIntExtra("drink", 0);
            drinkName = intent.getStringExtra("drinkName");
            drinkArray = intent.getByteArrayExtra("drinkImage");

            total = burger + side + drink;
            total_text.setText(String.valueOf(total));

            if (burgerName != null) {
                burger_text.setText(burgerName);
                set_burger_text.setText(burgerName);
            }
            if (burgerSize != null) {
                size_text.setText(burgerSize);
            }
            if (sideName != null) {
                set_side_text.setText(sideName);
            }
            if (drinkName != null) {
                set_drink_text.setText(drinkName);
            }

            if (burgerArray != null) {
                Bitmap burgerBitmap = BitmapFactory.decodeByteArray(burgerArray, 0, burgerArray.length);
                set_burger_img.setImageBitmap(burgerBitmap);
            }
            if (sideArray != null) {
                Bitmap sideBitmap = BitmapFactory.decodeByteArray(sideArray, 0, sideArray.length);
                set_side_img.setImageBitmap(sideBitmap);
            }
            if (drinkArray != null) {
                Bitmap drinkBitmap = BitmapFactory.decodeByteArray(drinkArray, 0, drinkArray.length);
                set_drink_img.setImageBitmap(drinkBitmap);
            }
        }

        count = 1;
    }

    public void count_minus(View view) {
        if (count>1) {
            count--;
            count_text.setText(String.valueOf(count));
            total_text.setText(String.valueOf(total*count));
        }
    }

    public void count_plus(View view) {
        count++;
        count_text.setText(String.valueOf(count));
        total_text.setText(String.valueOf(total*count));
    }

    public void goto_Kiosk_R_F_P_D(View view) {
        Intent goto_Kiosk_R_F_P_D = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Popup_Drink.class);
        goto_Kiosk_R_F_P_D.putExtra("value", value);

        goto_Kiosk_R_F_P_D.putExtra("burger", burger);
        goto_Kiosk_R_F_P_D.putExtra("burgerName", burgerName);
        goto_Kiosk_R_F_P_D.putExtra("burgerImage", burgerArray);
        goto_Kiosk_R_F_P_D.putExtra("burgerSize", burgerSize);

        goto_Kiosk_R_F_P_D.putExtra("side", side);
        goto_Kiosk_R_F_P_D.putExtra("sideName", sideName);
        goto_Kiosk_R_F_P_D.putExtra("sideImage", sideArray);

        goto_Kiosk_R_F_P_D.putExtra("drink", drink);
        goto_Kiosk_R_F_P_D.putExtra("drinkName", drinkName);
        goto_Kiosk_R_F_P_D.putExtra("drinkImage", drinkArray);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);

        total *= count;
        value += total;

        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);
        startActivity(goto_Kiosk_R_F_M);
    }
}