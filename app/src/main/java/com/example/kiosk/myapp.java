package com.example.kiosk;

import android.app.Application;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.List;

public class myapp extends Application {

    protected int id = 18;
    private int ttsVolume;
    private float ttsSpeed;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    private String myName;



    private String get_pn;
    private String get_pn_2;

    private long day;

    private String department;

    private String h_ssn;
    private String get_num_yse;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
    public void setH_ssn(String a) { this.h_ssn = a;}
    public String getH_ssn() { return h_ssn;}

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

    // 패스트푸드 주문 내역
    private List<Order> orderList;

    @Override
    public void onCreate() {
        super.onCreate();
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void clearOrderList() {
        orderList.clear();
    }

    // 임무

    private String checkTOMission;
    public String getCheckTOMission() {return checkTOMission;}
    public void setCheckTOMission(String a) {this.checkTOMission=a;}

    private long r_to_time = 0;
    public long getR_to_time() {return r_to_time;}
    public void setR_to_time(long a) {this.r_to_time=a;}

    private boolean practiceTOCheck = false;
    public boolean getPracticeTOCheck() {return practiceFastfoodCheck;}
    public void setPracticeTOCheck(boolean a) {this.practiceFastfoodCheck=a;}

    private String checkFastfoodMission;
    public String getCheckFastfoodMission() {return checkFastfoodMission;}
    public void setCheckFastfoodMission(String a) {this.checkFastfoodMission=a;}

    private String checkBusMission;
    public String getCheckBusMission() {return checkBusMission;}
    public void setCheckBusMission(String a) {this.checkBusMission=a;}

    private String checkHospitalMission;
    public String getCheckHospitalMission() {return checkHospitalMission;}
    public void setCheckHospitalMission(String a) {this.checkHospitalMission=a;}

    private long r_f_time = 0;
    public long getR_F_Time() {return r_f_time;}
    public void setR_F_Time(long a) {this.r_f_time=a;}

    private long r_f_pop_time = 0;
    public long getR_F_Pop_Time() {return r_f_pop_time;}
    public void setR_F_Pop_Time(long a) {this.r_f_pop_time=a;}

    private long r_f_pay_time = 0;
    public long getR_F_Pay_Time() {return r_f_pay_time;}
    public void setR_F_Pay_Time(long a) {this.r_f_pay_time=a;}

    private long r_b_time = 0;
    public long getR_B_Time() {return r_b_time;}
    public void setR_B_Time(long a) {this.r_b_time=a;}

    private long r_h_r_time = 0;
    public long getR_H_R_Time() {return r_h_r_time;}
    public void setR_H_R_Time(long a) {this.r_h_r_time=a;}

    private long r_h_a_time = 0;
    public long getR_H_A_Time() {return r_h_a_time;}
    public void setR_H_A_Time(long a) {this.r_h_a_time=a;}

    private boolean practiceFastfoodCheck = false;
    public boolean getPracticeFastfoodCheck() {return practiceFastfoodCheck;}
    public void setPracticeFastfoodCheck(boolean a) {this.practiceFastfoodCheck=a;}

    private boolean practiceBusCheck = false;
    public boolean getPracticeBusCheck() {return practiceBusCheck;}
    public void setPracticeBusCheck(boolean a) {this.practiceBusCheck=a;}

    private boolean practiceHospitalCheck = false;
    public boolean getPracticeHospitalCheck() {return practiceHospitalCheck;}
    public void setPracticeHospitalCheck(boolean a) {this.practiceHospitalCheck=a;}

    private long r_time;
    public long getR_Time() {return r_time;}
    public void setR_Time(long a) {this.r_time=a;}

    private boolean missionCheck;
    public boolean getMissionCheck() {return missionCheck;}
    public void setMissionCheck(boolean a) {this.missionCheck=a;}

    private long measTime;      // 전체
    public long get_meansTime() {return measTime;}
    public void set_meansTime(long a) {this.measTime=a;}

    private long payTime;       // 결제
    public long get_payTime() {return measTime;}
    public void set_payTime(long a) {this.measTime=a;}

    private long popTime;       // 세부
    public long get_popTime() {return measTime;}
    public void set_popTime(long a) {this.measTime=a;}

    private long menuTime;      // 메뉴
    public long get_menuTime() {return measTime;}
    public void set_menuTime(long a) {this.measTime=a;}
}