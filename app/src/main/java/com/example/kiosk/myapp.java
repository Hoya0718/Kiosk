package com.example.kiosk;

import android.app.Application;
import android.speech.tts.TextToSpeech;

public class myapp extends Application {

    protected int id=18;

    private TextToSpeech tts;
    private int ttsVolume;
    private float ttsSpeed;

    private String get_pn;

    public void setGet_pn(String a) {this.get_pn =a;}
    public  String getGet_pn(){return  this.get_pn;}
    public float getTtsVolume(){return this.ttsVolume;}
    public void setTtsVolume(int a) {this.ttsVolume =a;}

    public float getTtsSpeed() {return this.ttsSpeed;}

    public void setTtsSpeed(float ttsSpeed) {this.ttsSpeed=ttsSpeed;}

    public int getId() {
        return this.id;
    }

    public void setId(int a) {
        this.id = a;
    }
}
