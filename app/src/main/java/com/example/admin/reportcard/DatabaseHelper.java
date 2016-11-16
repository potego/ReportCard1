package com.example.admin.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

/**
 * Created by admin on 2016/10/26.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

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
    Cursor students_names;




    public DatabaseHelper(Context context) {
        super(context, REPORT_CARD, null, 7);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + STUDENTS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, EMAIL TEXT, TEST_1 INTEGER, TEST_2 INTEGER, ASSIGNMENT INTEGER, FINAL_MARK INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String email, String test1, String test2, String assignment, String final_mark) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);
        contentValues.put(col_3, surname);
        contentValues.put(col_4, email);
        contentValues.put(col_5, test1);
        contentValues.put(col_6, test2);
        contentValues.put(col_7, assignment);
        contentValues.put(col_8, final_mark);
        long result = db.insert(STUDENTS, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

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
}