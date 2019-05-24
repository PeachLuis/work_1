package com.example.luis.work_1.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.luis.work_1.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.recyclerViewAdapter;

public class RecyclerView_Activity extends AppCompatActivity {
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 50; i++) {
            data.add("" + i);
        }

        recyclerViewAdapter myAdapter = new recyclerViewAdapter(RecyclerView_Activity.this, data);
        recyclerView.setAdapter(myAdapter);
    }
}
