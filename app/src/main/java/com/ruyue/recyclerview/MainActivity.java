package com.ruyue.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button jumpToRecyclerViewBtn;
    private Button jumpToMultipleBtn;
    private Button jumpToImgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumpToRecyclerViewBtn = findViewById(R.id.jump_to_recyclerView);
        jumpToMultipleBtn = findViewById(R.id.jump_to_multiple);
        jumpToImgBtn = findViewById(R.id.jump_to_image);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        jumpToRecyclerViewBtn.setOnClickListener(onClick);
        jumpToMultipleBtn.setOnClickListener(onClick);
        jumpToImgBtn.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent;
            switch(view.getId()) {
                case R.id.jump_to_recyclerView:
                    intent = new Intent(MainActivity.this, MultipleListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.jump_to_multiple:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.jump_to_image:
                    intent = new Intent(MainActivity.this, ImageListActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}