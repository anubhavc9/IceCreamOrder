package com.example.android.icecreamorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class fileIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_intent);

       String bill=getIntent().getStringExtra("key");

        TextView text =(TextView)findViewById(R.id.bill);
        text.setText(bill);

    }
}
