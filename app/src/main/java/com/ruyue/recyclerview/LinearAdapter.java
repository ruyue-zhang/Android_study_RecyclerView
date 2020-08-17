package com.ruyue.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private List<Data> myList;

    public static class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.data_list);
        }
    }

    public LinearAdapter(List<Data> myList) {
        this.myList = myList;
    }

    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        Data data = myList.get(position);
        holder.textView.setText(data.getTitle() + data.getNumber() + data.description);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


}

