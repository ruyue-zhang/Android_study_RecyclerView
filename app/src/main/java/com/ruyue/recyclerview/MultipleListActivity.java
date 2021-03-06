package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MultipleListActivity extends AppCompatActivity {
    public static final int DATA_SIZE = 30;
    private ArrayList<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        dataList = new ArrayList<>();
        dataInit();

        RecyclerView myRecyclerView = findViewById(R.id.my_recyclerview);

        MultipleListAdapter adapter = new MultipleListAdapter(dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(adapter);
    }

    private void dataInit() {
        for (int i = 0; i < DATA_SIZE; i++) {
            if(0 == i) {
                dataList.add(new Data(Data.TYPE_HEADER, "This is header", null, i));
            } else {
                dataList.add(new Data(Data.TYPE_ITEM, "title"+ i, "desp" + i, i));
            }

        }
    }
}