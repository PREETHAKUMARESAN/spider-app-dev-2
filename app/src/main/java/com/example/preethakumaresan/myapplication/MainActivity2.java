package com.example.preethakumaresan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Timestamp;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent text = getIntent();
        String name  = text.getStringExtra("name");
        ((TextView) findViewById(R.id.response)).setText("Thank you "+name+" for your response");

        ((Button) findViewById(R.id.backbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        long times = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(times);
        String stamp =  timestamp.toString();
        ((TextView) findViewById(R.id.timestamp)).setText(stamp);


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
