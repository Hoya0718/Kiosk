package com.example.kiosk;

import android.app.Application;
import android.speech.tts.TextToSpeech;

public class myapp extends Application {



    protected int id=18;
    private int ttsVolume;
    private float ttsSpeed;

    private String get_pn;

    private String get_pn_2;
    private long day;

    private String department;
    public void setGet_pn_2(String a) {this.get_pn_2 =a;}

    public String getGet_pn_2() {return get_pn_2;}
    public void setDepartment(String a) {this.department =a;}

    public String getDepartment() { return this.department;}
    public long getDay() { return this.day;}
    public void setDay(long a) { this.day =a;}



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
