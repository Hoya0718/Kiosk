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
    private Button button45; //3B;
    private Button button47; //4B
    private Button button48; //4A
    private Button button49; //2B;
    private Button button53; //5D
    private Button button54; //5C
    private Button button59; //2C
    private Button button60; //2D

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kiosk19);

    button45 = findViewById(R.id.button45);
    button47 = findViewById(R.id.button47);
    button48 = findViewById(R.id.button48);
    button49 = findViewById(R.id.button49);
    button53 = findViewById(R.id.button53);
    button54 = findViewById(R.id.button54);
    button59 = findViewById(R.id.button59);
    button60 = findViewById(R.id.button60);

    button45.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
            Intent intent1 = getIntent();
            String bus = intent1.getStringExtra("bus");
            intent.putExtra("destination", "목포");
            intent.putExtra("bus", bus);
            intent.putExtra("seat", "좌석 번호 : 3B");
            startActivity(intent);
            }
        });

    button47.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
            Intent intent1 = getIntent();
            String bus = intent1.getStringExtra("bus");
            intent.putExtra("destination", "목포");
            intent.putExtra("bus", bus);
            intent.putExtra("seat", "좌석 번호 : 4B");
            startActivity(intent);
            }
        });
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 4A");
                startActivity(intent);
            }
        });
        button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 2B");
                startActivity(intent);
            }
        });
        button53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 5D");
                startActivity(intent);
            }
        });
        button54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 5C");
                startActivity(intent);
            }
        });
        button59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 2C");
                startActivity(intent);
            }
        });
        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_19.this, Kiosk_21.class);
                Intent intent1 = getIntent();
                String bus = intent1.getStringExtra("bus");
                intent.putExtra("destination", "목포");
                intent.putExtra("bus", bus);
                intent.putExtra("seat", "좌석 번호 : 2D");
                startActivity(intent);
            }
        });
    }
}