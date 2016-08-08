package com.example.steve.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    Button newStudentButton;
    ListView studentsList;
    ArrayAdapter<Student> adapter;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        newStudentButton = (Button) findViewById(R.id.student_list_new_student_button);
        newStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentListActivity.this, StudentFormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadStudents();
    }

    private void loadStudents() {
        StudentDAO dao = new StudentDAO(this);
        List<Student>students = dao.getStudents();
        dao.close();
        studentsList = (ListView)findViewById(R.id.student_list_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentsList.setAdapter(adapter);
    }
}
