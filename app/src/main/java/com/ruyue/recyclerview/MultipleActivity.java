package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MultipleActivity extends AppCompatActivity {
    private ArrayList<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        dataList = new ArrayList<>();
        dataInit();

        RecyclerView myRecyclerView = findViewById(R.id.my_recyclerview);

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(adapter);
    }

    private void dataInit() {
        for (int i = 0; i < 15; i++) {
            if(i == 0) {
                dataList.add(new Data(Data.TYPE_HEADER, "This is header", null, i));
            } else {
                dataList.add(new Data(Data.TYPE_ITEM, "title" + i, "desp" + i, i));
            }

        }
    }
}