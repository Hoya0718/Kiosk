package com.example.kiosk;

import android.app.Application;
import android.speech.tts.TextToSpeech;

public class myapp extends Application {

    protected int id=18;
    private TextToSpeech tts;
    private float ttsVolume = 1.0f;
    private float ttsSpeed = 1.0f;

    public float getTtsVolume() {
        return ttsVolume;
    }

    public void setTtsVolume(float a){ this.ttsVolume = a;}
    public int getId() {
        return this.id;
    }

    public void setId(int a) {
        this.id = a;
    }
}
