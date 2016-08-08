package com.example.steve.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends SQLiteOpenHelper {


    public StudentDAO(Context context) {
        super(context, "StudentContact", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE students (" +
                        "id INTEGER PRIMARY KEY," +
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
        SQLiteDatabase database = getWritableDatabase();
        database.insert("students",null, student.toContentValues());
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT * FROM students",null);
        while(cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String name =  cursor.getString(cursor.getColumnIndex("name"));
            String address =  cursor.getString(cursor.getColumnIndex("address"));
            String website =  cursor.getString(cursor.getColumnIndex("website"));
            String email =  cursor.getString(cursor.getColumnIndex("email"));
            String phoneNumber =  cursor.getString(cursor.getColumnIndex("phoneNumber"));
            Float rating =  cursor.getFloat(cursor.getColumnIndex("rating"));
            Student student = new Student(id, name, email, address, phoneNumber, website, rating);
            students.add(student);
        }
        cursor.close();
        return students;
    }

    public void remove(Student student) {
        SQLiteDatabase database = getWritableDatabase();
        String[] params = {student.getId()+""};
        database.delete("students","id=?",params);
    }

    public void update(Student student, int originalId) {
        SQLiteDatabase database = getWritableDatabase();
        String[] params = {originalId+""};
        database.update("students",student.toContentValues(),"id=?",params);
    }
}

