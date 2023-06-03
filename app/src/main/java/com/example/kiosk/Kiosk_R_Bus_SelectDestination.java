package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Kiosk_R_Bus_SelectDestination extends AppCompatActivity implements View.OnClickListener {
    private List<String> list;          // 데이터를 넣은 리스트변수
    private EditText editText;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private Map<String, Button> destinationMap;     //목적지 해쉬맵


    private Button seoul_btn, incheon_btn, kangwon_btn, sejong_btn;
    private Button chungnam_btn, chungbuk_btn, kwangju_btn, jeonbuk_btn;
    private Button busan_btn, daegu_btn, giyeok_btn, nieun_btn;
    private Button digeut_btn, rieul_btn, mieum_btn, bieup_btn;
    private Button siot_btn, ieung_btn, jieut_btn, chieut_btn;
    private Button kieuk_btn, tieut_btn, pieup_btn, hieut_btn;
    private Button button3;

    // 서울
    private Button central_btn, eastseoul_btn;
    // 인천/경기
    private Button incheonairport_btn, sungnam_btn;
    private Button suwon_btn, ansan_btn, yongin_btn;
    // 강원
    private Button gangneung_btn, chunchun_btn, sokcho_btn;
    // 대전/세종
    private Button daejun_bus_btn, sejong_bus_btn;
    // 충남
    private Button nonsan_btn, cheonan_btn, gongju_btn;
    // 충북
    private Button cheongju_btn, jechun_btn, chungju_btn;
    // 광주/전남
    private Button kwangju_bus_btn, suncheon_btn, damyang_btn, naju_btn;
    // 전북
    private Button jeonju_btn, gunsan_btn, namwon_btn;
    // 부산/경남
    private Button busan_bus_btn, ulsan_btn, gimhae_btn;
    // 대구/경북
    private Button eastdaegu_btn, westdaegu_btn, gyeongju_btn;

    private TextView textView1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_bus_selectdestination);

        giyeok_btn = findViewById(R.id.giyeok_btn);
        nieun_btn = findViewById(R.id.nieun_btn);
        digeut_btn = findViewById(R.id.digeut_btn);
        rieul_btn = findViewById(R.id.rieul_btn);
        mieum_btn = findViewById(R.id.mieum_btn);
        bieup_btn = findViewById(R.id.bieup_btn);
        siot_btn = findViewById(R.id.siot_btn);
        ieung_btn = findViewById(R.id.ieung_btn);
        jieut_btn = findViewById(R.id.jieut_btn);
        chieut_btn = findViewById(R.id.chieut_btn);
        kieuk_btn = findViewById(R.id.kieuk_btn);
        tieut_btn = findViewById(R.id.tieut_btn);
        pieup_btn = findViewById(R.id.pieup_btn);
        hieut_btn = findViewById(R.id.hieut_btn);
        seoul_btn = findViewById(R.id.seoul_btn);
        busan_btn = findViewById(R.id.busan_btn);
        chungbuk_btn = findViewById(R.id.chungbuk_btn);
        chungnam_btn = findViewById(R.id.chungnam_btn);
        daegu_btn = findViewById(R.id.daegu_btn);
        incheon_btn = findViewById(R.id.incheon_btn);
        jeonbuk_btn = findViewById(R.id.jeonbuk_btn);
        kwangju_btn = findViewById(R.id.kwangju_btn);
        sejong_btn = findViewById(R.id.sejong_btn);
        kangwon_btn = findViewById(R.id.kangwon_btn);
        central_btn = findViewById(R.id.central_btn);
        eastseoul_btn = findViewById(R.id.eastseoul_btn);
        incheonairport_btn = findViewById(R.id.incheonairport_btn);
        sungnam_btn = findViewById(R.id.sungnam_btn);
        suwon_btn = findViewById(R.id.suwon_btn);
        ansan_btn = findViewById(R.id.ansan_btn);
        yongin_btn = findViewById(R.id.yongin_btn);
        gangneung_btn = findViewById(R.id.gangneung_btn);
        chunchun_btn = findViewById(R.id.chunchun_btn);
        sokcho_btn = findViewById(R.id.sokcho_btn);
        daejun_bus_btn = findViewById(R.id.daejun_bus_btn);
        sejong_bus_btn = findViewById(R.id.sejong_bus_btn);
        nonsan_btn = findViewById(R.id.nonsan_btn);
        cheonan_btn = findViewById(R.id.cheonan_btn);
        gongju_btn = findViewById(R.id.gongju_btn);
        cheongju_btn = findViewById(R.id.cheongju_btn);
        chungju_btn = findViewById(R.id.chungju_btn);
        jechun_btn = findViewById(R.id.jechun_btn);
        kwangju_bus_btn = findViewById(R.id.kwangju_bus_btn);
        suncheon_btn = findViewById(R.id.suncheon_btn);
        damyang_btn = findViewById(R.id.damyang_btn);
        naju_btn = findViewById(R.id.naju_btn);
        jeonju_btn = findViewById(R.id.jeonju_btn);
        gunsan_btn = findViewById(R.id.gunsan_btn);
        namwon_btn = findViewById(R.id.namwon_btn);
        busan_bus_btn = findViewById(R.id.busan_bus_btn);
        ulsan_btn = findViewById(R.id.ulsan_btn);
        gimhae_btn = findViewById(R.id.gimhae_btn);
        eastdaegu_btn = findViewById(R.id.eastdaegu_btn);
        westdaegu_btn = findViewById(R.id.westdaegu_btn);
        gyeongju_btn = findViewById(R.id.gyeongju_btn);
        button3 = findViewById(R.id.button3);


        busan_btn.setOnClickListener(this);
        jeonbuk_btn.setOnClickListener(this);
        seoul_btn.setOnClickListener(this);
        incheon_btn.setOnClickListener(this);
        kwangju_btn.setOnClickListener(this);
        sejong_btn.setOnClickListener(this);
        kangwon_btn.setOnClickListener(this);
        daegu_btn.setOnClickListener(this);
        chungbuk_btn.setOnClickListener(this);
        chungnam_btn.setOnClickListener(this);
        giyeok_btn.setOnClickListener(this);
        nieun_btn.setOnClickListener(this);
        digeut_btn.setOnClickListener(this);
        rieul_btn.setOnClickListener(this);
        mieum_btn.setOnClickListener(this);
        bieup_btn.setOnClickListener(this);
        siot_btn.setOnClickListener(this);
        ieung_btn.setOnClickListener(this);
        jieut_btn.setOnClickListener(this);
        chieut_btn.setOnClickListener(this);
        kieuk_btn.setOnClickListener(this);
        tieut_btn.setOnClickListener(this);
        pieup_btn.setOnClickListener(this);
        hieut_btn.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);


        // 리스트를 생성한다.
        list = new ArrayList<String>();
        destinationMap = new HashMap<>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();
        mapSettig();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

//        // 리스트뷰에 아답터를 연결한다.
//        listView.setAdapter(adapter);
//        listView.setVisibility(View.INVISIBLE);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editText.getText().length() == 0) {

                    for (Map.Entry<String, Button> item : destinationMap.entrySet()) {
                        item.getValue().setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                if (editText.length() > 0) {
                    String text = editText.getText().toString();

                    search(text);
                }
                for (Map.Entry<String, Button> item : destinationMap.entrySet()) {
                    item.getValue().setVisibility(View.GONE);
                }


                for (String a : list) {
                    Log.d("listLog", a);
                    Log.d("listLog", String.valueOf(destinationMap.get(a).getText()));
                    if (!destinationMap.get(a).equals(null)) {
                        destinationMap.get(a).setVisibility(View.VISIBLE);
                    }
                    if (editText.length() == 0) {
                        for (Map.Entry<String, Button> item : destinationMap.entrySet()) {
                            item.getValue().setVisibility(View.GONE);
                        }
                    }
                }

            }
        });

        eastseoul_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "동서울");
                startActivity(intent);
            }
        });

        central_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "센트럴시티");
                startActivity(intent);
            }
        });

        incheonairport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "인천공항");
                startActivity(intent);
            }
        });

        sungnam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "성남");
                startActivity(intent);
            }
        });

        suwon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "수원");
                startActivity(intent);
            }
        });

        ansan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "안산");
                startActivity(intent);
            }
        });

        yongin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "용인");
                startActivity(intent);
            }
        });

        gangneung_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "강릉");
                startActivity(intent);
            }
        });

        chunchun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "춘천");
                startActivity(intent);
            }
        });

        sokcho_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "속초");
                startActivity(intent);
            }
        });

        daejun_bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "대전");
                startActivity(intent);
            }
        });

        sejong_bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "세종");
                startActivity(intent);
            }
        });

        nonsan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "논산");
                startActivity(intent);
            }
        });

        cheonan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "천안");
                startActivity(intent);
            }
        });

        gongju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "공주");
                startActivity(intent);
            }
        });

        cheongju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "청주");
                startActivity(intent);
            }
        });

        jechun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "제천");
                startActivity(intent);
            }
        });

        chungju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "충주");
                startActivity(intent);
            }
        });

        kwangju_bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "광주(유스퀘어)");
                startActivity(intent);
            }
        });

        suncheon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "순천");
                startActivity(intent);
            }
        });

        damyang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "담양");
                startActivity(intent);
            }
        });

        naju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "나주");
                startActivity(intent);
            }
        });

        jeonju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "전주");
                startActivity(intent);
            }
        });

        gunsan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "군산");
                startActivity(intent);
            }
        });

        namwon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "남원");
                startActivity(intent);
            }
        });

        busan_bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "부산");
                startActivity(intent);
            }
        });

        ulsan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "울산");
                startActivity(intent);
            }
        });

        gimhae_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "김해");
                startActivity(intent);
            }
        });

        eastdaegu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "동대구");
                startActivity(intent);
            }
        });

        westdaegu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "서대구");
                startActivity(intent);
            }
        });

        gyeongju_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                intent.putExtra("destination", "경주");
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kiosk_R_Bus_SelectDestination.this, Kiosk_R_Bus_SelectBustype.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seoul_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (eastseoul_btn.getVisibility() == View.GONE) {
                    eastseoul_btn.setVisibility(View.VISIBLE);
                    central_btn.setVisibility(View.VISIBLE);
                } else {
                    eastseoul_btn.setVisibility(View.GONE);
                    central_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.incheon_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (incheonairport_btn.getVisibility() == View.GONE) {
                    incheonairport_btn.setVisibility(View.VISIBLE);
                    sungnam_btn.setVisibility(View.VISIBLE);
                    suwon_btn.setVisibility(View.VISIBLE);
                    ansan_btn.setVisibility(View.VISIBLE);
                    yongin_btn.setVisibility(View.VISIBLE);
                } else {
                    incheonairport_btn.setVisibility(View.GONE);
                    sungnam_btn.setVisibility(View.GONE);
                    suwon_btn.setVisibility(View.GONE);
                    ansan_btn.setVisibility(View.GONE);
                    yongin_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.kangwon_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (gangneung_btn.getVisibility() == View.GONE) {
                    gangneung_btn.setVisibility(View.VISIBLE);
                    sokcho_btn.setVisibility(View.VISIBLE);
                    chunchun_btn.setVisibility(View.VISIBLE);
                } else {
                    gangneung_btn.setVisibility(View.GONE);
                    sokcho_btn.setVisibility(View.GONE);
                    chunchun_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.sejong_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (daejun_bus_btn.getVisibility() == View.GONE) {
                    daejun_bus_btn.setVisibility(View.VISIBLE);
                    sejong_bus_btn.setVisibility(View.VISIBLE);
                } else {
                    daejun_bus_btn.setVisibility(View.GONE);
                    sejong_bus_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.chungnam_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (nonsan_btn.getVisibility() == View.GONE) {
                    nonsan_btn.setVisibility(View.VISIBLE);
                    cheonan_btn.setVisibility(View.VISIBLE);
                    gongju_btn.setVisibility(View.VISIBLE);
                } else {
                    nonsan_btn.setVisibility(View.GONE);
                    cheonan_btn.setVisibility(View.GONE);
                    gongju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.chungbuk_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (cheongju_btn.getVisibility() == View.GONE) {
                    cheongju_btn.setVisibility(View.VISIBLE);
                    chungju_btn.setVisibility(View.VISIBLE);
                    jechun_btn.setVisibility(View.VISIBLE);
                } else {
                    cheongju_btn.setVisibility(View.GONE);
                    chungju_btn.setVisibility(View.GONE);
                    jechun_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.kwangju_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (kwangju_bus_btn.getVisibility() == View.GONE) {
                    kwangju_bus_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.VISIBLE);
                    damyang_btn.setVisibility(View.VISIBLE);
                    naju_btn.setVisibility(View.VISIBLE);
                } else {
                    kwangju_bus_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.GONE);
                    damyang_btn.setVisibility(View.GONE);
                    naju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.jeonbuk_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (jeonju_btn.getVisibility() == View.GONE) {
                    jeonju_btn.setVisibility(View.VISIBLE);
                    gunsan_btn.setVisibility(View.VISIBLE);
                    namwon_btn.setVisibility(View.VISIBLE);
                } else {
                    jeonju_btn.setVisibility(View.GONE);
                    gunsan_btn.setVisibility(View.GONE);
                    namwon_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.busan_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (busan_bus_btn.getVisibility() == View.GONE) {
                    busan_bus_btn.setVisibility(View.VISIBLE);
                    ulsan_btn.setVisibility(View.VISIBLE);
                    gimhae_btn.setVisibility(View.VISIBLE);
                } else {
                    busan_bus_btn.setVisibility(View.GONE);
                    ulsan_btn.setVisibility(View.GONE);
                    gimhae_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.daegu_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (eastdaegu_btn.getVisibility() == View.GONE) {
                    eastdaegu_btn.setVisibility(View.VISIBLE);
                    westdaegu_btn.setVisibility(View.VISIBLE);
                    gyeongju_btn.setVisibility(View.VISIBLE);
                } else {
                    eastdaegu_btn.setVisibility(View.GONE);
                    westdaegu_btn.setVisibility(View.GONE);
                    gyeongju_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.giyeok_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (gangneung_btn.getVisibility() == View.GONE) {
                    gangneung_btn.setVisibility(View.VISIBLE);
                    gyeongju_btn.setVisibility(View.VISIBLE);
                    gunsan_btn.setVisibility(View.VISIBLE);
                    kwangju_bus_btn.setVisibility(View.VISIBLE);
                    gongju_btn.setVisibility(View.VISIBLE);
                    gimhae_btn.setVisibility(View.VISIBLE);
                } else {
                    gangneung_btn.setVisibility(View.GONE);
                    gyeongju_btn.setVisibility(View.GONE);
                    gunsan_btn.setVisibility(View.GONE);
                    kwangju_bus_btn.setVisibility(View.GONE);
                    gongju_btn.setVisibility(View.GONE);
                    gimhae_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.nieun_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (nonsan_btn.getVisibility() == View.GONE) {
                    nonsan_btn.setVisibility(View.VISIBLE);
                    naju_btn.setVisibility(View.VISIBLE);
                    namwon_btn.setVisibility(View.VISIBLE);
                } else {
                    nonsan_btn.setVisibility(View.GONE);
                    naju_btn.setVisibility(View.GONE);
                    namwon_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.digeut_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (eastseoul_btn.getVisibility() == View.GONE) {
                    eastseoul_btn.setVisibility(View.VISIBLE);
                    daejun_bus_btn.setVisibility(View.VISIBLE);
                    damyang_btn.setVisibility(View.VISIBLE);
                    eastdaegu_btn.setVisibility(View.VISIBLE);
                } else {
                    eastseoul_btn.setVisibility(View.GONE);
                    daejun_bus_btn.setVisibility(View.GONE);
                    damyang_btn.setVisibility(View.GONE);
                    eastdaegu_btn.setVisibility(View.GONE);
                }
                break;
            case R.id.rieul_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                break;

            case R.id.mieum_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                break;

            case R.id.bieup_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (busan_bus_btn.getVisibility() == View.GONE) {
                    busan_bus_btn.setVisibility(View.VISIBLE);
                } else {
                    busan_bus_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.siot_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (central_btn.getVisibility() == View.GONE) {
                    central_btn.setVisibility(View.VISIBLE);
                    suwon_btn.setVisibility(View.VISIBLE);
                    sejong_btn.setVisibility(View.VISIBLE);
                    sokcho_btn.setVisibility(View.VISIBLE);
                    suncheon_btn.setVisibility(View.VISIBLE);
                    westdaegu_btn.setVisibility(View.VISIBLE);
                    sungnam_btn.setVisibility(View.VISIBLE);
                } else {
                    central_btn.setVisibility(View.GONE);
                    suwon_btn.setVisibility(View.GONE);
                    sejong_btn.setVisibility(View.GONE);
                    sokcho_btn.setVisibility(View.GONE);
                    suncheon_btn.setVisibility(View.GONE);
                    westdaegu_btn.setVisibility(View.GONE);
                    sungnam_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.ieung_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (incheonairport_btn.getVisibility() == View.GONE) {
                    incheonairport_btn.setVisibility(View.VISIBLE);
                    ansan_btn.setVisibility(View.VISIBLE);
                    yongin_btn.setVisibility(View.VISIBLE);
                    ulsan_btn.setVisibility(View.VISIBLE);
                } else {
                    incheonairport_btn.setVisibility(View.GONE);
                    ansan_btn.setVisibility(View.GONE);
                    yongin_btn.setVisibility(View.GONE);
                    ulsan_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.jieut_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (jeonju_btn.getVisibility() == View.GONE) {
                    jeonju_btn.setVisibility(View.VISIBLE);
                    jechun_btn.setVisibility(View.VISIBLE);
                } else {
                    jeonju_btn.setVisibility(View.GONE);
                    jechun_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.chieut_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);
                if (chunchun_btn.getVisibility() == View.GONE) {
                    chunchun_btn.setVisibility(View.VISIBLE);
                    cheonan_btn.setVisibility(View.VISIBLE);
                    cheongju_btn.setVisibility(View.VISIBLE);
                    chungju_btn.setVisibility(View.VISIBLE);
                } else {
                    chunchun_btn.setVisibility(View.GONE);
                    cheonan_btn.setVisibility(View.GONE);
                    cheongju_btn.setVisibility(View.GONE);
                    chungju_btn.setVisibility(View.GONE);
                }
                break;

            case R.id.kieuk_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);

                break;

            case R.id.tieut_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);

                break;

            case R.id.pieup_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);

                break;

            case R.id.hieut_btn:
                eastseoul_btn.setVisibility(View.GONE);
                central_btn.setVisibility(View.GONE);
                incheonairport_btn.setVisibility(View.GONE);
                sungnam_btn.setVisibility(View.GONE);
                suwon_btn.setVisibility(View.GONE);
                ansan_btn.setVisibility(View.GONE);
                yongin_btn.setVisibility(View.GONE);
                gangneung_btn.setVisibility(View.GONE);
                chunchun_btn.setVisibility(View.GONE);
                sokcho_btn.setVisibility(View.GONE);
                daejun_bus_btn.setVisibility(View.GONE);
                sejong_bus_btn.setVisibility(View.GONE);
                nonsan_btn.setVisibility(View.GONE);
                cheonan_btn.setVisibility(View.GONE);
                gongju_btn.setVisibility(View.GONE);
                cheongju_btn.setVisibility(View.GONE);
                jechun_btn.setVisibility(View.GONE);
                chungju_btn.setVisibility(View.GONE);
                kwangju_bus_btn.setVisibility(View.GONE);
                suncheon_btn.setVisibility(View.GONE);
                damyang_btn.setVisibility(View.GONE);
                naju_btn.setVisibility(View.GONE);
                jeonju_btn.setVisibility(View.GONE);
                gunsan_btn.setVisibility(View.GONE);
                namwon_btn.setVisibility(View.GONE);
                busan_bus_btn.setVisibility(View.GONE);
                ulsan_btn.setVisibility(View.GONE);
                gimhae_btn.setVisibility(View.GONE);
                eastdaegu_btn.setVisibility(View.GONE);
                westdaegu_btn.setVisibility(View.GONE);
                gyeongju_btn.setVisibility(View.GONE);

                break;
        }
    }



    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {

        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));

                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("동서울");
        list.add("센트럴시티");
        list.add("인천");
        list.add("인천공항");
        list.add("성남");
        list.add("수원");
        list.add("안산");
        list.add("용인");
        list.add("강릉");
        list.add("춘천");
        list.add("속초");
        list.add("대전");
        list.add("세종");
        list.add("논산");
        list.add("천안");
        list.add("공주");
        list.add("충주");
        list.add("제천");
        list.add("청주");
        list.add("광주(유스퀘어)");
        list.add("순천");
        list.add("담양");
        list.add("나주");
        list.add("전주");
        list.add("나주");
        list.add("전주");
        list.add("군산");
        list.add("남원");
        list.add("부산");
        list.add("울산");
        list.add("김해");
        list.add("동대구");
        list.add("서대구");
        list.add("경주");
    }
    private void mapSettig(){
        destinationMap.put("동서울", eastseoul_btn);
        destinationMap.put("센트럴시티", central_btn);
        destinationMap.put("인천", incheon_btn);
        destinationMap.put("인천공항", incheonairport_btn);
        destinationMap.put("성남", sungnam_btn);
        destinationMap.put("수원", suwon_btn);
        destinationMap.put("안산", ansan_btn);
        destinationMap.put("용인", yongin_btn);
        destinationMap.put("강릉", gangneung_btn);
        destinationMap.put("춘천", chunchun_btn);
        destinationMap.put("속초", sokcho_btn);
        destinationMap.put("대전", daejun_bus_btn);
        destinationMap.put("세종", sejong_bus_btn);
        destinationMap.put("논산", nonsan_btn);
        destinationMap.put("천안", cheonan_btn);
        destinationMap.put("공주", gongju_btn);
        destinationMap.put("충주", chungju_btn);
        destinationMap.put("제천", jechun_btn);
        destinationMap.put("청주", cheongju_btn);
        destinationMap.put("광주(유스퀘어)", kwangju_bus_btn);
        destinationMap.put("순천", suncheon_btn);
        destinationMap.put("담양", damyang_btn);
        destinationMap.put("나주", naju_btn);
        destinationMap.put("전주", jeonju_btn);
        destinationMap.put("군산", gunsan_btn);
        destinationMap.put("남원", namwon_btn);
        destinationMap.put("부산", busan_bus_btn);
        destinationMap.put("울산", ulsan_btn);
        destinationMap.put("김해", gimhae_btn);
        destinationMap.put("동대구", eastdaegu_btn);
        destinationMap.put("서대구", westdaegu_btn);
        destinationMap.put("경주", gyeongju_btn);
    }
}


