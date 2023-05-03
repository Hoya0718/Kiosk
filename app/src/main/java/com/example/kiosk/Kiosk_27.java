package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Kiosk_27 extends AppCompatActivity {


    private TextView department;
    private TextView day;
    private TextView birthday;

    private myapp pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk27);

        pn = (myapp) getApplication();

        department =findViewById(R.id.department);
        day =findViewById(R.id.day);
        birthday=findViewById(R.id.birthday);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyy/MM/dd(E)-HH:mm:ss", Locale.KOREAN);
        day.setText(format.format(c.getTime()));

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        department.setText(text);

        birthday.setText(pn.getGet_pn().substring(0,6));
    }
    public void goto_kiosk_28(View v) {
        Intent goto_kiosk_28 = new Intent(getApplicationContext(), Kiosk_28.class);
        startActivity(goto_kiosk_28);
    }
}