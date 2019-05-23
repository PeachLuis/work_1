package com.example.luis.work_1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luis.work_1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //跳转到RecyclerView
        Button button_recyclerView = (Button) findViewById(R.id.btn_recyclerview);
        button_recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显式Intent进行跳转
                Intent intent = new Intent(MainActivity.this,RecyclerView_Activity.class);
                startActivity(intent);
            }
        });

        //跳转到ListView
        Button button_listView = (Button) findViewById(R.id.btn_listview);
        button_listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用隐式Intent进行跳转
                Intent intent = new Intent("com.example.luis.work_1.MainActivity.ACTION_START");    //注意这里必须将完整包名写出来，不然程序会崩溃
                startActivity(intent);
            }
        });

        //跳转到进行Intent返回数据的一个活动
        Button button_intent = (Button) findViewById(R.id.btn_intent);
        button_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent("com.example.luis.work_1.MainActivity.ACTION_INTENT");
                startActivity(intent);
            }
        });
    }
}
