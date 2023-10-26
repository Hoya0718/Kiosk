package com.example.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KioskUser extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> userNames;
    NameAdapter adapter;
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_user);

        recyclerView = findViewById(R.id.recycler_view);

        database = RoomDB.getInstance(this);
        userNames = database.mainDao().getUserNames();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NameAdapter(this, userNames);
        recyclerView.setAdapter(adapter);
    }

    public void goto_kiosk_main(View v){
        Intent goto_kiosk_main = new Intent(getApplicationContext(), KioskMain.class);
        startActivity(goto_kiosk_main);
    }

    public void goto_kiosk_join(View v){
        Intent goto_kiosk_join = new Intent(getApplicationContext(), KioskJoin.class);
        startActivity(goto_kiosk_join);
    }
}
