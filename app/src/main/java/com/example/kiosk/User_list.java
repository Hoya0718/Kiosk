package com.example.kiosk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class User_list extends AppCompatActivity {

    EditText editText;
    Button btReset, bt_user;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        editText = findViewById(R.id.edit_text);
        btReset = findViewById(R.id.bt_reset);
        bt_user = findViewById(R.id.bt_user);
        recyclerView = findViewById(R.id.recycler_view);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapter(User_list.this, dataList);

        recyclerView.setAdapter(adapter);

        bt_user.setOnClickListener(new View.OnClickListener(){                                      //사용자 추가 팝업창 오픈
            @Override
            public void onClick(View v){
                AlertDialog.Builder ad = new AlertDialog.Builder(User_list.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("사용자 추가");
                ad.setMessage("사용자 이름을 적어주세요.");

                final EditText et = new EditText(User_list.this);
                ad.setView(et);

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {            //사용자 이름을 입력시 다음 액티비티로 이동
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        String sText = et.getText().toString().trim();


                        if (!sText.equals("")) {
                            MainData data = new MainData();
                            data.setText(sText);
                            data.setTime(null);
                            data.setCredit(null);
                            data.setDetail(null);
                            database.mainDao().insert(data);

                            editText.setText("");
                            dataList.clear();
                            dataList.addAll(database.mainDao().getAll());
                            adapter.notifyDataSetChanged();
                            Intent it = new Intent(getApplicationContext(), Kiosk_R_Part.class);
                            startActivity(it);
                        }
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {            //취소시 팝업 종료
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {                                     //모든 사용자 삭제
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}