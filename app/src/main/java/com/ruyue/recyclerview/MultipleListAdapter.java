package com.ruyue.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.ruyue.recyclerview.Data.TYPE_HEADER;
import static com.ruyue.recyclerview.Data.TYPE_ITEM;

public class MultipleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> myList;

    static class MultiViewHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataNumber;
        TextView dataDesc;

        public MultiViewHolder(View itemView) {
            super(itemView);
            dataTitle = itemView.findViewById(R.id.data_title);
            dataNumber = itemView.findViewById(R.id.data_number);
            dataDesc = itemView.findViewById(R.id.data_desc);
        }
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        public HeadViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.data_head);
        }
    }

    public MultipleListAdapter(List<Data> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER) {
            Log.d("viewType:", String.valueOf(viewType));
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multiple_list_layout, parent, false);
            return new HeadViewHolder(view);
        } else if(viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
            return new MultiViewHolder(view);
        } else {
            return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = myList.get(position);
        switch(data.type) {
            case TYPE_HEADER:
                ((HeadViewHolder) holder).header.setText(data.getTitle());
                break;
            case TYPE_ITEM:
                ((MultiViewHolder) holder).dataTitle.setText(data.getTitle());
                ((MultiViewHolder) holder).dataNumber.setText(data.getNumber() + "");
                ((MultiViewHolder) holder).dataDesc.setText(data.getDescription());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (myList.get(position).getType()) {
            case 0:
                return Data.TYPE_ITEM;
            case 1:
                return Data.TYPE_HEADER;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}

