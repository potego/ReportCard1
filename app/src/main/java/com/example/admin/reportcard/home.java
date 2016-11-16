package com.example.admin.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void Register(View view){
        Intent registerIntent = new Intent(home.this, Register.class);

        startActivity(registerIntent);
    }

    public void AllStudents(View view){
        Intent viewIntent = new Intent(home.this, Students.class);

        startActivity(viewIntent);
    }


    public void DeleteRecord(View view){
        Intent deleteIntent = new Intent(home.this, Delete.class);

        startActivity(deleteIntent);
    }


    public void UpdateRecord(View view){
        Intent updateIntent = new Intent(home.this, update.class);

        startActivity(updateIntent);
    }


}
