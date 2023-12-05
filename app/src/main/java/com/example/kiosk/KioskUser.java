package com.example.kiosk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KioskUser extends AppCompatActivity implements NameAdapter.NameAdapterListener {

    RecyclerView name_recycler;
    LineChart lineChart;
    List<String> userNames;
    NameAdapter adapter;
    RoomDB database;
    RecordAdapter recordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_user);

        name_recycler = findViewById(R.id.recycler_view);
        lineChart = findViewById(R.id.chart);

        database = RoomDB.getInstance(this);
        userNames = database.mainDao().getUserNames();

        name_recycler.setLayoutManager(new LinearLayoutManager(this));

        lineChart = findViewById(R.id.chart);

        List<MainData> recordData = database.mainDao().getMatchingItems("your_search_text_here");
        recordAdapter = new RecordAdapter(this, recordData);

        adapter = new NameAdapter(this, userNames, this); // 리스너 등록
        name_recycler.setAdapter(adapter);

        setupChart();
    }

    @Override
    public void onUserButtonClick(String userName) {
        List<MainData> matchingDates = database.mainDao().getMatchingItems(userName);
        recordAdapter.updateData(matchingDates);
        setupChart(); // 차트 업데이트
    }

    private String convertMillisToDate(long millis) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 원하는 날짜 포맷으로 지정
        Date date = new Date(millis);
        return dateFormat.format(date);
    }

    private void setupChart() {
        List<Entry> chartData = recordAdapter.getChartData();

        ArrayList<Entry> dataSet1 = new ArrayList<>();
        ArrayList<Entry> dataSet2 = new ArrayList<>();
        ArrayList<Entry> dataSet3 = new ArrayList<>();

        // 데이터를 각각의 그래프에 분배합니다.
        for (int i = 0; i < chartData.size(); i++) {
            Entry entry = chartData.get(i);
            float xValue = i / 3; // 3개의 데이터마다 X값을 1씩 증가시킵니다.

            // 각 그래프에 데이터 추가
            if (i % 3 == 0) {
                dataSet1.add(new Entry(xValue, entry.getY()));
            } else if (i % 3 == 1) {
                dataSet2.add(new Entry(xValue, entry.getY()));
            } else {
                dataSet3.add(new Entry(xValue, entry.getY()));
            }
        }

        // LineDataSet 객체 생성
        LineDataSet lineDataSet1 = new LineDataSet(dataSet1, "Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(dataSet2, "Data Set 2");
        LineDataSet lineDataSet3 = new LineDataSet(dataSet3, "Data Set 3");

        // 그래프 설정
        configureLineDataSet(lineDataSet1, Color.RED); // 데이터 색상을 설정하는 메서드
        configureLineDataSet(lineDataSet2, Color.BLUE);
        configureLineDataSet(lineDataSet3, Color.GREEN);

        // LineData 객체 생성
        LineData lineData = new LineData(lineDataSet1, lineDataSet2, lineDataSet3);

        // X축 범위 설정 코드
//        XAxis xAxis = lineChart.getXAxis();
//        xAxis.setAxisMinimum(0f); // X축 최소값 설정
//        xAxis.setAxisMaximum(10f); // X축 최대값 설정

        // Y축 범위 설정 코드
        YAxis yAxis = lineChart.getAxisLeft(); // 왼쪽 Y축을 가져옵니다.
        yAxis.setAxisMinimum(0f); // Y축 최소값 설정
        yAxis.setAxisMaximum(120f); // Y축 최대값 설정

        // 그래프에 데이터 설정
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    // LineDataSet 설정을 위한 메서드
    private void configureLineDataSet(LineDataSet lineDataSet, int color) {
        lineDataSet.setColors(color);
        lineDataSet.setCircleColor(color);
        // 다른 설정들을 추가할 수 있습니다.
    }

    public void goto_user_list(View v){
        Intent goto_user_list = new Intent(getApplicationContext(), User_list.class);
        startActivity(goto_user_list);
    }

    public void goto_kiosk_main(View v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_kiosk_main);
    }
}
