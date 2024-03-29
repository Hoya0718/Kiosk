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
    private String sideName;
    private String drinkName;
    private byte[] burgerArray;
    private byte[] sideArray;
    private byte[] drinkArray;

    private TextView askMission;
    private TextView showMission;
    private TextView burger_text;
    private TextView total_text;
    private TextView count_text;
    private TextView set_burger_text;
    private TextView set_side_text;
    private TextView set_drink_text;

    private ImageView set_burger_img;
    private ImageView set_side_img;
    private ImageView set_drink_img;

    private Bitmap burgerBitmap;
    private Bitmap sideBitmap;
    private Bitmap drinkBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_popup_total);

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());
        askMission = findViewById(R.id.askMission);

        if (showMission.getText().toString().equals(" ")) {
            askMission.setText(" ");
        }

        burger_text = findViewById(R.id.burger_text);
        total_text = findViewById(R.id.total_text);
        count_text = findViewById(R.id.count_text);

        set_burger_text = findViewById(R.id.set_burger_text);
        set_side_text = findViewById(R.id.set_side_text);
        set_drink_text = findViewById(R.id.set_drink_text);

        set_burger_img = findViewById(R.id.set_burger_img);
        set_side_img = findViewById(R.id.set_side_img);
        set_drink_img = findViewById(R.id.set_drink_img);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);

            burger = intent.getIntExtra("burger", 0);
            burgerName = intent.getStringExtra("burgerName");
            burgerArray = intent.getByteArrayExtra("burgerImage");

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
                String set_burger = burgerName.replaceAll("\\s-\\s(라지\\s)?세트", "");
                set_burger_text.setText(set_burger);
            }
            if (sideName != null) {
                set_side_text.setText(sideName);
            }
            if (drinkName != null) {
                set_drink_text.setText(drinkName);
            }

            if (burgerArray != null) {
                burgerBitmap = BitmapFactory.decodeByteArray(burgerArray, 0, burgerArray.length);
                set_burger_img.setImageBitmap(burgerBitmap);
            }
            if (sideArray != null) {
                sideBitmap = BitmapFactory.decodeByteArray(sideArray, 0, sideArray.length);
                set_side_img.setImageBitmap(sideBitmap);
            }
            if (drinkArray != null) {
                drinkBitmap = BitmapFactory.decodeByteArray(drinkArray, 0, drinkArray.length);
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

        goto_Kiosk_R_F_P_D.putExtra("side", side);
        goto_Kiosk_R_F_P_D.putExtra("sideName", sideName);
        goto_Kiosk_R_F_P_D.putExtra("sideImage", sideArray);

        goto_Kiosk_R_F_P_D.putExtra("drink", drink);
        goto_Kiosk_R_F_P_D.putExtra("drinkName", drinkName);
        goto_Kiosk_R_F_P_D.putExtra("drinkImage", drinkArray);
        startActivity(goto_Kiosk_R_F_P_D);
    }

    public void goto_Kiosk_R_F_Plus(View view) {
        Intent goto_Kiosk_R_F_Plus = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Plus.class);

        value += total * count;

        burgerName += " - " + sideName + " - " + drinkName;

        myapp orderHistory = (myapp) getApplicationContext();
        Order order = new Order(burgerName, total, count, burgerBitmap);
        orderHistory.addOrder(order);

        goto_Kiosk_R_F_Plus.putExtra("value", value);
        goto_Kiosk_R_F_Plus.putExtra("plus", total * count);
        startActivity(goto_Kiosk_R_F_Plus);
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);

        myapp orderHistory = (myapp) getApplicationContext();
        orderHistory.clearOrderList();

        startActivity(goto_Kiosk_R_F_M);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}