package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends AppCompatActivity {
    private List<Data> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        dataList = new ArrayList<>();
        dataInit();

        RecyclerView myRecyclerView = findViewById(R.id.my_recyclerview);
        ImageListAdapter adapter = new ImageListAdapter(this, dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(adapter);
    }

    private void dataInit() {
        for (int i = 0; i < 101; i++) {
            if(i == 0) {
                dataList.add(new Data(Data.TYPE_HEADER, "This is header", null, i, null));
            } else {
                dataList.add(new Data(Data.TYPE_ITEM, "title" + i, "desp" + i, i, "https://loremflickr.com/180/180?lock=" + i));
            }

        }
    }
}