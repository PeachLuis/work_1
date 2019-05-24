package com.example.luis.work_1.Activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luis.work_1.R;

import java.util.ArrayList;
import java.util.List;

public class ListView_Activity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<String> numbers;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_);

        //生成0到199的数字，存为ListView的数据
        numbers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            numbers.add("" + i);
        }

        //初始化ListView
        listView = (ListView) findViewById(R.id.list_view);
        //初始化适配器，这里的第二个参数是系统自带的
        arrayAdapter = new ArrayAdapter<>(ListView_Activity.this, android.R.layout.simple_expandable_list_item_1, numbers);
        //设置适配器
        listView.setAdapter(arrayAdapter);

        RefreshData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = numbers.get(position);
                Toast.makeText(ListView_Activity.this,"您按了"+data,Toast.LENGTH_LONG).show();
            }
        });

    }

    //实现下拉刷新
    private void RefreshData() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_listview_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            numbers.add("" + 1000 + i);
                        }
                        arrayAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

}

