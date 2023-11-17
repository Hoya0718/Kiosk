package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KioskUser extends AppCompatActivity {

    RecyclerView name_recycler;
    RecyclerView record_recycler;
    List<String> userNames;
    NameAdapter adapter;
    RecordAdapter recordAdapter;
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_user);

        name_recycler = findViewById(R.id.recycler_view);
        record_recycler = findViewById(R.id.rec_view);

        database = RoomDB.getInstance(this);
        userNames = database.mainDao().getUserNames();

        name_recycler.setLayoutManager(new LinearLayoutManager(this));
        // 두 번째 RecyclerView의 데이터를 초기화
        List<MainData> recordData = database.mainDao().getMatchingItems("your_search_text_here");
        recordAdapter = new RecordAdapter(this, recordData);
        record_recycler.setLayoutManager(new LinearLayoutManager(this));
        record_recycler.setAdapter(recordAdapter);

        adapter = new NameAdapter(this, userNames, recordAdapter);
        name_recycler.setAdapter(adapter);

    }

    public void goto_kiosk_main(View v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_kiosk_main);
    }

    public void goto_kiosk_join(View v){
        Intent goto_kiosk_join = new Intent(getApplicationContext(), KioskJoin.class);
        startActivity(goto_kiosk_join);
    }
}
