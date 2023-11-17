package com.example.kiosk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private Context context;
    private List<MainData> recordList;
    private RoomDB database;

    public RecordAdapter(Context context, List<MainData> recordList) {
        this.context = context;
        this.recordList = recordList;
        database = RoomDB.getInstance(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView timeTextView;
        TextView detailTextView;
        TextView creditTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            timeTextView = itemView.findViewById(R.id.time);
            detailTextView = itemView.findViewById(R.id.detail);
            creditTextView = itemView.findViewById(R.id.credit);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user_rec, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = recordList.get(position);
        holder.dateTextView.setText(data.getUserdate());
        holder.timeTextView.setText(data.getTime());
        holder.detailTextView.setText(data.getDetail());
        holder.creditTextView.setText(data.getCredit());
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public void updateData(List<MainData> newData) {
        recordList.clear();
        recordList.addAll(newData);
        notifyDataSetChanged();
    }
}
