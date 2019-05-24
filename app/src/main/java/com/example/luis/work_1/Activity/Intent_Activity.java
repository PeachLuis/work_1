package com.example.luis.work_1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.luis.work_1.R;

public class Intent_Activity extends AppCompatActivity {
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_);

        Intent intent = getIntent();
        textView = (TextView) findViewById(R.id.text_view);
        String str = intent.getStringExtra("extra_data");
        textView.setText(str);

    }
}
