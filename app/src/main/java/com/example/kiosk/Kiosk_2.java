package com.example.kiosk;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Kiosk_2 extends AppCompatActivity {

    private TextToSpeech tts;
    private myapp text_size;
    private TextView korean_text;

    private Button size_down_Btn;

    private Button save_Btn;
    private Button size_medium_btn;

    Handler handler = new Handler();
    private Button size_up_Btn;
    private myapp sound;

    private AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk02);

        float fontSizeLarge = getResources().getDimension(R.dimen.font_size_large);
        float fontSizeMedium = getResources().getDimension(R.dimen.font_size_medium);
        float fontSizeSmall = getResources().getDimension(R.dimen.font_size_small);

        size_down_Btn = findViewById(R.id.size_down_Btn);
        size_medium_btn = findViewById(R.id.size_medium_btn);
        size_up_Btn = findViewById(R.id.size_up_Btn);
        save_Btn = findViewById(R.id.save_Btn);

        sound = (myapp) getApplication();

        text_size =(myapp) getApplication();
        korean_text = findViewById(R.id.korean_text);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                        tts.setLanguage(Locale.KOREAN); // TTS 언어 설정
                        speakText("키오스크의 글자 크기를 설정합니다. 작게, 중간, 크게로 글자 크기를 적용하시고 다음을 눌러주세요.");
                    } else {
                        tts.setLanguage(Locale.ENGLISH); // TTS 언어 설정
                        speakText("Set the font size for the kiosk. Try small, medium, and large font sizes.");
                    }
                }
            }
        });

        /*
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
                                    speakText("글자 크기는 여기서 조절할수 있어요. 가나다의 크기를 확인하시고 글자크기를 조절해보세요.");
                                else
                                    speakText("You can adjust the size of the text here. Check the size of the columns and adjust the size of the text.");
                                Log.d("test", "isSpeaking true");
                            } else Log.d("test", "isSpeeking false");
                            //버튼
                            size_down_Btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)size_down_Btn.getBackground();
                            anim.start();
                            size_medium_btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)size_medium_btn.getBackground();
                            anim.start();
                            size_up_Btn.setBackgroundResource(R.drawable.anim_list);
                            anim = (AnimationDrawable)size_up_Btn.getBackground();
                            anim.start();
                            save_Btn.setBackgroundResource(R.drawable.anim_list2);
                            anim = (AnimationDrawable)save_Btn.getBackground();
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
        });*/
    }


    private void speakText(String text) {

        tts.setSpeechRate(sound.getTtsSpeed()) ;
        sound.getTtsVolume();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"delaySpeak");
    }
    public void goto_main(View v){
        tts.shutdown();
        Intent goto_main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goto_main);
    }
    public void goto_kiosk_04(View v){
        tts.shutdown();
        Intent goto_kiosk_04 = new Intent(getApplicationContext(), Kiosk_4.class);
        startActivity(goto_kiosk_04);
    }
    public void be_down(View v){

        korean_text.setTextSize(Dimension.SP,16);
        text_size.setId(16);
    }
    public void be_medium(View v){

        korean_text.setTextSize(Dimension.SP,22);
        text_size.setId(22);
    }
    public void be_up(View v){

        korean_text.setTextSize(Dimension.SP,26);
        text_size.setId(26);
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
}