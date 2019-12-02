package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DayCardActivity extends AppCompatActivity {

    public Button btnPlusPlan;
    public Button returnBtn;
    private TextView Day;
    private ArrayList<PlanList> pList = new ArrayList<>();
    private ArrayList<DayCard> dList = new ArrayList<>();
    private PlanListAdapter pAdapter;
    private RecyclerView pRecyclerView;
    private int Num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daycard);

        btnPlusPlan = (Button)findViewById(R.id.addlist);
        returnBtn = (Button)findViewById(R.id.btnReturn);
        pRecyclerView = findViewById(R.id.listPlan);
        Day = findViewById(R.id.travel);

        final Intent intent = getIntent();
        final sharedata data = (sharedata) intent.getSerializableExtra("Array");
        int Num = data.getdList().size();
        Day.setText((Num) + "일차");
        dList = data.getdList();
        if(sharedata.EditTrue = false){
            pList = dList.get(data.getTargetNum()).getDayPlan();
        }
        pAdapter = new PlanListAdapter(DayCardActivity.this,pList);
        pRecyclerView.setAdapter(pAdapter);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d("sharedata", "true? "+sharedata.Stance);

        btnPlusPlan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                // 2. 레이아웃 파일 edit_box.xml 을 불러와서 화면에 다이얼로그를 보여줍니다.

                AlertDialog.Builder builder = new AlertDialog.Builder(DayCardActivity.this);

                View view = LayoutInflater.from(DayCardActivity.this)
                        .inflate(R.layout.plan_input_layout, null, false);
                builder.setView(view);


                final Button ButtonSubmit = (Button) view.findViewById(R.id.inputFinish);
                final EditText editTextID = (EditText) view.findViewById(R.id.planName);
                final EditText editTextStarttime = (EditText) view.findViewById(R.id.planStart);
                final EditText editTextEndtime = (EditText) view.findViewById(R.id.planEnd);
                final EditText editTextStaytime = (EditText) view.findViewById(R.id.planDoing);
                final EditText editTextlocation = (EditText) view.findViewById(R.id.planLocation);


                ButtonSubmit.setText("삽입");

                final AlertDialog dialog = builder.create();


                // 3. 다이얼로그에 있는 삽입 버튼을 클릭하면

                ButtonSubmit.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View v) {


                        // 4. 사용자가 입력한 내용을 가져와서
                        String strID = editTextID.getText().toString();
                        String strStarttime = editTextStarttime.getText().toString();
                        String strEndtime = editTextEndtime.getText().toString();
                        String strStaytime = editTextStaytime.getText().toString();
                        String strlocation = editTextlocation.getText().toString();


                        // 5. ArrayList에 추가하고

                        PlanList dict = new PlanList(strID, strStarttime, strEndtime,strStaytime, strlocation);
                        pList.add(0, dict); //첫번째 줄에 삽입됨
                        //mArrayList.add(dict); //마지막 줄에 삽입됨


                        // 6. 어댑터에서 RecyclerView에 반영하도록 합니다.

                        pAdapter.notifyItemInserted(0);
                        //mAdapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedata data_1 = new sharedata();
                data_1.setdList(dList);
                if(sharedata.EditTrue = false){
                    dList.get(data_1.getTargetNum()).setDayPlan(pList);
                    sharedata.EditTrue = false;
                }
                else {
                    dList.get(dList.size() - 1).setDayPlan(pList);
                    intent.putExtra("Array_1",data_1);

                    sharedata.Stance = true;
                    setResult(0,intent);
                    finish();
                }

            }
        });
    }
}
