package com.example.admin.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.id.edit;

public class update extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView editID;
    EditText editName, editSurname,  editEmail, editTest1, editTest2, editAssignment, editFinalMark;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Bundle bundle = getIntent().getExtras();
        String[] stringArray = bundle.getStringArray("detail");
        assert stringArray != null;
        String identity  = stringArray[0];
        String name  = bundle.getString("Name");
        String surname  = bundle.getString("Surname");
        String email  = bundle.getString("Email");
        String test1  = bundle.getString("Test 1");
        String test2  = bundle.getString("Test 2");
        String assignment  = bundle.getString("Assignment");
        String finalMark  = bundle.getString("Final Mark");


        myDb = new DatabaseHelper(this);

        editID= (TextView)findViewById(R.id.id_view);
        editName= (EditText)findViewById(R.id.name_view);
        editSurname= (EditText)findViewById(R.id.surname_view);
        editName= (EditText)findViewById(R.id.name_view);
        editEmail= (EditText)findViewById(R.id.email_view);
        editTest1= (EditText)findViewById(R.id.test1_view);
        editTest2= (EditText)findViewById(R.id.test2_view);
        editAssignment= (EditText)findViewById(R.id.assignment_view);
        editFinalMark= (EditText)findViewById(R.id.final_view);
        btnUpdate= (Button)findViewById(R.id.update_btn);


        editID.setText(identity);
        editName.setText(name);
        editSurname.setText(surname);
        editEmail.setText(email);
        editTest1.setText(test1);
        editTest2.setText(test2);
        editAssignment.setText(assignment);
        editFinalMark.setText(finalMark);
        System.out.println("----------------"+finalMark);
       UpdateRecord();

    }

    public void UpdateRecord(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        boolean isUpdated = myDb.updateRecord(editID.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),
                                editEmail.getText().toString(),
                                editTest1.getText().toString(),
                                editTest2.getText().toString(),
                                editAssignment.getText().toString(),
                                editFinalMark.getText().toString());

                        if(isUpdated == true){
                            Toast.makeText(update.this, "Record Updated", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(update.this, "Record could not be updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}