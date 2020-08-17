package com.ruyue.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context myContext;

    private List<String> list;

    public LinearAdapter(Context context) {
        this.myContext = context;
    }
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(myContext).inflate(R.layout.linear_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        holder.textView.setText("11111");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.data_list);
        }
    }
}

