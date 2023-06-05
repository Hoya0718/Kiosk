package com.example.kiosk;

import static java.util.Locale.KOREAN;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.UUID;

import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BluetoothConnection";
    private static final String ARDUINO_MAC_ADDRESS = "00:21:09:01:2A:2B"; // 아두이노의 실제 블루투스 맥 주소로 대체해야 합니다.
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // 아두이노와 동일한 UUID 사용

    private int readBufferPosition; //버퍼  내 문자 저장 위치
    private BluetoothSocket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private TextToSpeech tts;
    private BluetoothDevice arduinoDevice;
    private Button practice_Btn;
    Handler handler = new Handler();
    private AnimationDrawable anim;

    private BluetoothAdapter bluetoothAdapter;
    private Thread workerThread = null; //문자열 수신에 사용되는 쓰레드
    private byte[] readBuffer; //수신된 문자열 저장 버퍼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practice_Btn = findViewById(R.id.practice_Btn);

        String[] permission_list;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permission_list = new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.BLUETOOTH_SCAN,
                    android.Manifest.permission.BLUETOOTH_ADMIN,
                    android.Manifest.permission.BLUETOOTH_ADVERTISE,
                    android.Manifest.permission.BLUETOOTH_CONNECT,
            };
        } else {
            permission_list = new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
            };
        }

        ActivityCompat.requestPermissions(MainActivity.this, permission_list, 1); // 각자의 클래스명 지정해야합니다.

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // BluetoothAdapter 초기화
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // 디바이스가 블루투스를 지원하지 않는 경우 처리
            return;
        }

        //여기까지


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                tts.setLanguage(KOREAN);
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(KOREAN);
                        speakText("안녕하세요 교육용 키오스크입니다. 저를 따라오시면 키오스크의 사용이 쉬워질거에요. 처음 사용하시는 경우 연습을 눌러볼까요?");

                    } else {
                        getResources().getConfiguration().locale.getLanguage().equals("en");
                        tts.setLanguage(Locale.ENGLISH);
                        speakText("Hello, this is the training kiosk. Follow me and the kiosk will be easy to use. If this is your first time, let's hit practice?");
                    }
                }
            }
        });

        /*
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                    speakText("연습은 여기에있어요 연습을 눌러보세요.");
                else
                    speakText("The practice button is here, click Practice");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        practice_Btn.setBackgroundResource(R.drawable.anim_list);
                        anim = (AnimationDrawable) practice_Btn.getBackground();
                        anim.start();
                    }
                }, 2000);
            }
        }, 10000);
        */



        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;
            @Override
            public void onStart(String delaySpeak) {
                Log.d("delaySpeak", "onstart");
            }

            @Override
            public void onDone(String delaySpeak) {
                if(one) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //tts
                            if (!tts.isSpeaking()) {
                                if (getResources().getConfiguration().locale.getLanguage().equals("ko"))
                                    speakText("연습은 여기에있어요 연습을 눌러보세요.");
                                else
                                    speakText("The practice button is here, click Practice");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            practice_Btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)practice_Btn.getBackground();
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

    //여기도 추가


    // onDestroy가 두개라 하나로 합쳐줌
    protected void onDestroy() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }


    // 여기까지

    private void speakText(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }

    public void goto_kiosk02(View v){
        tts.shutdown();
        Intent intent = new Intent(getApplicationContext(),Kiosk_2.class);
        startActivity(intent);
    }
    public void goto_Kiosk_R_Part(View v){
        tts.shutdown();
        Intent goto_Kiosk_R_Part = new Intent(getApplicationContext(), Kiosk_R_Part.class);
        startActivity(goto_Kiosk_R_Part);
    }
    public void change_to_korean(View v) {

        tts.shutdown();
        Locale newLocale = new Locale("ko");
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //Intent goto_Kiosk_R_Part = new Intent(this, Kiosk_R_Part.class);
        //startActivity(goto_Kiosk_R_Part);
    }
    public void change_to_english(View v) {

        tts.shutdown();
        Locale newLocale = new Locale("en");
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }

}