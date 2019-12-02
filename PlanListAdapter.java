package com.example.user.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.PlanListViewHolder> {

    Context context;
    List<PlanList> PlanList_List;

    public PlanListAdapter(Context context, List<PlanList> planList_List){
        this.context = context;
        PlanList_List = planList_List;
    }


    @NonNull
    @Override
    public PlanListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.daycardschedule,viewGroup, false);
        return new PlanListViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanListViewHolder holder, int i) {
        holder.txtPlanName.setText(PlanList_List.get(i).getPlanName());
        holder.txtPlanTime.setText(PlanList_List.get(i).getPlanStartTime());
        holder.txtResidenceTime.setText(PlanList_List.get(i).getPlanlocation());

    }

    @Override
    public int getItemCount() {
        return (null != PlanList_List ? PlanList_List.size() : 0);
    }

    public class PlanListViewHolder extends RecyclerView.ViewHolder{
        private TextView txtPlanName;
        private TextView txtPlanTime;
        private TextView txtResidenceTime;
        PlanListAdapter mAdapter;


        public PlanListViewHolder(@NonNull View itemView, PlanListAdapter mAdapter) {
            super(itemView);
            txtPlanName = itemView.findViewById(R.id.planName);
            txtPlanTime = itemView.findViewById(R.id.planTime);
            txtResidenceTime = itemView.findViewById(R.id.residenceTime);
            this.mAdapter = mAdapter;
        }
    }
}
