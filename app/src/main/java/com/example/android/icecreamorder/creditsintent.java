package com.example.android.icecreamorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class creditsintent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        String str=getIntent().getStringExtra("key");
        TextView tv=(TextView)findViewById(R.id.credit);
        tv.setText(str);
    }
}
