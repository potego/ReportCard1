package com.example.admin.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    Toolbar mToolbar;
    TextView tv0, tv, tv2, tv3, tv4, tv5, tv6, tv7;
    String[] detail;

    DatabaseHelper myDb;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myDb = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();

        detail = bundle.getStringArray("Details");
        if(detail != null){
            tv0 = (TextView)findViewById(R.id.identity_id);
            tv = (TextView)findViewById(R.id.name_id);
            tv2 = (TextView)findViewById(R.id.surname_id);
            tv3 = (TextView)findViewById(R.id.email_id);
            tv4 = (TextView)findViewById(R.id.test1_id);
            tv5 = (TextView)findViewById(R.id.test2_id);
            tv6 = (TextView)findViewById(R.id.assignment_id);
            tv7 = (TextView)findViewById(R.id.finalMark_id);
            btnDelete = (Button)findViewById(R.id.delete_btn);
            tv0.setText(detail[0]);
            tv.setText("Name: "+ detail[1]);
            tv2.setText("Surname: "+ detail[2]);
            tv3.setText("Email: "+ detail[3]);
            tv4.setText("Test 1: "+ detail[4]);
            tv5.setText("Test 2: "+ detail[5]);
            tv6.setText("Assignment: "+ detail[6]);
            tv7.setText("Final Mark: "+ detail[7]);
        }

        DeleteRecord();

    }

    public void UpdateRecord(View view){


        Intent updateIntent = new Intent(Details.this, update.class);

        updateIntent.putExtra("detail",detail);
        startActivity(updateIntent);
    }

    public void DeleteRecord(){
        btnDelete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Integer deletedRows = myDb.deleteRecord(tv0.getText().toString());
                        if(deletedRows > 0){
                            Toast.makeText(Details.this, "Student Record deleted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Details.this, "Student record could not be deleted ", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}