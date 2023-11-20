package com.example.kiosk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Kiosk_R_Fastfood_Congratulation extends AppCompatActivity {
    List<MainData> dataList = new ArrayList<>();
    List<NewData> newList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;
    private MainDao mainDao;
    private NewDao newDao;
    private TextView con_text, tot, tot_1, tot_2;
    private String mT, pT_1, pT_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_fastfood_congratulation);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = dateFormat.format(new Date());

        tot = findViewById(R.id.tot);
        tot_1 = findViewById(R.id.tot_1);
        tot_2 = findViewById(R.id.tot_2);
        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();
        newList = database.newDao().getAll();

        adapter = new MainAdapter(Kiosk_R_Fastfood_Congratulation.this, newList);

        RoomDB db = Room.databaseBuilder(getApplicationContext(), RoomDB.class, "Time_DB")
                .fallbackToDestructiveMigration()     //스키마 버젼 변경 가능
                .allowMainThreadQueries()             // 메인 스레드에서 DB에 IO가능하게
                .build();

        mainDao = db.mainDao();
        newDao = db.newDao();

        MainData data = new MainData(); //객체 인스턴스 생성

        myapp myApp = (myapp) getApplicationContext();
        long beforeTime = myApp.getR_Time();
        long beforePopTime = myApp.getR_F_Pop_Time();
        long beforePayTime = myApp.getR_F_Pay_Time();
        long afterTime = System.currentTimeMillis();
        long measTime = (afterTime - beforeTime) / 1000;        // 전체
        long payTime = (afterTime - beforePayTime) / 1000;      // 결제
        long popTime = (beforePayTime - beforePopTime) / 1000;  // 세부
        long menuTime = (beforePopTime - beforeTime) / 1000;    // 메뉴
        //myApp.set_meansTime(measTime);
        myApp.set_meansTime(payTime);
        myApp.set_meansTime(popTime);
        myApp.set_meansTime(menuTime);

        double md = Math.floor(menuTime / 60);
        double mp = menuTime % 60;
        double pd = Math.floor(payTime / 60);
        double pp = payTime % 60;
        double dd = Math.floor(popTime / 60);
        double dp = popTime % 60;

        String name_value;
        name_value = myApp.getMyName();

        mT = Double.toString(menuTime);
        pT_1 = Double.toString(popTime);
        pT_2 = Double.toString(payTime);

        List<Order> orderList = myApp.getOrderList();
        String checkMission = myApp.getCheckFastfoodMission();
        String missionComplete = "실패";
        for (Order order : orderList) {
            if (order.getOrderName().equals(checkMission)) {
                missionComplete = "성공";
                break;
            }
        }

        con_text = findViewById(R.id.con_text);
        long timeToCompare = myApp.getR_F_Time();
        String timeType = "";

        if (myApp.getPracticeFastfoodCheck() || timeToCompare != 0)
        {
            if (timeToCompare != 0) {
                timeType = (timeToCompare > measTime) ? "실전 전" : "실전 후";
            } else {
                timeType = (myApp.getPracticeFastfoodCheck() && measTime < timeToCompare) ? "연습 전" : "연습 후";
                if (measTime < timeToCompare) {
                    myApp.setR_F_Time(measTime);
                }
            }

            long diffTime = Math.abs(timeToCompare - measTime);
            String status = (timeToCompare > measTime) ? "빨랐어요" : "늦었어요";
            con_text.setText(timeType + " 소요 시간 : " + (timeToCompare / 60) + "분 " + (timeToCompare % 60) + "초\n" +
                    "실제 소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "이전 기록보다 " + (diffTime / 60) + "분 " + (diffTime % 60) + "초 " + status);


            data.setText(name_value);
            data.setUserdate(formattedDate);
            int ipd, ipp, idd, idp, imd, imp;
            ipd = (int)pd;
            ipp = (int)pp;
            idd = (int)dd;
            idp = (int)dp;
            imd = (int)md;
            imp = (int)mp;
            data.setCredit(ipd+"분"+ipp+"초");
            data.setDetail(idd+"분"+idp+"초");
            data.setTime(imd+"분"+imp+"초");
            database.mainDao().insert(data);


            List<MainData> dataList = database.mainDao().getAllDataWithTime_1();

            Log.d("DataList", "DataList size: " + dataList.size());
            double averageValue_1 = calculateAverageValue_1(dataList);
            double averageValue_2 = calculateAverageValue_2(dataList);
            double averageValue_3 = calculateAverageValue_3(dataList);

            int minutes_1 = (int) (averageValue_1 / 60);
            int seconds_1 = (int) (averageValue_1 % 60);
            int minutes_2 = (int) (averageValue_2 / 60);
            int seconds_2 = (int) (averageValue_2 % 60);
            int minutes_3 = (int) (averageValue_3 / 60);
            int seconds_3 = (int) (averageValue_3 % 60);
            String formattedAverage_1_minutes_seconds = String.format("%d분%d초", minutes_1, seconds_1);
            String formattedAverage_2_minutes_seconds = String.format("%d분%d초", minutes_2, seconds_2);
            String formattedAverage_3_minutes_seconds = String.format("%d분%d초", minutes_3, seconds_3);

            tot.setText("메뉴 선택 평균값: " + formattedAverage_1_minutes_seconds);
            tot_1.setText("세부 선택 평균값: " + formattedAverage_2_minutes_seconds);
            tot_2.setText("결제 선택 평균값: " + formattedAverage_3_minutes_seconds);
            database.mainDao().deleteNullNameData();
            myApp.setR_F_Time(measTime);
        }
        else
        {

            int ipd, ipp, idd, idp, imd, imp;
            ipd = (int)pd;
            ipp = (int)pp;
            idd = (int)dd;
            idp = (int)dp;
            imd = (int)md;
            imp = (int)mp;
            con_text.setText("소요 시간 : " + (measTime / 60) + "분 " + (measTime % 60) + "초\n" +
                    "구간별 소요 시간\n" +
                    "메뉴 선택 : " + md + "분 " + mp + "초\n" +
                    "세부 선택 : " + dd + "분 " + dp + "초\n" +
                    "결제 선택 : " + pd + "분 " + pp + "초");

            data.setText(name_value);
            data.setUserdate(formattedDate);
            data.setCredit(ipd+"분"+ipp+"초");
            data.setDetail(idd+"분"+idp+"초");
            data.setTime(imd+"분"+imp+"초");
            database.mainDao().insert(data);

            List<MainData> dataList = database.mainDao().getAllDataWithTime_1();

            Log.d("DataList", "DataList size: " + dataList.size());
            double averageValue_1 = calculateAverageValue_1(dataList);
            double averageValue_2 = calculateAverageValue_2(dataList);
            double averageValue_3 = calculateAverageValue_3(dataList);
            int minutes_1 = (int) (averageValue_1 / 60);
            int seconds_1 = (int) (averageValue_1 % 60);
            int minutes_2 = (int) (averageValue_2 / 60);
            int seconds_2 = (int) (averageValue_2 % 60);
            int minutes_3 = (int) (averageValue_3 / 60);
            int seconds_3 = (int) (averageValue_3 % 60);
            String formattedAverage_1_minutes_seconds = String.format("%d분%d초", minutes_1, seconds_1);
            String formattedAverage_2_minutes_seconds = String.format("%d분%d초", minutes_2, seconds_2);
            String formattedAverage_3_minutes_seconds = String.format("%d분%d초", minutes_3, seconds_3);

            tot.setText("메뉴 선택 평균값: " + formattedAverage_1_minutes_seconds);
            tot_1.setText("세부 선택 평균값: " + formattedAverage_2_minutes_seconds);
            tot_2.setText("결제 선택 평균값: " + formattedAverage_3_minutes_seconds);
            database.mainDao().deleteNullNameData();
            myApp.setR_F_Time(measTime);
        }

        if (myApp.getMissionCheck()) {
            String currentText = con_text.getText().toString();
            String appendedText = currentText + "\n임무 성공 여부 : " + missionComplete;
            con_text.setText(appendedText);
        }
    }

    public void goto_Kiosk_R_P(View v){
        myapp myApp = (myapp) getApplicationContext();
        myApp.clearOrderList();
        myApp.setCheckFastfoodMission("X");
        myApp.setMissionCheck(false);

        double tot_value = parseDoubleValue(tot.getText().toString());
        double tot_1_value = parseDoubleValue(tot_1.getText().toString());
        double tot_2_value = parseDoubleValue(tot_2.getText().toString());

        double mT_1 = parseDoubleValue(mT);
        double pT_1_1 = parseDoubleValue(pT_1);
        double pT_2_1 = parseDoubleValue(pT_2);

        double result_1 = mT_1 - tot_value;
        double result_2 = pT_1_1 - tot_1_value;
        double result_3 = pT_2_1 - tot_2_value;

        AlertDialog.Builder ad = new AlertDialog.Builder(Kiosk_R_Fastfood_Congratulation.this);
        ad.setIcon(R.mipmap.ic_launcher);
        ad.setTitle("소요 시간");

        if(result_1 >= result_2 && result_1 >= result_3){
            ad.setMessage("메뉴 선택시간이 평균값보다 " + result_1 + "초 느려요. 연습을 해 보실까요?\n연습을 하시려면 '네' 필요가 없으시다면 '아니요'를 눌러주세요.");
            ad.setPositiveButton("네", createIntentClickListener(Kiosk_7_b.class));
            ad.setNegativeButton("아니요", createIntentClickListener(MainActivity.class));
        } else if(result_2 >= result_1 && result_2 >= result_3){
            ad.setMessage("세부 선택시간이 평균값보다 " + result_2 +"초 느려요. 연습을 해 보실까요?\n연습을 하시려면 '네' 필요가 없으시다면 '아니요'를 눌러주세요.");
            ad.setPositiveButton("아니요", createIntentClickListener(Kiosk_8_1.class));
            ad.setNegativeButton("네", createIntentClickListener(MainActivity.class));
        } else if(result_3 >= result_1 && result_3 >= result_2){
            ad.setMessage("결제 선택시간이 평균값보다 " + result_3 + "초 느려요. 연습을 해 보실까요?\n연습을 하시려면 '네' 필요가 없으시다면 '아니요'를 눌러주세요.");
            ad.setPositiveButton("네", createIntentClickListener(Kiosk_9.class));
            ad.setNegativeButton("아니요", createIntentClickListener(MainActivity.class));
        } else {
            Intent goto_Kiosk_R_P = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(goto_Kiosk_R_P);
        }
        ad.show();
    }

    private double parseDoubleValue(String value){
        try {
            return Double.parseDouble(value.replaceAll("\\D+", ""));
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private DialogInterface.OnClickListener createIntentClickListener(Class<?> cls){
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), cls);
                startActivity(intent);
            }
        };
    }

    private double calculateAverageValue_1(List<MainData> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            Log.d("qwerty","return");
            return 0.0;
        }

        double totalValue_1 = 0.0;
        int validDataCount = 0;
        Log.d("qwerty","n_return");
        for (MainData entity : dataList) {
            String menu_t = entity.getTime();
            if (menu_t != null && !menu_t.trim().isEmpty()) {
                try {
                    // "분"과 "초"를 제거한 후 공백을 제거하고 변환
                    String cleanedTime = menu_t.replace("분", "").replace("초", "").trim();
                    Log.d("qwerty","value" + cleanedTime);

                    // 단위가 "분"인 경우
                    if (cleanedTime.contains("분")) {
                        // "분"을 공백으로 대체하고 남은 문자열을 정수로 변환
                        int minutes = Integer.parseInt(cleanedTime.replace("분", "").trim());
                        double value_1 = minutes * 60;
                        totalValue_1 += value_1;
                        validDataCount++;
                    } else if (cleanedTime.contains("초")) {
                        // 단위가 "초"인 경우
                        int seconds = Integer.parseInt(cleanedTime.replace("초", "").trim());
                        double value_1 = seconds;
                        totalValue_1 += value_1;
                        validDataCount++;
                    } else {
                        // ":"를 기준으로 분과 초를 나누어 배열에 저장
                        String[] timeComponents = cleanedTime.split(":");
                        if (timeComponents.length == 2) {
                            // 분과 초를 정수로 변환하여 합산
                            int minutes = Integer.parseInt(timeComponents[0]);
                            int seconds = Integer.parseInt(timeComponents[1]);

                            // 분과 초가 음수이거나 초가 60 이상인 경우는 유효하지 않은 데이터로 처리
                            if (minutes >= 0 && seconds >= 0 && seconds < 60) {
                                double value_1 = minutes * 60 + seconds;
                                totalValue_1 += value_1;
                                validDataCount++;
                            } else {
                                Log.e("ParsingError", "Invalid time format: " + menu_t);
                            }
                        } else {
                            Log.e("ParsingError", "Invalid time format: " + menu_t);
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        // 유효한 데이터가 없다면 0을 반환
        if (validDataCount == 0) {
            return 0.0;
        }

        // 평균 값을 계산하여 반환
        return totalValue_1 / validDataCount;
    }

    private double calculateAverageValue_2(List<MainData> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            Log.d("qwerty","return");
            return 0.0;
        }

        double totalValue_2 = 0.0;
        int validDataCount = 0;
        Log.d("return","n_return");
        for (MainData entity : dataList) {
            String detail_t = entity.getDetail();
            if (detail_t != null && !detail_t.trim().isEmpty()) {
                try {
                    // "분"과 "초"를 제거한 후 공백을 제거하고 변환
                    String cleanedTime = detail_t.replace("분", "").replace("초", "").trim();
                    Log.d("qwerty","value" + cleanedTime);

                    // 단위가 "분"인 경우
                    if (cleanedTime.contains("분")) {
                        // "분"을 공백으로 대체하고 남은 문자열을 정수로 변환
                        int minutes = Integer.parseInt(cleanedTime.replace("분", "").trim());
                        double value_1 = minutes * 60;
                        totalValue_2 += value_1;
                        validDataCount++;
                    } else if (cleanedTime.contains("초")) {
                        // 단위가 "초"인 경우
                        int seconds = Integer.parseInt(cleanedTime.replace("초", "").trim());
                        double value_1 = seconds;
                        totalValue_2 += value_1;
                        validDataCount++;
                    } else {
                        // ":"를 기준으로 분과 초를 나누어 배열에 저장
                        String[] timeComponents = cleanedTime.split(":");
                        if (timeComponents.length == 2) {
                            // 분과 초를 정수로 변환하여 합산
                            int minutes = Integer.parseInt(timeComponents[0]);
                            int seconds = Integer.parseInt(timeComponents[1]);

                            // 분과 초가 음수이거나 초가 60 이상인 경우는 유효하지 않은 데이터로 처리
                            if (minutes >= 0 && seconds >= 0 && seconds < 60) {
                                double value_1 = minutes * 60 + seconds;
                                totalValue_2 += value_1;
                                validDataCount++;
                            } else {
                                Log.e("ParsingError", "Invalid time format: " + detail_t);
                            }
                        } else {
                            Log.e("ParsingError", "Invalid time format: " + detail_t);
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        // 유효한 데이터가 없다면 0을 반환
        if (validDataCount == 0) {
            return 0.0;
        }

        // 평균 값을 계산하여 반환
        return totalValue_2 / validDataCount;
    }

    private double calculateAverageValue_3(List<MainData> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            Log.d("qwerty","return");
            return 0.0;
        }

        double totalValue_3 = 0.0;
        int validDataCount = 0;
        Log.d("return","n_return");
        for (MainData entity : dataList) {
            String credit_t = entity.getCredit();
            if (credit_t != null && !credit_t.trim().isEmpty()) {
                try {
                    // "분"과 "초"를 제거한 후 공백을 제거하고 변환
                    String cleanedTime = credit_t.replace("분", "").replace("초", "").trim();
                    Log.d("qwerty","value" + cleanedTime);

                    // 단위가 "분"인 경우
                    if (cleanedTime.contains("분")) {
                        // "분"을 공백으로 대체하고 남은 문자열을 정수로 변환
                        int minutes = Integer.parseInt(cleanedTime.replace("분", "").trim());
                        double value_1 = minutes * 60;
                        totalValue_3 += value_1;
                        validDataCount++;
                    } else if (cleanedTime.contains("초")) {
                        // 단위가 "초"인 경우
                        int seconds = Integer.parseInt(cleanedTime.replace("초", "").trim());
                        double value_1 = seconds;
                        totalValue_3 += value_1;
                        validDataCount++;
                    } else {
                        // ":"를 기준으로 분과 초를 나누어 배열에 저장
                        String[] timeComponents = cleanedTime.split(":");
                        if (timeComponents.length == 2) {
                            // 분과 초를 정수로 변환하여 합산
                            int minutes = Integer.parseInt(timeComponents[0]);
                            int seconds = Integer.parseInt(timeComponents[1]);

                            // 분과 초가 음수이거나 초가 60 이상인 경우는 유효하지 않은 데이터로 처리
                            if (minutes >= 0 && seconds >= 0 && seconds < 60) {
                                double value_1 = minutes * 60 + seconds;
                                totalValue_3 += value_1;
                                validDataCount++;
                            } else {
                                Log.e("ParsingError", "Invalid time format: " + credit_t);
                            }
                        } else {
                            Log.e("ParsingError", "Invalid time format: " + credit_t);
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        // 유효한 데이터가 없다면 0을 반환
        if (validDataCount == 0) {
            return 0.0;
        }

        // 평균 값을 계산하여 반환
        return totalValue_3 / validDataCount;
    }

}