package com.example.admin.reportcard;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.edit;

public class Register extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editSurname,  editEmail, editPhone, editTest1, editTest2, editAssignment, editFinalMark;
    Button btnRegister;
    Button btnViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DatabaseHelper(this);

        editName= (EditText)findViewById(R.id.name_view);
        editSurname= (EditText)findViewById(R.id.surname_view);
        editName= (EditText)findViewById(R.id.name_view);
        editEmail= (EditText)findViewById(R.id.email_view);
        editTest1= (EditText)findViewById(R.id.test1_view);
        editTest2= (EditText)findViewById(R.id.test2_view);
        editAssignment= (EditText)findViewById(R.id.assignment_view);
        editFinalMark= (EditText)findViewById(R.id.final_view);
        btnRegister= (Button)findViewById(R.id.reg_btn);
        Register();
    }
    public void Register(){
        btnRegister.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                   public void onClick(View view){
                       boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editEmail.getText().toString(),
                                editTest1.getText().toString(),
                                editTest2.getText().toString(),
                                editAssignment.getText().toString(),
                                editFinalMark.getText().toString());

                        if(isInserted==true)
                            Toast.makeText(Register.this,"Registration successful",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register.this,"Registration was not successful",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
