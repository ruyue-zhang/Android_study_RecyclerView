package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    public static final int DATA_SIZE = 15;
    private List<Data> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        myList = new ArrayList<>();
        dataInit();

        RecyclerView myRecyclerView = findViewById(R.id.my_recyclerview);
        myRecyclerView.setHasFixedSize(true);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        myRecyclerView.setAdapter(new ListAdapter(myList));
    }

    private void dataInit() {
        for (int i = 1; i < DATA_SIZE + 1; i++) {
            myList.add(new Data("title" + i, "desp" + i, i));
        }
    }
}
