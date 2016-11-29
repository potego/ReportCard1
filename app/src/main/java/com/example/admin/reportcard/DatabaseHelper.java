package com.example.admin.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

import static android.R.attr.name;

/**
 * Created by admin on 2016/10/26.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase myDb;

    public static final String REPORT_CARD = "Student.db";
    public static final String STUDENTS = "Student_table";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "SURNAME";
    public static final String col_4 = "EMAIL";
    public static final String col_5 = "TEST_1";
    public static final String col_6 = "TEST_2";
    public static final String col_7 = "ASSIGNMENT";
    public static final String col_8 = "FINAL_MARK";
    public static final String col_9 = "PASSWORD";
    Cursor students_names;




    public DatabaseHelper(Context context) {
        super(context, REPORT_CARD, null, 7);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + STUDENTS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT not null, SURNAME TEXT not null, EMAIL TEXT not null, TEST_1 INTEGER not null, TEST_2 INTEGER not null, ASSIGNMENT INTEGER not null, FINAL_MARK INTEGER not null, PASSWORD INTEGER not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);
        onCreate(db);
    }

    public boolean insertData(Contacts c/*String name, String surname, String email, String test1, String test2, String assignment, String final_mark, String password, String confirm_password*/) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, c.getName());
        contentValues.put(col_3, c.getSurname());
        contentValues.put(col_4, c.getEmail());
        contentValues.put(col_5, c.getTest1());
        contentValues.put(col_6, c.getTest2());
        contentValues.put(col_7, c.getAssignment());
        contentValues.put(col_8, c.getFinalMark());
        contentValues.put(col_9, c.getPassword());
        long result = db.insert(STUDENTS, null, contentValues);


        if (result == -1)
            return false;
        else
            return true;

    }

    public String searchPass(String email){
        myDb = this.getReadableDatabase();
        String query = "select EMAIL, PASSWORD from " + STUDENTS;
        Cursor cursor = myDb.rawQuery(query, null);
        String a, b;
        b = "Not found";

        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }
        return b;


    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        students_names = db.rawQuery("Select * from " + STUDENTS, null);

        if (students_names.moveToFirst()) {

        }
        return students_names;
    }


    public String[] oneStudentData(long t){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] col = new String[] {col_1,  col_2, col_3, col_4, col_5, col_6, col_7, col_8};
        Cursor results = db.query(STUDENTS,col,col_1 + " = " + t , null,null, null,null);

        int a = results.getColumnIndex(col_1);
        int b = results.getColumnIndex(col_2);
        int c = results.getColumnIndex(col_3);
        int d = results.getColumnIndex(col_4);
        int e = results.getColumnIndex(col_5);
        int f = results.getColumnIndex(col_6);
        int g = results.getColumnIndex(col_7);
        int h = results.getColumnIndex(col_8);

        if( results != null){
                results.moveToFirst();
            col = new String[]{results.getString(a), results.getString(b), results.getString(c),
                    results.getString(d), results.getString(e), results.getString(f), results.getString(g), results.getString(h)};
            }
            return col;

    }

    public boolean updateRecord( String id, String name, String surname, String email, String test1, String test2, String assignment, String finalMark){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,surname);
        contentValues.put(col_4,email);
        contentValues.put(col_5,test1);
        contentValues.put(col_6,test2);
        contentValues.put(col_7,assignment);
        contentValues.put(col_8,finalMark);
        db.update(STUDENTS, contentValues, "ID=?",new String[]{ id });

        return true;

    }

    public Integer deleteRecord(String id){
        SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(STUDENTS, "ID = ?", new String[]{id});
    }
}