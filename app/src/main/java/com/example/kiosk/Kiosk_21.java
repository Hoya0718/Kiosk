package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

public class Kiosk_21 extends AppCompatActivity {
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM dd (E)", Locale.KOREAN);
    private String departuretime = "출발 시간";
    private String destination = "목적지";
    private String price = "표 가격";
    private String seat = "좌석 번호";

    private TextView textView3, textView5, textView6, textView9, textView12, textView14, textView16, textView20, textView21, textView22;
    private TextToSpeech tts;//
    private int currentVolume;
    private AudioManager audioManager;
    private myapp sound;
    private myapp text_size;
    private AnimationDrawable anim;
    Handler handler = new Handler();

    private Button b_cancel_btn;

    private static final String TAG = "BluetoothConnection";
    private static final String ARDUINO_MAC_ADDRESS = "00:21:09:01:2A:2B"; // 아두이노의 실제 블루투스 맥 주소로 대체해야 합니다.
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // 아두이노와 동일한 UUID 사용

    private Thread workerThread = null; //문자열 수신에 사용되는 쓰레드
    private byte[] readBuffer; //수신된 문자열 저장 버퍼

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice arduinoDevice;
    private int readBufferPosition; //버퍼  내 문자 저장 위치
    private BluetoothSocket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk21);

        sound = (myapp) getApplication();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        text_size = (myapp) getApplication();

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView9 = findViewById(R.id.textView9);
        textView12 = findViewById(R.id.textView12);
        textView14 = findViewById(R.id.textView14);
        textView16 = findViewById(R.id.textView16);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        b_cancel_btn = findViewById(R.id.b_cancel_btn);

        textView3.setTextSize(text_size.getId());
        textView5.setTextSize(text_size.getId());
        textView6.setTextSize(text_size.getId());
        textView9.setTextSize(text_size.getId());
        textView12.setTextSize(text_size.getId());
        textView14.setTextSize(text_size.getId());
        textView16.setTextSize(text_size.getId());
        textView20.setTextSize(text_size.getId());
        textView21.setTextSize(text_size.getId());
        textView22.setTextSize(text_size.getId());
        b_cancel_btn.setTextSize(text_size.getId());

        Intent intent = getIntent();
        String departuretime = intent.getStringExtra("departuretime");
        String destination = intent.getStringExtra("destination");
        String bus = intent.getStringExtra("bus");
        String seat = intent.getStringExtra("seat");
        String price = intent.getStringExtra("price");

        textView3.setText(departuretime);
        textView5.setText(destination);
        textView16.setText(bus);
        textView20.setText(seat);
        textView21.setText(price);

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

        ActivityCompat.requestPermissions(Kiosk_21.this, permission_list, 1); // 각자의 클래스명 지정해야합니다.

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // BluetoothAdapter 초기화
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // 디바이스가 블루투스를 지원하지 않는 경우 처리
            return;
        }

        // 아두이노 디바이스 생성
        arduinoDevice = bluetoothAdapter.getRemoteDevice(ARDUINO_MAC_ADDRESS);

        // BluetoothSocket을 통한 연결 수립
        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            socket = arduinoDevice.createRfcommSocketToServiceRecord(MY_UUID);
            socket.connect();

            // InputStream과 OutputStream 설정
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            // 아두이노로부터 데이터 읽기 예시
            readDataFromArduino();

        } catch (IOException e) {
            // 연결 실패 처리
            e.printStackTrace();
        }

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    sound.setTtsVolume(currentVolume);
                    if(getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("목적지는 맞게 골랐는지. 버스 종류와 좌석은 정확하게 골랐는지 확인해주시고," +
                                "알맞게 고르셨다면 화면의 이미지처럼 카드를 키오스크 아래쪽에 갖다 대 주시면 다음 화면으로 넘어갈 수 있습니다." +
                                "만약 잘못 고르셨다면 취소하기 버튼을 눌러서 이전 화면으로 돌아가실 수 있습니다.");
                    }
                    else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Make sure you have chosen the correct destination, bus type and seat." +
                                "If you have chosen the right one, you can move to the next screen by holding the card to the bottom of the kiosk as shown in the image on the screen." +
                                "If you make a mistake, you can click the Cancel button to return to the previous screen.");
                    }

                    Calendar c = Calendar.getInstance();

                    SimpleDateFormat format;

                    if(getResources().getConfiguration().locale.getLanguage().equals("ko"))
                        format = new SimpleDateFormat("yyyy/MM/dd(E)", Locale.KOREAN);
                    else
                        format = new SimpleDateFormat("yyyy/MMM/dd(E)", Locale.ENGLISH);
                    textView22.setText(format.format(c.getTime()));

                    b_cancel_btn = findViewById(R.id.b_cancel_btn);

                    b_cancel_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Kiosk_21.this, Kiosk_16.class);
                            tts.shutdown();
                            startActivity(intent);
                        }
                    });
                }
            }
        });

        Log.d("delaySpeak1", "start");
        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            boolean one = true;

            @Override
            public void onStart(String delaySpeak) {
                // TTS가 말하기 시작했습니다.
                Log.d("delaySpeak1", "onstart");
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
                                    speakText("결제하기 버튼을 눌러주세요.");
                                else
                                    speakText("Please click the Make Payment button.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");

                        }
                    }, 2000);
                    Log.d("delaySpeak1", "onDone");
                    one=false;
                }
            }

            @Override
            public void onError(String delaySpeak) {
                //에러 발생시
                Log.d("delaySpeak1", "onError");
            }
        });
        Log.d("delaySpeak1", "end");
    }

    private void readDataFromArduino() {
        final Handler handler = new Handler();
        // 데이터를 수신하기 위한 버퍼를 생성
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        // 데이터를 수신하기 위한 쓰레드 생성
        workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    try {
                        // 데이터를 수신했는지 확인합니다.
                        int byteAvailable = inputStream.available();

                        // 데이터가 수신 된 경우
                        if(byteAvailable > 0) {
                            // 입력 스트림에서 바이트 단위로 읽어 옵니다.
                            byte[] bytes = new byte[byteAvailable];
                            inputStream.read(bytes);
                            // 입력 스트림 바이트를 한 바이트씩 읽어 옵니다.
                            for(int i = 0; i < byteAvailable; i++) {
                                byte tempByte = bytes[i];
                                // 개행문자를 기준으로 받음(한줄)
                                if(tempByte == '\n') {
                                    // readBuffer 배열을 encodedBytes로 복사
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    // 인코딩 된 바이트 배열을 문자열로 변환
                                    final String text = new String(encodedBytes, "UTF-8");
                                    readBufferPosition = 0;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            if (text.contains("success")) {
                                                Intent intent = new Intent(Kiosk_21.this, Kiosk_23.class); //(해당클래스명.this, 다음 클래스명.class)
                                                tts.shutdown();
                                                disconnectBluetooth();
                                                startActivity(intent);

                                            }
                                        }
                                    });
                                } // 개행 문자가 아닐 경우
                                else {
                                    readBuffer[readBufferPosition++] = tempByte;
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        // 1초마다 받아옴
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        workerThread.start();
    }


    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "delaySpeak");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred while closing the socket: " + e.getMessage());
            }
        }
        super.onDestroy();
    }
    private void disconnectBluetooth() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }
}