package com.example.meterialdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdaper extends RecyclerView.Adapter<TestAdaper.MyHolder> {
    private ArrayList<String> mData = new ArrayList<>();
    private Context mContext;

    public TestAdaper(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final  MyHolder holder = new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.iteam_list, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateList(ArrayList<String> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();

    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_position);
        }
    }
}
