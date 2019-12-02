package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class DayCardAdapter extends RecyclerView.Adapter<DayCardAdapter.DayCardViewHolder> {
    Context context_1;
    ArrayList<DayCard> DayCardList;

    public DayCardAdapter(Context context, ArrayList<DayCard> dayCardList) {
        this.context_1 = context;
        DayCardList = dayCardList;
    }

    public class DayCardViewHolder extends RecyclerView.ViewHolder implements  View.OnCreateContextMenuListener {
        private TextView txttravelDate;
        private TextView txttravel;
        private RecyclerView recycler_view_list;
        DayCardAdapter dAdapter;


        public DayCardViewHolder(View itemView , DayCardAdapter dAdapter)
        {
            super(itemView);
            txttravelDate = itemView.findViewById(R.id.travelDate);
            txttravel = itemView.findViewById(R.id.travel);
            recycler_view_list = (RecyclerView) itemView.findViewById(R.id.listPlan);
            this.dAdapter = dAdapter;
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1001:
                        sharedata data = new sharedata();
                        data.setTargetNum(getAdapterPosition());
                        sharedata.EditTrue = true;
                        data.setdList(DayCardList);
                        data.setTargetNum(getAdapterPosition());
                        Intent intent = new Intent(itemView.getContext(), DayCardActivity.class);
                        intent.putExtra("Array", data);
                        context_1.startActivity(intent);

                        break;

                    case 1002:
                        for(int x = getAdapterPosition()+1; x < DayCardList.size(); x ++) {

                            DayCardList.get(x).setTravel_1((x)+"일 차");
                        }
                        DayCardList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        for(int x = 0; x < DayCardList.size(); x ++) {
                            notifyItemRangeChanged(getAdapterPosition(), x);
                        }
                        break;

                }
                return true;
            }
        };
    }



    @Override
    public DayCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if(sharedata.Stance== true) {
            LayoutInflater inflater = LayoutInflater.from(context_1);
            View view_1 = inflater.inflate(R.layout.daycard, viewGroup, false);
            return new DayCardViewHolder(view_1, this);
        }
        else {
            LayoutInflater inflater = LayoutInflater.from(context_1);
            View view_1 = inflater.inflate(R.layout.daycard_view, viewGroup, false);

            return new DayCardViewHolder(view_1, this);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull DayCardViewHolder viewHolder, int i) {

        ArrayList PlanList = DayCardList.get(i).getDayPlan();
        viewHolder.txttravelDate.setText(DayCardList.get(i).getTravelDate_1());
        viewHolder.txttravel.setText(DayCardList.get(i).getTravel_1());
        PlanListAdapter pAdapter = new PlanListAdapter(context_1, PlanList);
        viewHolder.recycler_view_list.setHasFixedSize(true);
        viewHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context_1, LinearLayoutManager.VERTICAL,false));
        viewHolder.recycler_view_list.setAdapter(pAdapter);

    }

    @Override
    public int getItemCount() {
        return (null != DayCardList ? DayCardList.size() : 0);
    }

}
