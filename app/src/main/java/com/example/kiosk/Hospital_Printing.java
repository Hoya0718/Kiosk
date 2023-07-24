package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class Hospital_Printing extends AppCompatActivity {
    private static final long DELAY_MILLIS = 6000;

    private TextView h_printing_txt_printing, h_printing_txt_examination_fee;
    SpannableString spannableString_1, spannableString_2;
    String content, content_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_printing);

        //TextView 선언------------------------------------------------------------------------------

        h_printing_txt_printing = findViewById(R.id.h_printing_txt_printing);
        h_printing_txt_examination_fee= findViewById(R.id.h_printing_txt_examination_fee);

        //TextView 종료------------------------------------------------------------------------------

        content = h_printing_txt_printing.getText().toString(); //텍스트 가져옴
        spannableString_1 = new SpannableString(content); //객체 생성
        String word_1 = "출력중입니다.\n잠시만 기다려주세요.";
        spannableString_1 = new SpannableString(word_1);

        spannableString_1.setSpan(new ForegroundColorSpan(Color.parseColor("#4169E1")), 8, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new StyleSpan(Typeface.BOLD), 8, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_1.setSpan(new RelativeSizeSpan(1.1f), 8, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);


        content_1 = h_printing_txt_examination_fee.getText().toString(); //텍스트 가져옴
        spannableString_2 = new SpannableString(content_1); //객체 생성
        String word_2 = "진찰비 또는 검사비는 시행당일 수납하셔야 합니다.";
        spannableString_2 = new SpannableString(word_2);

        spannableString_2.setSpan(new ForegroundColorSpan(Color.parseColor("#4169E1")), 12, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_2.setSpan(new RelativeSizeSpan(1.0f), 12, 19, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        h_printing_txt_printing.setText(spannableString_1);
        h_printing_txt_examination_fee.setText(spannableString_2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Hospital_Printing_complete.class);
                startActivity(intent);
                finish(); // 현재 화면을 종료합니다. (선택사항)
            }
        }, DELAY_MILLIS);
    }
}