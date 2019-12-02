package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DayCard> dList = new ArrayList<>();
    private DayCardAdapter dAdapter;
    private RecyclerView dRecyclerView;
    public Button btnPlus_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dRecyclerView = findViewById(R.id.listDay);
        btnPlus_2 = (Button)findViewById(R.id.addDayCard);

        dAdapter = new DayCardAdapter(MainActivity.this,dList);
        dRecyclerView.setAdapter(dAdapter);
        dRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sharedata.Stance = true;
        btnPlus_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dList.add(new DayCard ("11월 11일",(dList.size()+1)+"일차"));
                sharedata data = new sharedata();
                data.setdList(dList);
                Intent intent = new Intent(MainActivity.this, DayCardActivity.class);
                intent.putExtra("Array", data);
                sharedata.Stance = false;
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        dRecyclerView = findViewById(R.id.listDay);
        btnPlus_2 = (Button)findViewById(R.id.addDayCard);

        sharedata data_1 = new sharedata();
        data_1 = (sharedata) data.getSerializableExtra("Array_1");

        Log.d("sharedata", "true? "+sharedata.Stance);
        dList = data_1.getdList();

        dAdapter = new DayCardAdapter(MainActivity.this,dList);
        dRecyclerView.setAdapter(dAdapter);
        dRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedata.Stance = false;
        btnPlus_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dList.add(new DayCard ("11월 11일",(dList.size()+1)+"일차"));
                sharedata data = new sharedata();
                data.setdList(dList);
                Intent intent = new Intent(MainActivity.this, DayCardActivity.class);
                intent.putExtra("Array", data);
                sharedata.EditTrue = false;
                startActivityForResult(intent,0);
            }
        });
    }

}