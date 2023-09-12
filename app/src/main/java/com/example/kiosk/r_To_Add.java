package com.example.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class r_To_Add extends AppCompatActivity {

    private Drawable img;
    // TextView 사용 선언----------------------------------------------------------------------------
    private TextView to_btn_check_1;
    // TextView 사용 선언----------------------------------------------------------------------------
    // Button --------------------------------------------------------------------------------------
    private Button to_btn_all, to_btn_not_all, past_a, past_a_not, family_config, family_config_not, family_config_day, family_config_day_not, report, report_not;
    private Button why, household, household_members, why_not, foreigner, foreigner_not, ssn_back, self, household_members_ssn, ssn_back_not;
    private Button relation, relation_not, partner, partner_not;

    private Drawable originalBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_add);

        to_btn_all = findViewById(R.id.to_btn_all);
        to_btn_not_all = findViewById(R.id.to_btn_not_all);
        past_a_not = findViewById(R.id.past_a_not);
        past_a = findViewById(R.id.past_a);
        to_btn_check_1 = findViewById(R.id.to_btn_check_1);
        family_config = findViewById(R.id.family_config);
        family_config_not = findViewById(R.id.family_config_not);
        family_config_day = findViewById(R.id.family_config_day);
        family_config_day_not = findViewById(R.id.family_config_day_not);
        report = findViewById(R.id.report);
        report_not = findViewById(R.id.report_not);
        why = findViewById(R.id.why);
        household_members = findViewById(R.id.household_members);
        household = findViewById(R.id.household);
        why_not = findViewById(R.id.why_not);
        foreigner = findViewById(R.id.foreigner);
        foreigner_not = findViewById(R.id.foreigner_not);
        ssn_back = findViewById(R.id.ssn_back);
        self = findViewById(R.id.self);
        household_members_ssn = findViewById(R.id.household_member_ssn);
        ssn_back_not = findViewById(R.id.ssn_back_not);
        relation = findViewById(R.id.relation);
        relation_not = findViewById(R.id.relation_not);
        partner = findViewById(R.id.partner);
        partner_not = findViewById(R.id.partner_not);

        originalBackground = past_a_not.getBackground();
    }
    public void goto_fee_Exam(View v){
        Intent goto_fee_Exam = new Intent(getApplicationContext(), r_To_Is_Fee_Examption.class);
        startActivity(goto_fee_Exam);
    }
    public void goto_to_issuance(View v){
        Intent goto_to_issuance = new Intent(getApplicationContext(), r_To_Issuance_Info.class);
        startActivity(goto_to_issuance);
    }
    public void goto_to_main(View v){
        Intent goto_to_main = new Intent(getApplicationContext(), P_TO.class);
        startActivity(goto_to_main);
    }
    public void all(View v){
        past_a.setBackgroundResource(R.drawable.to_btn_orange_green);
        family_config.setBackgroundResource(R.drawable.to_btn_orange_green);
        family_config_day.setBackgroundResource(R.drawable.to_btn_orange_green);
        report.setBackgroundResource(R.drawable.to_btn_orange_green);
        why.setBackgroundResource(R.drawable.to_btn_orange_green);
        foreigner.setBackgroundResource(R.drawable.to_btn_orange_green);
        ssn_back.setBackgroundResource(R.drawable.to_btn_orange_green);
        relation.setBackgroundResource(R.drawable.to_btn_orange_green);
        partner.setBackgroundResource(R.drawable.to_btn_orange_green);

        past_a_not.setBackground(originalBackground);
        family_config_not.setBackground(originalBackground);
        family_config_day_not.setBackground(originalBackground);
        report_not.setBackground(originalBackground);
        why_not.setBackground(originalBackground);
        foreigner_not.setBackground(originalBackground);
        ssn_back_not.setBackground(originalBackground);
        relation_not.setBackground(originalBackground);
        partner_not.setBackground(originalBackground);
    }
    public void all_not(View v){
        past_a_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        family_config_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        family_config_day_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        report_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        why_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        foreigner_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        ssn_back_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        relation_not.setBackgroundResource(R.drawable.to_btn_orange_green);
        partner_not.setBackgroundResource(R.drawable.to_btn_orange_green);

        past_a.setBackground(originalBackground);
        family_config.setBackground(originalBackground);
        family_config_day.setBackground(originalBackground);
        report.setBackground(originalBackground);
        why.setBackground(originalBackground);
        foreigner.setBackground(originalBackground);
        ssn_back.setBackground(originalBackground);
        relation.setBackground(originalBackground);
        partner.setBackground(originalBackground);
    }
}