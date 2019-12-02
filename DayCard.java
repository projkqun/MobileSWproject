package com.example.user.myapplication;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DayCard implements Serializable {

    private String TravelDate_1;
    private String Travel_1;
    private ArrayList<PlanList> dayPlan;

    public String getTravelDate_1() {
        return TravelDate_1;
    }

    public ArrayList<PlanList> getDayPlan() {
        return dayPlan;
    }

    public DayCard(){
    }
    public DayCard(String travelDate_1, String travel_1, ArrayList<PlanList> dayPlan) {
        TravelDate_1 = travelDate_1;
        Travel_1 = travel_1;
        this.dayPlan = dayPlan;
    }

    public void setDayPlan(ArrayList<PlanList> dayPlan) {
        this.dayPlan = dayPlan;
    }

    public DayCard(String travelDate_1, String travel_1) {
        TravelDate_1 = travelDate_1;
        Travel_1 = travel_1;

    }

    public void setTravelDate_1(String travelDate_1) {
        TravelDate_1 = travelDate_1;
    }

    public String getTravel_1() {
        return Travel_1;
    }

    public void setTravel_1(String travel_1) {
        Travel_1 = travel_1;
    }

}
