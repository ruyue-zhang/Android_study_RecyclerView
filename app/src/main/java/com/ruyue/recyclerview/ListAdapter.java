package com.ruyue.recyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.LinearViewHolder> {
    private List<Data> myList;

    static class LinearViewHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataNumber;
        TextView dataDesc;

        public LinearViewHolder(View itemView) {
            super(itemView);
            dataTitle = itemView.findViewById(R.id.data_title);
            dataNumber = itemView.findViewById(R.id.data_number);
            dataDesc = itemView.findViewById(R.id.data_desc);
        }
    }

    public ListAdapter(List<Data> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new LinearViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        Data data = myList.get(position);

        holder.dataTitle.setText(data.getTitle());
        holder.dataNumber.setText(data.getNumber() + "");
        holder.dataDesc.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


}

