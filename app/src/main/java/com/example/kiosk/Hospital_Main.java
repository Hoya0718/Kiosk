package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Hospital_Main extends AppCompatActivity {


    TextView select_text;
    String content;
    SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_main);


        select_text = findViewById(R.id.select_text);
        content = select_text.getText().toString(); //텍스트 가져옴
        spannableString = new SpannableString(content); //객체 생성

        String word ="원하시는 업무";
        int start = content.indexOf(word);
        int end = start + word.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0055FF")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.2f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        select_text.setText(spannableString);
    }

    public void goto_prescription(View v){
        Intent goto_prescription = new Intent(getApplicationContext(), Hospital_Prescription.class);
        startActivity(goto_prescription);
    }

    public void goto_medical_record(View v){
        Intent goto_medical_record = new Intent(getApplicationContext(), Hospital_Medical_Record.class);
        startActivity(goto_medical_record);
    }
    public void goto_kiosk_main(View v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_kiosk_main);
    }
}