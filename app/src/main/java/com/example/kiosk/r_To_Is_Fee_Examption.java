package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class r_To_Is_Fee_Examption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_is_fee_examption);
    }
    public void goto_get_Num(View v){
        Intent goto_get_Num = new Intent(getApplicationContext(), r_To_Get_Num.class);
        goto_get_Num.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_get_Num);
    }
    public void goto_get_Num_yes(View v){
        Intent goto_get_Num_yes = new Intent(getApplicationContext(), r_To_Get_Num_Yes.class);
        goto_get_Num_yes.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_get_Num_yes);
    }
    public void goto_add(View v){
        Intent goto_add = new Intent(getApplicationContext(), r_To_Add.class);
        goto_add.putExtra("TO_destination", getIntent().getStringExtra("TO_destination"));
        startActivity(goto_add);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
}