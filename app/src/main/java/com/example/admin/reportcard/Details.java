package com.example.admin.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    Toolbar mToolbar;
    TextView tv, tv2, tv3, tv4, tv5, tv6, tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        String[] detail;
        detail = bundle.getStringArray("Details");
        if(detail != null){
            tv = (TextView)findViewById(R.id.name_id);
            tv2 = (TextView)findViewById(R.id.surname_id);
            tv3 = (TextView)findViewById(R.id.email_id);
            tv4 = (TextView)findViewById(R.id.test1_id);
            tv5 = (TextView)findViewById(R.id.test2_id);
            tv6 = (TextView)findViewById(R.id.assignment_id);
            tv7 = (TextView)findViewById(R.id.finalMark_id);
            tv.setText("Name: "+ detail[1]);
            tv2.setText("Surname: "+ detail[2]);
            tv3.setText("Email: "+ detail[3]);
            tv4.setText("Test 1: "+ detail[4]);
            tv5.setText("Test 2: "+ detail[5]);
            tv6.setText("Assignment: "+ detail[6]);
            tv7.setText("Final Mark: "+ detail[7]);
        }

    }
}