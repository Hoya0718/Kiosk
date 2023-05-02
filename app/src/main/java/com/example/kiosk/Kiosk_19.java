package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Kiosk_19 extends AppCompatActivity {

    private TextView textView37; //목적지2
    private TextView textView38; //버스, 좌석

    private Button button45; //버스 3B;
    private Button button49; //버스 2B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kiosk19);

    button45 = findViewById(R.id.button45);
    button49 = findViewById(R.id.button49);

    button45.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
            intent.putExtra("destination", "목포");
            intent.putExtra("bus", "우등버스 1");
            intent.putExtra("seat", "좌석 번호 : 3B");
            startActivity(intent);
            }
        });

    button49.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
            intent.putExtra("destination", "목포");
            intent.putExtra("bus", "고속버스 2");
            intent.putExtra("seat", "좌석 번호 : 2B");
            startActivity(intent);
            }
        });
    }
}