package com.example.admin.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }

    public void login(View view){
        if(view.getId() == R.id.login_button){
            EditText a = (EditText)findViewById(R.id.username_edit);
            String string = a.getText().toString();

             EditText b = (EditText)findViewById(R.id.password_edit);
             String pass = b.getText().toString().trim();

            String password = myDb.searchPass(string);

            if(pass.equals(password)){
                Intent loginIntent = new Intent(MainActivity.this, home.class);
                loginIntent.putExtra("You logged on as", string);
                startActivity(loginIntent);
           }
            else{
                Toast.makeText(MainActivity.this, "The password you entered does not match the username", Toast.LENGTH_LONG).show();
            }

        }

    }

}

