package com.example.user.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class sharedata implements Serializable {

    public static  int DayMax;
    public static  Boolean Stance = true;
    private  int TargetNum;
    public static Boolean EditTrue = false;

    public int getTargetNum() {
        return TargetNum;
    }

    public void setTargetNum(int targetNum) {
        TargetNum = targetNum;
    }

    ArrayList<DayCard> dList = new ArrayList<>();

    public sharedata(){

    }

    public sharedata(ArrayList<DayCard> dList){
        this.dList = dList;
    }


    public ArrayList<DayCard> getdList() {
        return dList;
    }

    public DayCard getTargetdList(ArrayList<DayCard> dList, int num) {
        return dList.get(num);
    }

    public void setdList(ArrayList<DayCard> dList) {
        this.dList = dList;
    }


}
