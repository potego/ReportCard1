package com.example.admin.reportcard;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import junit.framework.Assert;

import static android.R.attr.value;
import static android.R.id.edit;

public class Register extends AppCompatActivity {

    DatabaseHelper myDb;
    boolean value;
    EditText editName, editSurname,  editEmail, editTest1, editTest2, editAssignment, editFinalMark, editPassword, editConPassWord;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DatabaseHelper(this);


        //Register();
    }

    public void Register(View view){

        if(view.getId() == R.id.reg_btn){
            editName= (EditText)findViewById(R.id.name_view);
            editSurname= (EditText)findViewById(R.id.surname_view);
            editName= (EditText)findViewById(R.id.name_view);
            editEmail= (EditText)findViewById(R.id.email_view);
            editTest1= (EditText)findViewById(R.id.test1_view);
            editTest2= (EditText)findViewById(R.id.test2_view);
            editAssignment= (EditText)findViewById(R.id.assignment_view);
            editFinalMark= (EditText)findViewById(R.id.final_view);
            editPassword= (EditText)findViewById(R.id.password_view);
            editConPassWord= (EditText)findViewById(R.id.confirm_password_view);
            btnRegister= (Button)findViewById(R.id.reg_btn);

            String nameString = editName.getText().toString();
            String surnameString = editSurname.getText().toString();
            String emailString = editEmail.getText().toString();
            String passString = editPassword.getText().toString().trim();
            String conpassString = editConPassWord.getText().toString().trim();
            String test1String = editTest1.getText().toString();
            String test2String = editTest2.getText().toString();
            String assignmentString = editAssignment.getText().toString();
            String finalmarkString = editFinalMark.getText().toString();

            if(!passString.equals(conpassString)){
                Toast.makeText(Register.this, "Sorry, Passwords do not match", Toast.LENGTH_LONG).show();
            }
            else{
                Contacts c = new Contacts();
                c.setName(nameString);
                c.setSurname(surnameString);
                c.setEmail(emailString);
                c.setPassword(passString);
//                c.set(conpassString);
                c.setTest1(test1String);
                c.setTest2(test2String);
                c.setAssignment(assignmentString);
                c.setFinalMark(finalmarkString);
                if(c!=null){
                value = myDb.insertData(c);
                }

                if(value){
                    Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Register.this, "Registration was not successful", Toast.LENGTH_LONG).show();
                }




            }
        }
    }

//    public void Register(){
//        btnRegister.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                   public void onClick(View view){
//                       boolean isInserted = myDb.insertData(editName.getText().toString(),
//                                editSurname.getText().toString(),
//                                editEmail.getText().toString(),
//                                editTest1.getText().toString(),
//                                editTest2.getText().toString(),
//                                editAssignment.getText().toString(),
//                                editFinalMark.getText().toString(),
//                                editPassword.getText().toString(),
//                                editConPassWord.getText().toString());
//                            System.out.println("++++++++pass: "+editPassword.getText().toString()+"  ++++++confirm "+editConPassWord.getText().toString());
//                        if(editPassword != editConPassWord){
//                            Toast.makeText(Register.this, "Passwords do not match",Toast.LENGTH_LONG).show();
//                        }
//                        else
//
//                            if(isInserted==true){
//                                Toast.makeText(Register.this,"Registration successful",Toast.LENGTH_LONG).show();
//                            }
//
//                            else{
//                                Toast.makeText(Register.this,"Registration was not successful",Toast.LENGTH_LONG).show();
//                            }
//
//                    }
//                }
//        );
//    }


}
