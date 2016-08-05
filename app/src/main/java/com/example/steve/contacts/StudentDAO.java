package com.example.steve.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDAO extends SQLiteOpenHelper {


    public StudentDAO(Context context) {
        super(context, "StudentContact", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE students (" +
                        "id INTEGER PRIMARY_KEY," +
                        "name TEXT NOT NULL,"+
                        "address TEXT," +
                        "website TEXT," +
                        "email TEXT," +
                        "phoneNumber TEXT," +
                        "rating REAL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Student student) {
        ContentValues content = new ContentValues();
        content.put("name", student.getName());
        content.put("rating", student.getRating());

        SQLiteDatabase database = getWritableDatabase();
        database.insert("students",null, content);
    }
}
