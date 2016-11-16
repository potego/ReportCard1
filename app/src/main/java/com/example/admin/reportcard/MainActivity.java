package com.example.admin.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }

    public void login(View view){
        Intent loginIntent = new Intent(MainActivity.this, home.class);

        startActivity(loginIntent);
    }

    public void forgot_password(View view){
        Intent passwordIntent = new Intent(MainActivity.this, forgot_password.class);
        startActivity(passwordIntent);
    }
}
