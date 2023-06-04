package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.UUID;

public class Kiosk_30 extends AppCompatActivity {


    private TextToSpeech tts;

    //블루투스 선언 코드는 여기부터

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

    // 여기까지

    private myapp sound;
    private myapp text_size;
    private Button hos_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk30);

        text_size = (myapp) getApplication();
        sound = (myapp) getApplication();
        hos_cancel = findViewById(R.id.hos_cancel);

        hos_cancel.setTextSize(text_size.getId());

        //블루투스 추가 코드는 여기서 부터


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

        ActivityCompat.requestPermissions(Kiosk_30.this, permission_list, 1); // 각자의 클래스명 지정해야합니다.

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

        //여기까지

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("마지막으로 결제하는 방법을 알아보겠습니다. 결제는 화면과 같이 키오스크 하단에 있는 네모에 카드르 3초간 가져다 주시면 화면이 전환이 돕니다.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Finally, let's see how to make a payment. To make a payment, you need to touch your card to the square at the bottom of the kiosk for 3 seconds and the screen will switch, as shown on the screen.");
                    }
                }
            }
        });

    }

    //여기도 추가

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
                                                Intent intent = new Intent(Kiosk_30.this, Kiosk_30_2.class); //(해당클래스명.this, 다음 클래스명.class)
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

    // onDestroy가 두개라 하나로 합쳐줌
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

    // 여기까지


    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

   /* public void goto_kiosk_30_2(View v) {
        tts.shutdown();
        Intent goto_kiosk_30_2 = new Intent(getApplicationContext(), Kiosk_30_2.class);
        startActivity(goto_kiosk_30_2);

    }*/

    protected void onPause() {
        if (tts != null) {
            // TTS 발화 중지
            tts.stop();
        }
        super.onPause();
    }

    public void cancel (View v){
        tts.shutdown();
        Intent cancel = new Intent (getApplicationContext(), Kiosk_29_2.class);
        disconnectBluetooth();
        startActivity(cancel);
    }
}