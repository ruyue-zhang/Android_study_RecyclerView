package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    List<Data> myList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView myRecyclerView = findViewById(R.id.my_recyclerview);
        myRecyclerView.setHasFixedSize(true);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        initList();
        myRecyclerView.setAdapter(new LinearAdapter(myList));
    }

    private void initList() {
        myList.add(new Data("title1", "desp1", 1));
        myList.add(new Data("title2", "desp2", 2));
        myList.add(new Data("title3", "desp3", 3));
        myList.add(new Data("title4", "desp4", 4));
        myList.add(new Data("title5", "desp5", 5));
        myList.add(new Data("title6", "desp6", 6));
        myList.add(new Data("title7", "desp7", 7));
        myList.add(new Data("title8", "desp8", 8));
        myList.add(new Data("title9", "desp9", 9));
        myList.add(new Data("title10", "desp10", 10));
    }



}
