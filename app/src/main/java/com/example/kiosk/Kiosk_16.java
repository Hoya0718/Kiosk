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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Kiosk_16 extends AppCompatActivity implements View.OnClickListener {
    private List<String> list;          // 데이터를 넣은 리스트변수
    private EditText editText;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private Map<String, Button> destinationMap;     //목적지 해쉬맵

    private TextToSpeech tts;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    private int currentVolume;
    private AudioManager audioManager;
    Handler handler = new Handler();

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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk16);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        giyeok_btn = findViewById(R.id.giyeok_btn); nieun_btn = findViewById(R.id.nieun_btn);
        digeut_btn = findViewById(R.id.digeut_btn); rieul_btn = findViewById(R.id.rieul_btn);
        mieum_btn = findViewById(R.id.mieum_btn); bieup_btn = findViewById(R.id.bieup_btn);
        siot_btn = findViewById(R.id.siot_btn); ieung_btn = findViewById(R.id.ieung_btn);
        jieut_btn = findViewById(R.id.jieut_btn); chieut_btn = findViewById(R.id.chieut_btn);
        kieuk_btn = findViewById(R.id.kieuk_btn); tieut_btn = findViewById(R.id.tieut_btn);
        pieup_btn= findViewById(R.id.pieup_btn); hieut_btn = findViewById(R.id.hieut_btn);
        seoul_btn = findViewById(R.id.seoul_btn); busan_btn = findViewById(R.id.busan_btn);
        chungbuk_btn = findViewById(R.id.chungbuk_btn); chungnam_btn = findViewById(R.id.chungnam_btn);
        daegu_btn = findViewById(R.id.daegu_btn); incheon_btn = findViewById(R.id.incheon_btn);
        jeonbuk_btn = findViewById(R.id.jeonbuk_btn); kwangju_btn = findViewById(R.id.kwangju_btn);
        sejong_btn = findViewById(R.id.sejong_btn); kangwon_btn = findViewById(R.id.kangwon_btn);
        central_btn = findViewById(R.id.central_btn); eastseoul_btn = findViewById(R.id.eastseoul_btn);
        incheonairport_btn = findViewById(R.id.incheonairport_btn);
        sungnam_btn = findViewById(R.id.sungnam_btn); suwon_btn = findViewById(R.id.suwon_btn);
        ansan_btn = findViewById(R.id.ansan_btn); yongin_btn = findViewById(R.id.yongin_btn);
        gangneung_btn = findViewById(R.id.gangneung_btn); chunchun_btn = findViewById(R.id.chunchun_btn);
        sokcho_btn = findViewById(R.id.sokcho_btn); daejun_bus_btn = findViewById(R.id.daejun_bus_btn);
        sejong_bus_btn = findViewById(R.id.sejong_bus_btn); nonsan_btn = findViewById(R.id.nonsan_btn);
        cheonan_btn = findViewById(R.id.cheonan_btn); gongju_btn = findViewById(R.id.gongju_btn);
        cheongju_btn = findViewById(R.id.cheongju_btn); chungju_btn = findViewById(R.id.chungju_btn);
        jechun_btn = findViewById(R.id.jechun_btn); kwangju_bus_btn = findViewById(R.id.kwangju_bus_btn);
        suncheon_btn = findViewById(R.id.suncheon_btn); damyang_btn = findViewById(R.id.damyang_btn);
        naju_btn = findViewById(R.id.naju_btn); jeonju_btn = findViewById(R.id.jeonju_btn);
        gunsan_btn = findViewById(R.id.gunsan_btn); namwon_btn = findViewById(R.id.namwon_btn);
        busan_bus_btn = findViewById(R.id.busan_bus_btn); ulsan_btn = findViewById(R.id.ulsan_btn);
        gimhae_btn = findViewById(R.id.gimhae_btn); eastdaegu_btn = findViewById(R.id.eastdaegu_btn);
        westdaegu_btn = findViewById(R.id.westdaegu_btn); gyeongju_btn = findViewById(R.id.gyeongju_btn);
        button3 = findViewById(R.id.button3);

        giyeok_btn.setTextSize(text_size.getId()); nieun_btn.setTextSize(text_size.getId());
        digeut_btn.setTextSize(text_size.getId()); rieul_btn.setTextSize(text_size.getId());
        mieum_btn.setTextSize(text_size.getId()); bieup_btn.setTextSize(text_size.getId());
        siot_btn.setTextSize(text_size.getId()); ieung_btn.setTextSize(text_size.getId());
        jieut_btn.setTextSize(text_size.getId()); chieut_btn.setTextSize(text_size.getId());
        kieuk_btn.setTextSize(text_size.getId()); tieut_btn.setTextSize(text_size.getId());
        pieup_btn.setTextSize(text_size.getId()); hieut_btn.setTextSize(text_size.getId());
        sejong_btn.setTextSize(text_size.getId()); seoul_btn.setTextSize(text_size.getId());
        incheon_btn.setTextSize(text_size.getId()); busan_btn.setTextSize(text_size.getId());
        kangwon_btn.setTextSize(text_size.getId()); kwangju_btn.setTextSize(text_size.getId());
        jeonbuk_btn.setTextSize(text_size.getId()); chungnam_btn.setTextSize(text_size.getId());
        chungbuk_btn.setTextSize(text_size.getId()); daegu_btn.setTextSize(text_size.getId());
        central_btn.setTextSize(text_size.getId()); eastseoul_btn.setTextSize(text_size.getId());
        incheonairport_btn.setTextSize(text_size.getId());
        sungnam_btn.setTextSize(text_size.getId()); suwon_btn.setTextSize(text_size.getId());
        ansan_btn.setTextSize(text_size.getId()); yongin_btn.setTextSize(text_size.getId());
        gangneung_btn.setTextSize(text_size.getId()); chunchun_btn.setTextSize(text_size.getId());
        sokcho_btn.setTextSize(text_size.getId()); daejun_bus_btn.setTextSize(text_size.getId());
        sejong_bus_btn.setTextSize(text_size.getId()); nonsan_btn.setTextSize(text_size.getId());
        cheonan_btn.setTextSize(text_size.getId()); gongju_btn.setTextSize(text_size.getId());
        cheongju_btn.setTextSize(text_size.getId()); chungju_btn.setTextSize(text_size.getId());
        jechun_btn.setTextSize(text_size.getId()); kwangju_bus_btn.setTextSize(text_size.getId());
        suncheon_btn.setTextSize(text_size.getId()); damyang_btn.setTextSize(text_size.getId());
        naju_btn.setTextSize(text_size.getId()); jeonju_btn.setTextSize(text_size.getId());
        gunsan_btn.setTextSize(text_size.getId()); namwon_btn.setTextSize(text_size.getId());
        busan_bus_btn.setTextSize(text_size.getId()); ulsan_btn.setTextSize(text_size.getId());
        gimhae_btn.setTextSize(text_size.getId()); eastdaegu_btn.setTextSize(text_size.getId());
        westdaegu_btn.setTextSize(text_size.getId()); gyeongju_btn.setTextSize(text_size.getId());
        button3.setTextSize(text_size.getId());

        busan_btn.setOnClickListener(this); jeonbuk_btn.setOnClickListener(this);
        seoul_btn.setOnClickListener(this); incheon_btn.setOnClickListener(this);
        kwangju_btn.setOnClickListener(this); sejong_btn.setOnClickListener(this);
        kangwon_btn.setOnClickListener(this); daegu_btn.setOnClickListener(this);
        chungbuk_btn.setOnClickListener(this); chungnam_btn.setOnClickListener(this);
        giyeok_btn.setOnClickListener(this); nieun_btn.setOnClickListener(this);
        digeut_btn.setOnClickListener(this); rieul_btn.setOnClickListener(this);
        mieum_btn.setOnClickListener(this); bieup_btn.setOnClickListener(this);
        siot_btn.setOnClickListener(this); ieung_btn.setOnClickListener(this);
        jieut_btn.setOnClickListener(this); chieut_btn.setOnClickListener(this);
        kieuk_btn.setOnClickListener(this); tieut_btn.setOnClickListener(this);
        pieup_btn.setOnClickListener(this); hieut_btn.setOnClickListener(this);

        editText =  findViewById(R.id.editText);


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

                    for(Map.Entry<String, Button>item : destinationMap.entrySet()){
                        item.getValue().setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                if (editText.length() > 0){
                    String text = editText.getText().toString();

                    search(text);
                }
                for(Map.Entry<String, Button>item : destinationMap.entrySet()){
                    item.getValue().setVisibility(View.GONE);
                }


                for(String a: list) {
                    Log.d("listLog", a);
                    Log.d("listLog", String.valueOf(destinationMap.get(a).getText()));
                    if(!destinationMap.get(a).equals(null)) {
                        destinationMap.get(a).setVisibility(View.VISIBLE);
                    }
                    if(editText.length() == 0){
                        for(Map.Entry<String, Button>item : destinationMap.entrySet()){
                            item.getValue().setVisibility(View.GONE);
                        }
                    }
                }

            }
        });


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("이곳에서는 도착지를 선택하실 수 있습니다. 가고 싶은 도착지를 찾을 수 있는 방법은 3가지가 있습니다. 첫번째 방법은 화면 왼쪽에 있는 서울, 강원도, 충청남도, 전라북도처럼 지역 이름이 써진 버튼을 누르면 " +
                                "그 지역에 있는 모든 버스정류장들이 출력됩니다. 두번째 방법은 ㄱ,ㄴ,ㄷ 처럼 앞 글자가 써진 버튼을 누르면 그 단어로 시작하는 정류장들을 찾을 수 있습니다." +
                                "마지막으로 화면 맨 위에 있는 목적지를 입력해주세요 라고 써진 칸을 누르게 되면 아래쪽에 키보드가 나오면서 검색을 할 수 있게 됩니다." +
                                "키보드에 가고 싶은 곳을 검색하면 빈 화면에 검색한 도착지 버튼이 나옵니다. 버튼을 누르면 가고 싶은 곳을 고를 수 있습니다." +
                                "동서울을 찾아볼까요? 동서울은 서울 지역에 있으니 서울 버튼을 눌러도 되고, ㄷ으로 시작하니 ㄷ 버튼을 눌러도 됩니다." +
                                "만약 찾기 힘드시다면 검색을 사용해서 찾으실 수 있습니다.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Here you can select your destination. There are 3 ways to find the destination you want to go to." +
                                "In the first method, if you press the button with the name of a region such as Seoul, Gangwon-do, Chungcheongnam-do, and Jeollabuk-do on the left side of the screen, all bus stops in that region are output." +
                                "In the second way, if you press the button with the first letter written like a, b, c, you can find stops that start with that word. Finally, if you press the box that says \"Please enter a destination\" at the top of the screen, a keyboard appears at the bottom and you can search." +
                                "When you search for a place you want to go on the keyboard, the searched destination button appears on a blank screen." +
                                "You can choose the place you want to go by pressing the button. Shall we look for Dong Seoul? East Seoul is located in the Seoul area, so you can press the Seoul button, or you can press the C button since it starts with a letter. If you have trouble finding it, you can use the search to find it.");
                    }

                    eastseoul_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_18.class);
                            intent.putExtra("destination", "동서울");
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });


                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_16.this, Kiosk_15.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });

                }
            }
        });
        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                // TTS가 말하기 시작했습니다.
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                // TTS가 말하기 끝났습니다.
                // 다른 코드를 실행합니다.

                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("서울 버튼, ㄷ 버튼을  눌러서 동서울을 찾을 수 있습니다." +
                                            "다른　방법으로는　반짝거리고　있는　검색창을　눌러서　검색하실　수　있습니다．");
                                else
                                    speakText("You can find East Seoul by pressing the Seoul button and the ㄷ button." +
                                            "Alternatively, you can search by tapping on the “flashing” search box.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            seoul_btn.setBackgroundResource(R.drawable.anim_list);
                            digeut_btn.setBackgroundResource(R.drawable.anim_list);
                            eastseoul_btn.setBackgroundResource(R.drawable.anim_list);
                            editText.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable) seoul_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) digeut_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) eastseoul_btn.getBackground();
                            anim.start();
                            anim = (AnimationDrawable) editText.getBackground();
                            anim.start();
                        }
                    }, 2000);
                    Log.d("delaySpeak", "onDone");
                    one=false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak", "onError");
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
    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
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


