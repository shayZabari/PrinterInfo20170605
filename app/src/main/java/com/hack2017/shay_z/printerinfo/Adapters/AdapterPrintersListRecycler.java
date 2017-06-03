package com.hack2017.shay_z.printerinfo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hack2017.shay_z.printerinfo.R;
import com.hack2017.shay_z.printerinfo.models.StatusTable;
import com.hack2017.shay_z.printerinfo.models.Subject;

import java.util.ArrayList;

/**
 * Created by shay_z on 24-May-17.
 */

public class AdapterPrintersListRecycler extends RecyclerView.Adapter<AdapterPrintersListRecycler.MyViewHolder> {


    private final LayoutInflater inflater;
    StatusTable statusTable ;
    ArrayList<Subject> mmm1;

    public AdapterPrintersListRecycler(Context context, StatusTable statusTable, ArrayList<Subject> mmm) {
        inflater = LayoutInflater.from(context);
        this.statusTable = statusTable;
        mmm1 = mmm;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_printers_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ArrayList<String> currntLine = statusTable.allLinesOfStatus.get(position).stringOfAllTheLine;
        String temp = "";
        for (int i = 0; i < currntLine.size(); i++) {
            if (mmm1.get(i).checkBoxStatus && mmm1.get(i) != null)
                temp = temp + ("[ " + currntLine.get(i) + " ]  ");

        }
        holder.textView.setText(temp);
//        holder.textView.setText("shay");
    }

    @Override
    public int getItemCount() {
        return statusTable.allLinesOfStatus.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_row_recycleview);
        }
    }
}