package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kiosk_R_Part extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiosk_r_part);
    }

   // public void goto_Kiosk_R_ (View v){
    //    Intent goto_Kiosk_R_ = new Intent(getApplicationContext(),Kiosk_R_.class);
    //    startActivity(Kiosk_R_);
  //      finish();
  //  }

  //  public void goto_Kiosk_R_ (View v){
   //     Intent goto_Kiosk_R_ = new Intent(getApplicationContext(),Kiosk_R_.class);
  //      startActivity(Kiosk_R_);
  //      finish();
  //  }

    public void goto_Kiosk_R_Hospital (View v){
        Intent goto_Kiosk_R_Hospital = new Intent(getApplicationContext(),Kiosk_R_Hospital.class);
        startActivity(goto_Kiosk_R_Hospital);
    }

    public void goto_Kiosk_Main (View v){
        Intent goto_Kiosk_Main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goto_Kiosk_Main);
    }

}