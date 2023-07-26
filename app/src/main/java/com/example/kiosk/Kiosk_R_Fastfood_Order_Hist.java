package com.example.kiosk;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

public class Kiosk_R_Fastfood_Order_Hist extends AppCompatActivity {

    private int value;

    private TextView value_text;

    private TextView showMission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_order_hist);

        Intent intent = getIntent();
        if (intent != null) {
            value = intent.getIntExtra("value", 0);
        }

        myapp myApp = (myapp) getApplicationContext();
        showMission = findViewById(R.id.showMission);
        showMission.setText(myApp.getCheckFastfoodMission());


        List<Order> orderList = myApp.getOrderList();

        LinearLayout containerLayout = findViewById(R.id.container_layout);

        value_text = findViewById(R.id.value_text);

        updateTotalPrice(orderList, value_text);

        for (int i = 0; i < orderList.size(); i++) {

            final Order order = orderList.get(i);

            // LinearLayout 생성
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setPadding(2, 2, 2, 2);  // 마진 적용

            // 삭제 버튼
            Button deleteButton = new Button(this);
            deleteButton.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            ));
            deleteButton.setGravity(Gravity.CENTER);
            deleteButton.setText(getResources().getString(R.string.delete));
            deleteButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            deleteButton.setBackgroundResource(R.drawable.fastfood_btn_background_yellow); // This line sets the background

            // 삭제 버튼 기능
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    containerLayout.removeView(linearLayout);
                    orderList.remove(order);
                    updateTotalPrice(orderList, value_text);

                    if (containerLayout.getChildCount() == 0) {
                        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
                        goto_Kiosk_R_F_M_B.putExtra("value", value);
                        startActivity(goto_Kiosk_R_F_M_B);
                    }
                }
            });

            // 메뉴 사진
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0.8f
            ));
            imageView.setForegroundGravity(Gravity.CENTER);
            imageView.setImageBitmap(orderList.get(i).getOrderBitmap());

            // 메뉴 이름
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    2.5f
            ));
            textView.setGravity(Gravity.CENTER);
            textView.setText(orderList.get(i).getOrderName());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

            // 카운트 레이아웃
            LinearLayout subLinearLayout = new LinearLayout(this);
            subLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.5f
            ));
            subLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            subLinearLayout.setGravity(Gravity.CENTER);

            // "-" 버튼
            Button minusButton = new Button(this);
            minusButton.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.5f
            ));
            minusButton.setText("-");
            minusButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            minusButton.setBackgroundResource(R.drawable.table_border); // This line sets the background

            // 메뉴 개수
            TextView countTextView = new TextView(this);
            countTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1f
            ));
            countTextView.setGravity(Gravity.CENTER);
            countTextView.setText(String.valueOf(orderList.get(i).getOrderCount()));
            countTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            // "+" 버튼
            Button plusButton = new Button(this);
            plusButton.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.5f
            ));
            plusButton.setText("+");
            plusButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            plusButton.setBackgroundResource(R.drawable.table_border); // This line sets the background

            // "₩" TextView 생성
            TextView wonTextView = new TextView(this);
            wonTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0.4f
            ));
            wonTextView.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            wonTextView.setText("₩");
            wonTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            // 메뉴 가격
            TextView priceTextView = new TextView(this);
            priceTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0.9f
            ));
            priceTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            priceTextView.setText(String.valueOf(orderList.get(i).getOrderPrice() * orderList.get(i).getOrderCount()));
            priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            // "-" 버튼 클릭 이벤트 처리
            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 현재 값 가져오기
                    int currentCount = Integer.parseInt(countTextView.getText().toString());
                    // 값 감소
                    if (currentCount > 1) {
                        currentCount--;
                    }
                    // 값 업데이트
                    countTextView.setText(String.valueOf(currentCount));

                    // 배열에서 해당 아이템 찾기
                    for (int i = 0; i < orderList.size(); i++) {
                        Order order = orderList.get(i);
                        if (order.getOrderName().equals(textView.getText().toString())) {
                            // 배열에서 가격과 카운트 업데이트
                            order.setOrderCount(currentCount);
                            // 메뉴 가격 텍스트뷰 업데이트
                            updateMenuPrice(priceTextView, order);
                            // 총합 가격 업데이트
                            updateTotalPrice(orderList, value_text);
                            break;
                        }
                    }
                }
            });

            // "+" 버튼 클릭 이벤트 처리
            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 현재 값 가져오기
                    int currentCount = Integer.parseInt(countTextView.getText().toString());
                    // 값 증가
                    currentCount++;
                    // 값 업데이트
                    countTextView.setText(String.valueOf(currentCount));

                    // 배열에서 해당 아이템 찾기
                    for (int i = 0; i < orderList.size(); i++) {
                        Order order = orderList.get(i);
                        if (order.getOrderName().equals(textView.getText().toString())) {
                            // 배열에서 가격과 카운트 업데이트
                            order.setOrderCount(currentCount);
                            // 메뉴 가격 텍스트뷰 업데이트
                            updateMenuPrice(priceTextView, order);
                            // 총합 가격 업데이트
                            updateTotalPrice(orderList, value_text);
                            break;
                        }
                    }
                }
            });

            // 하위 뷰들을 상위 LinearLayout에 추가
            subLinearLayout.addView(minusButton);
            subLinearLayout.addView(countTextView);
            subLinearLayout.addView(plusButton);

            linearLayout.addView(deleteButton);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            linearLayout.addView(subLinearLayout);
            linearLayout.addView(wonTextView);
            linearLayout.addView(priceTextView);

            // 상위 LinearLayout을 containerLayout에 추가
            containerLayout.addView(linearLayout);
        }
    }

    // 총합 가격을 업데이트하는 메소드
    private void updateTotalPrice(List<Order> orderList, TextView value_text) {
        int totalPrice = 0;
        for (Order order : orderList) {
            totalPrice += order.getOrderPrice() * order.getOrderCount();
        }
        value_text.setText(String.valueOf(totalPrice));
        value = totalPrice;
    }

    // 가격을 업데이트하는 메소드
    private void updateMenuPrice(TextView priceTextView, Order order) {
        int menuPrice = order.getOrderPrice() * order.getOrderCount();
        priceTextView.setText(String.valueOf(menuPrice));
    }

    public void goto_Kiosk_R_F_M(View v){
        Intent goto_Kiosk_R_F_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Main.class);

        myapp orderHistory = (myapp) getApplicationContext();
        orderHistory.clearOrderList();

        startActivity(goto_Kiosk_R_F_M);
    }

    public void goto_Kiosk_R_F_P_M(View v){
        if (value != 0){
            Intent goto_Kiosk_R_F_P_M = new Intent(getApplicationContext(),Kiosk_R_Fastfood_Pay_Meth.class);
            goto_Kiosk_R_F_P_M.putExtra("value", value);
            startActivity(goto_Kiosk_R_F_P_M);
        }
    }

    public void goto_Kiosk_R_F_M_B(View view) {
        Intent goto_Kiosk_R_F_M_B = new Intent(getApplicationContext(), Kiosk_R_Fastfood_Menu_Burger.class);
        goto_Kiosk_R_F_M_B.putExtra("value", value);
        startActivity(goto_Kiosk_R_F_M_B);
    }

    public void onBackPressed() {
        // 뒤로가기 버튼 무시
    }
}