package com.example.user.myapplication;

import android.widget.Button;

import java.io.Serializable;
import java.sql.Struct;

import static com.example.user.myapplication.sharedata.DayMax;

public class PlanList implements Serializable {
    private String PlanName;
    private String planStartTime;
    private String planEndTime;
    private String planStaytime;
    private String planlocation;

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getPlanStaytime() {
        return planStaytime;
    }

    public void setPlanStaytime(String planStaytime) {
        this.planStaytime = planStaytime;
    }

    public String getPlanlocation() {
        return planlocation;
    }

    public void setPlanlocation(String planlocation) {
        this.planlocation = planlocation;
    }

    public PlanList(String planName, String planStartTime, String planEndTime, String planStaytime, String planlocation) {
        PlanName = planName;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planStaytime = planStaytime;
        this.planlocation = planlocation;
    }
}
